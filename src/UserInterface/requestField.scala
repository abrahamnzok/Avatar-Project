 package UserInterface

import java.awt.Font
import scala.swing.TextField

class requestField extends TextField {
  columns = 25
  font = new Font("Courrier New", java.awt.Font.PLAIN, 14)
  tooltip = "Entrer votre question"
}