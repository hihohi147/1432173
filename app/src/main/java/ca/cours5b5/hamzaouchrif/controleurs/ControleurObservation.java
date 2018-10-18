package ca.cours5b5.hamzaouchrif.controleurs;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.hamzaouchrif.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.hamzaouchrif.modeles.MParametres;
import ca.cours5b5.hamzaouchrif.modeles.MPartie;
import ca.cours5b5.hamzaouchrif.modeles.Modele;

public class ControleurObservation {

    private static Map<Modele, ListenerObservateur> observations;

    private static MPartie partie;

    static {
        observations = new HashMap<>();
        Log.d("Atelier06", ControleurObservation.class.getSimpleName() + "::observerModele");
    }

    public static void observerModele(String nomModele, final ListenerObservateur listenerObservateur){



        if(nomModele.equals(MParametres.class.getSimpleName())){
            observations.put(MParametres.instance,listenerObservateur);
            lancerObservation(MParametres.instance);

        }else if(nomModele.equals(MPartie.class.getSimpleName())){
            observations.put(ControleurObservation.partie, listenerObservateur);
            lancerObservation(ControleurObservation.partie);


        }

    }


        /*
         * Enregistrer le listener dans le Map observations
         * Appeler le listener une première fois
         *
         * Pour l'instant, utiliser le nom pour décider quel modèle utiliser
         *     - MParametres.instance ou ControleurObservation.partie
         *
         * BONUS: pourquoi le modèle est identifié par son nom? (et pas son objet comme dans le Map?)
         *Pour pouvoir le comparer avec le nom de la classe qui est un String
         */






        public static void lancerObservation(Modele modele){
            ListenerObservateur listener = observations.get(modele);

            if(listener != null){
                listener.reagirChangementAuModele(modele);
            }
        }
    /*
     * Vérifier si le listener existe pour ce modele
     * Appeler le listener
     *
     */



}
