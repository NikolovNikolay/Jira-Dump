# Jira-Dump application 

Downloads all issues from Atlassian's public issue tracker for Jira, Confluence, Bitbucket, and other Atlassian products.  
Downloaded issues meet the following criterias:
  - Issue type in:
    * Bug
    * Enhancement
    * Documentation
  - Update date:
    * Start of the current week (concidered Sunday 00:00h)

## Prerequisites
[Install Java](https://www.java.com/en/download/) on your machine if it isn't installed.

## Output

Running the application will create a folder at the same place and the downloaded issues will be separated to `json|xml` folders, 
depending on user preference. If no preference is available the application will output issues in `json` format.

## Usage

1. Get the executable fat jar  
   - Go to [`/jar` directory](https://github.com/NikolovNikolay/Jira-Dump/tree/master/jar "Go to jar!") and download the executable jar. If you have 
  downloaded the source code copy the jar to a folder you like.  
   - 1.2. If you have downloaded the source code go to project root and run `.\gradlew clean build` command in terminal. It will trigger a
   Gradle build, execute tests and package an executable fat jar as an artefact in `/build/libs` project directory.
2. Run the jar
   - Double click on the jar file. This approach will start downloading Jira issues and output them in the default `json` format. This 
   approach is not recommended since the process may take time and there will be no way to interrupt it (some task manager maybe).
   - Run `java -jar .\jira-dump-1.0.0.jar xml|json` command in terminal. This will output issues in `xml` **or** `json`, not both.  
   If no argument is passed (`xml` or `json`) the application will use `json` by default. It will run until all issues are downloaded. `Ctrl + c` 
   will interrupt the execution.
