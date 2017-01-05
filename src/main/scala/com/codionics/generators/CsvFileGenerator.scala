package com.codionics.generators

import java.io.File

import com.codionics.domain.CsvWriteable
import com.github.tototoshi.csv.CSVWriter

/**
  * Created by mmwaikar on 05-01-17.
  */
object CsvFileGenerator {
  def generateCsvFiles(folder: String) = {
    val empsName = "emps.csv"
    val deptsName = "depts.csv"
    val officesName = "offices.csv"
    val orgChartName = "orgchart.csv"

    generateCsvFile(s"data\\${deptsName}", List("Id", "Sid", "Name"), DataGenerator.departments)
    generateCsvFile(s"data\\${officesName}", List("Id", "Sid", "City", "Country"), DataGenerator.offices)

    val employees = DataGenerator.employees
    val empHeader = List("Id", "Sid", "Name", "Designation", "Department", "Office")
    generateCsvFile(s"data\\${folder}\\${empsName}", empHeader, employees)

    val orgHeader = List("Id", "Sid", "EmpId", "ReportsTo")
    generateCsvFile(s"data\\$folder\\$orgChartName", orgHeader, DataGenerator.generateOrgChart(employees))
  }

  def generateCsvFile[T <: CsvWriteable](path: String, header: Seq[Any], data: Seq[T]) = {
    writeToCsvFile(path, header, data.map(_.toLine))
  }

  def writeToCsvFile(path: String, header: Seq[Any], ts: Seq[Seq[Any]]) = {
    val f = new File(path)
    val writer = CSVWriter.open(f)
    writer.writeRow(header)
    writer.writeAll(ts)
    writer.close()
  }
}
