package com.pensistudios.lens;

import org.lwjgl.LWJGLException
import org.lwjgl.opengl.{Display, DisplayMode, GL11}


class Scenes {
  def _init() = {

  }
  
  //def newScene
  //
  // better way to do this ( new Scene ) for scene object, pass it a type 
  // create sensible defaults OR somethign

  def displayScene(sceneType: Int) = {
      printf("disply scene")
  }
      //implementation of type of scene goes here
      // loadMenu, syncSound, etc
      // switch case can take care of what type is handled how

  //def loadMenu(menuFont: Font, menuOptions: Array ) = {
      
  //}

  //TODO def syncMenu(sound:)

  //TODO def loadCredits()

  //TODO def syncCredits()
}
