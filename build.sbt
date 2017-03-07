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

version in ThisBuild := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .enablePlugins(SbtWeb)

scalaVersion in ThisBuild := "2.11.8"

scalacOptions in ThisBuild := Seq(
  "-unchecked",             // Enable additional warnings where generated code depends on assumptions
  "-deprecation",           // Emit warning and location for usages of deprecated APIs
  "-explaintypes",          // Explain type errors in more detail
  "-feature",               // Emit warning and location for usages of features that should be imported explicitly
  "-language:_",            // Enable or disable language features: '_' for all
  "-target:jvm-1.8",        // Specify which backend to use
  "-encoding", "UTF-8",     // Specify character encoding used by source files
  //  "-optimise,"               // Generates faster bytecode by applying optimisations to the program
  // ******* Advanced options *******
  "-Xcheckinit",            // Wrap field accessors to throw an exception on uninitialized access.
  "-Xlint:_",               // Enable or disable specific warnings: '_' for all
  // ******* Private options *******
  "-Yconst-opt",            // Perform optimization with constant values
  "-Ywarn-dead-code",       // Warn when dead code is identified
  "-Ywarn-inaccessible",    // Warn about inaccessible types in method signatures
  "-Ywarn-unused",          // Warn when local and private vals, vars, defs, and types are unused
  "-Ywarn-value-discard"    // Warn when non-Unit expression results are unused
)

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
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

/**
  * Resolvers
  * =========
  *
  * Add aditional repositories with dependencies not in maven central.
  *
  * resolvers += name at location
  *
  * Example:
  *
  * resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  *
  */

/** Activator needs this setting made true */
fork in run := false

/** All sbt-web asset pipeline plugins must declare their order of execution */
pipelineStages := Seq(gzip)

/******************** Extra Play Framework devSettings **********************
  *
  * You can configure extra settings for the run command in your build.sbt.
  * These settings won’t be used when you deploy your application.
  *
  */
//PlayKeys.devSettings := Seq("play.server.http.port" -> "8080")

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
