package com.codionics.domain

/**
  * Created by mmwaikar on 05-01-17.
  */
trait CsvWriteable {
  def toLine(): Seq[Any]
}
