package cl.cutiko.shrinkquizz.views.lucky;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import cl.cutiko.shrinkquizz.R;


public class LuckyFragment extends Fragment {

    private CheckBox happy;

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

        happy = (CheckBox) main.findViewById(R.id.happyCb);
        final CheckBox preview = (CheckBox) main.findViewById(R.id.previewCb);
        preview.setEnabled(false);

        happy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                preview.setChecked(b);
            }
        });


        return main;
    }

    private void displayResults(){

    }
}
