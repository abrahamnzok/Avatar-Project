package fautes;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert._

class HammingTest {

  val calc:Hamming = new Hamming
  
	@Test
	def testTailleDifference1 {
		val mot2:String = "hotel"
		val mot1:String = "hotele"
		
		assertEquals(-1,calc.distanceHamming(mot1, mot2)) 
	}

  @Test
	def testTailleDifferente {
		val mot2:String = "hotel"
		val mot1:String = "hot"
		
		assertEquals(-1,calc.distanceHamming(mot1, mot2)) 
	}
  
  @Test
	def testMotVide {
		val mot2:String = "hotel"
		val mot1:String = ""
		
		assertEquals(-1,calc.distanceHamming(mot1, mot2)) 
	}
  	
  @Test
	def testMotMemeTaille {
		val mot2:String = "hotel"
		val mot1:String = "hotrl"
		
		assertEquals(1,calc.distanceHamming(mot1, mot2)) 
	}
  
  @Test
	def testMotIdentique {
		val mot2:String = "hotel"
		val mot1:String = "hotel"
		
		assertEquals(0,calc.distanceHamming(mot1, mot2)) 
	}
  
  @Test
	def testMotAccent {
		val mot2:String = "hotel"
		val mot1:String = "hôtel"
		
		assertEquals(0,calc.distanceHamming(mot1, mot2)) 
	}
  
  @Test
	def testDifferenceDebutTailleDifferente{
		val mot2:String = "VILLE"
		val mot1:String = "VLLE"
		assertEquals(1,calc.distanceHamming(mot1, mot2)) 
	}
  
  @Test
  def testDifferenceMajMin{
    val mot2:String = "VillE"
		val mot1:String = "VILLE"
		assertEquals(0,calc.distanceHamming(mot1, mot2)) 
  }
  
  @Test
  def testAccentsMaj{
    val mot2:String = "Théâtre de LA Paillette"
		val mot1:String = "tHeatre DE la pâillette"
		assertEquals(0,calc.distanceHamming(mot1, mot2)) 
  }
  
  
}
