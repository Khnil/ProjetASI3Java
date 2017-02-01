# ProjetASI3Java
Projet de Java d'ASI3

compilation: javac -Xlint:unchecked -classpath ./classes -sourcepath ./src -d classes $(find src -name *.java)

doc: javadoc -encoding utf8 -docencoding utf8 -charset utf8 -d ./doc -sourcepath ./src $(find ./src -name *.java)
