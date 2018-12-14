package ca.cours5b5.hamzaouchrif.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import ca.cours5b5.hamzaouchrif.R;
import ca.cours5b5.hamzaouchrif.controleurs.Action;
import ca.cours5b5.hamzaouchrif.controleurs.ControleurAction;
import ca.cours5b5.hamzaouchrif.global.GCommande;
import ca.cours5b5.hamzaouchrif.usagers.UsagerCourant;


public class VMenuPrincipal extends Vue {



    public VMenuPrincipal(Context context) {
        super(context);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Button boutonParametres;
    private Action actionParametres;

    private Button boutonPartie;
    private Action actionPartie;

    private Button boutonPartieReseau;
    private Action actionPartieReseau;

    private Button boutonConnexion;
    private Action actionConnexion;
    private Action actionDeconnexion;


    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();

        recupererControles();

        demanderActions();

        installerListeners();

        ajusterTexteConnexionDeconnexion();

    }


    private void recupererControles() {

        boutonParametres = findViewById(R.id.bouton_parametres);

        boutonPartie = findViewById(R.id.bouton_partie);

        boutonPartieReseau = findViewById(R.id.bouton_partie_reseau);

        boutonConnexion = findViewById(R.id.bouton_connexion);

    }

    private void demanderActions() {

        actionParametres = ControleurAction.demanderAction(GCommande.OUVRIR_MENU_PARAMETRES);

        actionPartie = ControleurAction.demanderAction(GCommande.DEMARRER_PARTIE);

        actionPartieReseau = ControleurAction.demanderAction(GCommande.JOINDRE_OU_CREER_PARTIE_RESEAU);

        actionConnexion = ControleurAction.demanderAction(GCommande.CONNEXION);

        actionDeconnexion = ControleurAction.demanderAction(GCommande.DECONNEXION);


    }


    private void installerListeners() {

        boutonParametres.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animParametres = AnimationUtils.loadAnimation(getContext(), R.anim.lefttoright);
                boutonParametres.startAnimation(animParametres);
                actionParametres.executerDesQuePossible();
            }
        });

        boutonPartie.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animPartie = AnimationUtils.loadAnimation(getContext(), R.anim.rotate);
                boutonPartie.startAnimation(animPartie);
                actionPartie.executerDesQuePossible();
            }
        });

        boutonPartieReseau.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


                if(UsagerCourant.siUsagerConnecte()){
                    boutonPartieReseau.setEnabled(true);

                    Animation animPartieR = AnimationUtils.loadAnimation(getContext(), R.anim.righttoleft);
                    boutonPartieReseau.startAnimation(animPartieR);
                    actionPartieReseau.executerDesQuePossible();

                }else{
                    boutonPartieReseau.setEnabled(false);
                    boutonPartieReseau.setText(R.string.message_connection);

                }

            }
        });

        boutonConnexion.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!UsagerCourant.siUsagerConnecte()){

                    actionConnexion.executerDesQuePossible();
                    boutonConnexion.setText(R.string.deconnexion);
                    boutonPartieReseau.setEnabled(true);
                    boutonPartieReseau.setText(R.string.jouer_enligne);

                }else{

                    actionDeconnexion.executerDesQuePossible();
                    boutonConnexion.setText(R.string.connexion);

                }

            }
        });
    }


    private void ajusterTexteConnexionDeconnexion() {
        if(UsagerCourant.siUsagerConnecte()){

            boutonConnexion.setText(R.string.deconnexion);

        }else{

            boutonConnexion.setText(R.string.connexion);

        }
    }

}
