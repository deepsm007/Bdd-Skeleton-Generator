BDD-Skeleton-Generator

Components of BDD (Behavior Driven Development) are

Feature file (Gherkin language)
Runner class (upon running this class, it generates methods for each steps written in feature file)
Step Definition file

This utility is use to generate runner class and step file from the provided feature file to save time and automate the process.

###################
# Running the jar #
###################

Copy the jar where all the feature files are placed or it can read from folders (can read nested folders for feature files)
Double click on the jar
It will create output folder (Containing -->  Runner class, StepDefinition class)

NOTE::

This project can be build using maven.
mvn [clean] package to clean the project & build the jar.
Logs are also generated, which will help for debugging in case of bad feature file or some error.

Hope it is useful.

THANK YOU