package com.codionics.domain

/**
  * Created by mmwaikar on 05-01-17.
  */
case class Employee(override val storeId: Long,
                    override val sId: String,
                    name: String,
                    designation: String,
                    dept: Department,
                    office: Office)
  extends StoredInfo
    with CsvWriteable {

  override def toLine(): Seq[Any] = Seq(storeId, sId, name, designation, dept.storeId, office.storeId)
}

object Employee {
  def default = Employee(0L, "", "", "", Department.default, Office.default)
}
