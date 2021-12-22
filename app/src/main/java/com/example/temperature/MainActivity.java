package com.example.temperature;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextcelsus,editTextferehent;
    Button buttonconvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextcelsus=findViewById(R.id.editTextcelsus);
        editTextferehent=findViewById(R.id.editTextfehent);
        buttonconvert=findViewById(R.id.buttonconvertir);
        buttonconvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String textCelsus=editTextcelsus.getText().toString();
               String textferehent=editTextferehent.getText().toString();
               if((textCelsus.isEmpty())&&(textferehent.isEmpty())){
                   Toast.makeText(MainActivity.this,"veuillez remplir une valeur",Toast.LENGTH_LONG).show();
               }
               else if((!textCelsus.isEmpty())&&(!textferehent.isEmpty())){
                   Toast.makeText(MainActivity.this,"veuillez entrer une seul valeur",Toast.LENGTH_LONG).show();
               }
               else if (!textCelsus.isEmpty()){
                  // double celsus=new Double(textCelsus).doubleValue();
                   double celsusval=(double) ((new Double(textCelsus).doubleValue())*1.8+32);
                   editTextferehent.setText(celsusval+" F");
               }
               else if (!textferehent.isEmpty()){
                   //double ferehnet=new Double(textCelsus).floatValue();
                   double ferehentval=(double) (((new Double(textferehent).doubleValue())-32)/1.8);
                   editTextcelsus.setText(ferehentval+" C");

               }
               else{
                   Toast.makeText(MainActivity.this,"veuillez entrer une valeur numérique",Toast.LENGTH_LONG).show();

               }

            }
        });
    }
}