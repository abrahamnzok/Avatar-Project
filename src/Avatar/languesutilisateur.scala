package Avatar
import baseDeDonnees.Langues

object languesutilisateur {

  var languecourante = "francais"
  var langueDetecter = "francais"
  
  /**
   * reinitialise la langue
   */
  def reinit() {
    languecourante = "francais"
    langueDetecter = "francais"
  }
  
  /**
   * Detecter la langue avec les map recherche politesse et NonDeLangue
   * @param String phrase dans laquelle on detecte une langue
   */
  def langueUtiliDetecter(req: String): Boolean = {
    val e = req.replace(",", "")
    val reqsep = e.split(" ")
    var base = false   
    
    for (i <- reqsep) {
      if (Langues.Politesse.contains(i)) {
        if (languecourante != Langues.Politesse(i)) {
          langueDetecter = Langues.Politesse(i)
          base = true
        }
      }
      if (Langues.Recherche.contains(i)) {
        if (languecourante != Langues.Recherche(i)) {
          langueDetecter = Langues.Recherche(i)
          base = true
      
        }
      }
      if (Langues.NomDeLangue.contains(i)) {
        if (languecourante != Langues.NomDeLangue(i)) {
          langueDetecter = Langues.NomDeLangue(i)
          base = true
   
        }
      }
    }
    base
  }

  /**
   * pose la question quand sa change de langue
   */
  def ChangementDeLangue(l: String): List[String] = {

    l match {
      case "francais" => List(Langues.Expressionfr("Parlez-vous français?"))
      case "english"  => List(Langues.ExpressionAng("Parlez-vous français?"))
      case "español"  => List(Langues.ExpressionEsp("Parlez-vous français?"))
      case "deutsch"  => List(Langues.ExpressionDeu("Parlez-vous français?"))
      case "italiano" => List(Langues.ExpressionIt("Parlez-vous français?"))
    }
  }
}