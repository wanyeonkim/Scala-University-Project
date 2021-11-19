package model

import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.paint.Color
import scalafx.scene.shape.{Circle, Rectangle}

import scalafx.scene.text._
import scala.collection.mutable.ListBuffer;
import scalafx.scene.control._


class FinalStageModel {

  // //! menu button
  // var menuButton = new Text(20,20,"Menu")
  // menuButton.setFont(Font.font(null, FontWeight.Bold, 20))

  var hpImage = new Image(getClass.getResourceAsStream("heart.png"))
  var hpImageView1 = new ImageView(hpImage) {
    fitWidth = 30
    fitHeight = 30
    x = 100
    y = 5
  }
  var hpImageView2 = new ImageView(hpImage) {
    fitWidth = 30
    fitHeight = 30
    x = 130
    y = 5
  }
  var hpImageView3 = new ImageView(hpImage) {
    fitWidth = 30
    fitHeight = 30
    x = 160
    y = 5
  }
  var hpImageView4 = new ImageView(hpImage) {
    fitWidth = 30
    fitHeight = 30
    x = 190
    y = 5
  }
  var hpImageView5 = new ImageView(hpImage) {
    fitWidth = 30
    fitHeight = 30
    x = 220
    y = 5
  }
  var hpList = ListBuffer[ImageView](hpImageView1, hpImageView2, hpImageView3, hpImageView4, hpImageView5)


  var score = 0
  var scoreArray1 = ListBuffer[Rectangle]()
  var scoreArray2 = ListBuffer[Rectangle]()

  var scoreBox = Rectangle(885, 25, 100, 50)
  scoreBox.fill = Color.White

  var scoreText = new Text(930, 60, score.toString)
  scoreText.fill = Color.Black
  scoreText.setFont(Font.font(30))

  var leftPressed = false
  var rightPressed = false
  var spacePressed = false
  var onGround = true

  //# game variables
  var gameTimer = 0L
  var playerJumpHeight = 250
  var counter = 30
  var cancelJump = false
  //! same as second but this will give a constant value as second gives different value everytime.
  var MSecond = 0.025


  //# player
  val player = Circle(300, 200, 20)
  player.fill = Color.Green

  val playerImage = new Image(getClass().getResourceAsStream("Body.png"))
  val playerImageView = new ImageView(playerImage) {
    fitWidth = 40
    fitHeight = 40
    x = 280
    y = 180
  }

  val playerEyeImage = new Image(getClass().getResourceAsStream("Eye.png"))
  val playerEye1ImageView = new ImageView(playerEyeImage) {
    fitWidth = 10
    fitHeight = 15
    x = 285
    y = 190
  }
  val playerEye2ImageView = new ImageView(playerEyeImage) {
    fitWidth = 10
    fitHeight = 15
    x = 300
    y = 190
  }


  val playerSpeed = 120


  //# enemy
  // var enemyHpValue = 100
  //! i need this enemy for a reference point  so this object doesnt really do anything, 
  //! so in this case it is just a reference point.
  var enemyDamage = 4
  var enemy = Rectangle(800, 750, 100, 300)

  enemy.fill = Color.web("#fff", 0)


  //# since there will be 2 position for the bullet
  //# so this will be the first opening for the bullet
  var enemyBulletTimer = 1.0
  var enemyBullet = ListBuffer[Rectangle]()

  //# this will be the second opening for the bullet
  var enemyBulletTimer2 = 1.5
  var enemyBullet2 = ListBuffer[Rectangle]()

  //# this will be used inside the scene initialized here so it can access anywhere in this class
  var second = 0.0

  //# since animationTimer doesnt stop until stop is called
  //# so saving a step back can be used for collision check.
  var playerOldY = player.centerY.value
  var playerOldX = player.centerX.value

  var playerImageViewOldX = playerImageView.x.value
  var playerImageViewOldY = playerImageView.y.value

  var playerEye1ImageViewOldX = playerEye1ImageView.x.value
  var playerEye1ImageViewOldY = playerEye1ImageView.y.value

  var playerEye2ImageViewOldX = playerEye2ImageView.x.value
  var playerEye2ImageViewOldY = playerEye2ImageView.y.value

  val backgroundImage = new Image(getClass().getResourceAsStream("background.png"))
  val backgroundImageView = new ImageView(backgroundImage) {
    fitWidth = 1000
    fitHeight = 1000
    x = 0
    y = 0
  }


}