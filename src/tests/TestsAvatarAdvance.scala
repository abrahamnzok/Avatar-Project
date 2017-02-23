

package tests

import org.junit.Test
import org.junit.Assert._
import Avatar._

class TestsAvatarAdvance {
  val avatar = Avatar

  
  //F6
  @Test
  def testPLusieursReponsesCasA {
     assertEquals(List("J'ai 4 reponses possibles :", "1) Piscine Villejean", "2) Piscine Gayeulles", "3) Piscine Brequigny", "4) Piscine Saint-Georges",
         "Quel est votre choix?"),
         avatar.reponse("Je cherche une piscine"))
         
     assertEquals(List("L'adresse de Piscine Brequigny est : 10, Boulevard Albert 1er"), avatar.reponse("je choisi la 3"))
  }
    @Test
    def testPLusieursReponsesCasB {
     assertEquals(List("J'ai 4 reponses possibles :", "1) Piscine Villejean", "2) Piscine Gayeulles", "3) Piscine Brequigny", "4) Piscine Saint-Georges",
         "Quel est votre choix?"),
         avatar.reponse("Je cherche une piscine"))
         
     assertEquals(List("L'adresse de Piscine Brequigny est : 10, Boulevard Albert 1er"), avatar.reponse("3"))
  }
  @Test  
  def testPLusieursReponsesCasC {
     assertEquals(List("J'ai 4 reponses possibles :", "1) Piscine Villejean", "2) Piscine Gayeulles", "3) Piscine Brequigny", "4) Piscine Saint-Georges",
         "Quel est votre choix?"),
         avatar.reponse("Je cherche une piscine"))
         
     assertEquals(List("Je ne comprends pas votre demande"), avatar.reponse("je choisi la 18"))
  }
  @Test
  def testPLusieursReponsesCasD {
     assertEquals(List("J'ai 4 reponses possibles :", "1) Piscine Villejean", "2) Piscine Gayeulles", "3) Piscine Brequigny", "4) Piscine Saint-Georges",
         "Quel est votre choix?"),
         avatar.reponse("Je cherche une piscine"))
         
     assertEquals(List("Je ne comprends pas votre demande"), avatar.reponse("18"))
  }
  @Test
  def testPLusieursReponsesCasE {
     assertEquals(List("J'ai 4 reponses possibles :", "1) Piscine Villejean", "2) Piscine Gayeulles", "3) Piscine Brequigny", "4) Piscine Saint-Georges",
         "Quel est votre choix?"),
         avatar.reponse("Je cherche une piscine"))
         
     assertEquals(List("Je ne comprends pas votre demande"), avatar.reponse("oui"))
  }
  @Test
  def testPLusieursReponsesCasF {
     assertEquals(List("J'ai 4 reponses possibles :", "1) Piscine Villejean", "2) Piscine Gayeulles", "3) Piscine Brequigny", "4) Piscine Saint-Georges",
         "Quel est votre choix?"),
         avatar.reponse("Je cherche une piscine"))
         
     assertEquals(List("L'adresse de Piscine Brequigny est : 10, Boulevard Albert 1er"), avatar.reponse("3 4"))
  }
  @Test
  def testPLusieursReponsesCasG {
     assertEquals(List("J'ai 4 reponses possibles :", "1) Piscine Villejean", "2) Piscine Gayeulles", "3) Piscine Brequigny", "4) Piscine Saint-Georges",
         "Quel est votre choix?"),
         avatar.reponse("Je cherche une piscine"))
         
     assertEquals(List("L'adresse de Piscine Brequigny est : 10, Boulevard Albert 1er"), avatar.reponse("3 et 4"))
  }
  @Test
  def testPLusieursReponsesCasH {
     assertEquals(List("J'ai 4 reponses possibles :", "1) Piscine Villejean", "2) Piscine Gayeulles", "3) Piscine Brequigny", "4) Piscine Saint-Georges",
         "Quel est votre choix?"),
         avatar.reponse("Je cherche une piscine"))
         
     assertEquals(List("Je ne comprends pas votre demande"), avatar.reponse("34"))
  }
  
   @Test
  def testPLusieursReponsesCasEspagnol {
     assertEquals(List("Tengo 4 opciones :", "1) Piscine Villejean", "2) Piscine Gayeulles", "3) Piscine Brequigny", "4) Piscine Saint-Georges",
         "Cuàl es su elección ?"),
         avatar.reponse("Busco una piscina"))
         
   }
   
@Test
  def testPLusieursReponsesCasAnglais {
     assertEquals(List("I found 4 answers :", "1) Piscine Villejean", "2) Piscine Gayeulles", "3) Piscine Brequigny", "4) Piscine Saint-Georges",
         "What is your choice ?"),
         avatar.reponse("I am looking for a pool"))
         
   }

@Test
  def testPLusieursReponsesCasAllemand {
     assertEquals(List("Ich habe 4 antworten :", "1) Piscine Villejean", "2) Piscine Gayeulles", "3) Piscine Brequigny", "4) Piscine Saint-Georges",
         "Was ist thre wahl?"),
         avatar.reponse("Ich möchte einen pool"))
         
   }

@Test
  def testPLusieursReponsesCasItalien {
     assertEquals(List("Ho 4 risposte :", "1) Piscine Villejean", "2) Piscine Gayeulles", "3) Piscine Brequigny", "4) Piscine Saint-Georges",
         "Qual è la vostra scelta?"),
         avatar.reponse("Voglio una piscina"))
         
   }
 
  
}