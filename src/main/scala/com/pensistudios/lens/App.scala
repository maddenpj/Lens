package com.pensistudios.lens;

import org.lwjgl.LWJGLException
import org.lwjgl.opengl.{Display, DisplayMode, GL11, GLContext}
import org.lwjgl.openal.AL
import org.lwjgl.input.{Keyboard}

object App {
  
  Manager // manager that is available everywhere

   def main(args: Array[String]) {
     _enter

      while( !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) ) { // render loop, ends on 'ESC'
        Manager.play
        Display.update
      }

     _exit
   }

   def _enter = { 
     Display.setDisplayMode(new DisplayMode(800,600) )
     Display.setTitle("Lens")

     Display.create
     
     Assets  //instantiate assets after we create display
     Scenes  //then scenes

     println( "Lens 0.0.1" )
   }

   def _exit = { 
     Display.destroy
     AL.destroy
   }
 }


