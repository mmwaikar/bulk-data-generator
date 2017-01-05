package com.codionics.domain

/**
  * A StoredInfo represents any object that has to be stored in a persistent
  * storage (or a database). Hence, any object that has to be stored in a
  * database should extend this class.
  */
trait StoredInfo {
  /**
    * Represents the unique id assigned by the persistent store.
    */
  def storeId: Long

  /**
    * Represents the unique id assigned by the external repository housing
    * the object (e.g. Teamcenter, Windchill etc.)
    */
  def sId: String
}
