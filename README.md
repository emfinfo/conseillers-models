# conseillers-models 1.0.15 (november 2021)
A Maven project to define JPA entity-beans for the Play "Conseillers" application.

How to use in a Play build.sbt file :

resolvers += "Local Maven Repository" at "file:///" + Path.userHome.absolutePath + "/.m2/repository"

libraryDependencies ++= Seq(
  javaJpa,
  "ch.jcsinfo.models" % "conseillers-models" % "1.0.15",
  ...
  )