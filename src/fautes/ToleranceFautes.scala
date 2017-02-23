package fautes

/**
 * @author 15012465
 *
 */
trait ToleranceFautes {
  
/**
 * Prend en paramètre un mot clé et le corrige. 
 * 
 * Si le mot clé donné est correct, il est retourné tel quel (exemple: corrigerFautes("Gare") renvoi "Gare".
 * 
 * Si le mot donné n'est pas corrigable, on renvoi une chaine vide. 
 * 
 * Il est recommandé d'appeler la méthode estCorrigeable(keyword:String):Boolean avant d'appeler cette méthode.
 * 
 * @param keyword Le mot clé à corriger.
 * @return Le mot clé corrigé.
 */
  
def corrigerFautes(keyword:String):String


/**
 * La fonction "estCorrect" dit si oui ou non le mot est correctement ecris.
 * @param keyword Un mot clé dont on veut vérifier l'exactitude. Exemple: "l'hôtel" est correct, "l'hotl" ne l'est pas.
 * @return true si le mot clé est correct. Un mot clé correct est connu de la base de donné.
 */
def estCorrect(keyword:String):Boolean

}