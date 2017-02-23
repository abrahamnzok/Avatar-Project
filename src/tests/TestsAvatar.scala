package tests

import org.junit.Test
import org.junit.Assert._
import Avatar._

class TestsAvatar {
  val avatar = Avatar
  //Tests de F1
 /*   
  @Test
  def testRechercheDepuisMotSimpleSansFaute {
    assertEquals(List("L'adresse de Théâtre National de Bretagne est : 1, Rue Saint-Hélier"), avatar.reponse("TNB"))
    assertEquals(List("L'adresse de Gare SNCF est : 19, Place de la Gare"), avatar.reponse("SNCF"))
    assertEquals(List("L'adresse de Théâtre La Paillette est : 2, Rue du Pré de Bris"), avatar.reponse("Paillette"))
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), avatar.reponse("Hotel"))
  }
  
  @Test
  def testRechercheDepuisPhraseSansFaute {
    assertEquals(List("L'adresse de Théâtre National de Bretagne est : 1, Rue Saint-Hélier"), avatar.reponse("Je cherche le TNB"))
    assertEquals(List("L'adresse de Gare SNCF est : 19, Place de la Gare"), avatar.reponse("Et la Gare ?"))
    assertEquals(List("L'adresse de Gare SNCF est : 19, Place de la Gare"), avatar.reponse("Et la Gare SNCF ?"))
    assertEquals(List("L'adresse de Théâtre La Paillette est : 2, Rue du Pré de Bris"), avatar.reponse("Où est la Paillette ?"))
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), avatar.reponse("Je cherche l'Hotel"))
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), avatar.reponse("Je cherche l'Hotel de ville"))
  }
  
  @Test
  def testAvecAliase {
    assertEquals(avatar.reponse("Gare SNCF"), avatar.reponse("SNCF"))
    assertEquals(avatar.reponse("Théâtre National de Bretagne"),avatar.reponse("TNB"))
    
    assertEquals(avatar.reponse("Mairie de Rennes"),avatar.reponse("Mairie"))
    assertEquals(avatar.reponse("Mairie de Rennes"), avatar.reponse("Hotel"))
    assertEquals(avatar.reponse("Mairie de Rennes"), avatar.reponse("Hotel de ville"))
    
    assertEquals(avatar.reponse("Théâtre La Paillette"),avatar.reponse("La Paillette"))
  }
  
  
  @Test
  def testRechercheDepuisPhraseSansEspaceAvantPointDivers {
    assertEquals(List("L'adresse de Gare SNCF est : 19, Place de la Gare"), avatar.reponse("Et la Gare?"))
    assertEquals(List("L'adresse de Gare SNCF est : 19, Place de la Gare"), avatar.reponse("Et la Gare SNCF?"))
    assertEquals(List("L'adresse de Théâtre La Paillette est : 2, Rue du Pré de Bris"), avatar.reponse("Où est la Paillette?"))
    
    assertEquals(List("L'adresse de Gare SNCF est : 19, Place de la Gare"), avatar.reponse("Je cherche la Gare SNCF."))
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), avatar.reponse("Je cherche la Mairie!"))
  }
  
  @Test
  def testCasIncomprehensionRequete {
     assertEquals(List("Je ne comprends pas votre demande"), avatar.reponse("Je cherche"))
  }
    
  //Tests de F2
  @Test
  def testRechercheDepuisPhraseAvecTiretSansFaute{
    assertEquals(List("L'adresse de Théâtre National de Bretagne est : 1, Rue Saint-Hélier"), avatar.reponse("Théatre-National de Bretagne"))
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), avatar.reponse("Je-cherche-l'Hotel-de-ville"))
  }
  
   @Test
  def testRechercheDepuisPhraseAvecTiretAvecFaute{
    assertEquals(List("Je ne comprends pas votre demande"), avatar.reponse("Théatre-Nationnal de Bretagne"))
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), avatar.reponse("Je-cherche-l'Hotel-de-volle"))
    assertEquals(List("L'adresse de Théâtre National de Bretagne est : 1, Rue Saint-Hélier"), avatar.reponse("Theatre-Natinal de Bretagne"))
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), avatar.reponse("Je-cherthe-l'Hotel-de-vilpe"))
  }
  
  @Test
  def testRechercheDepuisMotSimpleAccentSansFaute{
    assertEquals(List("L'adresse de Théâtre National de Bretagne est : 1, Rue Saint-Hélier"), avatar.reponse("Théatre National Bretagne"))
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), avatar.reponse("Hôtel"))

  }
  
  @Test
  def testRechercheDepuisMotSimpleAccentAvecFaute{
    assertEquals(List("L'adresse de Théâtre National de Bretagne est : 1, Rue Saint-Hélier"), avatar.reponse("Thétre National de Bretagne"))
    assertEquals(List("L'adresse de Théâtre La Paillette est : 2, Rue du Pré de Bris"), avatar.reponse("Paillètte"))
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), avatar.reponse("HôtAl"))
  }
     
  @Test
  def testRechercheDepuisMotSimpleAvecFaute {
    assertEquals(List("L'adresse de Théâtre National de Bretagne est : 1, Rue Saint-Hélier"), avatar.reponse("TNN"))
    assertEquals(List("L'adresse de Gare SNCF est : 19, Place de la Gare"), avatar.reponse("DNCF"))
    assertEquals(List("L'adresse de Théâtre La Paillette est : 2, Rue du Pré de Bris"), avatar.reponse("Pbillette"))
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), avatar.reponse("Htel"))
  }
  
   @Test
  def testRechercheDepuisPhraseSansMotDeLiaison {
    
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), avatar.reponse("Et la Mairie Rennes ?"))
    assertEquals(List("L'adresse de Gare SNCF est : 19, Place de la Gare"), avatar.reponse("Et Gare SNCF ?"))
    assertEquals(List("L'adresse de Théâtre La Paillette est : 2, Rue du Pré de Bris"), avatar.reponse("Où est Paillette ?"))
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), avatar.reponse("Je cherche l'Hotel ville"))
    assertEquals(List("L'adresse de Théâtre National de Bretagne est : 1, Rue Saint-Hélier"), avatar.reponse("Je cherche Theatre National Bretagne"))
  }
   
  @Test
  def testRechercheDepuisPhraseAvecFaute {
    assertEquals(List("L'adresse de Théâtre National de Bretagne est : 1, Rue Saint-Hélier"), avatar.reponse("Je cherche le TNC"))
    assertEquals(List("L'adresse de Gare SNCF est : 19, Place de la Gare"), avatar.reponse("Et la Gaae ?"))
    assertEquals(List("L'adresse de Théâtre La Paillette est : 2, Rue du Pré de Bris"), avatar.reponse("Où est la Pailette ?"))
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), avatar.reponse("Je cherch k'Hotel"))
  }
  
  @Test 
  def testPhrasePartiellementCorrecte {
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), avatar.reponse("Je cherche l'Hotel de vie"))
    assertEquals(List("L'adresse de Théâtre La Paillette est : 2, Rue du Pré de Bris"), avatar.reponse("Où est le théa la Paillette ?"))
    assertEquals(List("L'adresse de Gare SNCF est : 19, Place de la Gare"), avatar.reponse("Et la Garrrre SNCF ?"))
  }
  
  @Test
  def testRechercheAvecFauteMotTropPetit {
    assertEquals(List("Je ne comprends pas votre demande"), avatar.reponse("Htl"))
    assertEquals(List("Je ne comprends pas votre demande"), avatar.reponse("Pailete"))
    assertEquals(List("Je ne comprends pas votre demande"), avatar.reponse("Je cherche l'Htl de ville"))
  }
  
  @Test
  def testRechercheAvecFauteMotTropGrand {
    assertEquals(List("Je ne comprends pas votre demande"), avatar.reponse("TNBb"))
    assertEquals(List("Je ne comprends pas votre demande"), avatar.reponse("Gares"))
    assertEquals(List("Je ne comprends pas votre demande"), avatar.reponse("Paillettte"))
  }
  
  @Test
  def testInsensibleCasse {
     assertEquals(List("L'adresse de Gare SNCF est : 19, Place de la Gare"), avatar.reponse("Et la GAre sncf ?"))
     assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), avatar.reponse("HoTEl"))
  }
  
   @Test
  def testRechercheDepuisPhraseAvecFautesDiverses {
    
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), avatar.reponse("Et la-MAIRoe-de renKes ?"))
    assertEquals(List("L'adresse de Gare SNCF est : 19, Place de la Gare"), avatar.reponse("Et Gre-SNCF?"))
    assertEquals(List("L'adresse de Théâtre La Paillette est : 2, Rue du Pré de Bris"), avatar.reponse("Où est PaIleTTe ?"))
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), avatar.reponse("Je cherche l'HuteL-de- vilé"))
    assertEquals(List("L'adresse de Théâtre National de Bretagne est : 1, Rue Saint-Hélier"), avatar.reponse("Je cherche Theatte-NaTIOnxl-de BrETBgne"))
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), avatar.reponse("Je cherche l'HuteL-de- villé"))
    assertEquals(List("L'adresse de Théâtre National de Bretagne est : 1, Rue Saint-Hélier"), avatar.reponse("Je cherche Theàtre-NaTIOnal-de brETAgne"))
  }
  
  
  //F3

  @Test
  def testCasIncomprehensionRequeteAvecMotPolitesse {
     assertEquals(List("Bonjour", "Je ne comprends pas votre demande"), avatar.reponse("Bonjour, comment tu t'appelles?"))
  }
  
  @Test
  def testPolitesseDemandeCorrecte {
     assertEquals(List("Bonjour", "L'adresse de Mairie de Rennes est : Place de la Mairie"), avatar.reponse("Bonjour, Je cherche l'hotel de ville"))
     assertEquals(List("Bonjour", "L'adresse de Gare SNCF est : 19, Place de la Gare"), avatar.reponse("Bonjour, Où est la Gare SNCF ?"))  
     assertEquals(List("Bonjour", "L'adresse de Théâtre La Paillette est : 2, Rue du Pré de Bris"), avatar.reponse("Bonjour, Où est le Theatre la Paillette ?"))
     assertEquals(List("Bonjour", "L'adresse de Mairie de Rennes est : Place de la Mairie"), avatar.reponse("Salut, Je cherche l'hotel de ville"))
     assertEquals(List("Bonjour", "L'adresse de Gare SNCF est : 19, Place de la Gare"), avatar.reponse("Bonsoir, Où est la Gare SNCF ?"))    
  }
  
  @Test
  def testPolitesse {
    assertEquals(List("Bonjour"), avatar.reponse("Bonjour"))
  }
  
  //F4
  @Test
  def testAnglaisDemandeCorrecte {
    assertEquals(List("Hello", "The address of Gare SNCF is : 19, Place de la Gare"), avatar.reponse("Hello, I look for gare"))
    assertEquals(List("Hello", "The address of Mairie de Rennes is : Place de la Mairie"), avatar.reponse("Hello, I look for Mairie de Rennes"))
    assertEquals(List("Hello", "The address of Théâtre National de Bretagne est : 1, Rue Saint-Hélier"), avatar.reponse("Hello, I look for Theatre National de Bretagne")) 
  }
  
  @Test
  def testChangementLangue {
    assertEquals(List("Bonjour"), avatar.reponse("Bonjour"))
    assertEquals(List("Hablas español?"), avatar.reponse("Hola"))
    assertEquals(List("Está bien, cuál es tu petición?"), avatar.reponse("si"))
    assertEquals(List("La dirección de Gare SNCF es : 19, Place de la Gare"), avatar.reponse("busco gare"))
    assertEquals(List("Do you speak english?"), avatar.reponse("english?"))
    assertEquals(List("OK, what is your query?"), avatar.reponse("yes"))
    assertEquals(List("The address of Gare SNCF is : 19, Place de la Gare"), avatar.reponse("I look for gare"))
    assertEquals(List("Parlez-vous français?"), avatar.reponse("je cherche le tnb"))
    assertEquals(List("D'accord, quelle est votre demande?"), avatar.reponse("oui"))
    assertEquals(List("Sprechen Sie Deutsch?"), avatar.reponse("wo ist gare?"))
    assertEquals(List("Parli italiano"), avatar.reponse("jkhdfshjssd"))
    assertEquals(List("Parlez-vous français?"), avatar.reponse("jkhdfshjssd"))
    assertEquals(List("Do you speak english?"), avatar.reponse("jkhdfshjssd"))
    assertEquals(List("OK, what is your query?"), avatar.reponse("yes"))
    assertEquals(List("I do not understand"), avatar.reponse("jkhdfshjssd"))
  }
  
  //F5
  @Test
  def testDepuisOpenData {
    assertEquals(List("L'adresse de Piscine Villejean est : 1, SQUARE D'ALSACE"), avatar.reponse("Je cherche la piscine de villejean"))
    assertEquals(List("L'adresse de Piscine Bréquigny est : 10, Boulevard Albert 1er"), avatar.reponse("Je cherche la piscone de brequiny")) //Avec faute
  }
  
  //F6
  @Test
  def testPLusieursReponses {
     assertEquals(List("J'ai 4 reponses possibles :", "1) Piscine Villejean", "2) Piscine Gayeulles", "3) Piscine Bréquigny", "4) Piscine Saint-Georges",
         "Quel est votre choix?"),
         avatar.reponse("Je cherche une piscine"))
         
     assertEquals(List("L'adresse de Piscine Bréquigny est : 10, Boulevard Albert 1er"), avatar.reponse("je choisi la 3"))
  }*/
  @Test
  def PolitesseAdresse {
    assertEquals(List("Bonjour", "L'adresse de Gare SNCF est : 19, Place de la Gare"), avatar.reponse("bonjour gare"))
    assertEquals(List("Bonjour", "L'adresse de Gare SNCF est : 19, Place de la Gare"), avatar.reponse("bnjour gare"))
  }
  
  
}