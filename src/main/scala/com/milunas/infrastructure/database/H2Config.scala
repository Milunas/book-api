package com.milunas.infrastructure.database

import slick.jdbc.H2Profile.api._
import slick.jdbc.H2Profile

trait H2Config {
  val connectionPool = Database.forConfig("h2")
  val driver = H2Profile
}
