package model
import scala.collection.mutable.ListBuffer
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.media.AudioClip
import scalafx.scene.paint.Color
import scalafx.scene.shape.{Circle, Rectangle}


class Bullet {
    val player = new Player()
    val bulletSound = new AudioClip(getClass.getResource("shot.mp3").toExternalForm())
  bulletSound.setVolume(0.2)
    var bulletList = ListBuffer[Circle]()
  var bullet = Circle(player.player.centerX.value + 20, player.player.centerY.value, 10)
  bullet.fill = Color.White
  val bulletSpeed = 300
  val bulletImageL = new Image(getClass().getResourceAsStream("buLeft.png"))
  var bulletImageLList = ListBuffer[ImageView]()
  var bulletImageLList2 = ListBuffer[ImageView]()
  val bulletImageR = new Image(getClass().getResourceAsStream("buRight.png"))
  var bulletImageRList = ListBuffer[ImageView]()

  var shot = false
  var reloadTime = 0.0
  var isBulletTravel = false
  var totalAmmoAmount = 2

}