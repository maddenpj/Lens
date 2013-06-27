package com.pensistudios.lens;

import org.lwjgl.LWJGLException
import org.lwjgl.opengl.{Display, DisplayMode, GL11}
import org.lwjgl.input.{Keyboard,Mouse}
import org.newdawn.slick.opengl.{Texture, TextureImpl,TextureLoader}
import org.newdawn.slick.openal.{Audio,AudioLoader,SoundStore}
import org.newdawn.slick.util.ResourceLoader
import scala.collection.mutable

/*  Assets.scala
 *
 *  Responsible for loading content from the filesystem
 */
object Assets {

     //Load all texture groupings here 
     var intrologos = mutable.Map[String,Any]()

     //Load all assets here
     var logo = new TextureAsset("PNG","pensiLogo","Lens/assets/tex.png", intrologos)
    
     //Add texture groupings here -- Name should correspond to scene
     var allAssets = mutable.Map[String,Any]("pensiIntro" -> intrologos) 

     Manager.add(allAssets, "ASSET")
}
class TextureAsset(ext: String, name: String, path: String, list: mutable.Map[String,Any]) {
  var n = name
  var texture = TextureLoader.getTexture(ext, 
                ResourceLoader.getResourceAsStream(path))

  list += (name -> texture)
  
  _logAsset

    def _logAsset = {
        println("TexID: " + texture.getTextureID() + 
                " name: " + name + 
                " of type: " + ext + 
                " loaded on: " + list.keys) 
    }
}
class AudioAsset(ext: String, name: String, path: String) {
  var n = name 
  var audioEffect = AudioLoader.getAudio(ext, 
                ResourceLoader.getResourceAsStream(path))

}

class VideoAsset(ext: String, name: String, path: String) { //mp4, avi, video loading
  //TODO
}

class GfxAsset(ext: String, name: String, path: String) { // rendered gfx intros
  //TODO
}
