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

public class Main{
    private static Simulateur simulateur;

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

    private static void affichageMenu(){
        System.out.println("-- Menu --");
        System.out.println("1/ Jouer");
        System.out.println("2/ Charger un fichier de description");
        System.out.println("3/ Sauver la partie actuelle");
        System.out.println("4/ Charger une partie");
        System.out.println("5/ Quitter");
    }

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

    private static void choix1(){
        System.out.println("A finir\n");
    }

    private static void choix2()throws IOException,NomDEntiteDejaUtiliseDansLeMondeException{
        Reader fichier = new FileReader("./exsimulation1.txt");
        simulateur = new Simulateur(fichier);
        System.out.println(simulateur);
        fichier.close();
        System.out.println("Chargement du fichier description - OK. \n");
    }


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


    private static void choix4()throws IOException,NomDEntiteDejaUtiliseDansLeMondeException,ClassNotFoundException{
        FileInputStream fichier = new FileInputStream("./sauvegarde.txt");
        ObjectInputStream ois = new ObjectInputStream(fichier);
        simulateur = new Simulateur(ois);
        fichier.close();
        System.out.println(simulateur);
        System.out.println("Chargement de la partie - OK. \n");
    }

}
