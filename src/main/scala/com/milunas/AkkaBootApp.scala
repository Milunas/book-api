package com.milunas

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.Http.ServerBinding
import akka.stream.ActorMaterializer
import com.milunas.routing.BookRoutes
import com.typesafe.config.ConfigFactory

import scala.concurrent.ExecutionContextExecutor
import scala.util.{Failure, Success}

object AkkaBootApp extends App with BookRoutes {

  implicit val system: ActorSystem = ActorSystem()
  implicit val mat: ActorMaterializer = ActorMaterializer()

  implicit val ec: ExecutionContextExecutor = system.dispatcher

  system.registerOnTermination(connectionPool.close())

  val config = ConfigFactory.load()
  val host = config.getString("http.host")
  val port = config.getInt("http.port")

  val binding = Http().bindAndHandle(routes, host, port)

  binding.onComplete {
    case Success(serverBinding: ServerBinding) => println(s"Listening to ${serverBinding.localAddress}")
    case Failure(exception) => println(s"error: ${exception.getMessage}")
  }

}
