package fr.insarouen.asi.prog.asiaventure;
import java.util.Scanner;
import java.lang.System;
import java.lang.String;
import fr.insarouen.asi.prog.asiaventure.Simulateur;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.Reader;
import java.io.IOException;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import java.lang.ClassNotFoundException;

/**
 * Classe Main.<br>
 * Cette classe sert à lancer le jeu ASIAventure2K17deluxeEditionChristmasSpecial <br>
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class Main{
    private static Simulateur simulateur;

    /**
     * Il s'agit de le fonction main qui a pour but d'afficher le menu d'action, enregistrer ce que le joueur shouaite faire et l'effectuer. Cette fonction boucle jusqu'à ce que l'utilisateur demande de sortir.
     * @param args
     *        paramètre par défaut
     *
     *  @throws Throwable
     *          propage Throwable
     */
    public static void main(String[] args) throws Throwable{
        Scanner reponse = new Scanner(System.in);
        int choix=0;
        do {
            affichageMenu();
            choix = reponse.nextInt();
            System.out.println(choix);
            choixMenu(choix);
        } while (choix!=5);
    }

    /**
     * Cette méthode sert simplement à afficher le menu. Il s'agit d'une suite de println.
     *
     */
    private static void affichageMenu(){
        System.out.println("-- Menu --");
        System.out.println("1/ Jouer");
        System.out.println("2/ Charger un fichier de description");
        System.out.println("3/ Sauver la partie actuelle");
        System.out.println("4/ Charger une partie");
        System.out.println("5/ Quitter");
    }

    /**
     * Cette méthode est un caseof appelant les différentes fonctions du menu en fonction de ce que l'utilisateur a entré comme demande.
     *
     * @param choix
     *          Le choix entré par l'utilisateur sous forme d'integer.
     *
     * @throws Throwable.
     *          Renvoie toutes les erreurs possibles.
     */
    private static void choixMenu(int choix)throws Throwable{
        switch (choix) {
            case 1: System.out.println("Jouer\n");
                    choix1();
                    break;
            case 2: System.out.println("Charger un fichier de description\n");
                    choix2();
                    break;
            case 3: System.out.println("Sauver la partie actuelle\n");
                    choix3();
                    break;
            case 4: System.out.println("Charger une partie\n");
                    choix4();
                    break;
            case 5: break;
        }
    }

    /**
     * Cette méthode renvoie au choix "Jouer" Celle ci reste encore à définir.
     *
     */
    private static void choix1(){
        String choix = "oui";
        do {
            try {
                simulateur.executerUnTour();
            } catch(ASIAventureException e) {
                System.err.println(e.getMessage());
            }
            if (simulateur.getEtatDuJeu()==EtatDuJeu.ENCOURS) {
                System.out.println("\n Souhaitez-vous rejouer ? (oui ou non)");
            Scanner scan = new Scanner(System.in);
            choix = scan.nextLine();
            }
        } while (choix.equals("oui")&&simulateur.getEtatDuJeu()==EtatDuJeu.ENCOURS);

        String resultat = (simulateur.getEtatDuJeu()==EtatDuJeu.SUCCES) ? "Vous avez gagne":"Vous avez perdu";
        System.out.println(String.format("Impossible de jouer, la partie est finie. %s",resultatPartie));
    }

    /**
     * Cette méthode renvoie au choix "Charger un fichier de description". Celle ci va créer un nouveau simulateur à l'aide du fichier renseigné. Ainsi les informations du fichier seront entrées dans le jeu et le monde sera mis en place.
     * Une fois le fichier chargé, la fonction ferme le fichier ouvert.
     *
     * @throws IOException
     *          Renvoie toute erreur relative à un flux d'entrée d'objets. (IOS)
     * @throws NomDEntiteDejaUtiliseDansLeMondeException
     *          Renvoie toute erreur relative à un objet créé dont le nom existerait déjà dans le monde où celui-ci est créé.
     *
     */
    private static void choix2()throws IOException,NomDEntiteDejaUtiliseDansLeMondeException{
        Reader fichier = new FileReader("./exsimulation1.txt");
        simulateur = new Simulateur(fichier);
        System.out.println(simulateur);
        fichier.close();
        System.out.println("Chargement du fichier description - OK. \n");
    }

    /**
     * Cette méthode renvoie au choix "Sauver la partie actuelle". Pour ce faire la méthode créée un nouveau fichier de sauvegarde et entre dedans l'état actuel de la partie sous une forme lisible par le Simulateur.
     *
     * @throws IOException
     *          Renvoie toute erreur relative à un flux d'entrée d'objets. (IOS)
     *
     */
    private static void choix3()throws IOException{
        FileOutputStream fichier = new FileOutputStream("./sauvegarde.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fichier);
        if (simulateur == null) {
            System.out.println("Pas de partie à sauvegarder.\n");
        }
        simulateur.enregistrer(oos);
        System.out.println(simulateur);
        fichier.close();
        System.out.println("Sauvegarde de la partie - OK. \n");
    }

    /**
     * Cette méthode renvoie au choix "Charger une partie". Celle ci va créer un nouveau simulateur à l'aide d'un fichier de sauvegarde.
     * Une fois le fichier chargé, la fonction ferme le fichier ouvert.
     *
     * @throws IOException
     *          Renvoie toute erreur relative à un flux d'entrée d'objets. (IOS)
     * @throws NomDEntiteDejaUtiliseDansLeMondeException
     *          Renvoie toute erreur relative à un objet créé dont le nom existerait déjà dans le monde où celui-ci est créé.
     * @throws ClassNotFoundException
     *          Renvoie toute erreur relative à une tentative d'utilisation de classe non existante.
     *
     */
    private static void choix4()throws IOException,NomDEntiteDejaUtiliseDansLeMondeException,ClassNotFoundException{
        FileInputStream fichier = new FileInputStream("./sauvegarde.txt");
        ObjectInputStream ois = new ObjectInputStream(fichier);
        simulateur = new Simulateur(ois);
        fichier.close();
        System.out.println(simulateur);
        System.out.println("Chargement de la partie - OK. \n");
    }

}
