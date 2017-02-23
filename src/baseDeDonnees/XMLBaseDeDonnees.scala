package baseDeDonnees

sealed trait Xml
case class Tag(name:String, children:List[Xml]) extends Xml
case class Text(content:String) extends Xml

/** Un exemple de document html qui correspond au code HTML suivant:
 *  <html>
 *    <head>
 *      <meta content="text/html; charset=ISO-8859-1"></meta>
 *      <title> MyPage </title>
 *    </head>
 *    <body>
 *      "&nbsp"
 *      <center>
 *        <a href="http://www.irisa.fr"> Lien <img> </img> </a>
 *      </center>
 *    </body>
 *  </html>
 */

object ExempleXML{
  val exempleXml = Tag("data", List(
                     Tag("organization", List(
                         Tag("id", List(
                             Text("274"))),
                         Tag("acronym", List()),
                         Tag("name", List(
                             Text("Direction habitat social"))),
                         Tag("description", List(
                             Text("Lieu d'enregistrement de la demande de logement social pour l'ensemble des bailleurs sociaux"))),
                         Tag("minitel", List()),
                         Tag("email", List(
                             Text("dhs@ville-rennes.fr"))),
                         Tag("information", List(
                             Text("Metro Clemenceau"))),
                         Tag("web", List(
                             Text("metropole.rennes.fr"))),
                         Tag("schedule", List(
                             Text("Lundi au vendredi, 9h a 12h30 et 13h30 a 17h. Ferme jeudi matin. Possibilite d'etre recu sur rendez-vous."))),
                         Tag("adresses", List(
                             Tag("adress", List(
                                 Tag("street", List(
                                     Tag("number", List(
                                         Text("1"))),
                                     Tag("extension", List()),
                                     Tag("building", List()),
                                     Tag("name", List(
                                         Text("Place de la Communaute"))))),
                                 Tag("zipcode", List(
                                     Text("35031"))),
                                 Tag("pobox", List(
                                     Text("CS 63126"))),
                                 Tag("city", List(
                                     Text("Rennes"))),
                                 Tag("district", List(
                                     Text("Brequigny"))),
                                 Tag("phone", List(
                                     Text("02 23 62 16 30"))),
                                 Tag("phone", List()),
                                 Tag("fax", List()),
                                 Tag("latitude", List(
                                     Text("48,09285128"))),
                                 Tag("longitude", List(
                                     Text("-1,675734069"))),
                                 Tag("accessibility", List(
                                     Text("2"))))))),
                         Tag("theme", List(
                             Text("195,544"))),
                         Tag("theme", List(
                             Text("195,544"))),
                         Tag("theme", List(
                             Text("1373,1437")))))))
}