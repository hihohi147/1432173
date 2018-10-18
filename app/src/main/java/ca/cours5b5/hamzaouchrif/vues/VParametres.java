package ca.cours5b5.hamzaouchrif.vues;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import ca.cours5b5.hamzaouchrif.R;
import ca.cours5b5.hamzaouchrif.modeles.MParametres;


public class VParametres extends Vue implements AdapterView.OnItemSelectedListener {

    static{

        Log.d("Atelier04", VParametres.class.getSimpleName() + "::static");

    }
    private ArrayAdapter<Integer> adapterHauteur;
    private ArrayAdapter<Integer> adapterLargeur;
    private ArrayAdapter<Integer> adapterPourGagner;
    private Spinner spinnerHauteur;
    private Spinner spinnerLargeur;
    private Spinner spinnerPourGagner;

    public VParametres(android.content.Context context) {
        super(context);
    }

    public VParametres(android.content.Context context, android.util.AttributeSet attrs) {
        super(context, attrs);
    }

    public VParametres(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        spinnerHauteur = this.findViewById(R.id.spinner_hauteur);
        spinnerLargeur = this.findViewById(R.id.spinner_largeur);
        spinnerPourGagner = this.findViewById(R.id.spinner_pourGagner);

        spinnerHauteur.setOnItemSelectedListener(this);
        spinnerLargeur.setOnItemSelectedListener(this);
        spinnerPourGagner.setOnItemSelectedListener(this);

        adapterHauteur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        adapterLargeur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        adapterPourGagner = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        spinnerHauteur.setAdapter(adapterHauteur);
        spinnerLargeur.setAdapter(adapterLargeur);
        spinnerPourGagner.setAdapter(adapterPourGagner);

        adapterHauteur.addAll(MParametres.getInstance().getChoixHauteur());
        adapterLargeur.addAll(MParametres.getInstance().getChoixLargeur());
        adapterPourGagner.addAll(MParametres.getInstance().getChoixPourGagner());

        positionSpinners();
    }

    private void positionSpinners() {
        spinnerHauteur.setSelection(adapterHauteur.getPosition
                (MParametres.getInstance().getParametresPartie().getHauteur()));
        spinnerLargeur.setSelection(adapterLargeur.getPosition
                (MParametres.getInstance().getParametresPartie().getLargeur()));
        spinnerPourGagner.setSelection(adapterPourGagner.getPosition
                (MParametres.getInstance().getParametresPartie().getPourGagner()));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) parent;
        Integer choix = (Integer)parent.getAdapter().getItem(parent.getSelectedItemPosition());

        if(spinner.getId() == R.id.spinner_hauteur) {

            MParametres.getInstance().getParametresPartie().setHauteur(choix);

        } else if(spinner.getId() == R.id.spinner_largeur) {

            MParametres.getInstance().getParametresPartie().setLargeur(choix);

        } else {

            MParametres.getInstance().getParametresPartie().setPourGagner(choix);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}