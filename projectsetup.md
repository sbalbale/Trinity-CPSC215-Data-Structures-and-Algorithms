
# Create a new project:

Open your Command Prompt (Windows)/Terminal (Mac). Navigate to the folder you're organizing all your projects in using the following command:
```
cd [path to your folder]
```
cd stands for "Change Directory". This command will navigate your terminal over to the specified path. Any commands you run that create files will organize the files into the specified directory. 

Paste and run the following command in your command line (Command Prompt for Windows, Terminal for Mac):
```
mvn archetype:generate -DarchetypeArtifactId=homework-quickstart -DarchetypeGroupId=org.atp-fivt -DarchetypeVersion=1.09 -Djavaversion=23
```

When prompted, enter the following:
```
groupId: edu.trincoll
artifactId (aka the name of this project): lab01
version: press Enter (default value '1.0-SNAPSHOT' is ok) 
package: press Enter (default value 'edu.trincoll' is ok)
```

### Using JUnit 5 Tests: 
If you want to use JUnit 5 tests, make sure that your test files are in the `src/test/java` directory.

# Exporting a Project:

Use the export maven plugin by adding the following to your pom.xml file:
```
<plugin>
    <groupId>org.atp-fivt</groupId>
    <artifactId>export-maven-plugin</artifactId>
    <version>1.0</version>
    <configuration>
        <zipFileName>${project.artifactId}.zip</zipFileName>
    </configuration>
</plugin>
```

Then, run the following command in your command line:
```
mvn export:export
```
The command will create a zip file in the target directory of your project. This zip file contains all the files in your project.
