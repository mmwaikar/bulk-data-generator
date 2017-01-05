package com.codionics.domain

/**
  * Created by mmwaikar on 05-01-17.
  */
case class Department(override val storeId: Long,
                      override val sId: String,
                      name: String)
  extends StoredInfo
    with CsvWriteable {

  override def toLine(): Seq[Any] = Seq(storeId, sId, name)
}

object Department {
  def default = Department(0L, "", "")
}
