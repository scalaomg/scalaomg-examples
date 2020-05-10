package rock_paper_scissor.client

import javafx.scene.control.{Button, Label}
import javafx.scene.layout.VBox
import javafx.{event => jfxEvent, fxml => jfxf, scene => jfxs}
import scalafx.application.Platform
import scalaomg.client.core.Client
import scalaomg.client.room.JoinedRoom
import scalaomg.common.room.FilterOptions

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

class HomeController {
  @jfxf.FXML private var btnNewGame: Button = _
  @jfxf.FXML private var labelStatus: Label = _
  @jfxf.FXML private var vboxMenuButtons: VBox = _

  //get the client from the main stage
  private def client: Client = SharedClient.client

  private def goToMatchScene(room: JoinedRoom, gameMode: String): Unit = {
    Platform.runLater {
      val loader = new jfxf.FXMLLoader(getClass.getResource("match.fxml"))
      val root: jfxs.Parent = loader.load()
      loader.getController[MatchController]().init(room, gameMode)
      this.btnNewGame.getScene.setRoot(root)
    }

  }

  @jfxf.FXML
  def handleClassicGameButtonPress(event: jfxEvent.ActionEvent): Unit = {
    this.vboxMenuButtons.setDisable(true)
    this.labelStatus.setText("joining classic room...")

    //use client api to join a room. If no one is available create one and wait another player
    client.joinOrCreate("classic", FilterOptions.empty) onComplete {
      case Success(room) => goToMatchScene(room, "classic")
      case Failure(_) => println("client room creation failed")
    }
  }

  @jfxf.FXML
  def handleAdvancedGameButtonPress(event: jfxEvent.ActionEvent): Unit = {
    this.vboxMenuButtons.setDisable(true)

    this.labelStatus.setText("joining advanced room...")

    //use client api to join a room. If no one is availabe create one and wait another player
    client.joinOrCreate("advanced", FilterOptions.empty) onComplete {
      case Success(room) => goToMatchScene(room, "advanced")
      case Failure(_) => println("client room creation failed")
    }
  }


  @jfxf.FXML
  def handleExitButtonPress(event: jfxEvent.ActionEvent): Unit = {
    client.shutdown()
    Platform.exit()
    System.exit(0)
  }




}
