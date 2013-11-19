import AssemblyKeys._ 

name := "parrot-server"

scalaVersion := "2.10.2"

resolvers += "spray repo" at "http://repo.spray.io"

libraryDependencies ++= Seq(
	"com.typesafe.akka" %% "akka-actor" % "2.2.3",
	"io.spray" % "spray-can" % "1.2-RC3"
)

assemblySettings
