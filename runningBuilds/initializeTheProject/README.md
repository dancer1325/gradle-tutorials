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
          * Solution: TODO
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
