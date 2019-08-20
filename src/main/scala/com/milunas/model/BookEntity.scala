package com.milunas.model

import com.milunas.infrastructure.database.H2Config

trait BookEntity {

  this: H2Config =>
  import driver.api._

  class BookEntity(tag: Tag) extends Table[Book](tag, "books") {
    def id: Rep[Int] = column[Int]("id", O.PrimaryKey, O.AutoInc)
    def title: Rep[String] = column[String]("title")
    def * = (id.?, title) <> (Book.tupled, Book.unapply)
  }

  val booksQuery = TableQuery[BookEntity]

  def bookAutoInc = booksQuery returning booksQuery.map(_.id)

}