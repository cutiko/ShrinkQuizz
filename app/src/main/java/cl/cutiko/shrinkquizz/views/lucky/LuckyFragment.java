package cl.cutiko.shrinkquizz.views.lucky;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.cutiko.shrinkquizz.R;


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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lucky, container, false);
    }

}
