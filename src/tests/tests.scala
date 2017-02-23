package tests

import org.junit.Test
import org.junit.Assert._
import machine.MachineImpl
import machine.MachineDialogue
import fautes.ToleranceFautesImpl
import UserInterface.requestField
import UserInterface.GUI
import UserInterface.answerField
import UserInterface.UI
import client.Client
import baseDeDonnees.BaseDeDonnees
import baseDeDonnees.ContenuBaseDeDonnee
import baseDeDonnees._
import analyse_phrase.analyse_class
import analyse_phrase.analyse_app
import analyse_phrase.analyseTrait


class tests {
// assertTrue(m.suivantPossible)  
  

// @Test
//  def testmachine{
//   // Aucun commit
// }
//
//  
// @Test
//  def testBDD{
//    val BDD = ContenuBaseDeDonnee
//    for (i<-0 to BDD.Base.size){
//     // assertEquals(true,BDD.contient(BDD.Base(i)))
//    }
//    assertEquals(true,BDD.contient("Gare SNCF; 19, Place de la Gare"))
//    assertEquals(true,BDD.contient("Mairie de Rennes; Place de la Mairie"))
//    assertEquals(false,BDD.contient("Un truc qui existe pas"))
// }
 @Test
  def testmachine{
   // Aucun commit
 }

  
 @Test
  def testBDD{
    val BDD = ContenuBaseDeDonnee
    for (i<-0 to BDD.Base.size){
     // assertEquals(true,BDD.contient(BDD.Base(i)))
    }
 //   assertEquals(true,BDD.contient("Gare SNCF; 19, Place de la Gare"))
  //  assertEquals(true,BDD.contient("Mairie de Rennes; Place de la Mairie"))
 //   assertEquals(false,BDD.contient("Un truc qui existe pas"))
 }
 @Test
  def testAnalysePH{
    val APH = new analyse_class
    val base = ContenuBaseDeDonnee
    assertEquals(List("Theatre National de Bretagne"),APH.motCle("Je recherche le chemin vers TNB", base.getKeyword))
    assertEquals(List(),APH.motCle("Je recherche le chemin vers st anne",base.getKeyword))
    assertEquals(List("Mairie de Rennes"),APH.motCle("Hotel de Ville", base.getKeyword))
    assertEquals(List("Theatre National de Bretagne"),APH.analyse("Je recherche le chemin vers TNB"))
    assertEquals(List(),APH.analyse("Je recherche le chemin vers st anne"))
    assertEquals(List("Mairie de Rennes"),APH.analyse("Mairie de Rennes"))
    assertEquals(List(), APH.analyse("jkgf"))
    assertEquals(List("Gare SNCF"),APH.analyse("Je cherche la Gare SNCF"))
    assertEquals(List(),APH.analyse("Je m'appelle Romain je cherche le Theatre"))
    assertEquals(List("Theatre la Paillette"),APH.motCle("La Paillette", base.getKeyword))
    assertEquals(List("Theatre la Paillette"),APH.analyse("La Paillette"))
    assertEquals(List("Theatre la Paillette"),APH.analyse("Paillette"))
    assertEquals(List("Theatre la Paillette"),APH.analyse("Je cherche le theatre la Pallette"))

    
 }
 
   
 

  
}