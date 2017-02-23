package baseDeDonnees
import scala.xml.XML
object XMLResultat {

	val xml = XML.loadFile("http://subversion.istic.univ-rennes1.fr/2015-16-gen-a/Avatar/src/baseDeDonnees/vAr.xml")
	
	  def extraitAdresse(a:String):String={		    
			  var adresse = ""
			  
			  var baseBis = Map [String,String]()
			  
			  
			  for (i<- xml){
			    
			    baseBis = baseBis+( "nom"-> "adresse")
			  }
			  
			  
//			    val nom = print ( l )
//			    
//			    return Tag("html",List(),
//			                   List(Tag("head",List(),
//			                            List(Tag("meta",List(("content","text/html; charset=iso-8859-1")),List()),
//			                            		Tag("title",List(),List(Text("Liste des resultats"))))),
//			                        Tag("body",List(), List(
//			                           Tag ( "center", List(),  res)))))
		//	}
			  

//			  def print ( l:List[(String,String)]):List[Html]={
//			    var res = List[Html]()
//
//			    for ( (t1,t2) <- l ) {
//			      res = res :+ Tag("a", List(("href",t2)), List(Text(t1)))
//			    }
//			    
//			    return res
//			    
			  return " "
			  }
//	
	  
	  
}
