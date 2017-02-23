 package UserInterface

import java.awt.Font
import scala.swing._

class send(lab: String, from: requestField) extends Button {
  text = lab
  font = new Font("Helvetica Neue", java.awt.Font.ROMAN_BASELINE, 14)
  tooltip = "Click to send a request to the avatar"

  object userQuery{
    def query: String = {
      val t = from.text
      t
    }
  }


}