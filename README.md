# conseillers-models 1.0.12 (may 2020)
A Maven project to define JPA entity-beans for the Play "Conseillers" application.

How to use in a Play build.sbt file :

resolvers += "Local Maven Repository" at "file:///" + Path.userHome.absolutePath + "/.m2/repository"

libraryDependencies ++= Seq(
  javaJpa,
  "ch.jcwinfo.models" % "conseillers-models" % "1.0.12",
  ...
  )