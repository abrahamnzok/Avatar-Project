package Avatar

/*
 * Gère la gestion des réponses multiples en permettant de garder en mémoire les réponses possibles d'une requête précédente.
 * @param choix Les addresses possibles trouvées à partir de la requête utilisateur
 * @param Les mots clés connus extraits de la base de donnée. A chaque mots clés correspond à une adresse.
 */
class GestionnaireReponsesMultiples(choix:List[String], listeMotsCle:List[String]) {
  
  private def choixPossible:List[String]  = choix;
  private def listMotsCle:List[String]  = listeMotsCle;
       
   def getListeMotsCleFromLastRequest() = {
     listMotsCle;
    }
   
    /**
     * @param choix Le numéro du lieu choisi par l'utilisateur. Les indices commencent à 1, car c'est plus évident pour l'utilisateur.
     * @return Le mot clé complet du lieu choisi, tel qu'il est dans la base de donnée (exemple "théatre national de Bretagne").
     * @throw IndexOutOfBoundsException si choix > getNombreChoixPossibles().
     */
    def getChoixMotCle(choix:Int):String = {
       listMotsCle(choix - 1);
    } 
      
   def getChoixPossiblesFromLastRequest() = {
      choixPossible;
    }
   
    /**
     * @param choix Le numéro du lieu choisi par l'utilisateur. Les indices commencent à 1, car c'est plus évident pour l'utilisateur.
     * @return L'addresse du lieu choisi, tel qu'elle est dans la base de donnée (exemple "10,Boulevard Albert 1er").
     * @throw IndexOutOfBoundsException si choix > getNombreChoixPossibles().
     */
    def getChoixAddress(choix:Int):String = {
       choixPossible(choix - 1);
    } 
            
    def getNombreChoixPossibles() = {
      choixPossible.length;
    }
    
  def contiensUnNombre(s:String): Boolean = {
    for(ch <- s ){
      if ( ch.isDigit){
        return true;
      }
    }
    false;
  }
  
 /**
  * Note : si la chaine s contient -10, l'entier retourné est 10 (positif).
 * @param s une chaine dont on sait qu'elle contient un nombre positif, qui représente le choix de l'utilisateur.
 * @return le premier choix rencontré. 0 si s ne contient pas de nombre.
 */
def recupererPremierNombre(s:String):Int = {
    var fullNumber:String = ""

    var i = 0;
    var continuer = true;
    var lastCharWasDigit = false;
    while (i < s.length() && continuer) {
    
          val currentCharIsDigit = s.charAt(i).isDigit;
          
          if ( !currentCharIsDigit && lastCharWasDigit) {
            continuer = false;
          }
          else if (currentCharIsDigit) {
            
            val currentChar = s.charAt(i).toString();
            
            if (! (currentChar.equals("0") && fullNumber.equals("")) ) {
              fullNumber = fullNumber.concat(currentChar);
            }
       
          }
          
          lastCharWasDigit = currentCharIsDigit;
          i += 1;
    }
   
    if (fullNumber.equals("")) {
      0
    }
    else {
        Integer2int(Integer.decode(fullNumber))
    }
 
  }
}
