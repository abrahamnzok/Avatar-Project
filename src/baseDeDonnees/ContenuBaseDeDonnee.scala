package baseDeDonnees
import XMLimplementation._
import Langues._

object ContenuBaseDeDonnee extends BaseDeDonnees {
  
  /**
   * La base de données qui permet d'obtenir les adresses selon les lieux
   */
  val Base = Map[String,String]("Mairie" -> "Place de la Mairie",
    "Mairie de Rennes" -> "Place de la Mairie",
    "Hôtel de Ville" -> "Place de la Mairie",
    "L'Hôtel de Ville" -> "Place de la Mairie",
    "Hôtel" -> "Place de la Mairie",
    "Paillette" -> "2, Rue du Pré de Bris",
    "Théâtre La Paillette" -> "2, Rue du Pré de Bris",
    "Gare" -> "19, Place de la Gare",
    "Gare SNCF" -> "19, Place de la Gare",
    "SNCF" -> "19, Place de la Gare",
    "TNB" -> "1, Rue Saint-Hélier",
    "Théâtre National de Bretagne" -> "1, Rue Saint-Hélier",
    "Théâtre de Bretagne" -> "1, rue Saint-Hélier",
    "Universite de Rennes-1" ->"Batiment 1, Universite de Rennes 1, 263 Avenue General Leclerc",
    "Rennes-1" -> "Batiment 1, Universite de Rennes 1, 263 Avenue General Leclerc"

  )
  
  /**
   * La base de données qui permet d'obtenir les lieux selon les adresses
   */
  val Basebis2 = Map[String,String]("Place de la Mairie" -> "Mairie de Rennes",
      "2, Rue du Pré de Bris" -> "La Paillette",
      "19, Place de la Gare" -> "Gare SNCF",
      "1, Rue Saint-Hélier" -> "Théâtre National de Bretagne",
      "Batiment 1, Universite de Rennes 1, 263 Avenue General Leclerc" -> "Universite de Rennes-1")
  
  /**
   * Ajout des nouvelles bases depuis XMLImplementation et concatenation avec les anciennes bases
   */
  val F5 : Map [String, String] = XMLimplementation.my_xml_test2.bddMyXML
  val bddAdress : Map [String, String] = XMLimplementation.my_xml_test2.adressXML
 // val Base = F5 ++ Basebis
  val Base2 = bddAdress ++ Basebis2
   
  private val keyword = Base.keySet.toList ++ keywordLangNomDeLangue ++ keywordLangRecherche ++ keywordLangExpressionfr  ++keywordLangExpressionAng ++keywordLangExpressionEsp ++keywordLangExpressionDeu ++ keywordLangExpressionIt
  private val keywordPolitesse = Langues.Politesse.keySet.toList
  
  /**
   * permet d'avoir les cle de la base de donnees
   */
  def getKeyword : List[String] = {
    keyword
  }
  /**
   * permet davoir les cle des mots de politesse
   */
  def getKeywordPolitesse : List[String] = {
    keywordPolitesse
  }
   /**
    * Permet de faire marche quelque test de f1, f2, f3, f4, quand on rajoute f5
    */
  def testdeladernierechance (s:List[String]) : List [String]={
    s match {
      case x::Nil =>  List(x)
      case ""::tail => testdeladernierechance(tail)
      case x::tail => x :: testdeladernierechance(tail)
      case _ => List("mauvais")
    }
  }
 
 /**
  * Envoie l'adresse correspondant au lieu demandé
  * @param Une liste de String contenant un lieu
  * @return Une Liste de String de l'adresse du lieux recherché
  */
  def envoieReponse (s: List[String]) : List[String] = {
    var answer = List [String] ()
    var sbis=testdeladernierechance(s)
    if(sbis.isEmpty){
      answer
    }else {  
      for (x<- sbis){
        if(Base.contains(x)){
          answer = answer :+ Base(x)
        }
      }
    }
    answer
  }
  
 /**
  * Envoie le lieu correspondant à l'adresse demandée
  * @param Une String correspondant à l'adresse
  * @return Le lieu de l'adresse recherché
  */
 def envoieCle ( s:String) : String= {
    var answer= ""
    if(Base2.contains(s)){
      answer =  Base2(s)
    }
    answer
  }
 /**
  * permet de ne pas avoir des reponse differente ( gare mairie )
  */
 def validationRep (s:List[String]): Boolean= {
   !(s.length>1 && envoieReponse(s).length>1)
 }
}

object Testbdd extends App {
  ContenuBaseDeDonnee
  }