package view

import model.SceneJumping1Model
import scalafx.scene.control.Alert
import scalafx.scene.control.Alert.AlertType
import scalafx.scene.input.{KeyCode, KeyEvent}
import scalafx.scene.shape.Shape


class SceneJumping1Controller {
  var model = new SceneJumping1Model()


  def PlayerWall7Condition(): Boolean = {
    if (
      (model.player.centerY.value < 980 && (model.wall7PlayerX >= 20.0 && model.wall7PlayerX <= 80.0) && (model.wall7PlayerY <= 20.0 && model.wall7PlayerY <= 207)) ||
        (model.player.centerY.value < 980 && (model.wall7PlayerX <= -420.0 && model.wall7PlayerX > -480.0) && (model.wall7PlayerY <= 20.0 && model.wall7PlayerY <= 207)) ||
        (model.wall7PlayerX < 6 && model.wall7PlayerX > -404 && model.wall7PlayerY > 30 && model.wall7PlayerY < 207)
    ) {
      return true
    }
    false
  }

  def PlayerWall6Condition(): Boolean = {
    if ((model.player.centerY.value < 980 && (model.wall6PlayerX >= 20.0 && model.wall6PlayerX <= 29.0) && (model.wall6PlayerY <= 25.0)) ||
      (model.player.centerY.value < 980 && (model.wall6PlayerX <= -220.0 && model.wall6PlayerX >= -379.0) && (model.wall6PlayerY <= 25.0)) ||
      (model.wall6PlayerX < -20 && model.wall6PlayerX < -180 && model.wall6PlayerY < 307 && model.wall6PlayerY > 30)) {
      return true
    }
    false
  }

  def PlayerWall5Condition(): Boolean = {
    if ((model.player.centerY.value < 980 && (model.wall5PlayerX >= 20.0 && model.wall5PlayerX <= 128.0) && (model.wall5PlayerY <= 257.0 && model.wall5PlayerY > -230.0)) ||
      (model.player.centerY.value < 980 && (model.wall5PlayerX <= -420.0 && model.wall5PlayerX >= -490.0) && (model.wall5PlayerY <= 25.0 && model.wall5PlayerY > -177.0)) ||
      (model.wall5PlayerX < -20 && model.wall5PlayerX > -280 && model.wall5PlayerY > 30 && model.wall5PlayerY < 257) ||
      (model.wall5PlayerX < -280 && model.wall5PlayerX > -378 && model.wall5PlayerY > 30 && model.wall5PlayerY < 107)) {
      return true
    }
    false
  }

  def PlayerWall4Condtion(): Boolean = {
    if ((model.player.centerY.value < 980 && (model.wall4PlayerX >= 20.0 && model.wall4PlayerX <= 80.0) && (model.wall4PlayerY <= 25.0 && model.wall4PlayerY > -125.0)) ||
      (model.player.centerY.value < 980 && (model.wall4PlayerX <= -420.0 && model.wall4PlayerX >= -529.0) && (model.wall4PlayerY <= 25.0)) ||
      (model.wall4PlayerX < 20 && model.wall4PlayerX > -20 && model.wall4PlayerY > 30 && model.wall4PlayerY < 107) ||
      (model.wall4PlayerX < -20 && model.wall4PlayerX > -375 && model.wall4PlayerY > 30 && model.wall4PlayerY < 257)) {
      return true
    }
    false

  }

  def PlayerWall3Condition(): Boolean = {
    if ((model.player.centerY.value < 980 && (model.wall3PlayerX >= 20.0 && model.wall3PlayerX <= 80.0) && (model.wall3PlayerY <= 25.0)) ||
      (model.player.centerY.value < 980 && (model.wall3PlayerX <= -420.0 && model.wall3PlayerX >= -490.0) && (model.wall3PlayerY <= 25.0 && model.wall3PlayerY > -125)) ||
      (model.wall3PlayerX > -420 && model.wall3PlayerX < 20 && model.wall3PlayerY > 30 && model.wall3PlayerY < 205)) {
      return true
    }
    false
  }


  def PlayerWall2Condition(): Boolean = {
    if ((model.player.centerY.value < 980 && (model.wall2PlayerX >= 20.0 && model.wall2PlayerX <= 80.0) && (model.wall2PlayerY <= 25.0 && model.wall2PlayerY > -125)) ||
      (model.player.centerY.value < 980 && (model.wall2PlayerX <= -420.0 && model.wall2PlayerX >= -490.0) && (model.wall2PlayerY <= 25.0)) ||
      (model.wall2PlayerX < 20 && model.wall2PlayerX > -20 && model.wall2PlayerY > 30 && model.wall2PlayerY < 55)) {
      return true
    }
    false
  }

  def PlayerWall1Condition(): Boolean = {
    if ((model.player.centerY.value < 980 && (model.wall1PlayerX >= 20.0 && model.wall1PlayerX <= 80.0) && (model.wall1PlayerY <= 25.0 && model.wall1PlayerY > -225)) ||
      (model.player.centerY.value < 980 && (model.wall1PlayerX <= -420.0 && model.wall1PlayerX >= -490.0) && (model.wall1PlayerY <= 25.0 && model.wall1PlayerY > -75))) {
      return true
    }
    false
  }

  def gravityLogic() {
    if (!model.onGround && model.cancelJump) {
      // this will aid with the collosion part if
      // collision happens the player circle will go out the window screen
      //
      if ((model.counter > 0 && model.player.centerY.value < 980)) {
        model.player.centerY = model.player.centerY.value + 300 * model.MSecond

        model.playerImageView.y = model.playerImageView.y.value + 300 * model.MSecond
        model.playerEye1ImageView.y = model.playerEye1ImageView.y.value + 300 * model.MSecond
        model.playerEye2ImageView.y = model.playerEye2ImageView.y.value + 300 * model.MSecond


        // model.playerEyeLeft.centerY = model.playerEyeLeft.centerY.value + 300 * model.MSecond
        // model.playerEyeRight.centerY = model.playerEyeRight.centerY.value + 300 * model.MSecond
        // model.playerMouth.centerY = model.playerMouth.centerY.value + 300 * model.MSecond
        model.counter -= 1

      }

      // wall 7
      else if (PlayerWall7Condition()) {
        model.player.centerY = model.player.centerY.value + 300 * model.MSecond
        model.playerImageView.y = model.playerImageView.y.value + 300 * model.MSecond
        model.playerEye1ImageView.y = model.playerEye1ImageView.y.value + 300 * model.MSecond
        model.playerEye2ImageView.y = model.playerEye2ImageView.y.value + 300 * model.MSecond


        // model.playerEyeLeft.centerY = model.playerEyeLeft.centerY.value + 300 * model.MSecond
        // model.playerEyeRight.centerY = model.playerEyeRight.centerY.value + 300 * model.MSecond
        // model.playerMouth.centerY = model.playerMouth.centerY.value + 300 * model.MSecond

        println("wall 7")
        // counter-=1
      }

      // wall 6
      else if (PlayerWall6Condition()) {
        model.player.centerY = model.player.centerY.value + 300 * model.MSecond
        model.playerImageView.y = model.playerImageView.y.value + 300 * model.MSecond
        model.playerEye1ImageView.y = model.playerEye1ImageView.y.value + 300 * model.MSecond
        model.playerEye2ImageView.y = model.playerEye2ImageView.y.value + 300 * model.MSecond


        // model.playerEyeLeft.centerY = model.playerEyeLeft.centerY.value + 300 * model.MSecond
        // model.playerEyeRight.centerY = model.playerEyeRight.centerY.value + 300 * model.MSecond
        // model.playerMouth.centerY = model.playerMouth.centerY.value + 300 * model.MSecond
        println("wall 6")
      }

      //wall 5
      else if (PlayerWall5Condition()) {
        model.player.centerY = model.player.centerY.value + 300 * model.MSecond
        model.playerImageView.y = model.playerImageView.y.value + 300 * model.MSecond
        model.playerEye1ImageView.y = model.playerEye1ImageView.y.value + 300 * model.MSecond
        model.playerEye2ImageView.y = model.playerEye2ImageView.y.value + 300 * model.MSecond

        // model.playerEyeLeft.centerY = model.playerEyeLeft.centerY.value + 300 * model.MSecond
        // model.playerEyeRight.centerY = model.playerEyeRight.centerY.value + 300 * model.MSecond
        // model.playerMouth.centerY = model.playerMouth.centerY.value + 300 * model.MSecond
        println("wall 5")

      }
      // 107

      //wall4
      else if (PlayerWall4Condtion()) {
        model.player.centerY = model.player.centerY.value + 300 * model.MSecond
        model.playerImageView.y = model.playerImageView.y.value + 300 * model.MSecond
        model.playerEye1ImageView.y = model.playerEye1ImageView.y.value + 300 * model.MSecond
        model.playerEye2ImageView.y = model.playerEye2ImageView.y.value + 300 * model.MSecond

        // model.playerEyeLeft.centerY = model.playerEyeLeft.centerY.value + 300 * model.MSecond
        // model.playerEyeRight.centerY = model.playerEyeRight.centerY.value + 300 * model.MSecond
        // model.playerMouth.centerY = model.playerMouth.centerY.value + 300 * model.MSecond

        println("wall 4")

      }

      //wall3
      else if (PlayerWall3Condition()) {
        model.player.centerY = model.player.centerY.value + 300 * model.MSecond
        model.playerImageView.y = model.playerImageView.y.value + 300 * model.MSecond
        model.playerEye1ImageView.y = model.playerEye1ImageView.y.value + 300 * model.MSecond
        model.playerEye2ImageView.y = model.playerEye2ImageView.y.value + 300 * model.MSecond


        // model.playerEyeLeft.centerY = model.playerEyeLeft.centerY.value + 300 * model.MSecond
        // model.playerEyeRight.centerY = model.playerEyeRight.centerY.value + 300 * model.MSecond
        // model.playerMouth.centerY = model.playerMouth.centerY.value + 300 * model.MSecond


      }

      //wall2
      else if (PlayerWall2Condition()) {
        model.player.centerY = model.player.centerY.value + 300 * model.MSecond
        model.playerImageView.y = model.playerImageView.y.value + 300 * model.MSecond
        model.playerEye1ImageView.y = model.playerEye1ImageView.y.value + 300 * model.MSecond
        model.playerEye2ImageView.y = model.playerEye2ImageView.y.value + 300 * model.MSecond

        // model.playerEyeLeft.centerY = model.playerEyeLeft.centerY.value + 300 * model.MSecond
        // model.playerEyeRight.centerY = model.playerEyeRight.centerY.value + 300 * model.MSecond
        // model.playerMouth.centerY = model.playerMouth.centerY.value + 300 * model.MSecond

      }
      // 55
      // 30

      //wall1
      else if (PlayerWall1Condition()) {
        model.player.centerY = model.player.centerY.value + 300 * model.MSecond
        model.playerImageView.y = model.playerImageView.y.value + 300 * model.MSecond
        model.playerEye1ImageView.y = model.playerEye1ImageView.y.value + 300 * model.MSecond
        model.playerEye2ImageView.y = model.playerEye2ImageView.y.value + 300 * model.MSecond


        // model.playerEyeLeft.centerY = model.playerEyeLeft.centerY.value + 300 * model.MSecond
        // model.playerEyeRight.centerY = model.playerEyeRight.centerY.value + 300 * model.MSecond
        // model.playerMouth.centerY = model.playerMouth.centerY.value + 300 * model.MSecond

      }


      else if (model.counter <= 0) {
        model.onGround = true
        model.counter = 30
        model.cancelJump = false
        // println("cancel")
      }
      else {
        // println("cancel")
        model.onGround = true
        model.counter = 30
        model.cancelJump = false
      }
    }
  }

  def jumpingLogic() {
    if (model.onGround && !model.cancelJump) {
      // println("jump")

      if (model.counter > 0 && model.spacePressed) {
        model.player.centerY = model.player.centerY.value - 300 * model.MSecond
        model.playerImageView.y = model.playerImageView.y.value - 300 * model.MSecond
        model.playerEye1ImageView.y = model.playerEye1ImageView.y.value - 300 * model.MSecond
        model.playerEye2ImageView.y = model.playerEye2ImageView.y.value - 300 * model.MSecond

        // model.playerEyeLeft.centerY = model.playerEyeLeft.centerY.value - 300 * model.MSecond
        // model.playerEyeRight.centerY = model.playerEyeRight.centerY.value - 300 * model.MSecond
        // model.playerMouth.centerY = model.playerMouth.centerY.value - 300 * model.MSecond
        model.counter -= 1
      }
      if (!model.spacePressed) {
        model.onGround = false

        model.counter = 30 - model.counter
        model.cancelJump = true
      }
      if (model.counter <= 0 && model.onGround) {
        model.onGround = false

        model.counter = 30
        model.cancelJump = true
        // println("done")
      }

    }
  }

  //!
  def keyboardInputLeft() {
    if (model.leftPressed) {
      model.player.centerX = model.player.centerX.value - model.playerSpeed * model.second

      model.playerImageView.x = model.playerImageView.x.value - model.playerSpeed * model.second
      model.playerEye1ImageView.x = model.playerEye1ImageView.x.value - model.playerSpeed * model.second
      model.playerEye2ImageView.x = model.playerEye2ImageView.x.value - model.playerSpeed * model.second

      // model.playerEyeLeft.centerX = model.playerEyeLeft.centerX.value - model.playerSpeed * model.second
      // model.playerEyeRight.centerX =model.playerEyeRight.centerX.value - model.playerSpeed * model.second
      // model.playerMouth.centerX = model.playerMouth.centerX.value - model.playerSpeed * model.second
    }


  }

  def keyboardInputRight() {
    if (model.rightPressed) {
      model.player.centerX = model.player.centerX.value + model.playerSpeed * model.second
      model.playerImageView.x = model.playerImageView.x.value + model.playerSpeed * model.second
      model.playerEye1ImageView.x = model.playerEye1ImageView.x.value + model.playerSpeed * model.second
      model.playerEye2ImageView.x = model.playerEye2ImageView.x.value + model.playerSpeed * model.second


      // model.playerEyeLeft.centerX = model.playerEyeLeft.centerX.value + model.playerSpeed * model.second
      // model.playerEyeRight.centerX =model.playerEyeRight.centerX.value + model.playerSpeed * model.second
      // model.playerMouth.centerX = model.playerMouth.centerX.value + model.playerSpeed * model.second
    }
  }

  def collisionCheck() {
    model.wall7Collide = Shape.intersect(model.player, model.wall7).boundsInLocal.value.isEmpty
    if (!model.wall7Collide) {

      model.player.centerX = model.playerOldX
      model.player.centerY = model.playerOldY

      model.playerImageView.x = model.playerImageViewOldX
      model.playerImageView.y = model.playerImageViewOldY

      model.playerEye1ImageView.x = model.playerEye1ImageViewOldX
      model.playerEye1ImageView.y = model.playerEye1ImageViewOldY

      model.playerEye2ImageView.x = model.playerEye2ImageViewOldX
      model.playerEye2ImageView.y = model.playerEye2ImageViewOldY

      // model.playerEyeLeft.centerY = model.playerEyeLeftOldY
      // model.playerEyeLeft.centerX = model.playerEyeLeftOldX

      // model.playerEyeRight.centerY = model.playerEyeRightOldY
      // model.playerEyeRight.centerX = model.playerEyeRightOldX

      // model.playerMouth.centerY = model.playerMouthOldY
      // model.playerMouth.centerX = model.playerMouthOldX
    }
    model.wall6Collide = Shape.intersect(model.player, model.wall6).boundsInLocal.value.isEmpty
    if (!model.wall6Collide) {
      model.player.centerX = model.playerOldX
      model.player.centerY = model.playerOldY

      model.playerImageView.x = model.playerImageViewOldX
      model.playerImageView.y = model.playerImageViewOldY

      model.playerEye1ImageView.x = model.playerEye1ImageViewOldX
      model.playerEye1ImageView.y = model.playerEye1ImageViewOldY

      model.playerEye2ImageView.x = model.playerEye2ImageViewOldX
      model.playerEye2ImageView.y = model.playerEye2ImageViewOldY

      // model.playerEyeLeft.centerY = model.playerEyeLeftOldY
      // model.playerEyeLeft.centerX = model.playerEyeLeftOldX

      // model.playerEyeRight.centerY = model.playerEyeRightOldY
      // model.playerEyeRight.centerX = model.playerEyeRightOldX

      // model.playerMouth.centerY = model.playerMouthOldY
      // model.playerMouth.centerX = model.playerMouthOldX
    }
    model.wall5Collide = Shape.intersect(model.player, model.wall5).boundsInLocal.value.isEmpty
    if (!model.wall5Collide) {
      model.player.centerX = model.playerOldX
      model.player.centerY = model.playerOldY

      model.playerImageView.x = model.playerImageViewOldX
      model.playerImageView.y = model.playerImageViewOldY

      model.playerEye1ImageView.x = model.playerEye1ImageViewOldX
      model.playerEye1ImageView.y = model.playerEye1ImageViewOldY

      model.playerEye2ImageView.x = model.playerEye2ImageViewOldX
      model.playerEye2ImageView.y = model.playerEye2ImageViewOldY

      // model.playerEyeLeft.centerY = model.playerEyeLeftOldY
      // model.playerEyeLeft.centerX = model.playerEyeLeftOldX

      // model.playerEyeRight.centerY = model.playerEyeRightOldY
      // model.playerEyeRight.centerX = model.playerEyeRightOldX

      // model.playerMouth.centerY = model.playerMouthOldY
      // model.playerMouth.centerX = model.playerMouthOldX
    }
    model.wall4Collide = Shape.intersect(model.player, model.wall4).boundsInLocal.value.isEmpty
    if (!model.wall4Collide) {
      model.player.centerX = model.playerOldX
      model.player.centerY = model.playerOldY

      model.playerImageView.x = model.playerImageViewOldX
      model.playerImageView.y = model.playerImageViewOldY

      model.playerEye1ImageView.x = model.playerEye1ImageViewOldX
      model.playerEye1ImageView.y = model.playerEye1ImageViewOldY

      model.playerEye2ImageView.x = model.playerEye2ImageViewOldX
      model.playerEye2ImageView.y = model.playerEye2ImageViewOldY

      // model.playerEyeLeft.centerY = model.playerEyeLeftOldY
      // model.playerEyeLeft.centerX = model.playerEyeLeftOldX

      // model.playerEyeRight.centerY = model.playerEyeRightOldY
      // model.playerEyeRight.centerX = model.playerEyeRightOldX

      // model.playerMouth.centerY = model.playerMouthOldY
      // model.playerMouth.centerX = model.playerMouthOldX
    }
    model.wall3Collide = Shape.intersect(model.player, model.wall3).boundsInLocal.value.isEmpty
    if (!model.wall3Collide) {
      model.player.centerX = model.playerOldX
      model.player.centerY = model.playerOldY

      model.playerImageView.x = model.playerImageViewOldX
      model.playerImageView.y = model.playerImageViewOldY

      model.playerEye1ImageView.x = model.playerEye1ImageViewOldX
      model.playerEye1ImageView.y = model.playerEye1ImageViewOldY

      model.playerEye2ImageView.x = model.playerEye2ImageViewOldX
      model.playerEye2ImageView.y = model.playerEye2ImageViewOldY

      // model.playerEyeLeft.centerY = model.playerEyeLeftOldY
      // model.playerEyeLeft.centerX = model.playerEyeLeftOldX

      // model.playerEyeRight.centerY = model.playerEyeRightOldY
      // model.playerEyeRight.centerX = model.playerEyeRightOldX

      // model.playerMouth.centerY = model.playerMouthOldY
      // model.playerMouth.centerX = model.playerMouthOldX
    }
    model.wall2Collide = Shape.intersect(model.player, model.wall2).boundsInLocal.value.isEmpty
    if (!model.wall2Collide) {
      model.player.centerX = model.playerOldX
      model.player.centerY = model.playerOldY

      model.playerImageView.x = model.playerImageViewOldX
      model.playerImageView.y = model.playerImageViewOldY

      model.playerEye1ImageView.x = model.playerEye1ImageViewOldX
      model.playerEye1ImageView.y = model.playerEye1ImageViewOldY

      model.playerEye2ImageView.x = model.playerEye2ImageViewOldX
      model.playerEye2ImageView.y = model.playerEye2ImageViewOldY

      // model.playerEyeLeft.centerY = model.playerEyeLeftOldY
      // model.playerEyeLeft.centerX = model.playerEyeLeftOldX

      // model.playerEyeRight.centerY = model.playerEyeRightOldY
      // model.playerEyeRight.centerX = model.playerEyeRightOldX

      // model.playerMouth.centerY = model.playerMouthOldY
      // model.playerMouth.centerX = model.playerMouthOldX
    }
    model.wall1Collide = Shape.intersect(model.player, model.wall1).boundsInLocal.value.isEmpty
    if (!model.wall1Collide) {
      model.player.centerX = model.playerOldX
      model.player.centerY = model.playerOldY

      model.playerImageView.x = model.playerImageViewOldX
      model.playerImageView.y = model.playerImageViewOldY

      model.playerEye1ImageView.x = model.playerEye1ImageViewOldX
      model.playerEye1ImageView.y = model.playerEye1ImageViewOldY

      model.playerEye2ImageView.x = model.playerEye2ImageViewOldX
      model.playerEye2ImageView.y = model.playerEye2ImageViewOldY

      // model.playerEyeLeft.centerY = model.playerEyeLeftOldY
      // model.playerEyeLeft.centerX = model.playerEyeLeftOldX

      // model.playerEyeRight.centerY = model.playerEyeRightOldY
      // model.playerEyeRight.centerX = model.playerEyeRightOldX

      // model.playerMouth.centerY = model.playerMouthOldY
      // model.playerMouth.centerX = model.playerMouthOldX
    }
    model.keyCollide = Shape.intersect(model.player, model.keyNextStage).boundsInLocal.value.isEmpty
    if (!model.keyCollide) {
      model.nextStage = true

    }
  }

  def collisionlogicSideWall() {
    if (model.player.centerX.value <= 20.0) {
      model.player.centerX = model.playerOldX

      model.playerImageView.x = model.playerImageViewOldX
      model.playerEye1ImageView.x = model.playerEye1ImageViewOldX
      model.playerEye2ImageView.x = model.playerEye2ImageViewOldX


      // model.playerEyeLeft.centerX = model.playerEyeLeftOldX

      // model.playerEyeRight.centerX = model.playerEyeRightOldX

      // model.playerMouth.centerX = model.playerMouthOldX
    }
    if (model.player.centerX.value >= 980.0) {
      model.player.centerX = model.playerOldX

      model.playerImageView.x = model.playerImageViewOldX
      model.playerEye1ImageView.x = model.playerEye1ImageViewOldX
      model.playerEye2ImageView.x = model.playerEye2ImageViewOldX
      // model.playerEyeLeft.centerX = model.playerEyeLeftOldX

      // model.playerEyeRight.centerX = model.playerEyeRightOldX

      // model.playerMouth.centerX = model.playerMouthOldX
    }


  }

  def Press(e: KeyEvent) {
    if (e.code == KeyCode.Left) model.leftPressed = true
    if (e.code == KeyCode.Right) model.rightPressed = true
    if (e.code == KeyCode.Space) model.spacePressed = true
  }

  def Release(e: KeyEvent) {
    if (e.code == KeyCode.Left) model.leftPressed = false
    if (e.code == KeyCode.Right) model.rightPressed = false
    if (e.code == KeyCode.Space) model.spacePressed = false
  }

  def HelpNeeded() {
    new Alert(AlertType.Information) {
      title = "Game Control"
      headerText = "Control Information"
      contentText = "This game use 3keys\n\nLeftKey - move the object to the left\nRightKey - mvoe the object to the right\nspacebarKey - make the object jump"
    }.showAndWait()

  }


}