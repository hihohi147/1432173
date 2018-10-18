package ca.cours5b5.hamzaouchrif.modeles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ca.cours5b5.hamzaouchrif.exceptions.ErreurSerialisation;
import ca.cours5b5.hamzaouchrif.global.GCouleur;

public class MGrille extends Modele {

    private List<MColonne> colonnes;

    public MGrille(int largeur){
        initialiserColonnes(largeur);
    }

    private void initialiserColonnes(int largeur){

        colonnes = new ArrayList<>();
        for (int i = 0; i<largeur; i++) {

            colonnes.add(new MColonne());
        }
    }

    public List<MColonne> getColonnes(){
        return colonnes;
    }

    public void placerJeton(int colonne, GCouleur couleur){
        this.colonnes.get(colonne).placerJeton(couleur);
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation{
        /*
         * Inutilisé
         *
         */
    }


    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation{
    return null;
        /*
         * Inutilisé
         *
         */

    }
}
