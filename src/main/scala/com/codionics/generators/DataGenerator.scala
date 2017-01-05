package com.codionics.generators

import com.codionics.domain.{Department, Employee, Office, OrgChart}

/**
  * Created by mmwaikar on 05-01-17.
  */
object DataGenerator {
  val ints = 1 to 10000
  val empStartId = 8
  val empEndId = ints.max + empStartId

  val orgChartStartId = empEndId + 1
  val orgChartEndId = ints.max + orgChartStartId

  val alpha = fabricator.Alphanumeric()

  def designations = Seq(
    "CEO", "CSO", "Domain Expert", "Marketing Expert", "Software Engineer",
    "Sr. Software Engineer", "Technical Architect", "Project Manager")

  def offices = Seq(
    Office(1, "1", "Georgia", "USA"),
    Office(2, "2", "Pune", "India"),
    Office(3, "3", "Bangalore", "India"))

  def departments = Seq(
    Department(1, "1", "Marketing"),
    Department(2, "2", "Finance"),
    Department(3, "3", "HR"),
    Department(4, "4", "IT"))

  def employees = generateEmployees

  def getEmployee(i: Int): Employee = {
    val desigId = alpha.randomInt(7)
    val officeId = alpha.randomInt(1, 3)
    val deptId = alpha.randomInt(4, 7)
    val empId = alpha.randomLong(empStartId, empEndId)

    val designation = designations(desigId)
    val office = getOffice(officeId, offices).getOrElse(Office.default)
    val dept = getDepartment(deptId, departments).getOrElse(Department.default)

    val contact = fabricator.Contact()
    Employee(empId, i.toString, contact.fullName(false, false), designation, dept, office)
  }

  def getReportsTo(i: Int, emps: Seq[Employee]): OrgChart = {
    val empId = alpha.randomInt(emps.size - 1)
    val mgrId = alpha.randomInt(emps.size - 1)
    //    println(s"empId: $empId, mgrId: $mgrId")
    val emp = emps(empId)
    val mgr = emps(mgrId)

    val orgChartId = alpha.randomLong(orgChartStartId, orgChartEndId)
    OrgChart(orgChartId, i.toString, emp, mgr)
  }

  def generateEmployees() = {
    ints map getEmployee
  }

  def generateOrgChart(emps: Seq[Employee]) = {
    ints.map(getReportsTo(_, emps))
  }

  def getOffice(id: Long, offices: Seq[Office]): Option[Office] = offices.find(id == _.storeId)
  def getEmployee(id: Long, employees: Seq[Employee]): Option[Employee] = employees.find(id == _.storeId)
  def getDepartment(id: Long, departments: Seq[Department]): Option[Department] = departments.find(id == _.storeId)
}
