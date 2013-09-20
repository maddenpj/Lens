package com.pensistudios.lens;

import scala.math._
import util.Random

import org.lwjgl.LWJGLException
import org.lwjgl.opengl.{Display, DisplayMode, GL11}


case class Point(var x: Int, var y: Int)
case class Color(var r: Float, var g: Float, var b: Float, var a: Float)

object Color {
  val Red = Color(1.0f, 0.0f, 0.0f, 1.0f)
  val Green = Color(0.0f, 1.0f, 0.0f, 1.0f)
  val Blue = Color(0.0f, 0.0f, 1.0f, 1.0f)
}

trait Locatable {
  val pos: Point
}


object App {
  val WINDOW_BOUNDS = Point(800, 600)

  def main(args: Array[String]) {
    println( "Hello World!" )
    lwjglInit(WINDOW_BOUNDS)

    var pos = Point(100, 100)

    var lastFrame = getTime
    var T = 0

    while(!Display.isCloseRequested) {
      glClear
      val dt = (getTime - lastFrame).toInt
      lastFrame = getTime

      T += dt

      val res = 3
      for(i <- 0 to(800, res) ) {
        for(j <- 0 to(600, res) ) {
          val pos = Point(i, j)
          drawRect(pos, Point(res, res), colorSignal(pos, T))
        }
      }

      Display.update
    }
    Display.destroy
  }

  def colorYay(pos: Point, dt: Int): Color = {
    val t = dt * (1/100.0)
    var r = sin(t + 2*Pi*(pos.x/800.0)).toFloat
    var b = -sin(t + 2*Pi*(pos.y/800.0)).toFloat

    Color(r, 0.1f, b, 1.0f)
  }

  def colorSignal(pos: Point, dt: Int): Color = {
    var x = pos.x
    var y = pos.y
    if(onCircle(pos, dt)) {
      x += Random.nextInt(20) - 10
      y += Random.nextInt(20) - 10
    }
    var r = cos(dt/500.0).toFloat*sin(16*Pi*(x/800.0)).toFloat + cos(8*Pi*(y/800.0)).toFloat
    var b = -cos(dt/200.0).toFloat*sin(16*Pi*(y/600.0)).toFloat + cos(8*Pi*(x/600.0)).toFloat

    var g = cos(dt/500.0).toFloat*(r-b)

    if(onCircle(pos, dt)) {
      var colorChange = -cos(dt/600.0).toFloat
      r += colorChange
      g -= colorChange
      b -= colorChange + (Random.nextFloat - 1.0f)
    }

    Color(r, g, b, 1.0f)
  }

  def onCircle(pos: Point, dt: Int): Boolean = {
    val center = Point(WINDOW_BOUNDS.x/2, WINDOW_BOUNDS.y/2)
    /*val radius = 400*tan(dt/600.0)*/
    val radius = 200
    val threshold = 200*cos(dt/300.0)

    val r = Point(pos.x - center.x, pos.y - center.y)
    val mag = Math.sqrt(r.x*r.x + r.y*r.y)

    (mag < radius + threshold) && (mag > radius - threshold)
  }

  def colorThree(pos: Point, dt: Int): Color = {
    var rt = 16.0f*cos(dt/600.0)
    var bt = 16.0f*cos(dt/1200.0)

    var r = cos(dt/500.0).toFloat*sin(16*Pi*(pos.x/800.0)).toFloat + cos(8*Pi*(pos.y/800.0)).toFloat
    var b = -cos(dt/200.0).toFloat*sin(16*Pi*(pos.y/600.0)).toFloat + cos(8*Pi*(pos.x/600.0)).toFloat

    var g = cos(dt/500.0).toFloat*(r-b)
    /*var g = tan(dt*pos.x*pos.y/200.0).toFloat*(r-b)*/

    Color(r, g, b, 1.0f)
  }

  def colorFour(pos: Point, dt: Int): Color = {
    val x = 150.0*cos(dt/500.0)+pos.x
    val y = 150.0*sin(dt/500.0)+pos.y
    val t = 32*sin(dt/1000.0)
    var r = sin(t*Pi*(x/800.0)).toFloat
    var b = -cos(2*t*Pi*(y/800.0)).toFloat
    var d = Math.sqrt(x*x + y*y)
    var g = cos(dt/100.0).toFloat*2.0f*sin(6*t*Pi*(d/1000.0)).toFloat

    Color(r, g, b, 1.0f)
  }

  def colorMe(pos: Point): Color = {
    var r = sin(32*Pi*(pos.x/800.0)).toFloat
    var b = -sin(32*Pi*(pos.y/800.0)).toFloat

    Color(r, r-b, b, 1.0f)
  }

  def getTime(): Long = {
    System.nanoTime / 1000000
  }

  def drawRect(pos: Point, size: Point, color: Color) {
    // draw quad
    glColor(color);
    GL11.glBegin(GL11.GL_QUADS);
    GL11.glVertex2f(pos.x, pos.y)
    GL11.glVertex2f(pos.x + size.x, pos.y)
    GL11.glVertex2f(pos.x + size.x, pos.y + size.y)
    GL11.glVertex2f(pos.x, pos.y + size.y)
    GL11.glEnd
  }

  def glColor(color: Color) {
    GL11.glColor4f(color.r, color.g, color.b, color.a)
  }

  def lwjglInit(bounds: Point) {
    Display.setDisplayMode(new DisplayMode(bounds.x, bounds.y))
    Display.setTitle("Title Bar")
    Display.create
    glInit(bounds)
  }

  def glInit(bounds: Point) {
    GL11.glMatrixMode(GL11.GL_PROJECTION)
    GL11.glLoadIdentity
    GL11.glOrtho(0, bounds.x, 0, bounds.y, 1, -1)
    GL11.glMatrixMode(GL11.GL_MODELVIEW)
  }

  def glClear() {
    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT)
  }
}
