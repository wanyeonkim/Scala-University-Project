package view

import model.MenuBarModel
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.image.Image
import scalafx.scene.media.{Media, MediaPlayer}

object mainApp extends JFXApp {
  var sceneCounter = 0
  var totalScore = 0

  val scene1View = new SceneJumping1()
  val sceneTView = new SceneT()

  val menuBar = new MenuBarModel()

  val mus = new Media(getClass.getResource("sample.mp3").toExternalForm())
  val musPlayer = new MediaPlayer(mus) {
    volume = 0.2
    cycleCount = 1000
  }
  musPlayer.play()
  

  stage = new PrimaryStage {
    title = "Get Me Out"
    resizable = false
    scene = new Scene(1000, 1000) {

    }
    // icons += 

  }
  stage.getIcons().add(new Image(getClass.getResourceAsStream("gameicon.png")))

  stageIdentifier()


  def stageIdentifier() {
    sceneCounter match {
      case 0 => new MainPage().Start(stage,menuBar.menuBar)
      case 1 => scene1View.Jumping1(stage,menuBar.menuBar)
      case 2 => sceneTView.intermidateScene(stage,menuBar.menuBar)
      case 3 => new FinalStage().finalS(stage,menuBar.menuBar)
      case 4 => new BossRoom().bossRoom(stage,menuBar.menuBar)
      case 5 => new Credit().credit(stage,menuBar.menuBar)
      case 6 => new clicker().click(stage,menuBar.menuBar)
      // case 5 => scene1View.Jumping1(stage)
    }
  }

}