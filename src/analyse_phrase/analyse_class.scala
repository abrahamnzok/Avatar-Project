package analyse_phrase
import fautes._
import baseDeDonnees._

class analyse_class extends analyseTrait {
val correcteur =  ToleranceFautesImpl
val validation = ContenuBaseDeDonnee

/**
 * recois une requete sous forme de String en entree et renvois 1 List[String] correspondant au mot cle attendu par la base de donnee.
 * La phrase recu est corrigee par la fonction corrigerFautes.
 * @param phrase requete attendu
 * @return mot cle attendu par la base de donnee
 */
	def analyse(phrase:String):List[String] = { 
			var phrasecorrige = phrase
			phrasecorrige = correcteur.retirerDefaut(phrasecorrige)
			phrasecorrige = correcteur.corrigerFautes(phrasecorrige)
			phrasecorrige = correcteur.retirerDefaut(phrasecorrige.toLowerCase())
      val listCle = sansDoublon(motCle(phrasecorrige, validation.getKeyword ++ validation.getKeywordPolitesse))
			if (validation.validationRep(validation.testdeladernierechance(listCle))){
			  validation.testdeladernierechance(listCle)
			}else List("") 	
	}

/**
 * recherche les mot cle dans la phrase
 */
	def motCle(phrase:String, base:List[String]):List[String]={
	  base match {
	    case "TNB"::tail => if(phrase.contains("tnb")) ( "Théâtre National de Bretagne" +: motCle(phrase, tail)) else (motCle(phrase, tail))
	    case "Gare"::tail => if(phrase.contains("gare")) ( "Gare SNCF" +: motCle(phrase, tail)) else (motCle(phrase, tail))
	    case "SNCF"::tail => if(phrase.contains("sncf")) ( "Gare SNCF" +: motCle(phrase, tail)) else (motCle(phrase, tail))
	    case "Mairie"::tail => if(phrase.contains("mairie")) ( "Mairie de Rennes" +: motCle(phrase, tail)) else (motCle(phrase, tail))
	    case "Hôtel de Ville"::tail => if(phrase.contains("hotel de ville")) ( "Mairie de Rennes" +: motCle(phrase, tail)) else (motCle(phrase, tail))
	    case "Hôtel"::tail => if(phrase.contains("hotel")) ( "Mairie de Rennes" +: motCle(phrase, tail)) else (motCle(phrase, tail))
	    case "l'Hôtel de Ville"::tail => if(phrase.contains("l'hotel de ville")) ("Mairie de Rennes" +: motCle(phrase, tail)) else (motCle(phrase, tail))
	    case "Paillette"::tail => if(phrase.contains("paillette")) ( "Théâtre La Paillette" +: motCle(phrase, tail)) else (motCle(phrase, tail))
	    case "Théâtre de Bretagne"::tail => if(phrase.contains("theatre de bretagne")) ( "Théâtre National de Bretagne" +: motCle(phrase, tail)) else (motCle(phrase, tail))
	    case head::tail => if(phrase.contains(correcteur.retirerDefaut(head.toLowerCase()))) ( head +: motCle(phrase, tail)) else (motCle(phrase, tail))
	    case Nil => Nil
	  }
	}
	
	/**
	 * enleve doublon 
	 */
	  def sansDoublon (l:List[String]):List[String]= {
	    var listeARendre = List[String]()
	    for (e <- l) {
	      if(!listeARendre.contains(e)) {
	        listeARendre = listeARendre :+ e
	      }
	    }
	    listeARendre
	  }
}