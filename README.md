# conseillers-models 1.0.6 (february 2018)
A Maven project to define JPA entity-beans for the Play "Conseillers" application.

* New in release 1.3.0 (february 2018) :
  * New timestamp field for login

library and the method AesUtil.encrypt(data)

How to use in a Play build.sbt file :

resolvers += "Local Maven Repository" at "file:///" + Path.userHome.absolutePath + "/.m2/repository"

libraryDependencies ++= Seq(
  javaJpa,
  "ch.emf.info" % "conseillers-models" % "1.0.6",
  ...
  )