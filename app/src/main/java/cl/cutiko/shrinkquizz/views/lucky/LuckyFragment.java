package cl.cutiko.shrinkquizz.views.lucky;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import cl.cutiko.shrinkquizz.R;
import cl.cutiko.shrinkquizz.data.LuckyResult;


public class LuckyFragment extends Fragment {

    public LuckyFragment() {
        // Required empty public constructor
    }

    public static LuckyFragment newInstance() {
        return new LuckyFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View main = inflater.inflate(R.layout.fragment_lucky, container, false);
        CheckBox checkBox = (CheckBox) main.findViewById(R.id.happyCb);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, final boolean b) {
                Snackbar.make(compoundButton, "¿Ver resultado?", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Resultado", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                result(b);
                            }
                        }).show();
            }
        });

        return main;
    }
    
    private void result(boolean happy){
        String result = new LuckyResult(happy).detaisl();
        Toast.makeText(getContext(), result, Toast.LENGTH_LONG).show();
    }

}
