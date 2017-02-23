package baseDeDonnees

trait BaseDeDonnees {
  
  /**	
   * 	Créer une petite base de données de réponses.
   * 	Stocker les réponses envisageables autres que celles de la base de données.
   * 	Renvoyer les résultats correspondants aux recherches envoyées par "Analyse de la phrase".
   * 
   * 	La séparation entre la recherche et le résultat est ";".
   */

  def getKeyword: List[String]
  def getKeywordPolitesse : List[String]
  def envoieCle ( s:String) : String
  def envoieReponse (s:List[String]) : List [String]
  def validationRep (s:List[String]) : Boolean
}