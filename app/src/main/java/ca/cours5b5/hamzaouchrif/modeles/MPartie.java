package ca.cours5b5.hamzaouchrif.modeles;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.hamzaouchrif.exceptions.ErreurSerialisation;
import ca.cours5b5.hamzaouchrif.serialisation.AttributSerialisable;

public class MPartie extends Modele {

    @AttributSerialisable
    public MParametresPartie parametres;
    private final String __parametres = "parametres";


    public MPartie(MParametresPartie parametres) {
this.parametres = parametres;
    }

    public MParametresPartie getParametres() {

        return this.parametres;
    }


    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation {

        Map<String, Object> objetJson = new HashMap<>();

        objetJson.put(__parametres, parametres.toString());


        return objetJson;
    }
}
