package model 

import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.paint.Color
import scalafx.scene.shape.{Circle, Rectangle}
import scalafx.scene.text._
import scalafx.scene.control._


import scala.collection.mutable.ListBuffer
import scalafx.scene.media.AudioClip

class Enemy {
    var enemyDamage = 4
  var enemy = Rectangle(800, 750, 100, 300)
  enemy.fill = Color.web("#fff",0)

  

  //# enemy hp bar section
  var enemyHp = new Text(700.0, 50.0, "Enemy Hp: ")
  enemyHp.fill = Color.White
  enemyHp.setFont(Font.font(30))


  //# since there will be 2 position for the bullet
  //# so this will be the first opening for the bullet
  var enemyBulletTimer = 1.0
  var enemyBullet = ListBuffer[Circle]()
  var enemyList = ListBuffer[Circle]()


  //# this will be the second opening for the bullet
  var enemyBulletTimer2 = 1.5
  var enemyBullet2 = ListBuffer[Circle]()
  var enemyList2 = ListBuffer[Circle]()

  //# this will be enemy hp bar
  var barSquareEnemy = Rectangle(700, 100, 100, 10)
  barSquareEnemy.fill = Color.Green

  var barSquare1Enemy = Rectangle(700, 100, 100, 10)
  barSquare1Enemy.fill = Color.Red

  var ultimateTimer = 30.0
  var ultimateBar = Rectangle(680, 700, 300, 10)
  var ultimateBar1 = Rectangle(680, 700, 300, 10)
  ultimateBar.fill = Color.Green
  ultimateBar1.fill = Color.White

  val bossImage = new Image(getClass.getResourceAsStream("doge.png"))
  val bossImageDead = new Image(getClass.getResourceAsStream("doge_dead.png"))
  val bossImageView = new ImageView(bossImage){
    fitWidth = 100
    fitHeight = 300
    x = 800
    y = 700
  }



}