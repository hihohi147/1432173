package ca.cours5b5.hamzaouchrif.controleurs;

import ca.cours5b5.hamzaouchrif.global.GCommande;
import ca.cours5b5.hamzaouchrif.global.GCouleur;

public final class ControleurPartie {
    private ControleurPartie(){}

    private static final ControleurPartie instance = new ControleurPartie();
    public static ControleurPartie getInstance(){ return instance;}

    public void gagnerPartie(GCouleur couleurGagnante){

        Action actionGagner = ControleurAction.demanderAction(GCommande.AFFICHER_GAGNANT);
        actionGagner.setArguments(couleurGagnante);
        actionGagner.executerDesQuePossible();
    }
}
