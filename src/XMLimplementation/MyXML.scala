package XMLimplementation
import scala.xml._


object my_xml_test2  {
    //On recupere le fichier XML sous la forme dun element
  	val my_xml2 = XML.loadFile("./doc/vAr.xml")  	
  	//On change lelement obtenu en liste de noeuds
  	val nodelist = my_xml2.toList
  	
  	var bddMyXML = Map [String,String]()
  	var res : String = ""
  	var key : String = ""
  	var key2 : String = ""
  	var city : String = ""
  	var adressXML = Map [String, String]()
  	
  	//On parcourt cette liste de noeuds pour obtenir les noms, adresses, acronyms des lieux du fichier xml
  	for (i <- nodelist){
  	  for (l <- i.child){
  	    for ( m <- l.child){
  	      for (n <- m.child){
  	        for (o <- n.child){
  	          if (o.label == "name"){
  	            //println(o.text)
  	            key = o.text
  	          }
  	          if (o.label == "acronym"){
  	            //println(o.text)
  	            key2 = o.text
  	          }
  	          for (p <- o.child){
  	            for (q <- p.child){
  	              if (q.label == "city"){
  	                //println(q.text)
  	                city = q.text
  	              }
  	            }
  	            for (t <- p.child){
  	              for (r <- t.child){
  	                if (r.label == "number" && r.text.nonEmpty){
  	                  res = res + r.text + ", "
  	                }
  	                else if (r.label == "name"){
  	                  if(r.text.contains(",")){
  	                    res = res + r.text.split (",")(0)
  	                  }
  	                  else{
  	                    res = res + r.text
  	                  }
  	                  if (city == "Rennes" && res.nonEmpty){
  	                    bddMyXML = bddMyXML+(key -> res)
  	                    adressXML = adressXML+(res -> key)
  	                    //println(city)
  	                    if (key2.nonEmpty){
  	                      bddMyXML = bddMyXML+(key2 -> res)
  	                    }
  	                    //println(bddMyXML(key))
  	                    //println(adressXML(res)) 
  	                  }
  	                  res = ""
  	                  key = ""
  	                }
  	              }
  	            }
  	          }
  	        }}}}}

}

object Test extends App {
   my_xml_test2
}
