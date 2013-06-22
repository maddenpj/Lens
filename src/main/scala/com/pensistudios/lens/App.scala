package com.pensistudios.lens;

import org.lwjgl.LWJGLException
import org.lwjgl.opengl.{Display, DisplayMode, GL11}


 object App {
   def main(args: Array[String]) {
     println( "Hello World!" )
     Display.setDisplayMode(new DisplayMode(800,600))
     Display.setTitle("LeNs By PENSi - ScALa FunCti0nAl GeNiUSeS")
     Display.create

     GL11.glMatrixMode(GL11.GL_PROJECTION)
     GL11.glLoadIdentity
     GL11.glOrtho(0, 800, 0, 600, 1, -1)
     GL11.glMatrixMode(GL11.GL_MODELVIEW)

     while(!Display.isCloseRequested) {
       GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT)

       // set the color of the quad (R,G,B,A)
       GL11.glColor3f(0.5f,0.5f,1.0f)

       // draw quad
       GL11.glBegin(GL11.GL_QUADS);
       GL11.glVertex2f(100,100)
       GL11.glVertex2f(100+200,100)
       GL11.glVertex2f(100+200,100+200)
       GL11.glVertex2f(100,100+200)
       GL11.glEnd

       Display.update
     }
     Display.destroy
   }
 }
