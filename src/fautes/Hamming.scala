package fautes

class Hamming {

	/**on calcule la distance de Hamming a partir d'un mot entre par l'utilisateur et le mot contenu dans la base de donnees
	 * @param keyword1 le mot entre par l'utilisateur 
	 * @param keyword2 le mot contenu dans la base de donnees
	 * @return la distance de Hamming des deux mots
	 */
	def distanceHamming(keyword1:String, keyword2:String):Int = {
      val word1CorrigeAccents = ToleranceFautesImpl.retirerDefaut(keyword1.toLowerCase())
			val word2CorrigeAccents = ToleranceFautesImpl.retirerDefaut(keyword2.toLowerCase())
			val diffSize = (word2CorrigeAccents.length() - word1CorrigeAccents.length())    
			var distance = 0;
			
      if (diffSize == 1) {
				if (word1CorrigeAccents.length() < word2CorrigeAccents.length()) {
					distance = distanceHamming(ajouterJoker(word1CorrigeAccents,word2CorrigeAccents),word2CorrigeAccents)
				}
				else {
					distance = distanceHamming(word1CorrigeAccents,ajouterJoker(word2CorrigeAccents,word1CorrigeAccents))
				}
			}
			else if (diffSize == 0) {
			  
				distance = calculerDistance(charArrayOps(word1CorrigeAccents.toCharArray()).toList, charArrayOps(word2CorrigeAccents.toCharArray()).toList)
			}
			else {
				distance = -1
			}
			return distance
	}

	/**
	 * @param word1 Le mot le plus petit. Sa taille doit être word2.length() - 1
	 * @param word2 Le mot le plus grand. Sa taille doit être word1.length() + 1
	 */
	private def ajouterJoker(word1:String, word2:String):String = {
			require(word1.length() < word2.length());
			var withJoker:String = "";
			if (word1.isEmpty()) {
				withJoker = word2.substring(1) + "*" //Car différence de taille maximal de 1.
			}
			else if (word1.charAt(0) == word2.charAt(0)) {
				withJoker = word1.charAt(0) + ajouterJoker(word1.substring(1), word2.substring(1))
			}
			else { // Première différence de caractere, on ajoute notre joker.
				withJoker = "*" + word1.charAt(0) + word1.substring(1)
			}

			return withJoker;
	}

  /**
 	* le nombre de lettre de difference entre deux mots 
 	*/
	private def calculerDistance(word1:List[Char], word2:List[Char]):Int = {
			require(word1.length == word2.length)
			
			(word1, word2) match {
			case (Nil, Nil) => 0
			case (lettre1::mot1, lettre2::mot2) => if (lettre1 != (lettre2) ) {
				1 + calculerDistance(mot1, mot2)
			}
			else {
				calculerDistance(mot1, mot2)
			}
		}
	}
}