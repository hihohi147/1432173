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


    public static MParametresPartie aPartirMParametres(MParametres mParametres){
       MParametresPartie cettePartie = mParametres.parametresPartie.cloner();

        return cettePartie;

    }
    /*
     * Retourne une instance de MParametresPartie avec
     *   les mêmes paramètres partie que mParametres
     *
     *   TRUC: utiliser cloner() ci-dessous
     *
     */

    public MParametresPartie cloner(){

        MParametresPartie mParametresPartie = new MParametresPartie();

        mParametresPartie.hauteur = this.hauteur;
        mParametresPartie.largeur = this.largeur;
        mParametresPartie.pourGagner = this.pourGagner;

        return mParametresPartie;
}
    /*
     * Retourne une instance de MParametresPartie avec
     *   exactement les mêmes hauteur/largeur/pourGagner
     *   que l'objet courant
     *
     */



    public Integer getHauteur(){
return this.hauteur;
    }



    public Integer getLargeur(){
        return this.largeur;
    }


    public Integer getPourGagner(){
        return this.pourGagner;
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
