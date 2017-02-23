package UserInterface

import scala.swing._
import scala.swing.MainFrame
import scala.swing.BorderPanel.Position._
import Avatar._
import java.awt.Color

import scala.swing.event.{ButtonClicked, Key, KeyPressed}

class UI extends MainFrame {
  title = "Avatar Smart Assistant"
  preferredSize = new Dimension(620, 400)
  maximumSize = preferredSize
  minimumSize = preferredSize
  centerOnScreen()

  val u = new requestField
  val s = new send("Send", u)
  var r = new BoxPanel(Orientation.Vertical)

  val g = new MenuBar {
    val app = new Menu("Avatar") {
      val exit = new MenuItem(Action("Exit") {
        sys.exit(0)
      })
      contents += exit
    }
    val about = new Menu("About") {
      val rennes = new MenuItem("Version : 1.0")
      contents += rennes
    }
    contents += app
    contents += about
  }

  val flowPanel = new FlowPanel() {
    contents += u
    contents += s
    background = Color.cyan
  }

  var il = new TextArea {
    text = ""
    background = Color.gray
    foreground = Color.white
    enabled = true
    editable =false
  }

  def keyPressed(): Unit = {
    if(!u.text.isEmpty) {
      val a = Avatar.reponse(s.userQuery.query)
      il.text += "\n\bUser : " + s.userQuery.query
      r.contents += il
      for (i <- a.indices)
        il.text += "\n\bAvatar : ".concat(a(i))
      u.text = null
    }
  }

  def buttonClicked(): Unit = {
    if (!u.text.isEmpty){
      val a = Avatar.reponse(s.userQuery.query)
      il.text += "\nUser : " + s.userQuery.query
      r.contents += il
      for (i <- a.indices)
        il.text += "\nAvatar : ".concat(a(i))
      u.text = null
    }
  }

  contents = new BorderPanel {
    layout += r -> Center
    layout += g -> North
    layout += flowPanel -> South
    listenTo(u.keys)
    reactions += {
      case KeyPressed(_, Key.Enter, _, _) =>
        keyPressed()
        layout += new ScrollPane(il){
          preferredSize = new Dimension(620, 400)
        }->West
      case ButtonClicked(_) =>
        buttonClicked()
        layout += new ScrollPane(il){
          preferredSize = new Dimension(620, 400)
        }->West
    }
  }
}
