package fr.insarouen.asi.prog.asiaventure;
import java.util.Scanner;
import java.lang.System;

public class Main{
    public static void main(String[] args) throws Throwable{
        Scanner reponse = new Scanner(System.in);
        int choix;
        do {
            affichageMenu();
            choix = reponse.nextInt();
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

    private static void choixMenu(int choix){
        switch (choix) {
            case 1: choix1();
            case 2: choix2();
            case 3: choix3();
            case 4: choix4();
            case 5: break;
        }
    }

    private static void choix1(){

    }

    private static void choix2(){
        Reader fichier = new FileReader("./exsimulation1.txt");
        simulateur = new Simulateur(fichier);
        System.out.println(simulateur);
        fichier.close();
        System.out.println("Chargement du fichier description - OK. \n");
    }


    private static void choix3(){
        FileOutputStream fichier = new FileOutputStream("./sauvegarde.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fichier);
        if (simulateur = null) {
            System.out.println("Pas de partie à sauvegarder.\n");
        }
        simulateur.enregistrer(oos)
        System.out.println(simulateur);
        fichier.close();
        System.out.println("Sauvegarde de la partie - OK. \n");
    }


    private static void choix4(){
        FileInputStream fichier = new FileInputStream("./sauvegarde.txt");
        ObjectInputStream ois = new ObjectInputStream(fichier);
        simulateur = new Simulateur(ois);
        fichier.close();
        System.out.println(simulateur);
        System.out.println("Chargement de la partie - OK. \n");
    }

}
