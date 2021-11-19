package view

import scalafx.Includes._
import scalafx.animation._
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.MenuBar
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.Color
import scala.collection.mutable.ListBuffer

class clicker {
  def click(stage: PrimaryStage, menuBar:MenuBar):Unit = {
    var controller = new clickerController()
    var gameTimer =0.0

    val scene: Scene = new Scene(1000,1000){
      fill = Color.Black
      content = new ListBuffer()

      content += controller.model.clickText
      content += controller.model.catCloseImageView
      content += menuBar

      controller.model.catCloseImageView.onMousePressed = (m:MouseEvent) =>{
        controller.model.mouseCliked = true
      }

      controller.model.catCloseImageView.onMouseReleased = (m:MouseEvent) =>{
        controller.model.mouseCliked = false
      }
      var animationTimer: AnimationTimer = AnimationTimer(t => {
        if(gameTimer >0){
          if(controller.model.mouseCliked && !controller.model.dupCheck){
            controller.model.catCloseImageView.setImage(controller.model.catOpenImage)
            controller.model.dupCheck= true
            controller.model.popSound.play()
            
            controller.model.clickCount = controller.model.clickCount + 1.0
            controller.model.clickText.setText(controller.model.clickCount.toInt.toString)
          }
          if(!controller.model.mouseCliked){
            controller.model.catCloseImageView.setImage(controller.model.catCloseImage)
            controller.model.dupCheck = false
            if(content.contains(controller.model.catOpenImageView)){
              content -= controller.model.catOpenImageView
              content += controller.model.catCloseImageView
            }
           
          }
        }
        gameTimer = t
      })
      animationTimer.start


    }
    stage.setScene(scene)
  }
}
