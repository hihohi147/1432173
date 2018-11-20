package ca.cours5b5.hamzaouchrif.donnees;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

import ca.cours5b5.hamzaouchrif.exceptions.ErreurModele;

public final class Serveur extends SourceDeDonnees {

    private static final Serveur instance = new Serveur();

    private Serveur(){}


    public static Serveur getInstance(){

        return instance;
    }


    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson){
        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);
        noeud.setValue(objetJson);

    }
    /*
     * Sauvegarder sur le serveur
     *
     * Utiliser FirebaseDatabase et DatabaseReference
     *
     */


    @Override
    public void chargerModele(String cheminSauvegarde,final ListenerChargement listenerChargement){

        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);

        noeud.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    Map<String, Object> objetJson = (Map<String, Object>) dataSnapshot.getValue();

                    listenerChargement.reagirSucces(objetJson);
                } else {
                    listenerChargement.reagirErreur(new ErreurModele("Aucune donnée"));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                listenerChargement.reagirErreur(new ErreurModele(databaseError.getMessage()));
            }
        });
    }






    /*
     * BONUS: est-ce possible d'implanter cette méthode avec cette signature?
     */

    @Override
    public void detruireSauvegarde(String cheminSauvegarde){


        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);
        noeud.removeValue();

    }
    /*
     * BONUS
     */



}
