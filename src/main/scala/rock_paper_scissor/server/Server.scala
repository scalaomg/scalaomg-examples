package rock_paper_scissor.server

import scalaomg.server.core.GameServer

import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success}


object Server extends App {

  implicit private val executor: ExecutionContext = ExecutionContext.global
  private val Host = if(args.length > 0) args(0) else "localhost"
  private val Port = if(args.length > 1) args(1).toInt else 8080

  private val gameServer = GameServer(Host, Port)

  //define room types to host matches
  gameServer defineRoom("classic", () => new ClassicMatchRoom())
  gameServer defineRoom("advanced", () => new AdvancedMatchRoom())

  gameServer.start() onComplete {
    case Success(_) => println(s"Server started at $Host:$Port")
    case Failure(exception) => println(s"Startup failed: $exception")
  }



}
