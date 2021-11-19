package model

import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.paint.Color
import scalafx.scene.shape.{Circle, Rectangle}

import scalafx.scene.text._
import scala.collection.mutable.ListBuffer;
import scalafx.scene.media.AudioClip
import scalafx.scene.text._
import scalafx.scene.control._

class ClickerModel {
    
//     var menuButton = new Text(20,20,"Menu")
//     menuButton.fill = Color.White
//   menuButton.setFont(Font.font(null, FontWeight.Bold, 20))

    var popSound = new AudioClip(getClass.getResource("cat_pop.mp3").toExternalForm())
    var catCloseImage = new Image(getClass.getResourceAsStream("cat_close.png"))
    var catCloseImageView = new ImageView(catCloseImage){
        fitWidth = 635
        fitHeight = 584
        x = 200
        y = 200
    }
    var catOpenImage = new Image(getClass.getResourceAsStream("cat_open.png"))
    var catOpenImageView = new ImageView(catOpenImage){
        fitWidth = 635
        fitHeight = 584
        x = 200
        y = 200
    }
    var clickedImage = new Image(getClass.getResourceAsStream("click.png"))
    var clickedImageView = new ImageView(clickedImage){
        fitWidth = 83
        fitHeight = 44
        x = 100
        y = 100
    }
    var clickCount = 0.0
    var clickText = new Text(500,50,clickCount.toInt.toString)
    clickText.fill = Color.White
    clickText.setFont(Font.font(40))
    var mouseCliked = false

    var dupCheck = false
    
    


}