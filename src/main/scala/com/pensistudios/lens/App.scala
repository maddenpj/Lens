package com.pensistudios.lens;

import org.lwjgl.LWJGLException
import org.lwjgl.opengl.{Display, DisplayMode, GL11}
import com.pensistudios.lens.Scenes;


object App {
   def main(args: Array[String]) {
     println( "Lens 0.0.1" )
     var scene1 = new Scenes();
     Display.setDisplayMode(new DisplayMode(800,600) )
     Display.setTitle("Lens")
     Display.create
    
     scene1.displayScene(1)
    // Opening credits
    // run() kicks off the game, and credits
     //  displayPiece(type: 'credit'|'cutscene', audio)
     //       be able to display some graphics in terms of itself
     //  displayMenu(type: 'ingame'|'opening', audio)
     //       be able to display options, input selectable, with graphics
     //  


     while(Display.isActive) {


       Display.update
     }

     Display.destroy
   }
 }


