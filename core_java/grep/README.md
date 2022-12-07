# Introduction
(50-100 words)
Discuss the design of each app. What does the app do? What technologies have you used? (e.g. core java, libraries, lambda, IDE, docker, etc..)
The app searches for a text pattern recursively in a given directory,
and output matched lines to a file. The app takes three arguments: 
- regex: a special text string for describing a search pattern
- rootPath: root directory path
- outFile: output file name
Used Maven for building the jar, Intelliji for the IDE 

# Quick Start
How to use your apps? 

cd $Path_Repo\core_java\grep

java -cp target\$JARNAME.jar $CLASSNAME $REGEX $SRCPATH $OUTPUTPATH


#Implemenation
## Pseudocode
matchedLines = []
for file in listFilesRecursively(rootDir)
  for line in readLines(file)
      if containsPattern(line)
        matchedLines.add(line)
writeToFile(matchedLines)

## Performance Issue
(30-60 words)
Discuss the memory issue and how would you fix it
- BufferReader
- or Stream APIs
- You also need to update the grep app interface by replacing `List` with Buffer or Stream. 
(e.g. ~~`List<String>~~ readLines(File inputFile)`)

# Test
How did you test your application manually? (e.g. prepare sample data, run some test cases manually, compare result)
I build the jar in windows and linux and used a command prompt to manually call the jar file with the correct arguements 
as well as running it in the ide. I made sure to see if the output file correctly generated and used logs to see when a process
failed or succeed

# Deployment
How you dockerize your app for easier distribution?

# Improvement
List three things you can improve in this project.
The dockerization
Relative Path
The memory management