package com.milunas.model

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

trait BookMarshaller extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val bookFormat: RootJsonFormat[Book] = jsonFormat2(Book)
}
