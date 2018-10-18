package ca.cours5b5.hamzaouchrif.controleurs;

import ca.cours5b5.hamzaouchrif.controleurs.interfaces.Fournisseur;
import ca.cours5b5.hamzaouchrif.controleurs.interfaces.ListenerFournisseur;

public class Action {
    Fournisseur fournisseur;

    ListenerFournisseur listenerFournisseur;

    Object[] args;

    public void setArguments(Object... args) {
        this.args = args;
    }

        public void executerDesQuePossible () {

            ControleurAction.executerDesQuePossible(this);
            /*
             * Appeler le contrôleur. C'est au contrôleur
             * de gérer l'action (mettre en file d'attente,
             * exécuter si possible, etc.)
             *
             */
        }
        Action cloner () {
            Action clone = new Action();

            clone.fournisseur = fournisseur;
            clone.listenerFournisseur = listenerFournisseur;

            if (args != null) {
                clone.args = args.clone();
            }

            return clone;
        }

    }

