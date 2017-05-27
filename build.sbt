name := """play-todo"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean, SbtWeb)

scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "mysql" % "mysql-connector-java" % "5.1.40",
  "org.webjars.npm" % "bootstrap" % "3.3.7",
  "com.adrianhurt" %% "play-bootstrap" % "1.1-P25-B3",
  "org.webjars.npm" % "jquery" % "3.2.1",
  "org.webjars.npm" % "vue" % "2.3.0",
  "org.webjars.npm" % "vue-resource" % "1.3.1"
)

playEbeanModels in Compile := Seq("models.*")

fork in run := false