package com.milunas.routing

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.model.StatusCodes._
import com.milunas.model.{Book, BookMarshaller, BookRepository}

trait BookRoutes extends BookRepository with BookMarshaller {

  val api = "api"
  val version = "v1"
  val service = "books"

  protected val bookRoute: Route = path(api / version / service) {
    get {
      complete(OK, all())
    } ~
    post {
      entity(as[Book]) {
        book => create(book)
        complete(Created)
      }
    } ~
    put {
      entity(as[Book]) {
        book => update(book)
        complete(NoContent)
      }
    }
  }

  val routes: Route = bookRoute
}
