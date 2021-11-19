package view

import scalafx.Includes._
import scalafx.animation._
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.input.{KeyCode, KeyEvent, MouseEvent}
import scalafx.scene.paint.Color
import scalafx.scene.shape.{Circle, Rectangle, Shape}
import scalafx.scene.text._

import scala.collection.mutable.ListBuffer
import scalafx.scene.control.MenuBar

// import scalafx.scene.input._
// import scalafx.scene.control._
// import scalafx.scene.shape._
// import scalafx.util.Duration
// import scalafx.scene.paint.Color._
// import scalafx.geometry.Insets

//! implemented coin system that allow user to buy item
//! limited items sth like perks 
//! increase power  increase momemtn speed etc
class BossRoom {
  var bossRoomController = new BossRoomController
  var pp = 0
  var Tlist = ListBuffer[Circle]()
  var t = 0L
  Tlist += Circle(bossRoomController.model.enemy.enemy.x.value + 20, bossRoomController.model.enemy.enemy.y.value + 240, 10)
  
  def bossRoom(stage: PrimaryStage,menuBar:MenuBar) {
    val scene = new Scene(1000, 1000) {
      fill = Color.Black

      content += bossRoomController.model.backgroundImageView
      content += bossRoomController.model.player.player
      content += bossRoomController.model.enemy.enemy
      content += bossRoomController.model.player.playerHp
      content += bossRoomController.model.enemy.enemyHp
      content += bossRoomController.model.player.perkTimerDisplay
      content += bossRoomController.model.player.barSquare1Player
      content += bossRoomController.model.player.barSquarePlayer
      content += bossRoomController.model.enemy.barSquare1Enemy
      content += bossRoomController.model.enemy.barSquareEnemy
      content += bossRoomController.model.enemy.ultimateBar1
      content += bossRoomController.model.enemy.ultimateBar
      content += bossRoomController.model.player.playerShieldTimeDisplay
      content += bossRoomController.model.shieldImageView
      content += bossRoomController.model.perkDurationDisplay
      content += bossRoomController.model.perkImageView
      content += bossRoomController.model.bulletDisplay
      content += bossRoomController.model.bulletDisplayTag
      content += bossRoomController.model.avaBulletDisplay
      content += bossRoomController.model.avaBulletDisplayTag
      content += bossRoomController.model.coinBox
      content += bossRoomController.model.coinText
      content += bossRoomController.model.bulletImageView
      content += bossRoomController.model.reloadImageView
      content += bossRoomController.model.player.playerImageView
      content += bossRoomController.model.player.playerEye1ImageView
      content += bossRoomController.model.player.playerEye2ImageView
      content += bossRoomController.model.enemy.bossImageView
      content += menuBar

      
      //# key press
      onKeyPressed = (e: KeyEvent) => {
        if (e.code == KeyCode.Left) bossRoomController.model.control.leftPressed = true
        if (e.code == KeyCode.Right) bossRoomController.model.control.rightPressed = true
        if (e.code == KeyCode.Space) bossRoomController.model.control.spacePressed = true
        if (e.code == KeyCode.E) bossRoomController.model.control.shotPressed = true
        
      }
      //# key release
      onKeyReleased = (e: KeyEvent) => {
        if (e.code == KeyCode.Left) bossRoomController.model.control.leftPressed = false
        if (e.code == KeyCode.Right) bossRoomController.model.control.rightPressed = false
        if (e.code == KeyCode.Space) bossRoomController.model.control.spacePressed = false
        if (e.code == KeyCode.E) bossRoomController.model.control.shotPressed = false
        if (e.code == KeyCode.Q) bossRoomController.model.control.qPressed = false
      }
      bossRoomController.model.menuButton.onMouseClicked = (e: MouseEvent) => {
        animationTimer.stop()
        t= 0
        animationTimer.start()

      }


      var animationTimer: AnimationTimer = AnimationTimer(t => {

        if (bossRoomController.model.gameTimer > 0 ) {
          // println(t)

          bossRoomController.model.second = (t - bossRoomController.model.gameTimer) / 1e9

          //# since animationTimer doesnt stop until stop is called
          //# so saving a step back can be used for collision check.
          bossRoomController.model.player.playerOldY = bossRoomController.model.player.player.centerY.value
          bossRoomController.model.player.playerOldX = bossRoomController.model.player.player.centerX.value
          bossRoomController.model.player.playerPerkDiffX = bossRoomController.model.player.player.centerX.value - bossRoomController.model.player.perkBox.centerX.value
          bossRoomController.model.player.playerPerkDiffY = bossRoomController.model.player.player.centerY.value - bossRoomController.model.player.perkBox.centerY.value
          bossRoomController.model.player.perkBoxOldY = bossRoomController.model.player.perkBox.centerY.value
          bossRoomController.model.player.perkBoxOldX = bossRoomController.model.player.perkBox.centerX.value

          bossRoomController.model.player.playerImageViewOldX = bossRoomController.model.player.playerImageView.x.value
          bossRoomController.model.player.playerImageViewOldY = bossRoomController.model.player.playerImageView.y.value

          bossRoomController.model.player.playerEye1ImageViewOldX = bossRoomController.model.player.playerImageView.x.value
          bossRoomController.model.player.playerEye1ImageViewOldY = bossRoomController.model.player.playerImageView.y.value

          bossRoomController.model.player.playerEye2ImageViewOldX = bossRoomController.model.player.playerEye2ImageView.x.value
          bossRoomController.model.player.playerEye2ImageViewOldY = bossRoomController.model.player.playerEye2ImageView.y.value


          //# mimicing ms so it will deduct the time works as a counter
          if(bossRoomController.model.bullet.reloadTime > 0){
            bossRoomController.model.bullet.reloadTime -= bossRoomController.model.second
          }
          
          bossRoomController.model.enemy.enemyBulletTimer -= bossRoomController.model.second
          bossRoomController.model.enemy.enemyBulletTimer2 -= bossRoomController.model.second

          if (bossRoomController.model.player.perkTimer >= 0) {
            bossRoomController.model.player.perkTimer -= bossRoomController.model.second
            bossRoomController.model.player.perkTimerDisplay.setText(bossRoomController.model.player.perkTimer.toInt.toString)
          }

          if (bossRoomController.model.perkDuration >= 0) {
            bossRoomController.model.perkDuration -= bossRoomController.model.second
            bossRoomController.model.perkDurationDisplay.setText(bossRoomController.model.perkDuration.toInt.toString)
          }
          bossRoomController.model.enemy.ultimateTimer -= bossRoomController.model.second
          if (bossRoomController.model.enemy.ultimateBar.width.value >= 0) {
            bossRoomController.model.enemy.ultimateBar.setWidth(bossRoomController.model.enemy.ultimateBar.width.value - (bossRoomController.model.second * 10))
          }
          if (bossRoomController.model.perkDisappearTimer >= 0.0 && bossRoomController.model.isPerkGone) {
            bossRoomController.model.perkDisappearTimer -= bossRoomController.model.second

          }
          bossRoomController.model.bulletDisplay.setText(bossRoomController.model.bullet.bulletList.length.toString)
          bossRoomController.model.avaBulletDisplay.setText((bossRoomController.model.bullet.totalAmmoAmount - bossRoomController.model.bullet.bulletList.length).toString)

          //# cointimer reduction
          bossRoomController.model.bigCoinTimer -= bossRoomController.model.second

          //# handle
          bossRoomController.model.bulletImageView.onMousePressed = handle{
        if(bossRoomController.model.coinValue >= 20){
          bossRoomController.model.coinValue -= 20
          bossRoomController.model.bullet.totalAmmoAmount += 4
          println(bossRoomController.model.bullet.totalAmmoAmount)
          // bossRoomController.model.avaBulletDisplay.setText((bossRoomController.model.totalAmmoAmount - bossRoomController.model.bulletList.length).toString)
          bossRoomController.model.coinText.setText(bossRoomController.model.coinValue.toString)
        }
        else{
          bossRoomController.model.bulletUp = true
          var aT = t
          if(bossRoomController.model.bulletUp){
            
          }
          bossRoomController.UpgradeError(
            "Upgrade Error",
            "Ammo Upgrade",
            "You need atleast 20"
            )
            bossRoomController.model.bulletUp = false
            if(!bossRoomController.model.bulletUp){
              bossRoomController.model.gameTimer = t
            
          }
          println("no money")
        }
      }
      
      bossRoomController.model.reloadImageView.onMousePressed=handle {
        if(bossRoomController.model.coinValue >= 40){
          bossRoomController.model.coinValue -= 40
          bossRoomController.model.bullet.reloadTime = bossRoomController.model.bullet.reloadTime - 0.2
          bossRoomController.model.coinText.setText(bossRoomController.model.coinValue.toString)
        
        }
        else{
          bossRoomController.UpgradeError(
            "Upgrade Error",
            "Reload Speed Upgrade",
            "You need atleast 40"
            )
          println("no money")
          // println(bossRoomController.gg)
        }
      }
      
      
          //# this section is control logics
          if (bossRoomController.model.control.leftPressed) {
            if (bossRoomController.model.control.qPressed) {
              bossRoomController.model.player.player.centerX = bossRoomController.model.player.player.centerX.value - bossRoomController.model.player.playerSpeed * bossRoomController.model.second
              bossRoomController.model.shield.x = bossRoomController.model.shield.x.value - bossRoomController.model.player.playerSpeed * bossRoomController.model.second
              bossRoomController.model.player.playerImageView.x = bossRoomController.model.player.playerImageView.x.value - bossRoomController.model.player.playerSpeed * bossRoomController.model.second
              bossRoomController.model.player.playerEye1ImageView.x = bossRoomController.model.player.playerEye1ImageView.x.value - bossRoomController.model.player.playerSpeed * bossRoomController.model.second
              bossRoomController.model.player.playerEye2ImageView.x = bossRoomController.model.player.playerEye2ImageView.x.value - bossRoomController.model.player.playerSpeed * bossRoomController.model.second


              
            }
            else {
              bossRoomController.model.player.player.centerX = bossRoomController.model.player.player.centerX.value - bossRoomController.model.player.playerSpeed * bossRoomController.model.second
              bossRoomController.model.player.playerImageView.x = bossRoomController.model.player.playerImageView.x.value - bossRoomController.model.player.playerSpeed * bossRoomController.model.second
              bossRoomController.model.player.playerEye1ImageView.x = bossRoomController.model.player.playerEye1ImageView.x.value - bossRoomController.model.player.playerSpeed * bossRoomController.model.second
              bossRoomController.model.player.playerEye2ImageView.x = bossRoomController.model.player.playerEye2ImageView.x.value - bossRoomController.model.player.playerSpeed * bossRoomController.model.second
            }

          }

          if (bossRoomController.model.control.rightPressed) {
            if (bossRoomController.model.control.qPressed) {
              bossRoomController.model.player.player.centerX = bossRoomController.model.player.player.centerX.value + bossRoomController.model.player.playerSpeed * bossRoomController.model.second
              bossRoomController.model.shield.x = bossRoomController.model.shield.x.value + bossRoomController.model.player.playerSpeed * bossRoomController.model.second
              bossRoomController.model.player.playerImageView.x = bossRoomController.model.player.playerImageView.x.value + bossRoomController.model.player.playerSpeed * bossRoomController.model.second
              bossRoomController.model.player.playerEye1ImageView.x = bossRoomController.model.player.playerEye1ImageView.x.value + bossRoomController.model.player.playerSpeed * bossRoomController.model.second
              bossRoomController.model.player.playerEye2ImageView.x = bossRoomController.model.player.playerEye2ImageView.x.value + bossRoomController.model.player.playerSpeed * bossRoomController.model.second
            }
            else {
              bossRoomController.model.player.player.centerX = bossRoomController.model.player.player.centerX.value + bossRoomController.model.player.playerSpeed * bossRoomController.model.second
              bossRoomController.model.player.playerImageView.x = bossRoomController.model.player.playerImageView.x.value + bossRoomController.model.player.playerSpeed * bossRoomController.model.second
              bossRoomController.model.player.playerEye1ImageView.x = bossRoomController.model.player.playerEye1ImageView.x.value + bossRoomController.model.player.playerSpeed * bossRoomController.model.second
              bossRoomController.model.player.playerEye2ImageView.x = bossRoomController.model.player.playerEye2ImageView.x.value + bossRoomController.model.player.playerSpeed * bossRoomController.model.second
            }

          }

          //#player shoot
          if (bossRoomController.model.control.shotPressed || bossRoomController.model.bullet.shot) {

            bossRoomController.model.bossImageView.setImage(bossRoomController.model.bossImage)
            if (bossRoomController.model.bullet.reloadTime <= 0.0 && !bossRoomController.model.bullet.isBulletTravel) {
              bossRoomController.model.bulletSound.play()
              bossRoomController.model.bullet.isBulletTravel = true
              bossRoomController.model.bullet.shot = true
              bossRoomController.model.bullet.reloadTime =bossRoomController.model.bullet.reloadTime+ 0.5
              val p = new ImageView(bossRoomController.model.bullet.bulletImageR){
                fitWidth =30
                fitHeight = 30
                x = bossRoomController.model.player.player.centerX.value + 20
                y = bossRoomController.model.player.player.centerY.value 
              }
              bossRoomController.model.bullet.bulletImageRList += p
              for (pew <- bossRoomController.model.bullet.bulletImageRList) {
                if (!content.contains(pew)) {
                  content += pew
                }
              }
            }
            bossRoomController.model.bullet.isBulletTravel = true

            for (pew <- bossRoomController.model.bullet.bulletImageRList) {
              pew.x = pew.x.value + bossRoomController.model.bullet.bulletSpeed * bossRoomController.model.second
              if (bossRoomController.model.enemy.enemy.x.value - pew.x.value <= 0.0) {
                bossRoomController.model.bullet.bulletImageRList -= pew
                content -= pew
                bossRoomController.model.enemy.barSquareEnemy.setWidth(bossRoomController.model.enemy.barSquareEnemy.width.value - bossRoomController.model.player.playerDamage)
                bossRoomController.model.bossImageView.setImage(bossRoomController.model.bossImageDead)
                bossRoomController.model.enemy.enemy.fill = Color.web("#fff",0)
              }
            }
          }

          if (bossRoomController.model.control.shotPressed && bossRoomController.model.bullet.bulletImageRList.length < bossRoomController.model.bullet.totalAmmoAmount) {
            println("resetting")
            bossRoomController.model.bullet.isBulletTravel = false
          }

          if (bossRoomController.model.enemy.barSquareEnemy.width.value <= 0) {
            //! enemy died
             mainApp.totalScore = mainApp.totalScore +120
            
            println("enemy died")
            animationTimer.stop
            mainApp.sceneCounter = mainApp.sceneCounter + 1
            mainApp.stageIdentifier()
          }

          // enemy bullet

          //! bullet
          if (bossRoomController.model.enemy.enemyBulletTimer <= 0.0) {
            bossRoomController.model.enemy.enemyBulletTimer = 1.0
            val rBullet = new ImageView(bossRoomController.model.bullet.bulletImageL){
              fitWidth = 30
              fitHeight = 30
              x = bossRoomController.model.enemy.enemy.x.value + 20
              y = bossRoomController.model.enemy.enemy.y.value + 220
            }
            bossRoomController.model.bullet.bulletImageLList += rBullet
            for (c <- bossRoomController.model.bullet.bulletImageLList) {
              if (!content.contains(c)) {
                content += c
              }
            }
          }
          // the main bullet

          if (bossRoomController.model.bullet.bulletImageLList.length > 0) {
            for (pew <- bossRoomController.model.bullet.bulletImageLList) {
              pew.x = pew.x.value - bossRoomController.model.bullet.bulletSpeed * bossRoomController.model.second
              if (pew.x.value <= 50) {
                content -= pew
              }
              if (bossRoomController.model.shield.x.value - pew.x.value <=30 && bossRoomController.model.shield.x.value - pew.x.value >= -30 && 
              bossRoomController.model.shield.y.value -pew.y.value <=15 && bossRoomController.model.shield.y.value-pew.y.value >= -15) {
                bossRoomController.model.bullet.bulletImageLList -= pew
                content -= pew
                bossRoomController.model.control.qPressed = false
                bossRoomController.model.player.playerShieldTime = bossRoomController.model.player.playerShieldTime - 1
                bossRoomController.model.player.playerShieldTimeDisplay.setText(bossRoomController.model.player.playerShieldTime.toString)
                print("Blocked")
              }

              if (bossRoomController.model.player.player.centerX.value - pew.x.value <=30 && bossRoomController.model.player.player.centerX.value - pew.x.value >= -30 && 
              bossRoomController.model.player.player.centerY.value-pew.y.value <=15 && bossRoomController.model.player.player.centerY.value-pew.y.value >= -15) {

                bossRoomController.model.bullet.bulletImageLList -= pew
                bossRoomController.model.player.barSquarePlayer.setWidth(bossRoomController.model.player.barSquarePlayer.width.value - bossRoomController.model.enemy.enemyDamage)
                content -= pew
                println("bonk")
              }
            }
          }
         

        

          //# repeated

          if (bossRoomController.model.enemy.enemyBulletTimer2 <= 0.0) {
            // genRandom = randomValue.nextInt(300) + 20
            bossRoomController.model.enemy.enemyBulletTimer2 = 1.5
            val rBullet = new ImageView(bossRoomController.model.bullet.bulletImageL){
              fitWidth = 30
              fitHeight = 30
              x = bossRoomController.model.enemy.enemy.x.value + 20
              y = bossRoomController.model.enemy.enemy.y.value + 50
            }
            bossRoomController.model.bullet.bulletImageLList2 += rBullet
            for (c <- bossRoomController.model.bullet.bulletImageLList2) {
              if (!content.contains(c)) {
                content += c
              }
            }
                
          }

          // enemyBullet(content,100,enemyBullet2)
          if (bossRoomController.model.bullet.bulletImageLList2.length > 0) {

            for (pew <- bossRoomController.model.bullet.bulletImageLList2) {
              pew.x = pew.x.value - bossRoomController.model.bullet.bulletSpeed * bossRoomController.model.second
             
              if (pew.x.value <= 50) {
                content -= pew
              }
              if (bossRoomController.model.shield.x.value - pew.x.value <=30 && bossRoomController.model.shield.x.value - pew.x.value >= -30 && 
              bossRoomController.model.shield.y.value -pew.y.value <=15 && bossRoomController.model.shield.y.value-pew.y.value >= -15) {
                // bossRoomController.model.enemyBullet -= pew
                content -= pew
                bossRoomController.model.control.qPressed = false
                bossRoomController.model.player.playerShieldTime = bossRoomController.model.player.playerShieldTime - 1
                bossRoomController.model.player.playerShieldTimeDisplay.setText(bossRoomController.model.player.playerShieldTime.toString)
                print("Blocked")
              }

              if (bossRoomController.model.player.player.centerX.value - pew.x.value <=30 && bossRoomController.model.player.player.centerX.value - pew.x.value >= -30 && 
              bossRoomController.model.player.player.centerY.value-pew.y.value <=15 && bossRoomController.model.player.player.centerY.value-pew.y.value >= -15) {

                bossRoomController.model.bullet.bulletImageLList2 -= pew
                bossRoomController.model.player.barSquarePlayer.setWidth(bossRoomController.model.player.barSquarePlayer.width.value - bossRoomController.model.enemy.enemyDamage)
       
                content -= pew
                println("bonk")
              }
            }
          }

          if (bossRoomController.model.player.barSquarePlayer.width.value <= 0) {
            //!player die
            mainApp.totalScore = mainApp.totalScore +50

            println("player died")
            animationTimer.stop
            mainApp.sceneCounter = mainApp.sceneCounter + 1
            mainApp.stageIdentifier()

          }
          //# coin section
          if(bossRoomController.model.bigCoinTimer <= 0){
            var cImage = new ImageView(bossRoomController.model.coinImage){
              fitWidth = 30
              fitHeight = 30
              x = bossRoomController.model.player.player.centerX.value
              y = 0
            }
            bossRoomController.model.coinCollection += cImage
            bossRoomController.model.bigCoinTimer = 5.0
            for(c <- bossRoomController.model.coinCollection){
              if(!content.contains(c)){
                content += c
              }
            }
          }
          
          if(bossRoomController.model.coinCollection.length >0){
            for(c <- bossRoomController.model.coinCollection){
                var coinOldY = c.y.value
                var coinOldX = c.x.value
              // println(bossRoomController.model.player.centerX.value - c.x.value)
              // println(bossRoomController.model.player.centerY.value-c.y.value)
              c.y =c.y.value + 100 *bossRoomController.model.second
              if(bossRoomController.model.player.player.centerX.value - c.x.value <=30 && bossRoomController.model.player.player.centerX.value - c.x.value >= -30 && 
              bossRoomController.model.player.player.centerY.value-c.y.value <=15 && bossRoomController.model.player.player.centerY.value-c.y.value >= -15){
                content -= c
                bossRoomController.model.coinCollection -= c
                bossRoomController.model.coinValue += bossRoomController.model.currency
                println("glugluglu")
                bossRoomController.model.coinText.setText(bossRoomController.model.coinValue.toString)
              }
              if(c.y.value >= 970){
                c.x = coinOldX
                c.y = coinOldY
                
              
              }
            }
          }


          //! perks dropping from sky

          if (bossRoomController.model.player.perkTimer <= 0.0 && !bossRoomController.model.perkSent) {
            bossRoomController.model.player.perkBox.centerX = bossRoomController.model.player.player.centerX.value
            bossRoomController.model.player.perkBox.centerY = 0
            bossRoomController.model.perkSent = true
            content += bossRoomController.model.player.perkBox
          }

          if (bossRoomController.model.perkSent && !bossRoomController.model.isPerkBoxCollected && !bossRoomController.model.isPerkGone) {
            bossRoomController.model.player.perkBox.centerY = bossRoomController.model.player.perkBox.centerY.value + 100 * bossRoomController.model.second

          }
          // println(player.centerX.value - perkBox.centerX.value)
          // println(player.centerY.value - perkBox.centerY.value)
          // !Shape.intersect(player, perkBox).boundsInLocal.value.isEmpty
          //! collected when falling
          if ((bossRoomController.model.player.playerPerkDiffX >= -20.0 && bossRoomController.model.player.playerPerkDiffX <= 20.0) && (bossRoomController.model.player.playerPerkDiffY <= 26.0 && bossRoomController.model.player.playerPerkDiffY >= -20.0)) {
            content -= bossRoomController.model.player.perkBox
            bossRoomController.model.isPerkBoxCollected = true
            bossRoomController.model.perkSent = false
            println("collected perk")
            bossRoomController.model.player.perkTimer = 20.0
            println("more bullet for u ~~")
            bossRoomController.model.bullet.totalAmmoAmount = bossRoomController.model.bullet.totalAmmoAmount + 1
            bossRoomController.model.perkDuration = 4.0
            bossRoomController.model.player.perkBox.centerY = 0
            bossRoomController.model.player.perkBox.centerX = 0
            // perkDurationDisplay.setText(perkDuration.toInt.toString)
          }
          if (bossRoomController.model.player.perkBox.centerY.value >= 990 && !bossRoomController.model.isPerkGone) {
            bossRoomController.model.player.perkBox.centerY = bossRoomController.model.player.perkBoxOldY
            bossRoomController.model.player.perkBox.centerX = bossRoomController.model.player.perkBoxOldX
            bossRoomController.model.perkDisappearTimer = 10.0
            bossRoomController.model.isPerkGone = true
            println("poof")
          }


          //! collected from gronud

          if (bossRoomController.model.perkDisappearTimer <= 0 && bossRoomController.model.isPerkGone) {
            content -= bossRoomController.model.player.perkBox
            bossRoomController.model.isPerkBoxCollected = true
            bossRoomController.model.perkSent = false
            // println("collected perk")
            bossRoomController.model.player.perkTimer = 20.0
            println("more bullet for u ~~ YAY")
            bossRoomController.model.bullet.totalAmmoAmount = bossRoomController.model.bullet.totalAmmoAmount + 1
            bossRoomController.model.perkDuration = 4.0
            bossRoomController.model.player.perkBox.centerY = 0
            bossRoomController.model.isPerkGone = false
          }


          if (bossRoomController.model.perkDuration <= 0.0 && bossRoomController.model.isPerkBoxCollected) {
            bossRoomController.model.bullet.totalAmmoAmount = bossRoomController.model.bullet.totalAmmoAmount -1
            bossRoomController.model.isPerkBoxCollected = false

          }


          if (bossRoomController.model.enemy.ultimateTimer <= 0.0) {
            println("pew pew pew ultimate")
            bossRoomController.model.enemy.ultimateTimer = 30.0
            bossRoomController.model.enemy.ultimateBar.setWidth(300)
          }

          //! shield up 
          if (bossRoomController.model.control.qPressed && bossRoomController.model.player.playerShieldTime > 0) {
            if (!content.contains(bossRoomController.model.shield)) {
              bossRoomController.model.shield.x = bossRoomController.model.player.player.centerX.value + 30
              bossRoomController.model.shield.y = bossRoomController.model.player.player.centerY.value - 20

              bossRoomController.model.shield.fill = Color.White
              content += bossRoomController.model.shield
            }
          }
          if (!bossRoomController.model.control.qPressed) {
            if (content.contains(bossRoomController.model.shield)) {
              bossRoomController.model.shield.x = 0
              bossRoomController.model.shield.y = 0
              println("removed")
              content -= bossRoomController.model.shield
            }


          }

          // jumping simulating gravity
          if (bossRoomController.model.onGround && !bossRoomController.model.cancelJump) {
            // println("jump")
            
            if (bossRoomController.model.counter > 0 && bossRoomController.model.control.spacePressed) {
              if (bossRoomController.model.control.qPressed) {
                bossRoomController.model.control.qPressed = false
                // shield.y = shield.y.value - playerJumpHeight * MSecond
                // player.centerY = player.centerY.value - playerJumpHeight * MSecond
                // counter -= 1
              }
              else {
                bossRoomController.model.player.player.centerY = bossRoomController.model.player.player.centerY.value - bossRoomController.model.player.playerJumpHeight * bossRoomController.model.MSecond
                bossRoomController.model.player.playerImageView.y = bossRoomController.model.player.playerImageView.y.value - bossRoomController.model.player.playerJumpHeight * bossRoomController.model.MSecond
                bossRoomController.model.player.playerEye1ImageView.y = bossRoomController.model.player.playerEye1ImageView.y.value -bossRoomController.model.player.playerJumpHeight * bossRoomController.model.MSecond
                bossRoomController.model.player.playerEye2ImageView.y = bossRoomController.model.player.playerEye2ImageView.y.value - bossRoomController.model.player.playerJumpHeight * bossRoomController.model.MSecond
                bossRoomController.model.counter -= 1
                
              }

            }

            if (!bossRoomController.model.control.spacePressed) {
              
              bossRoomController.model.onGround = false
              // println("always running")
              bossRoomController.model.counter = 30 - bossRoomController.model.counter
              bossRoomController.model.cancelJump = true
            }
            if (bossRoomController.model.counter <= 0 && bossRoomController.model.onGround) {
              bossRoomController.model.onGround = false
              println("Sometime running")

              bossRoomController.model.counter = 30
              bossRoomController.model.cancelJump = true
              // println("done")
            }

          }

          // dropping again simulating gravity
          if (!bossRoomController.model.onGround && bossRoomController.model.cancelJump) {
            // this will aid with the collosion part if
            // collision happens the player circle will go out the window screen
            //

            if ((bossRoomController.model.counter > 0 && bossRoomController.model.player.player.centerY.value < 980)) {
              if (bossRoomController.model.control.qPressed) {
                bossRoomController.model.control.qPressed = false
                // player.centerY = player.centerY.value - playerJumpHeight * MSecond
                // shield.y = shield.y.value - playerJumpHeight * MSecond
                // counter -= 1
              }
              else {
                bossRoomController.model.player.player.centerY = bossRoomController.model.player.player.centerY.value + bossRoomController.model.player.playerJumpHeight * bossRoomController.model.MSecond
                bossRoomController.model.player.playerImageView.y = bossRoomController.model.player.playerImageView.y.value + bossRoomController.model.player.playerJumpHeight * bossRoomController.model.MSecond
                bossRoomController.model.player.playerEye1ImageView.y = bossRoomController.model.player.playerEye1ImageView.y.value + bossRoomController.model.player.playerJumpHeight * bossRoomController.model.MSecond
                bossRoomController.model.player.playerEye2ImageView.y = bossRoomController.model.player.playerEye2ImageView.y.value + bossRoomController.model.player.playerJumpHeight * bossRoomController.model.MSecond
                bossRoomController.model.counter -= 1
                println("droppign")
              }


            }
            else if (bossRoomController.model.counter <= 0) {
              bossRoomController.model.onGround = true
              bossRoomController.model.counter = 30
              bossRoomController.model.cancelJump = false
              // println("cancel")
            }
            else {
              // println("cancel")
              bossRoomController.model.onGround = true
              bossRoomController.model.counter = 30
              bossRoomController.model.cancelJump = false
            }
          }






          if (bossRoomController.model.player.player.centerX.value <= 20.0) {
            bossRoomController.model.player.player.centerX = bossRoomController.model.player.playerOldX
          }
          if (bossRoomController.model.player.player.centerX.value >= 980.0) {
            bossRoomController.model.player.player.centerX = bossRoomController.model.player.playerOldX
          }

        }
        bossRoomController.model.gameTimer = t

      })
      animationTimer.start

    }
    stage.setScene(scene)
  }


}

