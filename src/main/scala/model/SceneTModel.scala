package model

import scalafx.scene.paint.Color
import scalafx.scene.shape.{Circle, Rectangle};
import scalafx.scene.image.{ImageView, Image}
import scalafx.scene.text._
import scalafx.scene.control._

class SceneTModel {

  // //! menu button
  // var menuButton = new Text(20,20,"Menu")
  // menuButton.setFont(Font.font(null, FontWeight.Bold, 20))

  var Timer = 0.0
  var player = new Player()
  var wall = new Wall(player.player.centerX.value,player.player.centerY.value)
  var control = new Control()

  var isDialogShow = false
  var dialogTimer = 3.0
  var instructionBox = Rectangle(300, 500, 300, 110)
  instructionBox.fill = Color.web("#657c8c", 0.9)
  var instructionText = new Text(310, 520, "Welcome to this game you have\n120second to complete this\nround. Use left and right arrow\nkeys and space to jump")
  instructionText.setFont(Font.font(20))


  val help = new Text(930, 30, "Help")
  help.fill = Color.Black
  help.setFont(Font.font(30))

  // val wall1 = Rectangle(50, 300, 300, 20)
  // wall1.fill = Color.White

  // val wall2 = Rectangle(470, 400, 300, 20)
  // wall2.fill = Color.White

  // val wall3 = Rectangle(50, 500, 300, 20)
  // wall3.fill = Color.White

  // val wall4 = Rectangle(450, 600, 300, 20)
  // wall4.fill = Color.White

  // val wall5 = Rectangle(100, 700, 300, 20)
  // wall5.fill = Color.White

  // val wall6 = Rectangle(500, 800, 300, 20)
  // wall6.fill = Color.White

  // val wall7 = Rectangle(100, 900, 300, 20)
  // wall7.fill = Color.White

  // val wall1Image = new Image(getClass().getResourceAsStream("GroundTile.png"))

  // val wall1ImageView = new ImageView(wall1Image) {
  //   fitWidth = 300
  //   fitHeight = 20
  //   x = 50
  //   y = 300
  // }
  // val wall2ImageView = new ImageView(wall1Image) {
  //   fitWidth = 300
  //   fitHeight = 20
  //   x = 470
  //   y = 400
  // }
  // val wall3ImageView = new ImageView(wall1Image) {
  //   fitWidth = 300
  //   fitHeight = 20
  //   x = 50
  //   y = 500
  // }
  // val wall4ImageView = new ImageView(wall1Image) {
  //   fitWidth = 300
  //   fitHeight = 20
  //   x = 450
  //   y = 600
  // }
  // val wall5ImageView = new ImageView(wall1Image) {
  //   fitWidth = 300
  //   fitHeight = 20
  //   x = 100
  //   y = 700
  // }
  // val wall6ImageView = new ImageView(wall1Image) {
  //   fitWidth = 300
  //   fitHeight = 20
  //   x = 500
  //   y = 800
  // }
  // val wall7ImageView = new ImageView(wall1Image) {
  //   fitWidth = 300
  //   fitHeight = 20
  //   x = 100
  //   y = 900
  // }
  val backgroundImage = new Image(getClass().getResourceAsStream("background.png"))
  val backgroundImageView = new ImageView(backgroundImage) {
    fitWidth = 1000
    fitHeight = 1000
    x = 0
    y = 0
  }


  val keyNextStage = Circle(60, 290, 10)
  keyNextStage.fill = Color.White

  // player section
  // var leftPressed = false
  // var rightPressed = false
  // var spacePressed = false
  // var onGround = true

  var gameTimer = 0L
  var playerJumpHeight = 250

  var counter = 30
  var cancelJump = false
  var MSecond = 0.025
  var second = 0.0

  // val player = Circle(50, 980, 20)
  // player.fill = Color.Green

  // val playerImage = new Image(getClass().getResourceAsStream("Body.png"))
  // val playerImageView = new ImageView(playerImage) {
  //   fitWidth = 40
  //   fitHeight = 40
  //   x = 30
  //   y = 960
  // }

  // val playerEyeImage = new Image(getClass().getResourceAsStream("Eye.png"))
  // val playerEye1ImageView = new ImageView(playerEyeImage) {
  //   fitWidth = 10
  //   fitHeight = 15
  //   x = 35
  //   y = 970
  // }
  // val playerEye2ImageView = new ImageView(playerEyeImage) {
  //   fitWidth = 10
  //   fitHeight = 15
  //   x = 50
  //   y = 970
  // }


  // // val playerEyeLeft = Circle(42,975,5)
  // // playerEyeLeft.fill = Color.Red
  // // val playerEyeRight = Circle(60,975,5)
  // // playerEyeRight.fill = Color.Red
  // // val playerMouth = Circle(51,990,5) 
  // // playerMouth.fill = Color.White

  // val playerSpeed = 120

  // var playerOldY = player.centerY.value
  // var playerOldX = player.centerX.value


  // var playerImageViewOldX = playerImageView.x.value
  // var playerImageViewOldY = playerImageView.y.value

  // var playerEye1ImageViewOldX = playerEye1ImageView.x.value
  // var playerEye1ImageViewOldY = playerEye1ImageView.y.value

  // var playerEye2ImageViewOldX = playerEye2ImageView.x.value
  // var playerEye2ImageViewOldY = playerEye2ImageView.y.value


  // var wall7Collide = true
  // var wall7PlayerX = wall7.getX - player.centerX.value
  // var wall7PlayerY = wall7.getY - player.centerY.value

  // var wall6Collide = true
  // var wall6PlayerX = wall6.getX - player.centerX.value
  // var wall6PlayerY = wall6.getY - player.centerY.value

  // var wall5Collide = true
  // var wall5PlayerX = wall5.getX - player.centerX.value
  // var wall5PlayerY = wall5.getY - player.centerY.value

  // var wall4Collide = true
  // var wall4PlayerX = wall4.getX - player.centerX.value
  // var wall4PlayerY = wall4.getY - player.centerY.value

  // var wall3Collide = true
  // var wall3PlayerX = wall3.getX - player.centerX.value
  // var wall3PlayerY = wall3.getY - player.centerY.value

  // var wall2Collide = true
  // var wall2PlayerX = wall2.getX - player.centerX.value
  // var wall2PlayerY = wall2.getY - player.centerY.value

  // var wall1Collide = true
  // var wall1PlayerX = wall1.getX - player.centerX.value
  // var wall1PlayerY = wall1.getY - player.centerY.value

  var keyCollide = true

}