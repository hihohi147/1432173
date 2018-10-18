package ca.cours5b5.hamzaouchrif.modeles;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.hamzaouchrif.exceptions.ErreurSerialisation;
import ca.cours5b5.hamzaouchrif.global.GConstantes;
import ca.cours5b5.hamzaouchrif.serialisation.AttributSerialisable;

public class MParametresPartie extends Modele {
    @AttributSerialisable
    public Integer hauteur;
    protected final String __hauteur = "hauteur";

    @AttributSerialisable
    public Integer largeur;
    protected final String __largeur = "largeur";

    @AttributSerialisable
    public Integer pourGagner;
    protected final String __pourGagner = "pourGagner";


    public MParametresPartie(){
        hauteur = GConstantes.HAUTEUR_PAR_DEFAUT;
        largeur = GConstantes.LARGEUR_PAR_DEFAUT;
        pourGagner = GConstantes.POUR_GAGNER_PAR_DEFAUT;


    }

    public MParametresPartie(int hauteur, int largeur, int pourGagner) {
        this.setHauteur(hauteur);
        this.setLargeur(largeur);
        this.setPourGagner(pourGagner);
    }


    public static MParametresPartie aPartirMParametres(MParametres mParametres){


        return new MParametresPartie(mParametres.getParametresPartie().getHauteur(),
               mParametres.getParametresPartie().getLargeur(),
               mParametres.getParametresPartie().getPourGagner());

    }
    /*
     * Retourne une instance de MParametresPartie avec
     *   les mêmes paramètres partie que mParametres
     *
     */

    public MParametresPartie cloner(){

        return new MParametresPartie(this.hauteur, this.largeur, this.pourGagner);
}
    /*
     * Retourne une instance de MParametresPartie avec
     *   exactement les mêmes hauteur/largeur/pourGagner
     *   que l'objet courant
     *
     */



    public Integer getHauteur(){
return hauteur;
    }



    public Integer getLargeur(){
        return largeur;
    }


    public Integer getPourGagner(){
        return pourGagner;
    }


    public void setHauteur(int hauteur){
    this.hauteur = hauteur;
}

    public void setLargeur(int largeur){
        this.largeur = largeur;
    }

    public void setPourGagner(int pourGagner){
        this.pourGagner = pourGagner;
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation{
        for(Map.Entry<String, Object> entry : objetJson.entrySet()){

            String chaineValeur = (String) entry.getValue();

            switch (entry.getKey()){

                case __hauteur:

                    hauteur = Integer.valueOf(chaineValeur);
                    break;

                case __largeur:

                    largeur = Integer.valueOf(chaineValeur);
                    break;


                case __pourGagner:

                    largeur = Integer.valueOf(chaineValeur);
                    break;

                default:

                    throw new ErreurSerialisation("Attribut inconnu: " + entry.getKey());
            }
        }

}

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation{
        Map<String, Object> objetJson = new HashMap<>();

        objetJson.put(__hauteur, hauteur.toString());
        objetJson.put(__largeur, largeur.toString());
        objetJson.put(__pourGagner, pourGagner.toString());

        return objetJson;
}
}
