import CompilerFlags._

/**
  * Scoped Keys:
  *
  *   <code>{<build-uri>}<project-id>/config:intask::key</code>
  *
  *   - {<build-uri>}/<project-id>  identifies the project axis
  *       (the <project-id> part will be missing if the project axis has “entire build” scope)
  *   - config                      identifies the configuration axis.
  *   - intask                      identifies the task axis.
  *   - key                         identifies the key being scoped.
  */
name := """abyssal-gate"""
organization := "org.nekosoft"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.3"

scalacOptions := compilerFlags
scalacOptions in (Compile, console) ~= (_.filterNot(Set(
  "-Ywarn-unused:imports",
  "-Xfatal-warnings"
)))

/**
  * libraryDependencies += groupID % artifactID % revision % configuration
  *
  * Using this pattern:
  *
  * libraryDependencies += groupID %% artifactID % revision % configuration
  *
  * sbt will add the project's Scala version to the artifact name. It's just a shortcut.
  * These 2 declarations are identical (assuming scalaVersion is 2.11.1):
  *
  *   libraryDependencies += "org.scala-tools" %  "scala-stm_2.11.1"  % "0.3"
  *   libraryDependencies += "org.scala-tools" %% "scala-stm"         % "0.3"
  *
  * Revision options:
  *   - latest.integration    selects the latest revision of the dependency module
  *   - latest.[any status]   selects the latest revision of the dependency module with at least the specified status
  *   - xxx+                  selects the latest sub-revision of the dependency module
  *   - version ranges        mathematical notation for ranges
  *     * [1.0, 2.0]            matches all versions >= 1.0 and <= 2.0
  *     * [1.0, 2.0[            matches all versions >= 1.0 and < 2.0
  *     * ]1.0, 2.0]            matches all versions > 1.0 and <= 2.0
  *     * ]1.0, 2.0[            matches all versions > 1.0 and < 2.0
  *     * [1.0,)                matches all versions >= 1.0
  *     * ]1.0,)                matches all versions > 1.0
  *     * (,2.0]                matches all versions <= 2.0
  *     * (,2.0[                matches all versions < 2.0
  *
  */
libraryDependencies ++= Seq(
  guice,
  openId,
  "org.scalatestplus.play" %% "scalatestplus-play"              % "3.1.1" % Test,
  "com.typesafe.play"      %% "play-json"                       % "2.6.4",
  "com.typesafe.play"      %% "play-iteratees"                  % "2.6.1",
  "com.typesafe.play"      %% "play-iteratees-reactive-streams" % "2.6.1"
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "org.nekosoft.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "org.nekosoft.binders._"

/**
  * By default (since 2.5.0), Play will generate a router that will declare all the controllers that it routes to
  * as dependencies, allowing the controllers to be dependency injected themselves.
  *
  * When using the injected routes generator, prefixing the action with an @ symbol means a Provider of the controller
  * will be injected, instead of the controller being injected directly. This allows, for example,
  * prototype controllers, as well as an option for breaking cyclic dependencies.
  *
  */
// Enable the injected routes generator (Recommended).
routesGenerator := InjectedRoutesGenerator

// Enable the static routes generator
//routesGenerator := StaticRoutesGenerator

/******************** Extra Play Framework devSettings **********************
  *
  * You can configure extra settings for the run command in your build.sbt.
  * These settings won’t be used when you deploy your application.
  *
  */
//PlayKeys.devSettings := Seq("play.server.http.port" -> "8080")

