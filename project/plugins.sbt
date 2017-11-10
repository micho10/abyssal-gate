// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.6.7")


/* ********** web plugins ********** */

//// A CoffeeScript plugin for sbt
//addSbtPlugin("com.typesafe.sbt" % "sbt-coffeescript"  % "1.0.1")
//
//addSbtPlugin("com.typesafe.sbt" % "sbt-less"          % "1.1.2")
//
//// Allows jslint to be used from within sbt. Builds on com.typesafe:webdriver in order to execute jslint.js along with the scripts to verify
//addSbtPlugin("com.typesafe.sbt" % "sbt-jshint"        % "1.0.5")
//
//// RequireJs support for sbt-web
//addSbtPlugin("com.typesafe.sbt" % "sbt-rjs"           % "1.0.9")
//
//// sbt-web plugin for adding checksum files for web assets. Checksums are useful for asset fingerprinting and etag values
//addSbtPlugin("com.typesafe.sbt" % "sbt-digest"        % "1.1.3")
//
//// sbt mocha support
//addSbtPlugin("com.typesafe.sbt" % "sbt-mocha"         % "1.1.2")

addSbtPlugin("org.irundaia.sbt" % "sbt-sassify"       % "1.4.9")

// sbt plugin for gzipping web assets
addSbtPlugin("com.typesafe.sbt" % "sbt-gzip"          % "1.0.2")
