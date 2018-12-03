package ca.cours5b5.hamzaouchrif.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Map;

import ca.cours5b5.hamzaouchrif.R;
import ca.cours5b5.hamzaouchrif.controleurs.ControleurAction;
import ca.cours5b5.hamzaouchrif.donnees.Transition;
import ca.cours5b5.hamzaouchrif.global.GConstantes;
import ca.cours5b5.hamzaouchrif.modeles.MPartieReseau;
import ca.cours5b5.hamzaouchrif.serialisation.Jsonification;
import ca.cours5b5.hamzaouchrif.usagers.JoueursEnAttente;
import ca.cours5b5.hamzaouchrif.controleurs.interfaces.Fournisseur;
import ca.cours5b5.hamzaouchrif.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.hamzaouchrif.global.GCommande;
import ca.cours5b5.hamzaouchrif.usagers.UsagerCourant;

public class AEnAttenteAdversaire extends AppCompatActivity implements Fournisseur {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_en_attente_adversaire);

        JoueursEnAttente.getInstance().connecterAuServeur();

        JoueursEnAttente.getInstance().inscrireJoueurEnAttente();

        fournirActionDemarrerPartieReseau();

    }

    private void fournirActionDemarrerPartieReseau() {

        ControleurAction.fournirAction(this,
                GCommande.DEMARRER_PARTIE_RESEAU,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        Map<String, Object> objetJsonPartie = (Map<String, Object>) args[0];

                        transitionVersPartieReseau(objetJsonPartie);

                    }
                });

    }


    private void transitionVersPartieReseau(Map<String, Object> objetJsonPartie){

        String nomModele = MPartieReseau.class.getSimpleName();

        Intent intentionPartieReseau = new Intent(this, APartieReseau.class);

        Transition transition = new Transition();

        transition.sauvegarderModele(nomModele, objetJsonPartie);

        intentionPartieReseau.putExtras(transition.getBundle());

        startActivity(intentionPartieReseau);

        // XXX: on ne veut **pas** revenir à AAttendreAdversaire après la partie
        this.finish();

    }


}
