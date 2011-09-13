/*
 * Copyright (c) 2011, ScalaFX Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the ScalaFX Project nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package scalafx.scene.shape

import javafx.scene.paint.Paint
import scalafx.scene.Node
import scalafx.beans.property.{ObjectProperty, DoubleProperty}

class Rectangle extends Node {
  val rectangle = new javafx.scene.shape.Rectangle()
  override val node = rectangle

  lazy val _xProperty = new DoubleProperty(rectangle.xProperty())
  def x = _xProperty
  def x_=(v:Double) {
    x() = v
  }

  lazy val _yProperty = new DoubleProperty(rectangle.yProperty())
  def y = _yProperty
  def y_=(v:Double) {
    y() = v
  }

  lazy val _widthProperty = new DoubleProperty(rectangle.widthProperty())
  def width = _widthProperty
  def width_=(v:Double) {
    width() = v
  }

  lazy val _heightProperty = new DoubleProperty(rectangle.heightProperty())
  def height = _heightProperty
  def height_=(v:Double) {
    height() = v
  }

  lazy val _fillProperty = new ObjectProperty[Paint](rectangle.fillProperty())
  def fill = _fillProperty
  def fill_=(v: Paint) {
    fill() = v
  }
}
