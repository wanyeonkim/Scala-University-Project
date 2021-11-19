package model

import scalafx.scene.paint.Color
import scalafx.scene.shape.{Circle, Rectangle, Shape}

import scalafx.scene.text._
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.control._


class SceneJumping1Model {

  // //! menu button
  // var menuButton = new Text(20,20,"Menu")
  // menuButton.setFont(Font.font(null, FontWeight.Bold, 20))

  var Timer = 0.0

  val help = new Text(930, 30, "Help")
  help.fill = Color.White
  help.setFont(Font.font(30))


  val wall1 = Rectangle(100, 50, 400, 20)
  wall1.fill = Color.White
  wall1.disable

  val wall1Image = new Image(getClass().getResourceAsStream("GroundTile.png"))
  val wall1ImageView = new ImageView(wall1Image) {
    fitWidth = 400
    fitHeight = 20
    x = 100
    y = 50
  }

  val wall2 = Rectangle(500, 150, 400, 20)
  wall2.fill = Color.White

  val wall2ImageView = new ImageView(wall1Image) {
    fitWidth = 400
    fitHeight = 20
    x = 500
    y = 150
  }

  val wall3 = Rectangle(50, 300, 400, 20)
  wall3.fill = Color.White

  val wall3ImageView = new ImageView(wall1Image) {
    fitWidth = 400
    fitHeight = 20
    x = 50
    y = 300
  }

  val wall4 = Rectangle(450, 450, 400, 20)
  wall4.fill = Color.White

  val wall4ImageView = new ImageView(wall1Image) {
    fitWidth = 400
    fitHeight = 20
    x = 450
    y = 450
  }

  val wall5 = Rectangle(150, 600, 400, 20)
  wall5.fill = Color.White

  val wall5ImageView = new ImageView(wall1Image) {
    fitWidth = 400
    fitHeight = 20
    x = 150
    y = 600
  }

  val wall6 = Rectangle(600, 800, 200, 20)
  wall6.fill = Color.White

  val wall6ImageView = new ImageView(wall1Image) {
    fitWidth = 200
    fitHeight = 20
    x = 600
    y = 800
  }

  val wall7 = Rectangle(100, 850, 400, 20)
  wall7.fill = Color.White
  wall7.disable


  val wall7ImageView = new ImageView(wall1Image) {
    fitWidth = 400
    fitHeight = 20
    x = 100
    y = 850
  }

  val backgroundImage = new Image(getClass().getResourceAsStream("background.png"))
  val backgroundImageView = new ImageView(backgroundImage) {
    fitWidth = 1000
    fitHeight = 1000
    x = 0
    y = 0
  }

  val keyNextStage = Circle(120, 40, 10)
  keyNextStage.fill = Color.White


  // player section
  var leftPressed = false
  var rightPressed = false
  var spacePressed = false
  var onGround = true

  var gameTimer = 0L
  var playerJumpHeight = 100

  var counter = 30
  var cancelJump = false
  var MSecond = 0.025

  val player = Circle(50, 980, 20)
  player.fill = Color.Green

  val playerImage = new Image(getClass().getResourceAsStream("Body.png"))
  val playerImageView = new ImageView(playerImage) {
    fitWidth = 40
    fitHeight = 40
    x = 30
    y = 960
  }

  val playerEyeImage = new Image(getClass().getResourceAsStream("Eye.png"))
  val playerEye1ImageView = new ImageView(playerEyeImage) {
    fitWidth = 10
    fitHeight = 15
    x = 35
    y = 970
  }
  val playerEye2ImageView = new ImageView(playerEyeImage) {
    fitWidth = 10
    fitHeight = 15
    x = 50
    y = 970
  }


  val playerSpeed = 100


  var playerOldY = player.centerY.value
  var playerOldX = player.centerX.value

  var playerImageViewOldX = playerImageView.x.value
  var playerImageViewOldY = playerImageView.y.value

  var playerEye1ImageViewOldX = playerEye1ImageView.x.value
  var playerEye1ImageViewOldY = playerEye1ImageView.y.value

  var playerEye2ImageViewOldX = playerEye2ImageView.x.value
  var playerEye2ImageViewOldY = playerEye2ImageView.y.value


  var wall7Collide = Shape.intersect(player, wall7).boundsInLocal.value.isEmpty
  var wall7PlayerX = wall7.getX - player.centerX.value
  var wall7PlayerY = wall7.getY - player.centerY.value

  var wall6Collide = Shape.intersect(player, wall6).boundsInLocal.value.isEmpty
  var wall6PlayerX = wall6.getX - player.centerX.value
  var wall6PlayerY = wall6.getY - player.centerY.value

  var wall5Collide = Shape.intersect(player, wall5).boundsInLocal.value.isEmpty
  var wall5PlayerX = wall5.getX - player.centerX.value
  var wall5PlayerY = wall5.getY - player.centerY.value

  var wall4Collide = Shape.intersect(player, wall4).boundsInLocal.value.isEmpty
  var wall4PlayerX = wall4.getX - player.centerX.value
  var wall4PlayerY = wall4.getY - player.centerY.value

  var wall3Collide = Shape.intersect(player, wall3).boundsInLocal.value.isEmpty
  var wall3PlayerX = wall3.getX - player.centerX.value
  var wall3PlayerY = wall3.getY - player.centerY.value

  var wall2Collide = Shape.intersect(player, wall2).boundsInLocal.value.isEmpty
  var wall2PlayerX = wall2.getX - player.centerX.value
  var wall2PlayerY = wall2.getY - player.centerY.value

  var wall1Collide = Shape.intersect(player, wall1).boundsInLocal.value.isEmpty
  var wall1PlayerX = wall1.getX - player.centerX.value
  var wall1PlayerY = wall1.getY - player.centerY.value

  var keyCollide = Shape.intersect(player, keyNextStage).boundsInLocal.value.isEmpty

  var second = 0.0

  var nextStage = false


}