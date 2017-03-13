package fr.insarouen.asi.prog.asiaventure.materiel;

import fr.insarouen.asi.prog.asiaventure.materiel.ActivationException;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;

public interface Activable {
    boolean activableAvec(Objet obj);

    void activer() throws ActivationException;

    void activerAvec(Objet obj);
}
