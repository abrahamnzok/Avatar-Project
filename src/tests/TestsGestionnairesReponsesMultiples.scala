package tests;

import org.junit.Test
import org.junit.Assert._
import org.junit.Before;


import Avatar.GestionnaireReponsesMultiples;

class TestGestionnaireReponsesMultiples {

  def listKeywords = List("Piscine Villejean", "Piscine Gayeulles", "Piscine Bréquigny", "Piscine Saint-Georges");
  def listChoixPossibles = List("1 Square d'Alsace","16 Avenue des Gayeulles",  "10,Boulevard Albert 1er",  "2 Rue Gambetta");
  
	def gestionnaire = new GestionnaireReponsesMultiples(listChoixPossibles, listKeywords);
	
	@Before
	def setUp() {
	}

	@Test
	def testGetChoix() {
		assertEquals("1 Square d'Alsace", gestionnaire.getChoixAddress(1));
		assertEquals("16 Avenue des Gayeulles", gestionnaire.getChoixAddress(2));
		assertEquals("10,Boulevard Albert 1er", gestionnaire.getChoixAddress(3));
	  assertEquals("2 Rue Gambetta", gestionnaire.getChoixAddress(4));
		
	}

	@Test
	def testGetNombreChoixPossibles() {
		assertEquals(4, gestionnaire.getNombreChoixPossibles());
	}

	@Test
	def testContiensUnNombreChiffreUnique() {
	  val userInput:String = "Je choisi le choix 2";
	  
	  assertEquals(true, gestionnaire.contiensUnNombre(userInput));
	}

  @Test
	def testContiensUnNombrePlusieursChiffres() {
	  val userInput:String = "Je choisi le choix 10";
	  
	  assertEquals(true, gestionnaire.contiensUnNombre(userInput));
	}

		
	@Test
	def testRecupererPremierNombreChiffreUnique() {
		 val userInput:String = "Je choisi le choix 2";
	  
	  assertEquals(2, gestionnaire.recupererPremierNombre(userInput));
	}
		
	@Test
	def testRecupererPremierNombrePlusieursChiffres() {
		 val userInput:String = "Je choisi le choix 12";
	  
	  assertEquals(12, gestionnaire.recupererPremierNombre(userInput));
	}

	@Test
	def testRecupererPremierNombreAvecZeroNonSignigicatif() {
		val userInput:String = "Je choisi le choix 0012";
	  
	  assertEquals(12, gestionnaire.recupererPremierNombre(userInput));
	}

	@Test
	def testRecupererPremierNombreQuandPasDeNombre() {
		val userInput:String = "Je choisi le choix a";
	  
	  assertEquals(0, gestionnaire.recupererPremierNombre(userInput));
	}
		
	@Test
	def testRecupererPremierNombreQuandSeulementZero() {
		val userInput:String = "Je choisi le choix 0";
	  
	  assertEquals(0, gestionnaire.recupererPremierNombre(userInput));
	}
		
	@Test
	def testRecupererPremierNombrePlusieursChiffresQuandPlusieursNombres() {
		 val userInput:String = "Je choisi le choix 12 50 10";
	  
	  assertEquals(12, gestionnaire.recupererPremierNombre(userInput));
	}
		
  @Test
	def testRecupererPremierNombreChiffreUniqueQuandPlusieursNombres() {
		val userInput:String = "Je choisi le choix 2 3 5";
	  
	  assertEquals(2, gestionnaire.recupererPremierNombre(userInput));
	}
		
	@Test
	def testRecupererPremierNombreChiffreUniqueAttache() {
		 val userInput:String = "Je choisi le choix n°2";
	  
	  assertEquals(2, gestionnaire.recupererPremierNombre(userInput));
	}
	
	@Test
	def testRecupererPremierNombrePlusieursChiffresAttache() {
		 val userInput:String = "Je choisi le choix n°12";
	  
	   assertEquals(12, gestionnaire.recupererPremierNombre(userInput));
	}

}
