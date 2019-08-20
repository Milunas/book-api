name := "book-app"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.5.24"
libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.1.3"
libraryDependencies += "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.9"
libraryDependencies += "com.typesafe.slick" %% "slick" % "3.2.0"
libraryDependencies += "com.typesafe.slick" %% "slick-hikaricp" % "3.2.0"
libraryDependencies += "com.h2database" % "h2" % "1.4.187"
libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.6.4"
