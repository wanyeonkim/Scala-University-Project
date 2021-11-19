package model
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.shape.{Circle, Rectangle}
import scalafx.scene.paint.Color
import scalafx.scene.text._

class Player {
    var perkBox = Circle(0, 0, 10)
  perkBox.fill = Color.Green
    var playerHp = new Text(50.0, 50.0, "Player Hp: ")
  playerHp.fill = Color.White
  playerHp.setFont(Font.font(30))
    val player = Circle(50, 980, 20)
  player.fill = Color.Green
  var playerJumpHeight = 250
  var playerDamage = 2
  var playerShieldTime = 10
  var playerShieldTimeDisplay = new Text(60, 200, playerShieldTime.toString)
  playerShieldTimeDisplay.fill = Color.White

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

  val playerSpeed = 120

  var playerOldY = player.centerY.value
  var playerOldX = player.centerX.value
  var playerPerkDiffX = player.centerX.value - perkBox.centerX.value
  var playerPerkDiffY = player.centerY.value - perkBox.centerY.value
  var perkBoxOldY = perkBox.centerY.value
  var perkBoxOldX = perkBox.centerX.value

  var playerImageViewOldX = playerImageView.x.value
  var playerImageViewOldY = playerImageView.y.value

  var playerEye1ImageViewOldX = playerEye1ImageView.x.value
  var playerEye1ImageViewOldY = playerEye1ImageView.y.value

  var playerEye2ImageViewOldX = playerEye2ImageView.x.value
  var playerEye2ImageViewOldY = playerEye2ImageView.y.value

  var barSquarePlayer = Rectangle(50, 100, 100, 10)
  barSquarePlayer.fill = Color.Green

  var barSquare1Player = Rectangle(50, 100, 100, 10)
  barSquare1Player.fill = Color.Red

  var perkTimer = 20.0

  var perkTimerDisplay = new Text(300, 100, perkTimer.toInt.toString)
  perkTimerDisplay.fill = Color.White
  perkTimerDisplay.setFont(Font.font(25))

  

}