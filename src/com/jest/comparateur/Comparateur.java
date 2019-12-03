package com.jest.comparateur;


import com.jest.carte.Carte;
import com.jest.joueur.Joueur;

import java.util.ArrayList;

public class Comparateur {
    public void comparertrophee(ArrayList<Joueur>joueurs, ArrayList<Carte> trophees)
    {
        for (Carte trophee : trophees)
        {
            System.out.println(trophee.getTrophee());
            if (trophee.getTrophee() == "BEST_JEST")
            {
                int high_index = 0;
                int high_value = 0;

                for (int i = 0; i<joueurs.size();i++)
                {
                    if (high_value < joueurs.get(i).getScore().getJest_valeur())
                    {
                        high_index = i;
                        high_value = joueurs.get(i).getScore().getJest_valeur();
                    }
                    // deux joueurs ayant la meme note.
                    if (high_value == joueurs.get(i).getScore().getJest_valeur() && high_index!=i)
                    {
                        if (joueurs.get(i).getScore().getFace_valeur() > joueurs.get(high_index).getScore().getFace_valeur())
                        {
                            high_index = i;
                        }
                    }
                }

                joueurs.get(high_index).recupererCarte(trophee);
                System.out.println("La trophee est donnée à "+ joueurs.get(high_index).getName());
            }

            // BEST NO JOKER
            if (trophee.getTrophee() == "BEST_JEST_NO_JOKER")
            {

                int high_index = 0;
                int high_value = 0;

                for (int i=0; i< joueurs.size();i++)
                {
                    if (!joueurs.get(i).getScore().isAvecJoker())
                    {
                        if (high_value < joueurs.get(i).getScore().getJest_valeur())
                        {
                            high_index = i;
                            high_value = joueurs.get(i).getScore().getJest_valeur();
                        }
                        // deux joueurs ayant la meme note.
                        if (high_value == joueurs.get(i).getScore().getJest_valeur() && high_index!=i)
                        {
                            if (joueurs.get(i).getScore().getFace_valeur() > joueurs.get(high_index).getScore().getFace_valeur())
                            {
                                high_index = i;
                            }
                        }
                    }

                    joueurs.get(high_index).recupererCarte(trophee);
                    System.out.println("La trophee est donnée à "+ joueurs.get(high_index).getName());

                }
            }


            if (trophee.getTrophee() == "LOWEST")
            {
                int low_index = 0;
                int low_value = 30;

                for (int i = 0; i<joueurs.size();i++)
                {
                    if (low_value > joueurs.get(i).getScore().getFace_valeur())
                    {
                        low_index = i;
                        low_value = joueurs.get(i).getScore().getFace_valeur();
                    }
                }

                joueurs.get(low_index).recupererCarte(trophee);
                System.out.println("La trophee est donnée à "+ joueurs.get(low_index).getName());
            }

            if (trophee.getTrophee() == "HIGHEST")
            {
                int high_index = 0;
                int high_value = 0;

                for (int i = 0; i<joueurs.size();i++)
                {
                    if (high_value < joueurs.get(i).getScore().getFace_valeur())
                    {
                        high_index = i;
                        high_value = joueurs.get(i).getScore().getFace_valeur();
                    }
                }

                joueurs.get(high_index).recupererCarte(trophee);
                System.out.println("La trophee est donnée à "+ joueurs.get(high_index).getName());
            }


            if (trophee.getTrophee() == "JOKER")
            {
                for (Joueur joueur : joueurs)
                {
                    if (joueur.getScore().isAvecJoker()) {
                        joueur.recupererCarte(trophee);
                        System.out.println("La trophee est donnée à "+ joueur.getName());
                    }
                }
            }

            // MAJORITY

            if (trophee.getTrophee() == "4")
            {
                int most_index = 0;
                int most_value = 0;

                for (int i = 0; i<joueurs.size();i++)
                {
                    if (most_value < joueurs.get(i).getScore().getNb_4())
                    {
                        most_index = i;
                        most_value = joueurs.get(i).getScore().getNb_4();
                    }
                }

                joueurs.get(most_index).recupererCarte(trophee);
                System.out.println("La trophee est donnée à "+ joueurs.get(most_index).getName());
            }

            if (trophee.getTrophee() == "2")
            {
                int most_index = 0;
                int most_value = 0;

                for (int i = 0; i<joueurs.size();i++)
                {
                    if (most_value < joueurs.get(i).getScore().getNb_2())
                    {
                        most_index = i;
                        most_value = joueurs.get(i).getScore().getNb_2();
                    }
                }

                joueurs.get(most_index).recupererCarte(trophee);
                System.out.println("La trophee est donnée à "+ joueurs.get(most_index).getName());
            }

            if (trophee.getTrophee() == "3")
            {
                int most_index = 0;
                int most_value = 0;

                for (int i = 0; i<joueurs.size();i++)
                {
                    if (most_value < joueurs.get(i).getScore().getNb_3())
                    {
                        most_index = i;
                        most_value = joueurs.get(i).getScore().getNb_3();
                    }
                }

                joueurs.get(most_index).recupererCarte(trophee);
                System.out.println("La trophee est donnée à "+ joueurs.get(most_index).getName());
            }

        }

    }

    public ArrayList<Joueur> comparerFaceupValue(ArrayList<Joueur> joueurs)
    {
        ArrayList<Carte> faceupCartes = new ArrayList<>();
        for (Joueur joueur : joueurs)
        {
            faceupCartes.add(joueur.getCarteOffer().get(0));
        }
        Joueur j_face_max = joueurs.get(0);
        for (int i=0; i < joueurs.size();i++)
        {
            for (int j = 0;j<joueurs.size();j++)
            {
                if (joueurs.get(i).getCarteOffer().get(0).getValeur() < joueurs.get(j).getCarteOffer().get(0).getValeur())
                {
                    Joueur joueur = joueurs.get(i);
                    joueurs.set(i,joueurs.get(j));
                    joueurs.set(j,joueur);
                }
                if (joueurs.get(i).getCarteOffer().get(0).getValeur() == joueurs.get(j).getCarteOffer().get(0).getValeur()
                        && joueurs.get(i).getCarteOffer().get(0).getCouleur() < joueurs.get(j).getCarteOffer().get(0).getCouleur())
                {
                    Joueur joueur = joueurs.get(i);
                    joueurs.set(i,joueurs.get(j));
                    joueurs.set(j,joueur);
                }
            }
        }

        return joueurs;
    }
}
