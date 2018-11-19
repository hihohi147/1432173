package ca.cours5b5.hamzaouchrif.donnees;

import android.os.Bundle;

import java.util.Map;

import ca.cours5b5.hamzaouchrif.exceptions.ErreurModele;
import ca.cours5b5.hamzaouchrif.serialisation.Jsonification;

public class SauvegardeTemporaire extends SourceDeDonnees {

    private Bundle bundle;

    public SauvegardeTemporaire(Bundle bundle){
        this.bundle = bundle;
    }

    @Override
    public void chargerModele(final String cheminSauvegarde, final ListenerChargement listenerChargement) {

        String cle = getCle(cheminSauvegarde);
        if(bundle != null && bundle.containsKey(cle)){
            String json = bundle.getString(cle);

            Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);
            listenerChargement.reagirSucces(objetJson);

        }else{

            listenerChargement.reagirErreur(new Exception());
        }
    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson) {

        String cle = getCle(cheminSauvegarde);

        if(bundle != null){

            String json = Jsonification.enChaineJson(objetJson);
            bundle.putString(cle, json);

        }
    }
    public void detruireSauvegarde(String cheminSauvegarde) {

        if(bundle != null){

            bundle.clear();
        }

    }

    private String getCle(String cheminSauvegarde) {
        return getNomModele(cheminSauvegarde);
    }

}