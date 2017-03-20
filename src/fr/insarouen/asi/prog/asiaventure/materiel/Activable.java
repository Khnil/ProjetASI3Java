package fr.insarouen.asi.prog.asiaventure.materiel;

import fr.insarouen.asi.prog.asiaventure.materiel.ActivationException;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;

/**
 * Interface d'activation des objets. Elle réunit les methodes permettant d'activer les objets ou les elements du décor.
 *
 * @author Tom / Constantin
 * @version 1.0
 */

public interface Activable {
    boolean activableAvec(Objet obj);

    void activer() throws ActivationException;

    void activerAvec(Objet obj) throws ActivationImpossibleAvecObjetException,ActivationImpossibleException;
}
