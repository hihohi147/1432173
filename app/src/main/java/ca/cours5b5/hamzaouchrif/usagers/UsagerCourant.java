package ca.cours5b5.hamzaouchrif.usagers;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UsagerCourant {

    public static boolean siUsagerConnecte(){

    FirebaseUser usager = FirebaseAuth.getInstance().getCurrentUser();
    return usager != null;
    }
    public static String getId(){

        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }

}
