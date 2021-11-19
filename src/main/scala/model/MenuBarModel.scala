package model
import scalafx.scene.control.{MenuBar, Menu, MenuItem}
import scalafx.scene.layout.HBox
import scalafx.Includes._

import view.mainApp

class MenuBarModel {
  var checkMusicStatus = true

  var menu1 = new Menu("Option")
  var menu1Item = new MenuItem("Back To Main")

  

  
  
  
  var menu1Item2 = new MenuItem("Mute")

  menu1Item2.onAction = handle {
      if(checkMusicStatus){
          mainApp.musPlayer.stop()
          checkMusicStatus = false
          menu1Item2.text = "Play"
      }
      else if(!checkMusicStatus){
          mainApp.musPlayer.play()
          checkMusicStatus = true
           menu1Item2.text = "Mute"
      }
  }
  
  menu1.getItems.add(menu1Item2)
  var menuBar = new MenuBar()
  menuBar.getMenus().add(menu1)

  menu1.onShowing = handle {
    println("ddd")
    if(mainApp.sceneCounter == 6){
      if(!menu1.items.contains(menu1Item)){
        menu1.getItems().add(menu1Item)
        println("adding")
      }
    menu1Item.onAction = handle {
        mainApp.sceneCounter = 0
        mainApp.totalScore = 0
        mainApp.stageIdentifier()
      }
    }
    else {
      menu1.getItems().remove(menu1Item)
    }
  }
}