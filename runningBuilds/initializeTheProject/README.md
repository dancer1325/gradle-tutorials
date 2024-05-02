# Prerequisites
* Install Gradle  -- Check '../releases/installation'
* IDE

# How has it been created?
* `gradle`
  * test the Gradle installation
  * create the directory 'build/'
  * Problems:
    * Problem1: "This build requires JDK 11"
      * Solution1: `gradle -Dorg.gradle.ignoreBuildJavaVersionCheck=true`
      * Solution2: Adjust the environment variable 'JAVA_HOME'
    * Problem2: "org.gradle.api.InvalidUserDataException: Cannot generate project dependency accessors: Cannot generate project dependency accessors because project 'Initializing the project' doesn't follow the naming convention"
      * Solution: Rename the directory
* `mdir tutorial` & `cd tutorial` 
  * directory to use to create all
* `gradle init --type java-application  --dsl kotlin` / `gradle init --type java-application  --dsl groovy` & click enter for all
  * generate a Java application based on kotlin or groovy
    * check the structure of the project -- 'structureProjectWithGroovy.png' & 'structureProjectWithKotlin.png' -- 
      * './gradle'
        * cache directory
          * project specific
        * Problems: Why do NOT I have?
          * Solution: You need to build -- Check next section --
      * '/gradle'
        * gradle wrapper configuration
      * 'gradlew' & 'gradlew.bat'
        * scripts to execute builds -- via -- Gradle Wrapper
      * 'settings.gradle'
        * project's settings file
          * == list of subprojects
      * '/app'
        * source code + build configuration for the app
  * Problems:
    * Problem1: " 2 artifacts failed verification:"
      * Note: It's looking for dependencies of father projects in the path
      * Solution: Run this tutorial in a free location

# Invoke Gradle Wrapper
* `./gradlew build` / `.\gradlew.bat build`
  * First time that it's run -> 
    * downloads the Gradle binaries
    * caches the Gradle binaries -- Check './gradle' --
  * Generate '/app/build'

# Gradle's project structure
* Check 'gradleProjectStructure.png'
* build 
  * := bundle of related software + other builds
    * related software that you can all together
      * build
      * test
      * release
    * other builds
      * optional!!
      * _Example:_
        * libraries
        * plugins
        * build-time tools
  * == 'settings.gradle(.kts)' + rootProject + subProjects
    * rootProjects
      * 'libs.versions.toml'
        * := version catalog for dependency management
    * subProjects or modules
      * each one with its own 'build.gradle(.kts)'
* project
  * == 1! piece of your architecture
    * -- can optionally contain -- other projects
    * _Example:_
      * library
      * app
      * Gradle plugin

# build.gradle(.kts)
* := core component of the build process
  * define about the subproject
    * tasks
    * dependencies
    * plugins
  