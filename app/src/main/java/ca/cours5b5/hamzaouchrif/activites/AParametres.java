package ca.cours5b5.hamzaouchrif.activites;


import android.os.Bundle;

import ca.cours5b5.hamzaouchrif.R;
import ca.cours5b5.hamzaouchrif.controleurs.ControleurAction;
import ca.cours5b5.hamzaouchrif.controleurs.ControleurModeles;
import ca.cours5b5.hamzaouchrif.controleurs.interfaces.Fournisseur;
import ca.cours5b5.hamzaouchrif.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.hamzaouchrif.donnees.Disque;
import ca.cours5b5.hamzaouchrif.donnees.Serveur;
import ca.cours5b5.hamzaouchrif.global.GCommande;
import ca.cours5b5.hamzaouchrif.modeles.MParametres;
import ca.cours5b5.hamzaouchrif.modeles.MPartie;


public class AParametres extends Activite implements Fournisseur{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        fournirActions();

    }

    private void fournirActions(){
        fournirActionDetruire();
    }

    private void fournirActionDetruire(){
        ControleurAction.fournirAction(this, GCommande.DETRUIRE, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                recommencerPartie();
            }
        });
    }

    private void recommencerPartie(){
        Disque.getInstance().detruireSauvegarde(MPartie.class.getSimpleName());
        Serveur.getInstance().detruireSauvegarde(MPartie.class.getSimpleName());
        ControleurModeles.detruireModele(MPartie.class.getSimpleName());
    }

    @Override
    protected void onPause() {
        super.onPause();

        ControleurModeles.sauvegarderModele(MParametres.class.getSimpleName());

    }


}
