package com.azubkov.carcalc;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CarCalc extends Activity {

    TextView HText;
    EditText H1Text;
    EditText hText;
    EditText h1Text;
    TextView y1Text;
    TextView y2Text;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        HText = (EditText) findViewById(R.id.H);
        H1Text = (EditText) findViewById(R.id.H1);
        hText = (EditText) findViewById(R.id.h);
        h1Text = (EditText) findViewById(R.id.h1);
        y1Text = (TextView) findViewById(R.id.y1);
        y2Text = (TextView) findViewById(R.id.y2);

        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                // Do nothing
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                // Do nothing
            }

            @Override
            public void afterTextChanged(Editable editable) {
                recalculate();
            }
        };

        HText.addTextChangedListener(watcher);
        H1Text.addTextChangedListener(watcher);
        hText.addTextChangedListener(watcher);
        h1Text.addTextChangedListener(watcher);
    }

    private void recalculate() {
        String HStr = HText.getText().toString();
        String H1Str = H1Text.getText().toString();
        String hStr = hText.getText().toString();
        String h1Str = h1Text.getText().toString();

        try{

            double H = Double.parseDouble(HStr);
            double H1 = Double.parseDouble(H1Str);
            double h = Double.parseDouble(hStr);
            double h1 = Double.parseDouble(h1Str);

            double y1 = (H + H1)/2 - h1 + h;
            double y2 = (H - H1)/2 + h1 - h;

            y1Text.setText("Y1 = " + Double.toString(y1));
            y2Text.setText("Y2 = " + Double.toString(y2));

        }catch (NumberFormatException e){
            y1Text.setText("Y1 = ");
            y2Text.setText("Y2 = ");
        }
    }

}
