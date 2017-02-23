package Avatar

import analyse_phrase.analyse_app
import baseDeDonnees._
import analyse_phrase.analyse_class
import fautes._

object Avatar extends App {
  var i = 0
  languesutilisateur.reinit()
  var gestionnaireMultiples:GestionnaireReponsesMultiples = new GestionnaireReponsesMultiples(List(), List());
  
  def reponse(req: String): List[String] = {
    val an = new analyse_class
    val listeMotCles = an.analyse(req)
    var reqcorrige = ToleranceFautesImpl.corrigerFautes(req.toLowerCase()).toLowerCase()
    var listeBDD = ContenuBaseDeDonnee.envoieReponse(listeMotCles)
    var listeRep = List[String]()
    var len = listeBDD.size
    var reqbis=req

    if (gestionnaireMultiples != null && gestionnaireMultiples.getNombreChoixPossibles() >= 2) {//Si l'on s'attend à un choix de l'utilisateur parmis plusieurs réponses possibles.
      if (gestionnaireMultiples.contiensUnNombre(req)) {
        val n = gestionnaireMultiples.recupererPremierNombre(req)
        if (n <= gestionnaireMultiples.getNombreChoixPossibles() && n > 0) {
          val listeDesKeyword = gestionnaireMultiples.getListeMotsCleFromLastRequest();
          listeRep = langueAdresse(1,  listeRep,  List(gestionnaireMultiples.getChoixMotCle(n)) , List(gestionnaireMultiples.getChoixAddress(n)));
        }
        else {
          //L'utilisateur a selectionné un choix impossible: soit le choix de numéro > n alors qu'il n'y a que n réponses possibles, soit 0 alors que les choix commencent à 1.
          listeRep = List("Je ne comprends pas votre demande") 
        }
      }
      else {
        //L'utilisateur n'a pas fait de choix parmis les réponses proposées.
        listeRep = List("Je ne comprends pas votre demande") 
      }
        //Remise à zéro : Si l'utilisateur tape "3" alors qu'on ne lui a pas encore proposé plusieurs réponses, ce chiffre ne doit alors pas être interprété comme "je veux la réponse 3".   
        //Si l'utilisateur fait un choix incompréhensible, on abandonne la sélection du choix.
        gestionnaireMultiples = new GestionnaireReponsesMultiples(List(), List());
    }
    else {
      if (Langues.Politesse.contains(reqcorrige) || Langues.Recherche.contains(reqcorrige) || Langues.NomDeLangue.contains(reqcorrige)){
        reqbis=reqcorrige
      }
      if (languesutilisateur.langueUtiliDetecter(ToleranceFautesImpl.retirerDefaut(reqbis.toLowerCase()))) {
        listeRep = languesutilisateur.ChangementDeLangue(languesutilisateur.langueDetecter)
      } 
      else if (languesutilisateur.languecourante != languesutilisateur.langueDetecter) {
        listeRep = changementLangue(req.toLowerCase(), listeRep)
      } 
      else if (Langues.Politesse.contains(reqcorrige)) {
         if (languesutilisateur.langueUtiliDetecter(reqcorrige.toLowerCase())) {
          listeRep = languesutilisateur.ChangementDeLangue(languesutilisateur.langueDetecter)
          } 
          else if (languesutilisateur.languecourante != languesutilisateur.langueDetecter) {
            listeRep = changementLangue(req.toLowerCase(), listeRep)
          }
          else{
            listeRep = motPolitesse(listeRep)
          }
      } 
      else {    
        listeRep = politesseEtPhrase(reqcorrige, listeRep)
        listeRep = langueAdresse(len, listeRep, listeMotCles, listeBDD)
      }
    }
    listeRep
  }
/**
 * change la langue
 */
    def changementLangue (requete: String, listReponse: List[String]): List[String] = {
    var list = listReponse
     requete.trim() match {
      case "oui" => if(languesutilisateur.langueDetecter == "francais"){
        languesutilisateur.languecourante = "francais"
        list = list :+ Langues.Expressionfr("D'accord, quelle est votre demande?")
      }else{ list = list :+ langueSuivante()(0) }
      
      case "yes" => if(languesutilisateur.langueDetecter == "english"){
        languesutilisateur.languecourante = "english"
        list = list :+ Langues.ExpressionAng("D'accord, quelle est votre demande?")
      }else{ list = list :+ langueSuivante()(0) }
      
      case "si" => if(languesutilisateur.langueDetecter == "español"){
        languesutilisateur.languecourante = "español"
        list = list :+ Langues.ExpressionEsp("D'accord, quelle est votre demande?")
      }else if(languesutilisateur.langueDetecter == "italiano"){
        languesutilisateur.languecourante = "italiano"
        list = list :+ Langues.ExpressionIt("D'accord, quelle est votre demande?")
      }else{ list = list :+ langueSuivante()(0) }
      
      case "ja" => if(languesutilisateur.langueDetecter == "deutsch"){
        languesutilisateur.languecourante = "deutsch"
        list = list :+ Langues.ExpressionDeu("D'accord, quelle est votre demande?")
      }else{ list = list :+ langueSuivante()(0) }
      
      case _ => list = list :+ langueSuivante()(0) 
    
    }
    return list
  }
  
    /**
     * passe a la langue suivante dasn un ordre precis
     */
  def langueSuivante () : List[String] ={
    var rep = ""
    languesutilisateur.languecourante = ""
        val langues = Array("francais", "english", "español", "deutsch", "italiano")
        i = langues.indexOf(languesutilisateur.langueDetecter)
        i = (i + 1) % langues.length
        languesutilisateur.langueDetecter = langues(i)
        rep = languesutilisateur.ChangementDeLangue(langues(i))(0)
        
       return List(rep)
  }

  /**
   * traduit les mots de politesse
   */
  def motPolitesse(listReponse: List[String]): List[String] = {
    var list = listReponse
    languesutilisateur.languecourante match {
      case "francais" => list = list :+ Langues.Expressionfr("bonjour")
      case "english"  => list = list :+ Langues.ExpressionAng("bonjour")
      case "español"  => list = list :+ Langues.ExpressionEsp("bonjour")
      case "deutsch"  => list = list :+ Langues.ExpressionDeu("bonjour")
      case "italiano" => list = list :+ Langues.ExpressionIt("bonjour")
    }
    return list
  }

  /**
   *ajout le mot de politesse au debut si l utilisateur est poli
   */

  def politesseEtPhrase(req: String, listReponse: List[String]): List[String] = {
    var list = listReponse
    languesutilisateur.languecourante match {
      case "francais" => if (req.contains("bonjour") || req.contains("salut")
        || req.contains("bonsoir")) {
        list = Langues.Expressionfr("bonjour") :: list
      }
      case "english" => if (req.contains("hi") || req.contains("hello")
        || req.contains("morning") || req.contains("evening") || req.contains("hey")) {
        list = Langues.ExpressionAng("bonjour") :: list
      }
      case "español" => if (req.contains("hola") || req.contains("buenos")
        || req.contains("dias")) {
        list = Langues.ExpressionEsp("bonjour") :: list
      }
      case "deutsch" => if (req.contains("hallo") || req.contains("guten")
        || req.contains("morgen") || req.contains("tag")
        || req.contains("abend")) {
        list = Langues.ExpressionDeu("bonjour") :: list
      }
      case "italiano" => if (req.contains("buongiorno") || req.contains("ciao")
        || req.contains("salve") || req.contains("buon") || req.contains("pomeriggio")
        || req.contains("buonasera") || req.contains("incantato")) {
        list = Langues.ExpressionIt("bonjour") :: list
      }
    }
    return list
  }

  /**
   *reponse a envoyer a l utilisateur
   */

  def langueAdresse(longueur: Int, req: List[String], listMotCle: List[String], listBDD: List[String]): List[String] = {
    var list1 = req
    longueur match {
      case 1 =>
        languesutilisateur.languecourante match {
          case "francais" => list1 = list1 :+ Langues.Expressionfr("L'adresse de XXX est : ").replace("XXX", listMotCle(0)) + listBDD(0)
          case "english"  => list1 = list1 :+ Langues.ExpressionAng("L'adresse de XXX est : ").replace("XXX", listMotCle(0)) + listBDD(0)
          case "español"  => list1 = list1 :+ Langues.ExpressionEsp("L'adresse de XXX est : ").replace("XXX", listMotCle(0)) + listBDD(0)
          case "deutsch"  => list1 = list1 :+ Langues.ExpressionDeu("L'adresse de XXX est : ").replace("XXX", listMotCle(0)) + listBDD(0)
          case "italiano" => list1 = list1 :+ Langues.ExpressionIt("L'adresse de XXX est : ").replace("XXX", listMotCle(0)) + listBDD(0)
        }
      case 0 =>
        languesutilisateur.languecourante match {
          case "francais" => list1 = list1 :+ Langues.Expressionfr("Je ne comprends pas votre demande")
          case "english"  => list1 = list1 :+ Langues.ExpressionAng("Je ne comprends pas votre demande")
          case "español"  => list1 = list1 :+ Langues.ExpressionEsp("Je ne comprends pas votre demande")
          case "deutsch"  => list1 = list1 :+ Langues.ExpressionDeu("Je ne comprends pas votre demande")
          case "italiano" => list1 = list1 :+ Langues.ExpressionIt("Je ne comprends pas votre demande")
        }
      case _ =>
        gestionnaireMultiples = new GestionnaireReponsesMultiples(listBDD, listMotCle)
        languesutilisateur.languecourante match {
          case "francais" => list1 = list1 :+ Langues.Expressionfr("J'ai XXX réponses possibles : ").replace("XXX", longueur.toString())
          case "english"  => list1 = list1 :+ Langues.ExpressionAng("J'ai XXX réponses possibles : ").replace("XXX", longueur.toString())
          case "español"  => list1 = list1 :+ Langues.ExpressionEsp("J'ai XXX réponses possibles : ").replace("XXX", longueur.toString())
          case "deutsch"  => list1 = list1 :+ Langues.ExpressionDeu("J'ai XXX réponses possibles : ").replace("XXX", longueur.toString())
          case "italiano" => list1 = list1 :+ Langues.ExpressionIt("J'ai XXX réponses possibles : ").replace("XXX", longueur.toString())
        }
        var j = 1
        for (rep <- listMotCle) {
          list1 = list1 :+ j + ") " + rep
          j = j + 1
        }
        languesutilisateur.languecourante match {
          case "francais" => list1 = list1 :+ Langues.Expressionfr("Quel est votre choix?")
          case "english"  => list1 = list1 :+ Langues.ExpressionAng("Quel est votre choix?")
          case "español"  => list1 = list1 :+ Langues.ExpressionEsp("Quel est votre choix?")
          case "deutsch"  => list1 = list1 :+ Langues.ExpressionDeu("Quel est votre choix?")
          case "italiano" => list1 = list1 :+ Langues.ExpressionIt("Quel est votre choix?")
        }
    }
    return list1
  }

}