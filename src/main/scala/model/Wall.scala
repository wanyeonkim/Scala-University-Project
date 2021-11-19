package model

import scalafx.scene.paint.Color
import scalafx.scene.shape.{Circle, Rectangle};
import scalafx.scene.image.{ImageView, Image}
import scalafx.scene.text._
import scalafx.scene.control._

class Wall(playerx:Double,playery:Double) {
    val wall1 = Rectangle(50, 300, 300, 20)
  wall1.fill = Color.White

  val wall2 = Rectangle(470, 400, 300, 20)
  wall2.fill = Color.White

  val wall3 = Rectangle(50, 500, 300, 20)
  wall3.fill = Color.White

  val wall4 = Rectangle(450, 600, 300, 20)
  wall4.fill = Color.White

  val wall5 = Rectangle(100, 700, 300, 20)
  wall5.fill = Color.White

  val wall6 = Rectangle(500, 800, 300, 20)
  wall6.fill = Color.White

  val wall7 = Rectangle(100, 900, 300, 20)
  wall7.fill = Color.White

  val wall1Image = new Image(getClass().getResourceAsStream("GroundTile.png"))

  val wall1ImageView = new ImageView(wall1Image) {
    fitWidth = 300
    fitHeight = 20
    x = 50
    y = 300
  }
  val wall2ImageView = new ImageView(wall1Image) {
    fitWidth = 300
    fitHeight = 20
    x = 470
    y = 400
  }
  val wall3ImageView = new ImageView(wall1Image) {
    fitWidth = 300
    fitHeight = 20
    x = 50
    y = 500
  }
  val wall4ImageView = new ImageView(wall1Image) {
    fitWidth = 300
    fitHeight = 20
    x = 450
    y = 600
  }
  val wall5ImageView = new ImageView(wall1Image) {
    fitWidth = 300
    fitHeight = 20
    x = 100
    y = 700
  }
  val wall6ImageView = new ImageView(wall1Image) {
    fitWidth = 300
    fitHeight = 20
    x = 500
    y = 800
  }
  val wall7ImageView = new ImageView(wall1Image) {
    fitWidth = 300
    fitHeight = 20
    x = 100
    y = 900
  }
  
  var wall7Collide = true
  var wall7PlayerX = wall7.getX - playerx
  var wall7PlayerY = wall7.getY - playery

  var wall6Collide = true
  var wall6PlayerX = wall6.getX - playerx
  var wall6PlayerY = wall6.getY - playery

  var wall5Collide = true
  var wall5PlayerX = wall5.getX - playerx
  var wall5PlayerY = wall5.getY - playery

  var wall4Collide = true
  var wall4PlayerX = wall4.getX - playerx
  var wall4PlayerY = wall4.getY - playery

  var wall3Collide = true
  var wall3PlayerX = wall3.getX - playerx
  var wall3PlayerY = wall3.getY - playery

  var wall2Collide = true
  var wall2PlayerX = wall2.getX - playerx
  var wall2PlayerY = wall2.getY - playery

  var wall1Collide = true
  var wall1PlayerX = wall1.getX - playerx
  var wall1PlayerY = wall1.getY - playery
}