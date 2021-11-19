package view

import scalafx.Includes._
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.text._
import scala.collection.mutable.ListBuffer;
import scalafx.scene.input.{KeyCode, KeyEvent, MouseEvent}
import scalafx.scene.control.MenuBar


class Credit {
  var controller = new CreditController()

  def credit(stage: PrimaryStage,menuBar:MenuBar): Unit = {
    val scene: Scene = new Scene(1000, 1000) {
      // controller.model.menuButton.onMouseClicked = (e: MouseEvent) => {
      //   mainApp.sceneCounter = 0
      //   mainApp.totalScore = 0
      //   mainApp.stageIdentifier()
      // }
      content = new ListBuffer()
      // content += controller.model.menuButton
      content += menuBar


      

      if (mainApp.totalScore > 200) {
        content += controller.model.goldImageView
      }
      else if (mainApp.totalScore < 200 && mainApp.totalScore > 100) {
        content += controller.model.silverImageView
      }
      else {
        content += controller.model.bronzeImageView
      }
    }
    stage.setScene(scene)
  }
}