package com.jest;

import com.jest.Controller.Controller;

import java.util.Scanner;

public class Jest {
    public static void main(String[] args) throws Throwable {
        int nbJoueur = 1;
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();
        String ordre = "";
        controller.initJoueur("aaa","a");
        controller.initJoueur("bbb","b");

        System.out.println("1. Creer un joue");
        System.out.println("2. Ajouter un joue");
        System.out.print("votre choix: ");
        int choix = scanner.nextInt();
        if(choix == 1)
        {
            //creer un serveur
        }
        else if(choix == 2)
        {
            //rechercher un serveur
        }

        while (nbJoueur<3)
        {
            System.out.println("1. Creer un joueur virtuel");
            System.out.println("2. Attendre un joueur");
            System.out.print("votre choix: ");
            int choixJoueur = scanner.nextInt();
            if(choixJoueur == 1)
            {
                System.out.println("get name");
                String name = scanner.nextLine();
                System.out.println("get webIp");
                String web = scanner.nextLine();
                controller.initJoueur(name,web);
            }
            else if (choixJoueur == 2)
            {

            }
        }


        while (!ordre.equals("n"))
        {
            System.out.println("Le joue commence !");
//            System.out.println("Entez l'ordre, s'il vous plait");
//            ordre = scanner.nextLine();
            System.out.println("Choisir un carte pour donner aux autres joueurs");
        }
    }
}
