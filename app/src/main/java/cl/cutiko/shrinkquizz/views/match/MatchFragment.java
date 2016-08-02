package cl.cutiko.shrinkquizz.views.match;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import cl.cutiko.shrinkquizz.R;

public class MatchFragment extends Fragment {

    private EditText userName, loverName;
    private RadioGroup quarterRg;

    public MatchFragment() {
        // Required empty public constructor
    }
    public static MatchFragment newInstance() {
        return new MatchFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View main = inflater.inflate(R.layout.fragment_match, container, false);

        userName = (EditText) main.findViewById(R.id.userName);
        loverName = (EditText) main.findViewById(R.id.loverName);
        quarterRg = (RadioGroup) main.findViewById(R.id.quarterRg);

        Button sendBtn = (Button) main.findViewById(R.id.sendBtn);
        setSendBtn(sendBtn);

        return main;
    }

    private void setSendBtn(Button sendBtn){
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quarterRg.getCheckedRadioButtonId() != -1) {

                } else {
                    Toast.makeText(getContext(), "Seleccione nacimiento", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
