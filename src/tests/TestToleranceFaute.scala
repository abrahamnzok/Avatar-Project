package tests


import org.junit.Test
import org.junit.Assert._
import fautes.ToleranceFautesImpl

class TestToleranceFaute {

	val faute =  ToleranceFautesImpl

			@Test
			def testfautesCasPasDeFauteMotSimple{
		assertEquals("Hôtel",ToleranceFautesImpl.corrigerFautes("hotel"))
	}

	@Test
	def testfautesCasPasDeFautePhrase{
		assertEquals("Hôtel de Ville",ToleranceFautesImpl.corrigerFautes("Hotel de Ville"))
	}

	@Test
	def testCorrectionMotSimple{
		assertEquals("Hôtel",ToleranceFautesImpl.corrigerFautes("hotal"))
	}

	@Test
	def testCorrectionPhraseSimple{
		assertEquals("Théâtre La Paillette",ToleranceFautesImpl.corrigerFautes("THzatre La pallette"))
		assertEquals("Hôtel de Ville",ToleranceFautesImpl.corrigerFautes("hotal de Pille"))
	}

	@Test
	def testCorrectionMotSimpleTailleDifference{
		assertEquals("Hôtel",ToleranceFautesImpl.corrigerFautes("hotl"))
	}


	@Test
	def testCorrectionPhraseTailleDifference{
		assertEquals("Hôtel de Ville",ToleranceFautesImpl.corrigerFautes("hotl de Ville"))
		assertEquals("Hôtel de Ville",ToleranceFautesImpl.corrigerFautes("hotl de ille"))
	}

	@Test
	def testCorrectionImpossible {
		assertEquals("",ToleranceFautesImpl.corrigerFautes("hotzul"))
		assertEquals("",ToleranceFautesImpl.corrigerFautes("kenan"))   
	}

	@Test
	def testCasse {
		assertEquals("Hôtel de Ville",ToleranceFautesImpl.corrigerFautes("HoTEL de ViLlE"))
		assertEquals("Hôtel de Ville",ToleranceFautesImpl.corrigerFautes("hOTl de VILle"))
	}

	@Test
	def casMotTropGrand {
		assertEquals("",ToleranceFautesImpl.corrigerFautes("Hotelz"))
	}

	@Test
	def casMotTropGrandPhrase {
		assertEquals("Hôtel de ",ToleranceFautesImpl.corrigerFautes("hotl de Villes"))
		assertEquals("  ",ToleranceFautesImpl.corrigerFautes("hotels des Villes"))
		assertEquals(" de ",ToleranceFautesImpl.corrigerFautes("hotels de Villes"))
	}
	@Test 
	def specialHotel {
		//   assertEquals("Mairie",ToleranceFautesImpl.corrigerFautes("mairie de rennas"))
		assertEquals("Hôtel",ToleranceFautesImpl.corrigerFautes("Hotel"))
		assertEquals("Hôtel",ToleranceFautesImpl.corrigerFautes("Hôtal"))
		assertEquals("Hôtel",ToleranceFautesImpl.corrigerFautes("Hotal"))
		assertEquals("Hôtel",ToleranceFautesImpl.corrigerFautes("HôtEL"))
		assertEquals("Hôtel",ToleranceFautesImpl.corrigerFautes("hotl"))
		assertEquals("Hôtel",ToleranceFautesImpl.corrigerFautes("hôtel"))
		assertEquals("Hôtel de Ville",ToleranceFautesImpl.corrigerFautes("Hôtel de Ville"))
		assertEquals("Hôtel de Ville",ToleranceFautesImpl.corrigerFautes("hôtel de Ville"))
		assertEquals("Hôtel de Ville",ToleranceFautesImpl.corrigerFautes("Hôtel de ville"))
	}

	@Test
	def MotLangues {
		assertEquals("hello",ToleranceFautesImpl.corrigerFautes("hello"))
		assertEquals("buon",ToleranceFautesImpl.corrigerFautes("beon"))
		assertEquals("ciao",ToleranceFautesImpl.corrigerFautes("cio"))
		assertEquals(" Gare",ToleranceFautesImpl.corrigerFautes("hello gore"))
		assertEquals(" Gare",ToleranceFautesImpl.corrigerFautes("Yello gare"))
		assertEquals("english",ToleranceFautesImpl.corrigerFautes("ênglis"))
		assertEquals("français",ToleranceFautesImpl.corrigerFautes("français"))
		assertEquals("francais",ToleranceFautesImpl.corrigerFautes("francais"))
		assertEquals("francais",ToleranceFautesImpl.corrigerFautes("franwais"))
		assertEquals("english",ToleranceFautesImpl.corrigerFautes("engwish?"))
	}



}