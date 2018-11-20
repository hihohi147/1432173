package ca.cours5b5.hamzaouchrif.vues;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;

import ca.cours5b5.hamzaouchrif.controleurs.ControleurAction;
import ca.cours5b5.hamzaouchrif.controleurs.interfaces.Fournisseur;
import ca.cours5b5.hamzaouchrif.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.hamzaouchrif.global.GCommande;


public abstract class Vue extends ConstraintLayout implements Fournisseur {

    public Vue(Context context) {
        super(context);
    }

    public Vue(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Vue(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ControleurAction.fournirAction(this, GCommande.AFFICHER_GAGNANT, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                String message = "Joueur "+args[0]+" l'emporte!";
                Snackbar fenetreMessage = Snackbar.make(Vue.this, message, Snackbar.LENGTH_SHORT);
                fenetreMessage.show();
            }
        });
    }

}
