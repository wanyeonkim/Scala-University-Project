package model


import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.text._
import scalafx.scene.control._

class CreditModel {
  // var menuButton = new Text(20,20,"Menu")
  // menuButton.setFont(Font.font(null, FontWeight.Bold, 20))
  val bronze = new Image(getClass.getResourceAsStream("bronze.png"))
  val silver = new Image(getClass.getResourceAsStream("silver.png"))
  val gold = new Image(getClass.getResourceAsStream("gold.png"))

  val bronzeImageView = new ImageView(bronze) {
    fitWidth = 313
    fitHeight = 296
    x = 350
    y = 200
  }
  val silverImageView = new ImageView(silver) {
    fitWidth = 313
    fitHeight = 296
    x = 350
    y = 200
  }
  val goldImageView = new ImageView(gold) {
    fitWidth = 313
    fitHeight = 296
    x = 350
    y = 200
  }

}