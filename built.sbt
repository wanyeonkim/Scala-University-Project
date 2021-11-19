name := "finalproject"

version := "1.0"



// https://mvnrepository.com/artifact/org.scalafx/scalafx

libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.192-R14"

// https://mvnrepository.com/artifact/org.scalafx/scalafxml-core-sfx8

libraryDependencies += "org.scalafx" %% "scalafxml-core-sfx8" % "0.5"

libraryDependencies +=  "org.scalaj" %% "scalaj-http" % "2.4.2"

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)



fork := true