package ca.cours5b5.hamzaouchrif.vues;

import android.content.Context;
import android.util.AttributeSet;

import ca.cours5b5.hamzaouchrif.R;
import ca.cours5b5.hamzaouchrif.controleurs.ControleurObservation;
import ca.cours5b5.hamzaouchrif.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.hamzaouchrif.exceptions.ErreurObservation;
import ca.cours5b5.hamzaouchrif.modeles.MParametresPartie;
import ca.cours5b5.hamzaouchrif.modeles.MPartie;
import ca.cours5b5.hamzaouchrif.modeles.MPartieReseau;
import ca.cours5b5.hamzaouchrif.modeles.Modele;


public class VPartieReseau extends VPartie {


    private VGrille grille;


    public VPartieReseau(Context context) {
        super(context);
    }

    public VPartieReseau(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VPartieReseau(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected String getNomModele(){
        return MPartieReseau.class.getSimpleName();
    }

}
