package com.codionics.domain

/**
  * Created by mmwaikar on 05-01-17.
  */
case class Office(override val storeId: Long,
                  override val sId: String,
                  city: String,
                  country: String)
  extends StoredInfo
    with CsvWriteable {

  override def toLine(): Seq[Any] = Seq(storeId, sId, city, country)
}

object Office {
  def default = Office(0L, "", "", "")
}
