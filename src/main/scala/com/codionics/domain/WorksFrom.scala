package com.codionics.domain

/**
  * Created by mmwaikar on 05-01-17.
  */
case class WorksFrom(
                      override val storeId: Long,
                      override val sId: String,
                      employee: Employee)
  extends StoredInfo
    with CsvWriteable {
  override def toLine(): Seq[Any] = Seq(storeId, sId, employee.storeId, employee.office.storeId)
}
