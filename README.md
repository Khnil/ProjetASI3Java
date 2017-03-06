# ProjetASI3Java
Projet de Java d'ASI3

compilation: javac -Xlint:unchecked -classpath ./classes -sourcepath ./src -d classes $(find src -name *.java)

doc: javadoc -encoding utf8 -docencoding utf8 -charset utf8 -d ./doc -sourcepath ./src $(find ./src -name *.java)


Mac Tom TEST COMPILATION: javac -classpath /Users/Tom/Java/jUnit/hamcrest.jar:/Users/Tom/Java/jUnit/junit.jar:./classes:./classestest -sourcepath ./testsrc -d classestest $(find testsrc -name *.java)

Mac Tom TEST EXECUTION: java -classpath /Users/Tom/Java/jUnit/hamcrest.jar:/Users/Tom/Java/jUnit/junit.jar:./classes:./classestest  org.junit.runner.JUnitCore fr.insarouen.asi.prog.asiaventure.materiel.TestEntite
