package view

import scalafx.Includes._
import scalafx.animation._
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.image.{Image, ImageView}

import scalafx.scene.paint.Color
import scalafx.scene.text.{FontWeight, _}

import scala.collection.mutable.ListBuffer
import scalafx.scene.layout.HBox
import scalafx.scene.control.{MenuBar, Menu, MenuItem}



class MainPage {
  val scene1View = new SceneJumping1()
  val sceneTView = new SceneT()
  val bossR = new BossRoom()
  val fStage = new FinalStage()
  var previewTimer = 5.0
  var gameTimer = 0L
  var mediaLoopCount = 0
  var mediaTimer = 0.0
  var mSecond = 0.025

  //! stage1 Section
  var stage1Bool = false
  val stage1PreviewImage = new Image(getClass().getResourceAsStream("stage1Preview.png"))
  val stage1PreviewImageView = new ImageView(stage1PreviewImage) {
    fitWidth = 500
    fitHeight = 380
    x = 200
    y = 600
  }

  //! stage2 Section
  var stage2Bool = false
  val stage2PreviewImage = new Image(getClass().getResourceAsStream("stage2Preview.png"))
  val stage2PreviewImageView = new ImageView(stage2PreviewImage) {
    fitWidth = 500
    fitHeight = 380
    x = 200
    y = 600
  }

  //! stage3 Section
  var stage3Bool = false
  val stage3PreviewImage = new Image(getClass().getResourceAsStream("stage3Preview.png"))
  val stage3PreviewImageView = new ImageView(stage3PreviewImage) {
    fitWidth = 500
    fitHeight = 380
    x = 200
    y = 600
  }

  //! stage4 Section
  var stage4Bool = false
  val stage4PreviewImage = new Image(getClass().getResourceAsStream("stage4Preview.png"))
  val stage4PreviewImageView = new ImageView(stage4PreviewImage) {
    fitWidth = 500
    fitHeight = 380
    x = 200
    y = 600
  }

 


  //! end


  def Start(stage: PrimaryStage,menuBar:MenuBar) {
    val scene = new Scene(1280, 1000) {

      


      fill = Color.web("#0dbfbf")

      content = ListBuffer()
      var title = new Text(550, 100, "Scala GamePack - OOP")
      title.setFont(Font.font(null, FontWeight.Bold, 20))

      val backgroundImage = new Image(getClass().getResourceAsStream("background.png"))
      val backgroundImageView = new ImageView(backgroundImage) {
        fitWidth = 1280
        fitHeight = 1000
        x = 0
        y = 0
      }
      //# start game button

      var startG = new Button("Start Game")
      startG.setFont(Font.font(null, FontWeight.Bold, 20))
      startG.layoutX = 750
      startG.layoutY = 350
      startG.setPrefWidth(200)
      startG.setPrefHeight(100)


      //# stage 1
      var tGame1 = new Text(230, 230, "Jumping map 1 :")
      tGame1.setFont(Font.font(30))

      var game1 = new Button("Stage1")
      game1.setFont(Font.font(null, FontWeight.Bold, 20))
      game1.layoutX = 470
      game1.layoutY = 200
      game1.setPrefWidth(200)
      game1.setPrefHeight(50)

      //# stage 2
      var tGame2 = new Text(230, 340, "Jumping map 2 :")
      tGame2.setFont(Font.font(30))
      var game2 = new Button("Stage2")
      game2.setFont(Font.font(null, FontWeight.Bold, 20))
      game2.layoutX = 470
      game2.layoutY = 310
      game2.setPrefWidth(200)
      game2.setPrefHeight(50)

      //# stage 3
      var tGame3 = new Text(375, 450, "Evade :")
      tGame3.setFont(Font.font(30))
      var game3 = new Button("Stage3")
      game3.setFont(Font.font(null, FontWeight.Bold, 20))
      game3.layoutX = 470
      game3.layoutY = 420
      game3.setPrefWidth(200)
      game3.setPrefHeight(50)

      //# stage 4
      var tGame4 = new Text(250, 560, "Shooting game :")
      tGame4.setFont(Font.font(30))
      var game4 = new Button("Stage4")
      game4.setFont(Font.font(null, FontWeight.Bold, 20))
      game4.layoutX = 470
      game4.layoutY = 530
      game4.setPrefWidth(200)
      game4.setPrefHeight(50)

       //! special stage
       var specialGame = new Button("Special Stage")
       specialGame.setFont(Font.font(null, FontWeight.Bold, 20))
      specialGame.layoutX = 1000
      specialGame.layoutY = 900
      specialGame.setPrefWidth(200)
      specialGame.setPrefHeight(50)

      


      

      content += backgroundImageView
      content += title
      content += game1
      content += game2
      content += game3
      content += game4
      content += tGame1
      content += tGame2
      content += tGame3
      content += tGame4
      content += startG
      content += specialGame
      content += menuBar
     

      //# actions - handle

      startG.onAction = handle {
        // musPlayer.stop()
        mainApp.sceneCounter = 1
        mainApp.stageIdentifier()
      }
      specialGame.onAction = handle {
        // musPlayer.stop()
          mainApp.sceneCounter = 6
          mainApp.stageIdentifier()
        }


      game1.onAction = handle {
        if (previewTimer > 0 && stage1Bool) {
          previewTimer = 2
          stage1Bool = false
          content -= stage1PreviewImageView
        }
        else {
          if (content.contains(stage2PreviewImageView)) {
            content -= stage2PreviewImageView
            stage2Bool = false
          }
          if (content.contains(stage3PreviewImageView)) {
            content -= stage3PreviewImageView
            stage3Bool = false
          }
          if (content.contains(stage4PreviewImageView)) {
            content -= stage4PreviewImageView
            stage4Bool = false
          }
          stage1Bool = true
        }

      }


      game2.onAction = handle {
        if (previewTimer > 0 && stage2Bool) {
          previewTimer = 2
          stage2Bool = false
          content -= stage2PreviewImageView
        }
        else {

          if (content.contains(stage1PreviewImageView)) {
            content -= stage1PreviewImageView
            stage1Bool = false
          }
          if (content.contains(stage3PreviewImageView)) {
            content -= stage3PreviewImageView
            stage3Bool = false
          }
          if (content.contains(stage4PreviewImageView)) {
            content -= stage4PreviewImageView
            stage4Bool = false
          }
          stage2Bool = true
        }

      }


      game3.onAction = handle {
        if (previewTimer > 0 && stage3Bool) {
          previewTimer = 2
          stage3Bool = false
          content -= stage3PreviewImageView
        }
        else {
          if (content.contains(stage1PreviewImageView)) {
            content -= stage1PreviewImageView
            stage1Bool = false
          }
          if (content.contains(stage2PreviewImageView)) {
            content -= stage2PreviewImageView
            stage2Bool = false
          }
          if (content.contains(stage4PreviewImageView)) {
            content -= stage4PreviewImageView
            stage4Bool = false
          }

          stage3Bool = true
        }

      }


      game4.onAction = handle {
        if (previewTimer > 0 && stage4Bool) {
          previewTimer = 2
          stage4Bool = false
          content -= stage4PreviewImageView
        }
        else {
          if (content.contains(stage1PreviewImageView)) {
            content -= stage1PreviewImageView
            stage1Bool = false
          }
          if (content.contains(stage3PreviewImageView)) {
            content -= stage3PreviewImageView
            stage3Bool = false
          }
          if (content.contains(stage2PreviewImageView)) {
            content -= stage2PreviewImageView
            stage2Bool = false
          }

          stage4Bool = true
        }

      }

      var animationTimer = AnimationTimer(t => {
        


        if (gameTimer > 0) {
          var second = (t - gameTimer) / 1e9
          //# stage 1 section
          if (stage1Bool) {
            if (!content.contains(stage1PreviewImageView)) {
              content += stage1PreviewImageView
            }
            previewTimer = previewTimer - second
          }
          if (stage1Bool && previewTimer <= 0) {
            // musPlayer.stop()
            stage1Bool = false
            content -= stage1PreviewImageView
            previewTimer = 5
          }
          //# end of stage 1 section

          //# stage 2 section

          if (stage2Bool) {
            if (!content.contains(stage2PreviewImageView)) {
              content += stage2PreviewImageView
            }
            previewTimer = previewTimer - second
          }
          if (stage2Bool && previewTimer <= 0) {
            // musPlayer.stop()
            stage2Bool = false
            content -= stage2PreviewImageView
            previewTimer = 5
          }
          //# end of stage 2 

          //# stage 3 section
          if (stage3Bool) {
            if (!content.contains(stage3PreviewImageView)) {
              content += stage3PreviewImageView
            }
            previewTimer = previewTimer - second
          }
          if (stage3Bool && previewTimer <= 0) {
            // musPlayer.stop()
            stage3Bool = false
            content -= stage3PreviewImageView
            previewTimer = 5
          }
          //# end of stage 3

          //# stage 4 section
          if (stage4Bool) {
            if (!content.contains(stage4PreviewImageView)) {
              content += stage4PreviewImageView
            }
            previewTimer = previewTimer - second
          }
          if (stage4Bool && previewTimer <= 0) {
            // musPlayer.stop()
            stage4Bool = false
            content -= stage4PreviewImageView
            previewTimer = 5

          }
          //# end of stage 4

        }
        gameTimer = t
      })
      animationTimer.start


    }
    stage.setScene(scene)

  }
}

