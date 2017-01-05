package com.codionics.domain

/**
  * Created by mmwaikar on 05-01-17.
  */
case class OrgChart(override val storeId: Long,
                    override val sId: String,
                    employee: Employee,
                    manager: Employee)
  extends StoredInfo
    with CsvWriteable {

  override def toLine(): Seq[Any] = Seq(storeId, sId, employee.storeId, manager.storeId)
}
