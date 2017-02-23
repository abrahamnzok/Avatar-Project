package analyse_phrase

trait analyseTrait {
  
  /** recoit une phrase de l'avatar et renvois la reponse associee dans la base de
   *  donnee via une recherche d'element cle
   * 
   * @param phrase String envoye par l'utilisateur correspondant à une requete
   * @return renvois la String reponse contenu dans la base de donnee
   */
  def analyse(phrase:String):List[String]
}