CLASSPATH=./classes
CLASSPATHTEST=./classestest
HAMCREST=/Users/Tom/Java/jUnit/hamcrest.jar
JUNIT=/Users/Tom/Java/jUnit/junit.jar
SOURCEPATH=./src
DOC=./doc

all: javac -Xlint:unchecked -classpath $(CLASSPATH) -sourcepath $(SOURCEPATH) -d classes find src -name *.java

test: javac -classpath $(HAMCREST):$(JUNIT):$(CLASSPATH):$(CLASSPATHTEST) -sourcepath ./testsrc -d classestest find testsrc -name *.java

doc: javadoc -encoding utf8 -docencoding utf8 -charset utf8 -d $(DOC) -sourcepath $(SOURCEPATH) find ./src -name *.java
