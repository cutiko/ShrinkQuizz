package cl.cutiko.shrinkquizz.views.cool;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import cl.cutiko.shrinkquizz.R;
import cl.cutiko.shrinkquizz.data.CoolResult;

public class CoolFragment extends Fragment {


    private EditText userEt;
    private TextView counterTv;
    private Switch partySw;
    private SeekBar drinksBar;
    private Button sendBtn;

    public CoolFragment() {
        // Required empty public constructor
    }

    public static CoolFragment newInstance() {
        return new CoolFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View main = inflater.inflate(R.layout.fragment_cool, container, false);
        userEt = (EditText) main.findViewById(R.id.userName);
        partySw = (Switch) main.findViewById(R.id.partySw);
        counterTv = (TextView) main.findViewById(R.id.drinksTv);
        drinksBar = (SeekBar) main.findViewById(R.id.drinksSb);
        sendBtn = (Button) main.findViewById(R.id.sendBtn);
        setSeekBar();
        setSendBtn();
        return main;
    }

    private void setSeekBar(){
        drinksBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                counterTv.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void setSendBtn(){
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = userEt.getText().toString();
                boolean party = partySw.isChecked();
                int drinks = drinksBar.getProgress();
                Context context = getContext();
                CoolResult coolResult = new CoolResult(name, party, drinks);
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setMessage(coolResult.details(context));
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        reset();
                    }
                });
                dialog.show();

            }
        });
    }

    private void reset(){
        userEt.setText("");
        partySw.setChecked(false);
        counterTv.setText("0");
        drinksBar.setProgress(0);
    }


}
