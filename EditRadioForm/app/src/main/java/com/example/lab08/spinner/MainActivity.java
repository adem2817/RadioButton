package com.example.lab08.spinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Gelir;
    EditText Gider;
    RadioGroup GroupSecim;
    RadioButton RadioSecim;
    String secim;
    String deger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gelir = findViewById(R.id.editGelir);
        Gider = findViewById(R.id.editGider);
        GroupSecim = findViewById(R.id.RadioGroup);


        Gelir.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    String gelirDeger = Gelir.getText().toString();
                    if(gelirDeger.isEmpty()){
                        Gelir.setError("Boş Bırakılamaz");
                    }
                    else if(!isNumeric(gelirDeger)) {
                        Gelir.setError("Sayı Giriniz");
                    }
                }
            }
        });
        Gider.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    String giderDeger = Gider.getText().toString();
                    if(giderDeger.isEmpty()){
                        Gider.setError("Boş Bırakılamaz");
                    }
                    else if(!isNumeric(giderDeger)) {
                        Gider.setError("Sayı Giriniz");
                    }
                }
            }
        });


        GroupSecim.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioSecim = findViewById(GroupSecim.getCheckedRadioButtonId());
                secim = RadioSecim.getText().toString();
                Toast.makeText(MainActivity.this,secim, Toast.LENGTH_SHORT).show();

            }
        });


    }

    public static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(.\\d+)?");
    }

}
