package com.pensistudios.lens;

import org.lwjgl.LWJGLException
import org.lwjgl.opengl.{Display, DisplayMode, GL11}
import org.lwjgl.input.{Keyboard,Mouse}
import org.newdawn.slick.opengl.{Texture, TextureImpl,TextureLoader}
import org.newdawn.slick.openal.{Audio,AudioLoader,SoundStore}
import org.newdawn.slick.util.ResourceLoader
import scala.collections.mutable

// responsible for setting up duration, position, display of content
object Scenes {

  def _init() = {
  
  }
  
  
  def  play = {
      // play a scene code
  }

  def kill = {
    // terminate a scene code
    // do if the right button is pressed
  }

  var pensiIntro = new VideoScene('intro', 'pensiIntro', 4000)

  //var allScenes = mutable.Map[String,Any]("pensiIntro" -> pensiIntro) 
  //Manager.add(allScenes, "SCENE")

}
/*  Render a scene based off input content
 *  
 *  @param content Texture or Video object
 *  @param contentType ex. GIF, PNG, MP4
 */
class VideoScene(sceneType: String, sceneName: String, maxDuration: Int) {
  
  Manager.join(sceneType, sceneName, maxDuration)
  
  def _displayScene = {
      //openGL stuff
  }

  def playContentType(content: TextureAsset, contentType: String, d: Int) = {
    //TODO
    //var X, var Y
    //if music , play music
    //if image render; else if video render; else if gfx render

      //place image content in center of screen
      //if music play that as well
      //if video content place in center but handle appropriate
      //if music play that as well
      //if graphics then place in center and handle appropriate
      //if music play that as well
  }

  def play = {
      var sceneTimer = 0
      var sceneActive = !Keyboard.isKeyDown(Keyboard.KEY_RETURN) || (sceneTimer <= maxDuration)

      while( sceneActive ) {
        _displayScene

        sceneTimer++ // how to do a timer properly? this will go too fast

      }

      //cleanup
      return true
  }

  //add scene specific behaviors here
  //move right, zoom left, flicker, etc.
  
  //should we take in a text file with defined behaviors and then
  //execute them here? ie load 'pensiIntro.behave' and execute
}

/*  Render a menu scene with input choices, graphics and music
 *  
 *  @param content Texture or Video object
 *  @param contentType ex. GIF, PNG, MP4
 */
class MenuScene(content: TextureAsset, contentType: String) {
  //TODO selectable menu items and layering of items
  //def loadMenu(menuFont: Font, menuOptions: Array ) = {
}
