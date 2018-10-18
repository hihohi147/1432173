package ca.cours5b5.hamzaouchrif.vues;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import ca.cours5b5.hamzaouchrif.global.GCouleur;

public class VCase extends AppCompatButton {
    public VCase(Context context) {
        super(context);
    }

    public VCase(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VCase(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public VCase(Context context, int rangee, int colonne) {
        super(context);
        this.setText(rangee + " . " + colonne);
    }

    public void afficherJeton(GCouleur jeton) {
        int color = Color.LTGRAY;

        if (jeton == GCouleur.ROUGE) {
            color = Color.RED;
        } else if (jeton == GCouleur.JAUNE) {
            color = Color.YELLOW;
        }
        this.setBackgroundColor(color);

    }
}
