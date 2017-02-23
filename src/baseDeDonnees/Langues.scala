package baseDeDonnees

object Langues {
  // c'est les Map des langues
  val Politesse = Map[String, String](
    "bonjour" -> "francais", "salut" -> "francais", "bonsoir" -> "francais",
    "hello" -> "english", "morning" -> "english", "evening" -> "english", "afternoon" -> "english", "hey" -> "english",
    "hola" -> "español", "buenos" -> "español", "dias" -> "español",
    "hallo" -> "deutsch", "guten" -> "deutsch", "morgen" -> "deutsch", "tag" -> "deutsch", "abend" -> "deutsch",
    "buongiorno" -> "italiano", "ciao" -> "italiano", "salve" -> "italiano", "buon" -> "italiano", "pomeriggio" -> "italiano", "buonasera" -> "italiano", "incantato" -> "italiano")

  val Recherche = Map[String, String](
    "recherche" -> "francais", "cherche" -> "francais", "ou" -> "francais","donc" -> "francais", "trouve" -> "francais", "trouver" -> "francais",
    "seek" -> "english", "seeking" -> "english", "search" -> "english", "searching" -> "english", "look" -> "english", "looking" -> "english", "where" -> "english", "find" -> "english",
    "donde" -> "español", "esta" -> "español", "busco" -> "español", "buscando" -> "español",
    "wo" -> "deutsch", "suche" -> "deutsch", "suchen" -> "deutsch",
    "buongiorno" -> "italiano", "ciao" -> "italiano", "salve" -> "italiano", "buon" -> "italiano", "pomeriggio" -> "italiano", "buonasera" -> "italiano", "incantato" -> "italiano", "cerco" -> "italiano")

  val NomDeLangue = Map[String, String](
    "francais" -> "francais", "anglais" -> "english", "espagnol" -> "español", "allemand" -> "deutsch", "italien" -> "italiano",
    "français" -> "francais", "english" -> "english", "español" -> "español", "espanol" -> "español","deutsch" -> "deutsch", "italiano" -> "italiano")

  val Expressionfr = Map[String, String](
    "bonjour" -> "Bonjour",
    "oui" -> "oui", "non" -> "non", "L'adresse de XXX est : " -> "L'adresse de XXX est : ", "Je ne comprends pas votre demande" -> "Je ne comprends pas votre demande",
    "Parlez-vous français?" -> "Parlez-vous français?", "D'accord, quelle est votre demande?" -> "D'accord, quelle est votre demande?",
    "J'ai XXX réponses possibles : " -> "J'ai XXX réponses possibles : ", "Quel est votre choix?" -> "Quel est votre choix?", "restaurant" -> "restaurant",
    "creperie" -> "creperie", "pizzeria" -> "pizzeria")

  val ExpressionAng = Map[String, String](
    "bonjour" -> "Hello",
    "oui" -> "yes", "non" -> "no", "L'adresse de XXX est : " -> "The address of XXX is : ", "Je ne comprends pas votre demande" -> "I do not understand",
    "Parlez-vous français?" -> "Do you speak english?", "D'accord, quelle est votre demande?" -> "OK, what is your query?",
    "J'ai XXX réponses possibles : " -> "I found XXX answers : ", "Quel est votre choix?" -> "What is your choice?", "restaurant" -> "restaurant",
    "creperie" -> "creperie", "pizzeria" -> "pizzeria")

  val ExpressionEsp = Map[String, String](
    "bonjour" -> "Hola",
    "oui" -> "si", "non" -> "no", "L'adresse de XXX est : " -> "La dirección de XXX es : ", "Je ne comprends pas votre demande" -> "No comprendo",
    "Parlez-vous français?" -> "Hablas español?", "D'accord, quelle est votre demande?" -> "Está bien, cuál es tu petición?",
    "J'ai XXX réponses possibles : " -> "Tengo XXX opciones : ", "Quel est votre choix?" -> "Cuál es su elección?",
    "restaurant" -> "restaurante", "creperie" -> "creperie", "pizzeria" -> "pizzeria", "bonjour" -> "Hola")

  val ExpressionDeu = Map[String, String](
    "bonjour" -> "Hallo",
    "oui" -> "ja", "non" -> "nein", "L'adresse de XXX est : " -> "Die adresse von XXX ist : ", "Je ne comprends pas votre demande" -> "Ich verstehe nicht",
    "Parlez-vous français?" -> "Sprechen Sie Deutsch?", "D'accord, quelle est votre demande?" -> "Okay, was ist Ihr Wunsch?",
    "J'ai XXX réponses possibles : " -> "Ich habe XXX Antworten : ", "Quel est votre choix?" -> "Was ist Ihre Wahl?",
    "restaurant" -> "restaurant", "creperie" -> "creperie", "pizzeria" -> "pizzeria")

  val ExpressionIt = Map[String, String](
    "bonjour" -> "Buongiorno",
    "oui" -> "si", "non" -> "no", "L'adresse de XXX est : " -> "Indirizzo di XXX è : ", "Je ne comprends pas votre demande" -> "No capisco",
    "Parlez-vous français?" -> "Parli italiano?", "D'accord, quelle est votre demande?" -> "Va bene, qual è la tua richiesta?",
    "J'ai XXX réponses possibles : " -> "Ho XXX risposte : ", "Quel est votre choix?" -> "Qual è la vostra scelta?", "restaurant" -> "ristorante",
    "creperie" -> "creperia", "pizzeria" -> "pizzeria")
   
   val keywordLangNomDeLangue = NomDeLangue.keySet.toList
   val keywordLangPolitesse = Politesse.keySet.toList
 	 val keywordLangRecherche = Recherche.keySet.toList
   val keywordLangExpressionfr = Expressionfr.keySet.toList
	 val keywordLangExpressionAng = ExpressionAng.keySet.toList
 	 val keywordLangExpressionEsp = ExpressionEsp.keySet.toList
 	 val keywordLangExpressionDeu = ExpressionDeu.keySet.toList
 	 val keywordLangExpressionIt = ExpressionIt.keySet.toList
  /**
   * base de donnees complete des langues              
   */
  def getKeywordLang : List[String] = {
    return keywordLangNomDeLangue ++ keywordLangPolitesse ++ keywordLangRecherche ++ keywordLangExpressionfr ++ keywordLangExpressionAng ++ keywordLangExpressionEsp ++ keywordLangExpressionDeu ++ keywordLangExpressionIt
  }

}