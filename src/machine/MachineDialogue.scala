package machine

trait MachineDialogue {
  /** réinitialisation de l'avatar */
  def reinit:Unit
  /** test de l'avatar
   *  @param l une liste de requête
   *  @return la liste des réponses produites par l'avatar */
	def test(l:List[String]):List[String]
}