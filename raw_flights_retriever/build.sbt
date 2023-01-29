ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

libraryDependencies += "org.apache.httpcomponents.client5" % "httpclient5" % "5.2"
libraryDependencies += "com.googlecode.json-simple" % "json-simple" % "1.1"
libraryDependencies += "org.apache.kafka" % "kafka-clients" % "3.3.2"
libraryDependencies += "com.google.code.gson" % "gson" % "2.8.9"





lazy val root = (project in file("."))
  .settings(
    name := "raw_flights_retriever",
    idePackagePrefix := Some("com.epicwasa")
  )
