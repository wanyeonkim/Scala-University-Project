package view

import model.SceneTModel
import scalafx.scene.shape.Shape;
import scalafx.scene.control.Alert
import scalafx.scene.control.Alert.AlertType


class SceneTController {
  var model = new SceneTModel()


  def PlayerWall7Condition(): Boolean = {
    if ((model.player.player.centerY.value < 980 && (model.wall.wall7PlayerX >= 20.0 && model.wall.wall7PlayerX <= 80.0) && (model.wall.wall7PlayerY <= 20.0)) ||
      (model.player.player.centerY.value < 980 && (model.wall.wall7PlayerX <= -320.0 && model.wall.wall7PlayerX >= -382.0) && (model.wall.wall7PlayerY <= 20.0)) ||
      (model.wall.wall7PlayerX < -3 && model.wall.wall7PlayerX > -320 && model.wall.wall7PlayerY > 30 && model.wall.wall7PlayerY < 157)
    ) {
      return true
    }
    false
  }

  def PlayerWall6Condition(): Boolean = {
    if ((model.player.player.centerY.value < 980 && (model.wall.wall6PlayerX >= 20.0 && model.wall.wall6PlayerX <= 50.0) && (model.wall.wall6PlayerY <= 25.0)) ||
      (model.player.player.centerY.value < 980 && (model.wall.wall6PlayerX <= -320.0 && model.wall.wall6PlayerX >= -390.0) && (model.wall.wall6PlayerY <= 25.0)) ||
      (model.wall.wall6PlayerX < -3 && model.wall.wall6PlayerX > -320 && model.wall.wall6PlayerY > 30 && model.wall.wall6PlayerY < 157)) {
      return true
    }
    false
  }

  def PlayerWall5Condition(): Boolean = {
    if ((model.player.player.centerY.value < 980 && (model.wall.wall5PlayerX >= 20.0 && model.wall.wall5PlayerX <= 80.0) && (model.wall.wall5PlayerY <= 25.0 && model.wall.wall5PlayerY > -180.0)) ||
      (model.player.player.centerY.value < 980 && (model.wall.wall5PlayerX <= -320.0 && model.wall.wall5PlayerX >= -350.0) && (model.wall.wall5PlayerY <= 25.0 && model.wall.wall5PlayerY > -180.0)) ||
      (model.wall.wall5PlayerX < -3 && model.wall.wall5PlayerX > -320 && model.wall.wall5PlayerY > 30 && model.wall.wall5PlayerY < 157)) {
      return true
    }
    false
  }

  def PlayerWall4Condition(): Boolean = {
    if ((model.player.player.centerY.value < 980 && (model.wall.wall4PlayerX >= 20.0 && model.wall.wall4PlayerX <= 80.0) && (model.wall.wall4PlayerY <= 25.0 && model.wall.wall4PlayerY > -70.0)) ||
      (model.player.player.centerY.value < 980 && (model.wall.wall4PlayerX <= -320.0 && model.wall.wall4PlayerX >= -330.0) && (model.wall.wall4PlayerY <= 25.0 && model.wall.wall4PlayerY > -175.0)) ||
      (model.wall.wall4PlayerX < -3 && model.wall.wall4PlayerX > -320 && model.wall.wall4PlayerY > 30 && model.wall.wall4PlayerY < 157)) {
      return true
    }
    false

  }

  def PlayerWall3Condition(): Boolean = {
    if ((model.player.player.centerY.value < 980 && (model.wall.wall3PlayerX >= 20.0 && model.wall.wall3PlayerX <= 80.0) && (model.wall.wall3PlayerY <= 25.0)) ||
      (model.player.player.centerY.value < 980 && (model.wall.wall3PlayerX <= -320.0 && model.wall.wall3PlayerX >= -390.0) && (model.wall.wall3PlayerY <= 25.0 && model.wall.wall3PlayerY > -75.0)) ||
      (model.wall.wall3PlayerX < -3 && model.wall.wall3PlayerX > -320 && model.wall.wall3PlayerY > 30 && model.wall.wall3PlayerY < 157)) {
      return true
    }
    false
  }


  def PlayerWall2Condition(): Boolean = {
    if ((model.player.player.centerY.value < 980 && (model.wall.wall2PlayerX >= 20.0 && model.wall.wall2PlayerX <= 25.0) && (model.wall.wall2PlayerY <= 25.0 && model.wall.wall2PlayerY > -170.0)) ||
      (model.player.player.centerY.value < 980 && (model.wall.wall2PlayerX <= -320.0 && model.wall.wall2PlayerX >= -330.0) && (model.wall.wall2PlayerY <= 25.0 && model.wall.wall2PlayerY > -360.0)) ||
      (model.wall.wall2PlayerX < -3 && model.wall.wall2PlayerX > -320 && model.wall.wall2PlayerY > 30 && model.wall.wall2PlayerY < 157)) {
      return true
    }
    false
  }

  def PlayerWall1Condition(): Boolean = {
    if ((model.player.player.centerY.value < 980 && (model.wall.wall1PlayerX >= 20.0 && model.wall.wall1PlayerX <= 25.0) && (model.wall.wall1PlayerY <= 25.0)) ||
      (model.player.player.centerY.value < 980 && (model.wall.wall1PlayerX <= -320.0 && model.wall.wall1PlayerX >= -330.0) && (model.wall.wall1PlayerY <= 25.0 && model.wall.wall1PlayerY > -180)) ||
      (model.wall.wall1PlayerX < -3 && model.wall.wall1PlayerX > -320 && model.wall.wall1PlayerY > 30 && model.wall.wall1PlayerY < 157)) {
      return true
    }
    false
  }

  def gravityLogic() {

    if (!model.control.onGround && model.cancelJump) {

      if ((model.counter > 0 && model.player.player.centerY.value < 980)) {
        model.player.player.centerY = model.player.player.centerY.value + model.playerJumpHeight * model.MSecond
        model.player.playerImageView.y = model.player.playerImageView.y.value + model.playerJumpHeight * model.MSecond
        model.player.playerEye1ImageView.y = model.player.playerEye1ImageView.y.value + model.playerJumpHeight * model.MSecond
        model.player.playerEye2ImageView.y = model.player.playerEye2ImageView.y.value + model.playerJumpHeight * model.MSecond

        model.counter -= 1
        println("drop")

      }

      // wall 7
      else if (PlayerWall7Condition()) {
        model.player.player.centerY = model.player.player.centerY.value + model.playerJumpHeight * model.MSecond
        model.player.playerImageView.y = model.player.playerImageView.y.value + model.playerJumpHeight * model.MSecond
        model.player.playerEye1ImageView.y = model.player.playerEye1ImageView.y.value + model.playerJumpHeight * model.MSecond
        model.player.playerEye2ImageView.y = model.player.playerEye2ImageView.y.value + model.playerJumpHeight * model.MSecond

        println("wall 7")
        // counter-=1
      }


      // wall 6
      else if (PlayerWall6Condition()) {
        model.player.player.centerY = model.player.player.centerY.value + model.playerJumpHeight * model.MSecond
        model.player.playerImageView.y = model.player.playerImageView.y.value + model.playerJumpHeight * model.MSecond
        model.player.playerEye1ImageView.y = model.player.playerEye1ImageView.y.value + model.playerJumpHeight * model.MSecond
        model.player.playerEye2ImageView.y = model.player.playerEye2ImageView.y.value + model.playerJumpHeight * model.MSecond

        println("wall 6")
      }

      //wall 5
      else if (PlayerWall5Condition()) {
        model.player.player.centerY = model.player.player.centerY.value + model.playerJumpHeight * model.MSecond
        model.player.playerImageView.y = model.player.playerImageView.y.value + model.playerJumpHeight * model.MSecond
        model.player.playerEye1ImageView.y = model.player.playerEye1ImageView.y.value + model.playerJumpHeight * model.MSecond
        model.player.playerEye2ImageView.y = model.player.playerEye2ImageView.y.value + model.playerJumpHeight * model.MSecond

        println("wall 5")

      }

      //wall4
      else if (PlayerWall4Condition()) {
        model.player.player.centerY = model.player.player.centerY.value + model.playerJumpHeight * model.MSecond
        model.player.playerImageView.y = model.player.playerImageView.y.value + model.playerJumpHeight * model.MSecond
        model.player.playerEye1ImageView.y = model.player.playerEye1ImageView.y.value + model.playerJumpHeight * model.MSecond
        model.player.playerEye2ImageView.y = model.player.playerEye2ImageView.y.value + model.playerJumpHeight * model.MSecond

        println("wall 4")

      }

      //wall3
      else if (PlayerWall3Condition()) {
        model.player.player.centerY = model.player.player.centerY.value + model.playerJumpHeight * model.MSecond
        model.player.playerImageView.y = model.player.playerImageView.y.value + model.playerJumpHeight * model.MSecond
        model.player.playerEye1ImageView.y = model.player.playerEye1ImageView.y.value + model.playerJumpHeight * model.MSecond
        model.player.playerEye2ImageView.y = model.player.playerEye2ImageView.y.value + model.playerJumpHeight * model.MSecond


        println("wall 3")

      }

      //wall2
      else if (PlayerWall2Condition()) {
        model.player.player.centerY = model.player.player.centerY.value + model.playerJumpHeight * model.MSecond
        model.player.playerImageView.y = model.player.playerImageView.y.value + model.playerJumpHeight * model.MSecond
        model.player.playerEye1ImageView.y = model.player.playerEye1ImageView.y.value + model.playerJumpHeight * model.MSecond
        model.player.playerEye2ImageView.y = model.player.playerEye2ImageView.y.value + model.playerJumpHeight * model.MSecond

        println("wall 2")
      }

      //wall1
      else if (PlayerWall1Condition()) {
        model.player.player.centerY = model.player.player.centerY.value + model.playerJumpHeight * model.MSecond
        model.player.playerImageView.y = model.player.playerImageView.y.value + model.playerJumpHeight * model.MSecond
        model.player.playerEye1ImageView.y = model.player.playerEye1ImageView.y.value + model.playerJumpHeight * model.MSecond
        model.player.playerEye2ImageView.y = model.player.playerEye2ImageView.y.value + model.playerJumpHeight * model.MSecond

        println("wall 1")

      }

      else if (model.counter <= 0) {
        model.control.onGround = true
        model.counter = 30
        model.cancelJump = false
      }
      else {
        model.control.onGround = true
        model.counter = 30
        model.cancelJump = false
      }
    }

  }

  def wallPlayerCollision() {
    if (model.player.player.centerX.value <= 20.0) {
      model.player.player.centerX = model.player.playerOldX
      model.player.playerImageView.x = model.player.playerImageViewOldX
      model.player.playerEye1ImageView.x = model.player.playerEye1ImageViewOldX
      model.player.playerEye2ImageView.x = model.player.playerEye2ImageViewOldX

    }
    if (model.player.player.centerX.value >= 980.0) {
      model.player.player.centerX = model.player.playerOldX
      model.player.playerImageView.x = model.player.playerImageViewOldX
      model.player.playerEye1ImageView.x = model.player.playerEye1ImageViewOldX
      model.player.playerEye2ImageView.x = model.player.playerEye2ImageViewOldX
    }
    model.wall.wall7Collide = Shape.intersect(model.player.player, model.wall.wall7).boundsInLocal.value.isEmpty
    if (!model.wall.wall7Collide) {
      model.player.player.centerX = model.player.playerOldX
      model.player.player.centerY = model.player.playerOldY

      model.player.playerImageView.x = model.player.playerImageViewOldX
      model.player.playerImageView.y = model.player.playerImageViewOldY

      model.player.playerEye1ImageView.x = model.player.playerEye1ImageViewOldX
      model.player.playerEye1ImageView.y = model.player.playerEye1ImageViewOldY

      model.player.playerEye2ImageView.x = model.player.playerEye2ImageViewOldX
      model.player.playerEye2ImageView.y = model.player.playerEye2ImageViewOldY

    }
    model.wall.wall6Collide = Shape.intersect(model.player.player, model.wall.wall6).boundsInLocal.value.isEmpty
    if (!model.wall.wall6Collide) {
      model.player.player.centerX = model.player.playerOldX
      model.player.player.centerY = model.player.playerOldY

      model.player.playerImageView.x = model.player.playerImageViewOldX
      model.player.playerImageView.y = model.player.playerImageViewOldY

      model.player.playerEye1ImageView.x = model.player.playerEye1ImageViewOldX
      model.player.playerEye1ImageView.y = model.player.playerEye1ImageViewOldY

      model.player.playerEye2ImageView.x = model.player.playerEye2ImageViewOldX
      model.player.playerEye2ImageView.y = model.player.playerEye2ImageViewOldY

    }

    model.wall.wall5Collide = Shape.intersect(model.player.player, model.wall.wall5).boundsInLocal.value.isEmpty
    if (!model.wall.wall5Collide) {
      model.player.player.centerX = model.player.playerOldX
      model.player.player.centerY = model.player.playerOldY

      model.player.playerImageView.x = model.player.playerImageViewOldX
      model.player.playerImageView.y = model.player.playerImageViewOldY

      model.player.playerEye1ImageView.x = model.player.playerEye1ImageViewOldX
      model.player.playerEye1ImageView.y = model.player.playerEye1ImageViewOldY

      model.player.playerEye2ImageView.x = model.player.playerEye2ImageViewOldX
      model.player.playerEye2ImageView.y = model.player.playerEye2ImageViewOldY

    }

    model.wall.wall4Collide = Shape.intersect(model.player.player, model.wall.wall4).boundsInLocal.value.isEmpty
    if (!model.wall.wall4Collide) {
      model.player.player.centerX = model.player.playerOldX
      model.player.player.centerY = model.player.playerOldY

      model.player.playerImageView.x = model.player.playerImageViewOldX
      model.player.playerImageView.y = model.player.playerImageViewOldY

      model.player.playerEye1ImageView.x = model.player.playerEye1ImageViewOldX
      model.player.playerEye1ImageView.y = model.player.playerEye1ImageViewOldY

      model.player.playerEye2ImageView.x = model.player.playerEye2ImageViewOldX
      model.player.playerEye2ImageView.y = model.player.playerEye2ImageViewOldY

    }

    model.wall.wall3Collide = Shape.intersect(model.player.player, model.wall.wall3).boundsInLocal.value.isEmpty
    if (!model.wall.wall3Collide) {
      model.player.player.centerX = model.player.playerOldX
      model.player.player.centerY = model.player.playerOldY

      model.player.playerImageView.x = model.player.playerImageViewOldX
      model.player.playerImageView.y = model.player.playerImageViewOldY

      model.player.playerEye1ImageView.x = model.player.playerEye1ImageViewOldX
      model.player.playerEye1ImageView.y = model.player.playerEye1ImageViewOldY

      model.player.playerEye2ImageView.x = model.player.playerEye2ImageViewOldX
      model.player.playerEye2ImageView.y = model.player.playerEye2ImageViewOldY

    }


    model.wall.wall2Collide = Shape.intersect(model.player.player, model.wall.wall2).boundsInLocal.value.isEmpty
    if (!model.wall.wall2Collide) {
      model.player.player.centerX = model.player.playerOldX
      model.player.player.centerY = model.player.playerOldY

      model.player.playerImageView.x = model.player.playerImageViewOldX
      model.player.playerImageView.y = model.player.playerImageViewOldY

      model.player.playerEye1ImageView.x = model.player.playerEye1ImageViewOldX
      model.player.playerEye1ImageView.y = model.player.playerEye1ImageViewOldY

      model.player.playerEye2ImageView.x = model.player.playerEye2ImageViewOldX
      model.player.playerEye2ImageView.y = model.player.playerEye2ImageViewOldY

    }


    model.wall.wall1Collide = Shape.intersect(model.player.player, model.wall.wall1).boundsInLocal.value.isEmpty

    if (!model.wall.wall1Collide) {
      model.player.player.centerX = model.player.playerOldX
      model.player.player.centerY = model.player.playerOldY

      model.player.playerImageView.x = model.player.playerImageViewOldX
      model.player.playerImageView.y = model.player.playerImageViewOldY

      model.player.playerEye1ImageView.x = model.player.playerEye1ImageViewOldX
      model.player.playerEye1ImageView.y = model.player.playerEye1ImageViewOldY

      model.player.playerEye2ImageView.x = model.player.playerEye2ImageViewOldX
      model.player.playerEye2ImageView.y = model.player.playerEye2ImageViewOldY
    }
    model.keyCollide = Shape.intersect(model.player.player, model.keyNextStage).boundsInLocal.value.isEmpty


  }

  def jumpingControl() {
    if (model.control.onGround && !model.cancelJump) {
      // println("jump")

      if (model.counter > 0 && model.control.spacePressed) {
        model.player.player.centerY = model.player.player.centerY.value - model.playerJumpHeight * model.MSecond
        model.player.playerImageView.y = model.player.playerImageView.y.value - model.playerJumpHeight * model.MSecond
        model.player.playerEye1ImageView.y = model.player.playerEye1ImageView.y.value - model.playerJumpHeight * model.MSecond
        model.player.playerEye2ImageView.y = model.player.playerEye2ImageView.y.value - model.playerJumpHeight * model.MSecond

        model.counter -= 1
      }
      if (!model.control.spacePressed) {
        model.control.onGround = false

        model.counter = 30 - model.counter
        model.cancelJump = true
      }
      if (model.counter <= 0 && model.control.onGround) {
        model.control.onGround = false

        model.counter = 30
        model.cancelJump = true
      }

    }
  }

  def keyboardInputLeft() {
    if (model.control.leftPressed) {
      model.player.player.centerX = model.player.player.centerX.value - model.player.playerSpeed * model.second
      model.player.playerImageView.x = model.player.playerImageView.x.value - model.player.playerSpeed * model.second
      model.player.playerEye1ImageView.x = model.player.playerEye1ImageView.x.value - model.player.playerSpeed * model.second
      model.player.playerEye2ImageView.x = model.player.playerEye2ImageView.x.value - model.player.playerSpeed * model.second

    }


  }

  def keyboardInputRight() {
    if (model.control.rightPressed) {
      model.player.player.centerX = model.player.player.centerX.value + model.player.playerSpeed * model.second
      model.player.playerImageView.x = model.player.playerImageView.x.value + model.player.playerSpeed * model.second
      model.player.playerEye1ImageView.x = model.player.playerEye1ImageView.x.value + model.player.playerSpeed * model.second
      model.player.playerEye2ImageView.x = model.player.playerEye2ImageView.x.value + model.player.playerSpeed * model.second

    }
  }

  def HelpNeeded() {
    new Alert(AlertType.Information) {
      title = "Game Control"
      headerText = "Control Information"
      contentText = "This game use 3keys\n\nLeftKey - move the object to the left\nRightKey - mvoe the object to the right\nspacebarKey - make the object jump"
    }.showAndWait()

  }

}