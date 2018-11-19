package ca.cours5b5.hamzaouchrif.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import ca.cours5b5.hamzaouchrif.R;
import ca.cours5b5.hamzaouchrif.controleurs.Action;
import ca.cours5b5.hamzaouchrif.controleurs.ControleurAction;
import ca.cours5b5.hamzaouchrif.global.GCommande;
import ca.cours5b5.hamzaouchrif.usagers.UsagerCourant;


public class VMenuPrincipal extends Vue {

    private Button boutonParametres;
    private Action actionParametres;
    private Button boutonConnexion;
    private Action actionConnexion;
    private Action actionDeconnexion;
    private Button boutonPartie;
    private Action actionPartie;

    public VMenuPrincipal(Context context) {
        super(context);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        recupererControles();

        demanderActions();

        installerListeners();

    }


    private void recupererControles() {

        boutonParametres = findViewById(R.id.bouton_parametres);

        boutonPartie = findViewById(R.id.bouton_partie);

        boutonConnexion = findViewById((R.id.bouton_connexion));

    }

    private void demanderActions() {

        actionParametres = ControleurAction.demanderAction(GCommande.OUVRIR_MENU_PARAMETRES);

        actionPartie = ControleurAction.demanderAction(GCommande.DEMARRER_PARTIE);

        actionConnexion = ControleurAction.demanderAction(GCommande.CONNEXION);

        actionDeconnexion = ControleurAction.demanderAction(GCommande.DECONNEXION);

    }


    private void installerListeners() {

        installerListenerParametres();

        installerListenerPartie();

        installerListenerConnexion();

    }

    private void installerListenerPartie() {

        boutonPartie.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionPartie.executerDesQuePossible();
            }
        });

    }

    private void installerListenerParametres() {

        boutonParametres.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionParametres.executerDesQuePossible();
            }
        });

    }

    private void installerListenerConnexion() {
        boutonConnexion.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionConnexion.executerDesQuePossible();
                if (UsagerCourant.siUsagerConnecte()) {
                    actionDeconnexion.executerDesQuePossible();
                } else if (!UsagerCourant.siUsagerConnecte()) {
                    actionConnexion.executerDesQuePossible();
                }
            }
        });
    }
}