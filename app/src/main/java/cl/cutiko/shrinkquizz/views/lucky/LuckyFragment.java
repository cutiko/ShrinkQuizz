package cl.cutiko.shrinkquizz.views.lucky;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import cl.cutiko.shrinkquizz.R;
import cl.cutiko.shrinkquizz.data.LuckyResult;


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

        Button sendBtn = (Button) main.findViewById(R.id.sendBtn);
        setSendBtn(sendBtn);

        return main;
    }

    private void setSendBtn(Button sendBtn){
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getContext();
                LuckyResult result = new LuckyResult(happy.isChecked());
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setMessage(result.detaisl());
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        happy.setChecked(false);
                    }
                });
                dialog.show();
            }
        });
    }
}
