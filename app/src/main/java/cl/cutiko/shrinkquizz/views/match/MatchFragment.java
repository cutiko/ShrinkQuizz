package cl.cutiko.shrinkquizz.views.match;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import cl.cutiko.shrinkquizz.R;
import cl.cutiko.shrinkquizz.data.MatchResult;

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
                int selectedId = quarterRg.getCheckedRadioButtonId();
                if (selectedId != -1) {
                    RadioButton selected = (RadioButton) quarterRg.findViewById(selectedId);
                    Context context = getContext();
                    String result = new MatchResult(userName.getText().toString(), loverName.getText().toString(), selected.getText().toString(), context).details();
                    Log.d("RESULT", result);
                    AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                    dialog.setMessage(result);
                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialogInterface) {
                            userName.setText("");
                            loverName.setText("");
                            quarterRg.clearCheck();
                        }
                    });
                    dialog.show();
                } else {
                    Toast.makeText(getContext(), "Seleccione nacimiento", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
