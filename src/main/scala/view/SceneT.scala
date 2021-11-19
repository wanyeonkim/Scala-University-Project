package view

import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.Includes._
import scalafx.scene.input.{KeyCode, KeyEvent}
import scala.collection.mutable.ListBuffer
import scalafx.scene.input._
import scalafx.animation._
import scalafx.scene.paint.Color
import scalafx.scene.control.MenuBar


/// scene 2 

class SceneT {

  val sceneTController = new SceneTController()

  def intermidateScene(stage: PrimaryStage, menuBar:MenuBar) {
    val scene = new Scene(1000, 1000) {

      fill = Color.Black

      content = new ListBuffer()
      content += sceneTController.model.backgroundImageView
      content += sceneTController.model.wall.wall1
      content += sceneTController.model.wall.wall2
      content += sceneTController.model.wall.wall3
      content += sceneTController.model.wall.wall4
      content += sceneTController.model.wall.wall5
      content += sceneTController.model.wall.wall6
      content += sceneTController.model.wall.wall7
      content += sceneTController.model.keyNextStage
      content += sceneTController.model.player.player
      // content += sceneTController.model.playerEyeLeft
      // content += sceneTController.model.playerEyeRight
      // content += sceneTController.model.playerMouth


      content += sceneTController.model.wall.wall1ImageView
      content += sceneTController.model.wall.wall2ImageView
      content += sceneTController.model.wall.wall3ImageView
      content += sceneTController.model.wall.wall4ImageView
      content += sceneTController.model.wall.wall5ImageView
      content += sceneTController.model.wall.wall6ImageView
      content += sceneTController.model.wall.wall7ImageView

      content += sceneTController.model.player.playerImageView
      content += sceneTController.model.player.playerEye1ImageView
      content += sceneTController.model.player.playerEye2ImageView

      content += sceneTController.model.help
      content += sceneTController.model.instructionBox
      content += sceneTController.model.instructionText
      // content += sceneTController.model.menuButton
      content += menuBar

      sceneTController.model.help.onMouseClicked = (e: MouseEvent) => {
        sceneTController.HelpNeeded()
        println("sdsd")
      }
      // sceneTController.model.menuButton.onMouseClicked = (e: MouseEvent) => {
      //   mainApp.sceneCounter = 0
      //   mainApp.totalScore = 0
      //   mainApp.stageIdentifier()
      // }

      // key press
      onKeyPressed = (e: KeyEvent) => {
        if (e.code == KeyCode.Left) sceneTController.model.control.leftPressed = true
        if (e.code == KeyCode.Right) sceneTController.model.control.rightPressed = true
        if (e.code == KeyCode.Space) sceneTController.model.control.spacePressed = true
      }
      //key release
      onKeyReleased = (e: KeyEvent) => {
        if (e.code == KeyCode.Left) sceneTController.model.control.leftPressed = false
        if (e.code == KeyCode.Right) sceneTController.model.control.rightPressed = false
        if (e.code == KeyCode.Space) sceneTController.model.control.spacePressed = false
      }

      var animationTimer = AnimationTimer(t => {

        if (sceneTController.model.gameTimer > 0) {

          sceneTController.model.second = (t - sceneTController.model.gameTimer) / 1e9
          sceneTController.model.Timer += sceneTController.model.second

          sceneTController.model.player.playerOldY = sceneTController.model.player.player.centerY.value
          sceneTController.model.player.playerOldX = sceneTController.model.player.player.centerX.value

          sceneTController.model.player.playerImageViewOldX = sceneTController.model.player.playerImageView.x.value
          sceneTController.model.player.playerImageViewOldY = sceneTController.model.player.playerImageView.y.value

          sceneTController.model.player.playerEye1ImageViewOldX = sceneTController.model.player.playerEye1ImageView.x.value
          sceneTController.model.player.playerEye1ImageViewOldY = sceneTController.model.player.playerEye1ImageView.y.value

          sceneTController.model.player.playerEye2ImageViewOldX = sceneTController.model.player.playerEye2ImageView.x.value
          sceneTController.model.player.playerEye2ImageViewOldY = sceneTController.model.player.playerEye2ImageView.y.value

          // sceneTController.model.playerEyeLeftOldY = sceneTController.model.playerEyeLeft.centerY.value
          // sceneTController.model.playerEyeLeftOldX = sceneTController.model.playerEyeLeft.player.centerX.value

          // sceneTController.model.playerEyeRightOldY = sceneTController.model.playerEyeRight.centerY.value
          // sceneTController.model.playerEyeRightOldX = sceneTController.model.playerEyeRight.player.centerX.value

          // sceneTController.model.playerMouthOldY = sceneTController.model.playerMouth.centerY.value
          // sceneTController.model.playerMouthOldX = sceneTController.model.playerMouth.player.centerX.value


          // sceneTController.model.wall7Collide = true
          sceneTController.model.wall.wall7PlayerX = sceneTController.model.wall.wall7.getX - sceneTController.model.player.player.centerX.value
          sceneTController.model.wall.wall7PlayerY = sceneTController.model.wall.wall7.getY - sceneTController.model.player.player.centerY.value

          // var wall6Collide = true
          sceneTController.model.wall.wall6PlayerX = sceneTController.model.wall.wall6.getX - sceneTController.model.player.player.centerX.value
          sceneTController.model.wall.wall6PlayerY = sceneTController.model.wall.wall6.getY - sceneTController.model.player.player.centerY.value

          // var wall5Collide = true
          sceneTController.model.wall.wall5PlayerX = sceneTController.model.wall.wall5.getX - sceneTController.model.player.player.centerX.value
          sceneTController.model.wall.wall5PlayerY = sceneTController.model.wall.wall5.getY - sceneTController.model.player.player.centerY.value

          // var wall4Collide = true
          sceneTController.model.wall.wall4PlayerX = sceneTController.model.wall.wall4.getX - sceneTController.model.player.player.centerX.value
          sceneTController.model.wall.wall4PlayerY = sceneTController.model.wall.wall4.getY - sceneTController.model.player.player.centerY.value

          // var wall3Collide = true
          sceneTController.model.wall.wall3PlayerX = sceneTController.model.wall.wall3.getX - sceneTController.model.player.player.centerX.value
          sceneTController.model.wall.wall3PlayerY = sceneTController.model.wall.wall3.getY - sceneTController.model.player.player.centerY.value

          // var wall2Collide = true
          sceneTController.model.wall.wall2PlayerX = sceneTController.model.wall.wall2.getX - sceneTController.model.player.player.centerX.value
          sceneTController.model.wall.wall2PlayerY = sceneTController.model.wall.wall2.getY - sceneTController.model.player.player.centerY.value

          // var wall1Collide = true
          sceneTController.model.wall.wall1PlayerX = sceneTController.model.wall.wall1.getX - sceneTController.model.player.player.centerX.value
          sceneTController.model.wall.wall1PlayerY = sceneTController.model.wall.wall1.getY - sceneTController.model.player.player.centerY.value

          // var keyCollide = true


          // jumping simulating gravity
          //!
          sceneTController.keyboardInputLeft()
          sceneTController.keyboardInputRight()

          sceneTController.jumpingControl()
          sceneTController.gravityLogic()

          // dropping again simulating gravity

          // println(player.centerY.value)

          sceneTController.wallPlayerCollision()


          if (!sceneTController.model.keyCollide) {
            if (content.contains(sceneTController.model.keyNextStage)) {
              content -= sceneTController.model.keyNextStage

              var checkNumer = 120 - sceneTController.model.Timer.toInt
              if (checkNumer <= 0) {
                checkNumer = 10
              }
              mainApp.totalScore = mainApp.totalScore + checkNumer
              println("score:  " + mainApp.totalScore)
              mainApp.sceneCounter += 1
              mainApp.stageIdentifier()

              // mainApp.scene2()
            }

          }


          if (sceneTController.model.dialogTimer >= 0 && !sceneTController.model.isDialogShow) {
            sceneTController.model.dialogTimer -= sceneTController.model.second
          }

          if (sceneTController.model.dialogTimer <= 0 && !sceneTController.model.isDialogShow) {
            sceneTController.model.isDialogShow = true
          }
          if (sceneTController.model.isDialogShow) {
            if (content.contains(sceneTController.model.instructionBox)) {
              content -= sceneTController.model.instructionBox
            }
            if (content.contains(sceneTController.model.instructionText)) {
              content -= sceneTController.model.instructionText
            }
          }


        }
        sceneTController.model.gameTimer = t

      })
      animationTimer.start
    }
    stage.setScene(scene)
  }

}
