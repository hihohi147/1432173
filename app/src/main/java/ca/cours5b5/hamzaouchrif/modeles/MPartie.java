package ca.cours5b5.hamzaouchrif.modeles;

import java.util.Map;

import ca.cours5b5.hamzaouchrif.controleurs.ControleurAction;
import ca.cours5b5.hamzaouchrif.controleurs.interfaces.Fournisseur;
import ca.cours5b5.hamzaouchrif.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.hamzaouchrif.exceptions.ErreurSerialisation;
import ca.cours5b5.hamzaouchrif.global.GCommande;
import ca.cours5b5.hamzaouchrif.global.GCouleur;
import ca.cours5b5.hamzaouchrif.serialisation.AttributSerialisable;

public class MPartie extends Modele implements Fournisseur {

    @AttributSerialisable
    public MParametresPartie parametres;
    private final String __parametres = "parametres";
    private MGrille grille;
    private GCouleur couleur;

    public MPartie(MParametresPartie parametres) {
this.parametres = parametres;
        this.grille = new MGrille(parametres.getLargeur());
        fournirActionPlacerJeton();
        initialiserCouleurCourante();
    }

    private void fournirActionPlacerJeton() {
        ControleurAction.fournirAction(this, GCommande.JOUER_COUP_ICI, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                jouerCoup((int) args[0]);
            }
        });
    }

    private void initialiserCouleurCourante() {
        couleur = GCouleur.JAUNE;
    }

    private void prochaineCouleurCourante() {
        if (couleur == GCouleur.ROUGE) {
            couleur = GCouleur.JAUNE;
        } else if (couleur == GCouleur.JAUNE) {
            couleur = GCouleur.ROUGE;
        }
    }

    protected void jouerCoup(int colonne) {
        this.grille.placerJeton(colonne, couleur);
        prochaineCouleurCourante();
    }

    public MGrille getGrille() {
        return this.grille;
    }

    public MParametresPartie getParametres() {

        return this.parametres;
    }


    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation {

        return null;
    }
}
