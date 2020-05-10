package rock_paper_scissor.client

import javafx.{fxml => jfxf, scene => jfxs}
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalaomg.client.core.Client

object App extends JFXApp {
  private val args: Array[String] = parameters.raw.toArray
  private val host = if (args.length > 0) args(0) else "localhost"
  private val port = if (args.length > 1) args(1).toInt else 8080
  val root: jfxs.Parent = new jfxf.FXMLLoader(getClass.getResource("home.fxml")).load()
  SharedClient.init(host, port)
  stage = new PrimaryStage {
    title = "Rock Paper Scissor"
    scene = new Scene(root)
  }
}

object SharedClient {
  var client: Client = _

  def init(host: String, port: Int): Unit = {
    this.client = Client(host, port)
  }
}




