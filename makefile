JFLAGS = -g
JC = javac

.SUFFIXES: .java .class


#
# Here is our target entry for creating .class files from .java files
# This is a target entry that uses the suffix rule syntax:
#	DSTS:
#		rule
#  'TS' is the suffix of the target file, 'DS' is the suffix of the dependency
#  file, and 'rule'  is the rule for building a target
# '$*' is a built-in macro that gets the basename of the current target
# Remember that there must be a < tab > before the command line ('rule')
#

.java.class:
	$(JC) $(JFLAGS) $*.java


#
# CLASSES is a macro consisting of 4 words (one for each java source file)
#

CLASSES = \
	fr.insarouen.asi.prog.asiaventure.materiel.objets.serrurerie.Serrure.java \
	fr.insarouen.asi.prog.asiaventure.materiel.objets.serrurerie.Clef.java \
	fr.insarouen.asi.prog.asiaventure.materiel.objets.Coffre.java \
	fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet.java \
	fr.insarouen.asi.prog.asiaventure.materiel.objets.ObjetException.java \
	fr.insarouen.asi.prog.asiaventure.materiel.objets.ObjetNonDeplacable.java \
	fr.insarouen.asi.prog.asiaventure.materiel.objets.PiedDeBiche.java \
	fr.insarouen.asi.prog.asiaventure.materiel.structure.ElementStructurel.java \
	fr.insarouen.asi.prog.asiaventure.materiel.structure.ElementStructurelException.java \
	fr.insarouen.asi.prog.asiaventure.materiel.structure.ObjetAbsentDeLaPieceException.java \
	fr.insarouen.asi.prog.asiaventure.materiel.structure.Piece.java \
	fr.insarouen.asi.prog.asiaventure.materiel.structure.PieceException.java \
	Main.java


#
# the default make target entry
#

default: classes


#
# This target entry uses Suffix Replacement within a macro:
# $(name:string1=string2)
# 	In the words in the macro named 'name' replace 'string1' with 'string2'
# Below we are replacing the suffix .java of all words in the macro CLASSES
# with the .class suffix
#

classes: $(CLASSES:.java=.class)


#
# RM is a predefined macro in make (RM = rm -f)
#

clean:
	$(RM) *.class
