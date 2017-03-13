package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.materiel.objets.SuiteObjets;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.SuiteStructure;
import fr.insarouen.asi.prog.asiaventure.materiel.vivants.SuiteVivants;
import fr.insarouen.asi.prog.asiaventure.materiel.SuiteElements;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.serrurerie.SuiteSerrurerie;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  SuiteObjets.class,
  SuiteStructure.class,
  SuiteVivants.class,
  SuiteElements.class,
  SuiteSerrurerie.class,
  SuiteASIAventure.class
})

public class AllTests {

}
