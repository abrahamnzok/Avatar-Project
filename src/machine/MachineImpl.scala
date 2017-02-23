package machine
import Avatar._
object MachineImpl extends MachineDialogue{
  
  
  def reinit= {
 languesutilisateur.reinit()
  }

  
  def test(l:List[String]):List[String]= {
    var lrep = List[String]()
	  for (req <- l) {
     // var rep = Avatar.reponse(req)
      lrep = lrep ++ Avatar.reponse(req)
	  }
	  lrep
  }
  
}