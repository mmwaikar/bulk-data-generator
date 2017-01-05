name := """bulk-data-generator"""

version := "1.0"

scalaVersion := "2.11.7"

// Change this to another test framework if you prefer
libraryDependencies ++= Seq(
  // colored console output
  "com.lihaoyi" %% "fansi" % "0.2.3",

  // fake data generator
  "com.github.azakordonets" % "fabricator_2.11" % "2.1.3",

  // csv read-write utility
  "com.github.tototoshi" %% "scala-csv" % "1.3.4",

  // testing
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.4" % "test"
)


