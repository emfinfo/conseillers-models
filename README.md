# conseillers-models 1.0.1 (november 2016)
A Maven project to define JPA entity-beans for the Play "Conseillers" application.

Use (in an Play build.sbt file) :

resolvers += "Local Maven Repository" at "file:///" + Path.userHome.absolutePath + "/.m2/repository"

libraryDependencies ++= Seq(
  javaJpa,
  "ch.emf.info" % "conseillers-models" % "1.0.1",
  ...
  )