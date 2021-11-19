package view

import scalafx.Includes._
import scalafx.animation._
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.input.{KeyEvent, MouseEvent}

import scala.collection.mutable.ListBuffer;
import scalafx.scene.control.MenuBar




class SceneJumping1 {

  val sceneJumping1Controller = new SceneJumping1Controller()

  def Jumping1(stage: PrimaryStage, menuBar:MenuBar): Unit = {

    val scene: Scene = new Scene(1000, 1000) {
      //wall section
      content = new ListBuffer()
      
      content += sceneJumping1Controller.model.backgroundImageView
      content += sceneJumping1Controller.model.wall1


      content += sceneJumping1Controller.model.wall2


      content += sceneJumping1Controller.model.wall3
      content += sceneJumping1Controller.model.wall4
      content += sceneJumping1Controller.model.wall5
      content += sceneJumping1Controller.model.wall6
      content += sceneJumping1Controller.model.wall7

      content += sceneJumping1Controller.model.keyNextStage
      content += sceneJumping1Controller.model.player
      content += sceneJumping1Controller.model.help

      content += sceneJumping1Controller.model.wall1ImageView
      content += sceneJumping1Controller.model.wall2ImageView
      content += sceneJumping1Controller.model.wall3ImageView
      content += sceneJumping1Controller.model.wall4ImageView
      content += sceneJumping1Controller.model.wall5ImageView
      content += sceneJumping1Controller.model.wall6ImageView
      content += sceneJumping1Controller.model.wall7ImageView
      content += sceneJumping1Controller.model.playerImageView
      content += sceneJumping1Controller.model.playerEye1ImageView
      content += sceneJumping1Controller.model.playerEye2ImageView
      content += menuBar



      // sceneJumping1Controller.keyboardInput(scene)
      onKeyPressed = (e: KeyEvent) => {
        sceneJumping1Controller.Press(e)
      }
      //key release
      onKeyReleased = (e: KeyEvent) => {
        sceneJumping1Controller.Release(e)
      }
      sceneJumping1Controller.model.help.onMouseClicked = (e: MouseEvent) => {
        sceneJumping1Controller.HelpNeeded()
        println("sdsd")
      }
  

      
     

      var animationTimer = AnimationTimer(t => {

        if (sceneJumping1Controller.model.gameTimer > 0) {

          sceneJumping1Controller.model.second = (t - sceneJumping1Controller.model.gameTimer) / 1e9
          sceneJumping1Controller.model.Timer += sceneJumping1Controller.model.second

          sceneJumping1Controller.model.playerOldY = sceneJumping1Controller.model.player.centerY.value
          sceneJumping1Controller.model.playerOldX = sceneJumping1Controller.model.player.centerX.value


          sceneJumping1Controller.model.playerImageViewOldX = sceneJumping1Controller.model.playerImageView.x.value
          sceneJumping1Controller.model.playerImageViewOldY = sceneJumping1Controller.model.playerImageView.y.value

          sceneJumping1Controller.model.playerEye1ImageViewOldX = sceneJumping1Controller.model.playerEye1ImageView.x.value
          sceneJumping1Controller.model.playerEye1ImageViewOldY = sceneJumping1Controller.model.playerEye1ImageView.y.value

          sceneJumping1Controller.model.playerEye2ImageViewOldX = sceneJumping1Controller.model.playerEye2ImageView.x.value
          sceneJumping1Controller.model.playerEye2ImageViewOldY = sceneJumping1Controller.model.playerEye2ImageView.y.value





          sceneJumping1Controller.model.wall7PlayerX = sceneJumping1Controller.model.wall7.getX - sceneJumping1Controller.model.player.centerX.value
          sceneJumping1Controller.model.wall7PlayerY = sceneJumping1Controller.model.wall7.getY - sceneJumping1Controller.model.player.centerY.value


          sceneJumping1Controller.model.wall6PlayerX = sceneJumping1Controller.model.wall6.getX - sceneJumping1Controller.model.player.centerX.value
          sceneJumping1Controller.model.wall6PlayerY = sceneJumping1Controller.model.wall6.getY - sceneJumping1Controller.model.player.centerY.value


          sceneJumping1Controller.model.wall5PlayerX = sceneJumping1Controller.model.wall5.getX - sceneJumping1Controller.model.player.centerX.value
          sceneJumping1Controller.model.wall5PlayerY = sceneJumping1Controller.model.wall5.getY - sceneJumping1Controller.model.player.centerY.value


          sceneJumping1Controller.model.wall4PlayerX = sceneJumping1Controller.model.wall4.getX - sceneJumping1Controller.model.player.centerX.value
          sceneJumping1Controller.model.wall4PlayerY = sceneJumping1Controller.model.wall4.getY - sceneJumping1Controller.model.player.centerY.value


          sceneJumping1Controller.model.wall3PlayerX = sceneJumping1Controller.model.wall3.getX - sceneJumping1Controller.model.player.centerX.value
          sceneJumping1Controller.model.wall3PlayerY = sceneJumping1Controller.model.wall3.getY - sceneJumping1Controller.model.player.centerY.value


          sceneJumping1Controller.model.wall2PlayerX = sceneJumping1Controller.model.wall2.getX - sceneJumping1Controller.model.player.centerX.value
          sceneJumping1Controller.model.wall2PlayerY = sceneJumping1Controller.model.wall2.getY - sceneJumping1Controller.model.player.centerY.value


          sceneJumping1Controller.model.wall1PlayerX = sceneJumping1Controller.model.wall1.getX - sceneJumping1Controller.model.player.centerX.value
          sceneJumping1Controller.model.wall1PlayerY = sceneJumping1Controller.model.wall1.getY - sceneJumping1Controller.model.player.centerY.value


          sceneJumping1Controller.keyboardInputLeft()
          sceneJumping1Controller.keyboardInputRight()
          sceneJumping1Controller.jumpingLogic()
          sceneJumping1Controller.gravityLogic()

          sceneJumping1Controller.collisionCheck()
          sceneJumping1Controller.collisionlogicSideWall()

          if (sceneJumping1Controller.model.nextStage) {
            if (content.contains(sceneJumping1Controller.model.keyNextStage)) {
              content -= sceneJumping1Controller.model.keyNextStage

              var checkNumer = 120 - sceneJumping1Controller.model.Timer.toInt
              if (checkNumer <= 0) {
                checkNumer = 10
              }
              mainApp.totalScore = mainApp.totalScore + checkNumer
              println("score:  " + mainApp.totalScore)

              mainApp.sceneCounter += 1
              mainApp.stageIdentifier()


            }
          }

          sceneJumping1Controller.collisionlogicSideWall()


        }
        sceneJumping1Controller.model.gameTimer = t

      })
      animationTimer.start


    }
    stage.setScene(scene)

  }


}