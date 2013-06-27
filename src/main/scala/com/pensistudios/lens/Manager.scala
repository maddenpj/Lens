
package com.pensistudios.lens;

import org.lwjgl.LWJGLException
import org.lwjgl.opengl.{Display, DisplayMode, GL11}
import org.lwjgl.input.{Keyboard,Mouse}
import org.newdawn.slick.opengl.{Texture, TextureImpl,TextureLoader}
import org.newdawn.slick.openal.{Audio,AudioLoader,SoundStore}
import org.newdawn.slick.util.ResourceLoader
import scala.collections.mutable

// responsible for pairing scenes with content
object Manager {
  private var assets;
  private var scenes;

  def add(content: mutable.Map[String,Any], contentType: String) = {
    if contentType == "ASSET"
      assets = content
    else 
      if contentType == "SCENE"
        scenes = content
  }

  def join(name: String) = {
    //problem: finding a way to properly bind different asset types to one scene
    //find asset list that matches scene list
    //if none exists warning out 'NO MATCHING SCENE FOR ASSET'
    //add the Scenes reference mapped to assets to the 'scenes' variable
  }

  def play = {
    scenes.foreach( scene => scene.play )
  }

  if type intro
  apply
}
