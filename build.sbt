ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

lazy val root = (project in file("."))
  .settings(
      inThisBuild(List(
          organization := "org.bk",
          scalaVersion := "2.12.2",
          version := "0.3.0"
      )),
libraryDependencies +="org.springframework.boot" % "spring-boot-starter-web" % "3.1.0",
libraryDependencies += "org.springframework.boot" % "spring-boot-starter-data-jpa" % "3.1.0",
libraryDependencies += "org.springframework.boot" % "spring-boot-starter-actuator" % "3.1.0",
libraryDependencies += "org.springframework.boot" % "spring-boot-starter-validation" % "3.1.0",
libraryDependencies += "org.springframework.boot" % "spring-boot-starter-thymeleaf" % "3.1.0",
libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.30",
libraryDependencies += "org.thymeleaf.extras" % "thymeleaf-extras-springsecurity5" % "3.0.4.RELEASE",
//libraryDependencies += "org.thymeleaf" % "thymeleaf-spring4" % "3.1.0",
libraryDependencies += "javax.xml.bind" % "jaxb-api" % "2.3.1",
libraryDependencies += "com.sun.xml.bind" % "jaxb-impl" % "2.3.4",
libraryDependencies += "org.projectlombok" % "lombok" % "1.18.28",
//libraryDependencies += "com.h2database" % "h2" % "1.4.195",
//libraryDependencies += "org.webjars" % "bootstrap" % "3.1.1"
)
libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2"

mainClass in (Compile, run) := Some("IssApplication")
