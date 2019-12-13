package com.jest.strategy;

import com.jest.carte.Carte;
import com.jest.joueur.Joueur;

import java.util.ArrayList;

import com.csvreader.CsvReader;


public class DonneeStrategy implements Strategy {

    private static final String FILE = "resultat.csv";
    private int [][] donnee;
    private int index;

    public DonneeStrategy()
    {
        index = 0;
        donnee = new int[100][11];
        System.out.println("Donnee Strategie");
        readDonnee();
    }

    private void readDonnee()
    {
        System.out.println("read donnee");
        try {
            CsvReader reader = new CsvReader(FILE);
            while (reader.readRecord())
            {
                if (index+1 == donnee.length)
                {
                    int newRec[][] = new int[donnee.length+100][11];
                    System.arraycopy(donnee,0,newRec,0, donnee.length);
                    donnee = newRec;
//                    System.out.println("--------------------agrandir--------------------");
                }

                String record = reader.getRawRecord();
//                System.out.println(record);
                String [] recSpt = record.split(",");
                if (Integer.parseInt(recSpt[recSpt.length-1])>=9)
                {
                    for (int i=0;i<11;i++)
                    {
//                    System.out.println("length: " + recSpt.length);
                        donnee[index][i] = Integer.parseInt(recSpt[i]);
                    }
                    index++;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Carte makeOffer(Joueur joueur, ArrayList<Carte> carteOffer) {
        System.out.println(joueur.getName() + " choit le face up carte: ");
        listerCartes(carteOffer);
        int [] counts = new int[2];
        for (int k=0;k<carteOffer.size();k++)
        {
            int count = 0;
            for(int i = 0;i<donnee.length;i++)
            {
                for (int j = 6;j<donnee[0].length-1;j++)
                {
                    if (donnee[i][j] == carteOffer.get(k).getId())
                        count++;
                }
            }
            counts[k] = count;
        }

        if (counts[0] < counts[1])      // la 2eme carte a la plus possibilite que la 1ere carte comme la carte face-up
        {
            Carte carte = carteOffer.get(0);
            carteOffer.set(0,carteOffer.get(1));
            carteOffer.set(1,carte);
        }
        joueur.addPileTest(carteOffer.get(0));    // la carte face-up
        System.out.println(joueur.getName()+" choit "+carteOffer.get(0));
        System.out.println();
        return carteOffer.get(1);       // renenvoie la carte face-down
    }


    public int takeCartes(Joueur joueur, ArrayList<Carte> cartes) {
        System.out.println(joueur.getName()+" recupere une carte");
        listerCartes(cartes);
        int []counts = new int[4];

        for (int k = 0;k<cartes.size();k++)
        {
            int count = 0;
            for (int i = 0;i< donnee.length;i++)
            {
                for (int j = 0;j<6;j++)
                {
                    if (donnee[i][j] == cartes.get(k).getId())
                    {
                        count ++;
                    }
                }
            }
            if (cartes.get(k).getJoueurId() == joueur.getId())
                count = 0;
            counts[k] = count;
        }

        int choix = 0;
        int maxCount = counts[0];
        for (int i=0;i<counts.length;i++)
        {
            if (counts[i]>maxCount)
            {
                maxCount = counts[i];
                choix = i;
            }
        }
        joueur.recupererCarte(cartes.get(choix));
        System.out.println();
        return choix;
    }

    public void listerCartes(ArrayList<Carte> cartes)       // lister tous les carte de parametre
    {
        for(int i=0;i<cartes.size();i++)
        {
            System.out.print(i+1 + " ");
            System.out.println(cartes.get(i));
        }
    }
}
