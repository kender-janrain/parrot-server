import AssemblyKeys._ 

name := "parrot-server"

scalaVersion := "2.10.2"

libraryDependencies ++= Seq(
	"com.typesafe.akka" %% "akka-actor" % "2.2.0",
	"io.spray" % "spray-can" % "1.2-20130710"
)

assemblySettings
