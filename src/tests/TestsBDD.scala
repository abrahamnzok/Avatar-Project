package tests
import baseDeDonnees._
import org.junit.Test
import org.junit.Assert._

class TestsBDD {
   val bdd:BaseDeDonnees = ContenuBaseDeDonnee 

  @Test
  def envoiReponse {
    assertEquals(List("1, Rue Saint-Hélier"), bdd.envoieReponse(List("TNB")))
    assertEquals(List("2, Rue du Pré de Bris"), bdd.envoieReponse(List("Paillette")))
    assertEquals(List("1, Rue Saint-Hélier"), bdd.envoieReponse(List("Theatre National de Bretagne")))
  }
  
  @Test
  def getKeywords {
    val keywords:List[String] = bdd.getKeyword
    assertTrue(keywords.contains("TNB"))
    assertTrue(keywords.contains("Theatre National de Bretagne"))
    assertTrue(keywords.contains("Gare SNCF"))
    assertTrue(keywords.contains("SNCF"))
    assertTrue(keywords.contains("Hotel de Ville"))
    assertTrue(keywords.contains("Mairie de Rennes"))
    assertFalse(keywords.contains("Place de la Mairie, 35031 Rennes"))
    assertFalse(keywords.contains("Place de la Mairie"))
    assertFalse(keywords.contains("Gare : 19, Place de la Gare"))
    assertFalse(keywords.contains("Gare 19, Place de la Gare"))
  }
  
  
}