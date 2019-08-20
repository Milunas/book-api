package com.milunas

import com.milunas.model.{Book, BookEntity}
import com.milunas.infrastructure.database.H2Config

object DBInit extends App with H2Config with BookEntity {

  import driver.api._

  val setup = DBIO.seq(
    booksQuery.schema.create,
    booksQuery += Book(None, "Harry Potter pt1"),
    booksQuery += Book(None, "Harry Potter pt2")
  )
  connectionPool.run(setup)
  connectionPool.close()

}
