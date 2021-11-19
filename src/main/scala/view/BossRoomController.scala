package view
import scalafx.scene.control.Alert
import scalafx.scene.control.Alert.AlertType
import scala.collection.mutable.ListBuffer
import scalafx.scene.shape.{Circle, Rectangle, Shape}
import scalafx.scene.paint.Color

import model.BossRoomModel

class BossRoomController {
    var model = new BossRoomModel()
    // var gg = false

    def UpgradeError(t:String,hT:String,cT:String){
     new Alert(AlertType.Information) {
     title = t
     headerText = hT
     contentText = cT
   }.showAndWait()
    
  }
}