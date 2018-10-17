package ca.cours5b5.hamzaouchrif.modeles;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.hamzaouchrif.exceptions.ErreurSerialisation;
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

    public MParametresPartie(MParametres parametres) {
this.hauteur = parametres.getHauteur();
this.largeur = parametres.getLargeur();
this.pourGagner = parametres.getPourGagner();
    }

    public MParametresPartie(Integer vHauteur, Integer vLargeur, Integer vPourGagner){
this.hauteur = vHauteur;
this.largeur = vLargeur;
this.pourGagner = vPourGagner;

    }


    public static MParametresPartie aPartirMParametres(MParametres mParametres){
       MParametresPartie cettePartie = new MParametresPartie();
       cettePartie.setHauteur(mParametres.getHauteur());
       cettePartie.setLargeur(mParametres.getLargeur());
       cettePartie.setPourGagner(mParametres.getPourGagner());



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

        MParametresPartie cettePartie = new MParametresPartie(this.getHauteur(), this.getLargeur(),
                this.getPourGagner());

        return cettePartie;
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
