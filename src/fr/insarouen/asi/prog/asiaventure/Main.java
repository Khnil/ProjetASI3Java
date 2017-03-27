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

    }


    private static void choix3(){

    }


    private static void choix4(){

    }

}
