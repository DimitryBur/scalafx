/*
 * Copyright (c) 2011-2014, ScalaFX Project
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
package scalafx.scene.control

import javafx.scene.{control => jfxsc, text => jfxst}
import javafx.{css => jfxcss, scene => jfxs}

import scala.collection.JavaConversions._
import scala.collection.mutable.Buffer
import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.beans.property.{BooleanProperty, DoubleProperty, ObjectProperty, ReadOnlyBooleanProperty, StringProperty}
import scalafx.delegate.SFXDelegate
import scalafx.scene.Node
import scalafx.scene.Node._
import scalafx.scene.text.Font.sfxFont2jfx
import scalafx.scene.text.{Font, TextAlignment}


/**
 * Object companion for [[scalafx.scene.control.PopupControl]].
 */
object Tooltip {

  /**
   * Converts a ScalaFX Tooltip to its JavaFX counterpart
   *
   * @param v ScalaFX Tooltip
   * @return JavaFX Tooltip
   */
  implicit def sfxTooltip2jfx(v: Tooltip): jfxsc.Tooltip = if (v == null) null else v.delegate


  /**
   * Generates a Simple Tooltip with default properties from a text.
   *
   * @param string Tooltip's text.
   */
  def apply(string: String) = new Tooltip {
    text = string
  }

  /**
   * Converts a String to a Simple Tooltip with default properties.
   *
   * @param string Tooltip's text.
   */
  implicit def stringToTooltip(string: String): Tooltip = Tooltip(string)

  /**
   * Just to satisfy Spec tests.
   */
  @deprecated("Use Tooltip.install(Node, Tooltip)", "2.1")
  def install(node: jfxs.Node, tooltip: jfxsc.Tooltip) {
    jfxsc.Tooltip.install(node, tooltip)
  }

  /**
   * Associates the given Tooltip with a given Node. The tooltip can then behave similar to when it is set on any Control.
   * A single tooltip can be associated with multiple nodes.
   */
  def install(node: Node, tooltip: Tooltip) {
    jfxsc.Tooltip.install(node, tooltip)
  }

  /**
   * Just to satisfy Spec tests.
   */
  @deprecated("Use Tooltip.uninstall(Node, Tooltip)", "2.1")
  def uninstall(node: jfxs.Node, tooltip: jfxsc.Tooltip) {
    jfxsc.Tooltip.uninstall(node, tooltip)
  }

  /**
   * Removes the association of the given Tooltip on a specified Node. Hence hovering on the node will no longer result in showing of the tooltip.
   */
  def uninstall(node: Node, tooltip: Tooltip) {
    jfxsc.Tooltip.uninstall(node, tooltip)
  }

  /**
   * The CssMetaData associated with this class, which may include the CssMetaData of its super
   * classes.
   *
   * @since 8.0
   */
  def classCssMetaData: Buffer[jfxcss.CssMetaData[_ <: jfxcss.Styleable, _]] =
    jfxsc.Tooltip.getClassCssMetaData()

}

/**
 * Wraps a JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Tooltip.html Tooltip]].
 *
 * @constructor Creates a new ScalaFX Tooltip from its JavaFX counterpart.
 * @param delegate JavaFX Tooltip to be wrapped. It defaul value is a new JavaFX Tooltip with no text.
 */
class Tooltip(override val delegate: jfxsc.Tooltip = new jfxsc.Tooltip)
  extends PopupControl(delegate)
  with SFXDelegate[jfxsc.Tooltip] {

  /**
   * Typically, the tooltip is "activated" when the mouse moves over a Control.
   */
  def activated: ReadOnlyBooleanProperty = delegate.activatedProperty

  /**
   * Specifies the positioning of the graphic relative to the text.
   */
  def contentDisplay: ObjectProperty[jfxsc.ContentDisplay] = delegate.contentDisplayProperty
  def contentDisplay_=(v: ContentDisplay) {
    contentDisplay() = v
  }

  /**
   * The default font to use for text in the Tooltip.
   */
  def font: ObjectProperty[jfxst.Font] = delegate.fontProperty
  def font_=(v: Font) {
    font() = v
  }

  /**
   * An optional icon for the Tooltip.
   */
  def graphic: ObjectProperty[jfxs.Node] = delegate.graphicProperty
  def graphic_=(v: Node) {
    graphic() = v
  }

  /**
   * The amount of space between the graphic and text
   */
  def graphicTextGap: DoubleProperty = delegate.graphicTextGapProperty
  def graphicTextGap_=(v: Double) {
    graphicTextGap() = v
  }

  /**
   * Specifies the behavior for lines of text when text is multiline Unlike contentDisplay which affects the graphic and text,
   * this setting only affects multiple lines of text relative to the text bounds.
   */
  def textAlignment: ObjectProperty[jfxst.TextAlignment] = delegate.textAlignmentProperty
  def textAlignment_=(v: TextAlignment) {
    textAlignment() = v
  }

  /**
   * Specifies the behavior to use if the text of the Tooltip exceeds the available space for rendering the text.
   */
  def textOverrun: ObjectProperty[jfxsc.OverrunStyle] = delegate.textOverrunProperty
  def textOverrun_=(v: OverrunStyle) {
    textOverrun() = v
  }

  /**
   * The text to display in the tooltip.
   */
  def text: StringProperty = delegate.textProperty
  def text_=(v: String) {
    text() = v
  }

  /**
   * If a run of text exceeds the width of the Tooltip, then this variable indicates whether the text should wrap onto another line.
   */
  def wrapText: BooleanProperty = delegate.wrapTextProperty
  def wrapText_=(v: Boolean) {
    wrapText() = v
  }

}