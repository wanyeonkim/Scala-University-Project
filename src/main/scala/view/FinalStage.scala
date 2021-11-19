package view

import scalafx.Includes._
import scalafx.animation._
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.input.{KeyCode, KeyEvent, MouseEvent}
import scalafx.scene.paint.Color
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.paint.Color
import scalafx.scene.shape.{Circle, Rectangle, Shape}
import scalafx.scene.text._
import scala.collection.mutable.ListBuffer;
import scala.util.Random
import scalafx.scene.control.MenuBar


class FinalStage {
  var controller = new FinalStageController()
  var xpos = 30

  def finalS(stage: PrimaryStage, menuBar:MenuBar): Unit = {
    val scene: Scene = new Scene(1000, 1000) {
      fill = Color.Black

      content = new ListBuffer()
      content += controller.model.backgroundImageView
      content += controller.model.player
      content += controller.model.enemy
      content += controller.model.scoreBox
      content += controller.model.scoreText
      content += controller.model.playerImageView
      content += controller.model.playerEye1ImageView
      content += controller.model.playerEye2ImageView
      // content += controller.model.menuButton
      content += menuBar


      onKeyPressed = (e: KeyEvent) => {
        if (e.code == KeyCode.Left) controller.model.leftPressed = true
        if (e.code == KeyCode.Right) controller.model.rightPressed = true
        if (e.code == KeyCode.Space) controller.model.spacePressed = true

      }
      //# key release
      onKeyReleased = (e: KeyEvent) => {
        if (e.code == KeyCode.Left) controller.model.leftPressed = false
        if (e.code == KeyCode.Right) controller.model.rightPressed = false
        if (e.code == KeyCode.Space) controller.model.spacePressed = false

      }

      // controller.model.menuButton.onMouseClicked = (e: MouseEvent) => {
      //   mainApp.sceneCounter = 0
      //   mainApp.totalScore = 0
      //   mainApp.stageIdentifier()
      // }

      var animationTimer: AnimationTimer = AnimationTimer(t => {
        if (controller.model.gameTimer > 0) {
          controller.model.second = (t - controller.model.gameTimer) / 1e9
          controller.model.playerOldY = controller.model.player.centerY.value
          controller.model.playerOldX = controller.model.player.centerX.value

          controller.model.playerImageViewOldX = controller.model.playerImageView.x.value
          controller.model.playerImageViewOldY = controller.model.playerImageView.y.value

          controller.model.playerEye1ImageViewOldX = controller.model.playerEye1ImageView.x.value
          controller.model.playerEye1ImageViewOldY = controller.model.playerEye1ImageView.y.value

          controller.model.playerEye2ImageViewOldX = controller.model.playerEye2ImageView.x.value
          controller.model.playerEye2ImageViewOldY = controller.model.playerEye2ImageView.y.value

          //   if(controller.model.rightPressed){
          controller.model.enemyBulletTimer -= controller.model.second
          //   }
          controller.model.enemyBulletTimer2 -= controller.model.second



          //# this section is control logics
          if (controller.model.leftPressed) {
            // controller.model.player.centerX = controller.model.player.centerX.value - controller.model.playerSpeed * controller.model.second

          }

          if (controller.model.rightPressed) {
            //   controller.model.player.centerX = controller.model.player.centerX.value + controller.model.playerSpeed * controller.model.second

          }
          //# player jumping logic

          // println("jump")

          if (controller.model.spacePressed) {
            controller.model.player.centerY = controller.model.player.centerY.value - 200 * controller.model.MSecond
            controller.model.playerImageView.y = controller.model.playerImageView.y.value - 200 * controller.model.MSecond
            controller.model.playerEye1ImageView.y = controller.model.playerEye1ImageView.y.value - 200 * controller.model.MSecond
            controller.model.playerEye2ImageView.y = controller.model.playerEye2ImageView.y.value - 200 * controller.model.MSecond
            // controller.model.counter -= 1
          }
          if (!controller.model.spacePressed && controller.model.player.centerY.value <= 980) {
            controller.model.onGround = false
            controller.model.counter = 30 - controller.model.counter
            controller.model.cancelJump = true
            controller.model.player.centerY = controller.model.player.centerY.value + 200 * controller.model.MSecond
            controller.model.playerImageView.y = controller.model.playerImageView.y.value + 200 * controller.model.MSecond
            controller.model.playerEye1ImageView.y = controller.model.playerEye1ImageView.y.value + 200 * controller.model.MSecond
            controller.model.playerEye2ImageView.y = controller.model.playerEye2ImageView.y.value + 200 * controller.model.MSecond

          }
          if (controller.model.counter <= 0 && controller.model.onGround) {
            controller.model.onGround = false

            controller.model.counter = 30
            controller.model.cancelJump = true
            // println("done")
          }


          //# enemy wall
          if (controller.model.enemyBulletTimer <= 0.0) {
            // genRandom = randomValue.nextInt(300) + 20
            controller.model.enemyBulletTimer = Random.nextInt(2) + 3
            var storeRandom1 = Random.nextInt(100) + 400
            // println(controller.model.enemyBulletTimer)
            val eBullet = Rectangle(controller.model.enemy.x.value + 20, controller.model.enemy.y.value - storeRandom1 + 250, 100, storeRandom1)
            eBullet.fill = Color.White
            controller.model.enemyBullet += eBullet
            controller.model.scoreArray1 += eBullet
            for (b <- controller.model.enemyBullet) {
              if (!content.contains(b)) {
                content += b
              }
            }
          }
          if (controller.model.enemyBullet.length > 0) {
            for (pew <- controller.model.enemyBullet) {
              pew.x = pew.x.value - 100 * controller.model.second
              // println(genRandom)
              // pew.centerY = pew.centerY.value +  100* second
              if (pew.x.value <= 0) {
                // pew.x.value-player.centerX.value <= 0.0
                content -= pew
                controller.model.enemyBullet -= pew
              }
              if (controller.model.scoreArray1.length > 0) {
                for (i <- controller.model.scoreArray1) {
                  //   println(i.x.value.toString)
                  if (controller.model.player.centerX.value >= i.x.value) {
                    //   println(i.x.value.toString)
                    controller.model.score = controller.model.score + 1
                    controller.model.scoreText.setText(controller.model.score.toString)
                    controller.model.scoreArray1 -= i
                  }
                }
              }

              if (!Shape.intersect(controller.model.player, pew).boundsInLocal.value.isEmpty) {

                controller.model.enemyBullet -= pew
                // playerHpValue -= enemyDamage
                // playerBar.setText(playerHpValue.toString)
                if (controller.model.hpList.length > 0) {
                  content -= controller.model.hpList(controller.model.hpList.length - 1)
                  controller.model.hpList.remove(controller.model.hpList.length - 1)
                  // println(controller.model.hpList.length.toString)
                }
                content -= pew
                println("bonk")


              }
            }
          }

          if (controller.model.hpList.length > 0) {
            for (image <- controller.model.hpList) {
              if (!content.contains(image)) {
                // image.toFront()
                content += image
              }
            }
          }

          //! stop section
          if (controller.model.hpList.length == 0) {
            animationTimer.stop
            mainApp.totalScore = mainApp.totalScore + controller.model.score
            println("score:  " + mainApp.totalScore)
            mainApp.sceneCounter = mainApp.sceneCounter + 1
            mainApp.stageIdentifier()
          }


          //# enemy wall2
          if (controller.model.enemyBulletTimer2 <= 0.0) {
            // genRandom = randomValue.nextInt(300) + 20
            controller.model.enemyBulletTimer2 = Random.nextInt(2) + 3
            var storeRandom2 = Random.nextInt(100) + 400
            val eBullet1 = Rectangle(controller.model.enemy.x.value + 20, controller.model.enemy.y.value - (storeRandom2 * 2) + 80, 100, storeRandom2)
            eBullet1.fill = Color.White
            controller.model.enemyBullet2 += eBullet1
            controller.model.scoreArray2 += eBullet1
            for (b <- controller.model.enemyBullet2) {
              if (!content.contains(b)) {
                content += b
              }
            }
          }
          // enemyBullet(content,100,enemyBullet2)
          if (controller.model.enemyBullet2.length > 0) {
            for (pew <- controller.model.enemyBullet2) {
              pew.x = pew.x.value - 100 * controller.model.second
              // println(genRandom)
              // pew.centerY = pew.centerY.value +  100* second
              if (pew.x.value <= 50) {
                // pew.x.value-player.centerX.value <= 0.0
                content -= pew
                controller.model.enemyBullet2 -= pew
              }
              if (controller.model.scoreArray2.length > 0) {
                for (i <- controller.model.scoreArray2) {
                  if (controller.model.player.centerX.value >= i.x.value) {
                    controller.model.score = controller.model.score + 1
                    controller.model.scoreText.setText(controller.model.score.toString)
                    controller.model.scoreArray2 -= i
                  }
                }

              }

              if (!Shape.intersect(controller.model.player, pew).boundsInLocal.value.isEmpty) {

                controller.model.enemyBullet2 -= pew
                // controller.model.barSquarePlayer.setWidth(controller.model.barSquarePlayer.width.value - controller.model.enemyDamage)
                // playerHpValue -= enemyDamage
                // playerBar.setText(playerHpValue.toString)

                content -= pew

                if (controller.model.hpList.length > 0) {
                  content -= controller.model.hpList(controller.model.hpList.length - 1)
                  controller.model.hpList.remove(controller.model.hpList.length - 1)
                  // println(controller.model.hpList.length.toString)
                }

                println("bonk")
              }


            }
          }


        }
        controller.model.gameTimer = t

      })
      animationTimer.start


    }
    stage.setScene(scene)
  }

}

