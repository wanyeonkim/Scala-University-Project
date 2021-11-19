package model

import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.media.AudioClip
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle
import scalafx.scene.text._

import scala.collection.mutable.ListBuffer

class BossRoomModel {
  var bullet = new Bullet()
  var player = new Player()
  var control = new Control()
  var enemy = new Enemy()

  val bossImage = new Image(getClass.getResourceAsStream("doge.png"))
  val bossImageDead = new Image(getClass.getResourceAsStream("doge_dead.png"))
  val bossImageView = new ImageView(bossImage){
    fitWidth = 100
    fitHeight = 300
    x = 800
    y = 700
  }

  var menuButton = new Text(20,20,"Menu")
  menuButton.setFont(Font.font(null, FontWeight.Bold, 20))


  val bulletSound = new AudioClip(getClass.getResource("shot.mp3").toExternalForm())
  bulletSound.setVolume(0.2)

  var score = 0


  var onGround = true

  //# game variables
  var gameTimer = 0L
  
  var counter = 30
  var cancelJump = false
  //! same as second but this will give a constant value as second gives different value everytime.
  var MSecond = 0.025




  //#coin
  var coinBox = Rectangle(885, 25, 100, 50)
  coinBox.fill = Color.White
  var coinValue = 0
  var coinText = new Text(930, 60, coinValue.toString)
  coinText.fill = Color.Black
  coinText.setFont(Font.font(30))


  var currency = 10
  var coinTimer = 2.0
  var bigCoinTimer = 5.0
  var coinCollection = ListBuffer[ImageView]()
  var coinImage = new Image(getClass.getResourceAsStream("coin.png"))
  var coinImageView = new ImageView(coinImage) {
    fitWidth = 30
    fitHeight = 30
    x = player.player.centerX.value
    y = 0
  }

  //# powerup icons
  var bulletImage = new Image(getClass.getResourceAsStream("bullet.png"))
  var bulletImageView = new ImageView(bulletImage) {
    fitWidth = 50
    fitHeight = 50
    x = 930
    y = 100
  }
  var bulletUp = false

  var reloadImage = new Image(getClass.getResourceAsStream("reload.png"))
  var reloadImageView = new ImageView(reloadImage) {
    fitWidth = 50
    fitHeight = 50
    x = 930
    y = 180
  }


  //# player hp bar section
  // var playerHp = new Text(50.0, 50.0, "Player Hp: ")
  // playerHp.fill = Color.White
  // playerHp.setFont(Font.font(30))
  // var playerBar = new Text(50,100,playerHpValue.toString)
  // playerBar.fill = Color.White
  // playerBar.setFont(Font.font(20))

  //# shield
  val shield = Rectangle(0, 0, 5, 50)
  val shieldImage = new Image(getClass.getResourceAsStream("shield.png"))
  val shieldImageView = new ImageView(shieldImage) {
    fitWidth = 30
    fitHeight = 30
    x = 20
    y = 180
  }


  //# displays amount bullet shot out
//  def btnCell(actionEvent: ActionEvent): Unit = {
//    val source = actionEvent.getSource.asInstanceOf[Nothing]
//    val id = source.getId()
//    val scene = source.getScene
//    scene.lookup("#" + id).getStyleClass
//  }

  var bulletDisplayTag = new Text(20, 300, "Shot :")
  bulletDisplayTag.fill = Color.White
  var bulletDisplay = new Text(60, 300, bullet.bulletList.length.toString)
  bulletDisplay.fill = Color.White

  //# display amount bullet ava
  var avaBulletDisplayTag = new Text(20, 350, "Ava :")
  avaBulletDisplayTag.fill = Color.White
  var avaBulletDisplay = new Text(60, 350, (bullet.totalAmmoAmount - bullet.bulletList.length).toString)
  avaBulletDisplay.fill = Color.White





  //# check if the perk is collected by the player
  var isPerkBoxCollected = false
  var perkSent = false;

  var perkDuration = 0.0
  var perkDurationDisplay = new Text(60, 250, perkDuration.toInt.toString)
  perkDurationDisplay.fill = Color.White

  var perkImage = new Image(getClass.getResourceAsStream("saiyan.png"))
  var perkImageView = new ImageView(perkImage) {
    fitWidth = 30
    fitHeight = 30
    x = 20
    y = 230
  }


  var perkDisappearTimer = -1.0
  var isPerkGone = false



  var second = 0.0




  val backgroundImage = new Image(getClass().getResourceAsStream("BG.png"))
  val backgroundImageView = new ImageView(backgroundImage) {
    fitWidth = 1000
    fitHeight = 1000
    x = 0
    y = 0
  }


}