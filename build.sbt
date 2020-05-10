name := "scalaomg-examples"

version := "0.1"

scalaVersion := "2.12.10"

libraryDependencies ++= Seq(
  "com.github.scalaomg" % "scala-omg" % "1.0.1",
  "org.scala-lang.modules" %% "scala-swing" % "2.1.1")

libraryDependencies ++= Seq(
  "it.unibo.alice.tuprolog" % "tuprolog" % "3.1",
  "org.scalafx" %% "scalafx" % "12.0.2-R18")

// Determine OS version of JavaFX binaries
lazy val osName = System.getProperty("os.name") match {
  case n if n.startsWith("Linux") => "linux"
  case n if n.startsWith("Mac") => "mac"
  case n if n.startsWith("Windows") => "win"
  case _ => throw new Exception("Unknown platform!")
}

// Add dependency on JavaFX libraries, OS dependent
lazy val javaFXModules = Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
libraryDependencies ++= javaFXModules.map(m =>
  "org.openjfx" % s"javafx-$m" % "12.0.2" classifier osName)
