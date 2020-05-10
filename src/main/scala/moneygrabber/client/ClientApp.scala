package moneygrabber.client

import moneygrabber.client.controller.MainMenuController
import moneygrabber.client.view.menu.MainMenu
import moneygrabber.server.ServerInfo

object ClientApp extends App {
  private val Host = if (args.length > 0) args(0) else ServerInfo.DefaultHost
  private val Port = if (args.length > 1) args(1).toInt else ServerInfo.DefaultPort
  val mainWindow = new MainMenu()
  val mainController = new MainMenuController(mainWindow, ServerInfo(Host,Port))
  mainWindow.pack()
  mainWindow.centerOnScreen()
  mainWindow.open()
}
