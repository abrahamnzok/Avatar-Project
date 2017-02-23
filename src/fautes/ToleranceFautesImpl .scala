package fautes

import baseDeDonnees._;
import java.text.Normalizer

object ToleranceFautesImpl extends ToleranceFautes {

  private val knownKeywords: List[String] = ContenuBaseDeDonnee.getKeyword
  private val knownKeywordsPolitesse: List[String] = ContenuBaseDeDonnee.getKeywordPolitesse
  private val knownKeywordLang: List[String] = Langues.getKeywordLang
  private val hamming: Hamming = new Hamming

 /**
  * savoir si le mot est correcte dans la base de donnees
  */
  def estCorrect(keyword: String): Boolean = {
    knownKeywords.contains(keyword.trim()) || knownKeywordsPolitesse.contains(keyword.trim()) || knownKeywordLang.contains(keyword.trim())
  }
/**
 * corrige les fautes 
 */
  def corrigerFautes(keyword: String): String = {
    if (keyword == null || keyword.trim().equals("")) {
      return "";
    } else {
      if (estCorrect(keyword.trim())) {
        return keyword.trim();
      } else {
        var motpolitesse = corrigerMotCompletPolitesse(refArrayOps(keyword.split(" ")).toList)
        var motcomplet = corrigerMotComplet(refArrayOps(keyword.split(" ")).toList)
        var motcompletLang = corrigerMotCompletLangues(refArrayOps(keyword.split(" ")).toList)
        var motcompletLangMotCle = corrigerMotComplet(refArrayOps(motcompletLang.split(" ")).toList)

        if (motpolitesse.nonEmpty) {
          motpolitesse
        } else {
          if (motcompletLang.nonEmpty) {
            motcompletLang
          } else {
            motcomplet
          }
        }
      }
    }
  }

  /**
   * La fonction corrigerMotComplet corrige une liste entriere de mot.
   * @param listeMots la liste de mots.
   * @return Une string corrigee de l'ensemble de la liste passee en parametre.
   */

  def corrigerMotComplet(listeMots: List[String]): String = {
    listeMots match {
      case Nil => ""
      case e :: Nil => corrigerFautesMotSimple(e, knownKeywords)
      case e :: r => corrigerFautesMotSimple(e, knownKeywords) + " " + corrigerMotComplet(r)
    }
  }

  /**
   * La fonction corrigerMotCompletPolitesse corrige une liste entriere de mot de politesse.
   * @param listeMots la liste de mots politesse.
   * @return Une string politesse corrigee de l'ensemble de la liste passee en parametre.
   */

  def corrigerMotCompletPolitesse(listeMots: List[String]): String = {
    listeMots match {
      case Nil => ""
      case e :: Nil => corrigerFautesMotSimple(e, knownKeywordsPolitesse)
      case e :: r => corrigerFautesMotSimple(e, knownKeywordsPolitesse) + "" + corrigerMotComplet(listeMots)
    }
  }

  /**
   *corrige les mots de langue
   */
  def corrigerMotCompletLangues(listeMots: List[String]): String = {
    listeMots match {
      case Nil => ""
      case e :: Nil => corrigerFautesMotSimple(e, knownKeywordLang)
      case e :: r => corrigerFautesMotSimple(e, knownKeywordLang) + "" + corrigerMotCompletLangues(r)
    }
  }

  /**
   * La fonction corrigerFautesMotSimple corrige un mot.
   * @param keyword Le mot clé à corriger.
   * @return Le mot corrigé de ses fautes.
   */

  def corrigerFautesMotSimple(keyword: String, base: List[String]): String = {
    // println("Mot en cours ---> " + keyword)
    var correctedKeyword = ""
    for (knownKeywordFull <- base) {
      for (knownKeyword <- refArrayOps(knownKeywordFull.split(" ")).toList) {

        val CorrectAccentkeyword = retirerDefaut(keyword) //Retire accents et tirets
        val knownKeywordlower = retirerDefaut(knownKeyword.toLowerCase())
        val knownKeywordUpper = knownKeywordlower.toUpperCase()
        val keywordUpper = CorrectAccentkeyword.toUpperCase()
        // println("Cmp ---> " + knownKeywordUpper + "<->" + keywordUpper + " d: "+ hamming.distanceHamming(keywordUpper, knownKeywordUpper));

        if (knownKeywordUpper.equals(keywordUpper)) { //Correction de la casse.		
          correctedKeyword = knownKeyword;
        } else {
          if (hamming.distanceHamming(keywordUpper, knownKeywordUpper) == 1) { //Correction erreur simple.
            correctedKeyword = knownKeyword
          }
        }
      }
    }
    return correctedKeyword
  }
/**
 * retire tout les defauts
 */
     def retirerDefaut (s:String) : String = {
    var res = s
    res = res.replace("é","e")
    res = res.replace("è","e")
    res = res.replace("ë","e")
    res = res.replace("ê","e")
    res = res.replace("à","a")
    res = res.replace("ä","a")
    res = res.replace("â","a")
    res = res.replace("ù","u")
    res = res.replace("ü","u")
    res = res.replace("û","u")
    res = res.replace("ï","i")
    res = res.replace("î","i")
    res = res.replace("ô","o")
    res = res.replace("ö","o")
    res = res.replace("ç","c")
    res = res.replace("'"," ")
    res = res.replace("-"," ")
    res = res.replace("_"," ")
    res = res.replace("ñ","n")
    res = res.replace ("?","")
    res = res.replace ("!","")
    res = res.replace (".","")
    res = res.replace (":","")
    res = res.replace (",","")
    res = res.replace ("/","")
    res
  }

}