package com.milunas.model

import com.milunas.infrastructure.database.H2Config
import scala.concurrent.Future

trait BookRepository extends BookEntity with H2Config {

  this: H2Config =>
  import driver.api._

  /**
    * @return
    * Get all books
    */
  def all(): Future[List[Book]] = connectionPool.run { booksQuery.to[List].result }

  /**
    * @param book
    * create new book
    */
  def create(book: Book): Future[Int] = connectionPool.run { bookAutoInc += book }

  /**
    * @param book
    * update existing book
    */
  def update(book: Book): Future[Int] = connectionPool.run { booksQuery.filter(_.id === book.id.get).update(book) }

}
