package com.example.student.xox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void OnClick(View view){

        EditText XName = (EditText) findViewById(R.id.xPlayerName);
        EditText OName = (EditText) findViewById(R.id.oPlayerName);

        Intent i = new Intent(this, gameplay.class);
        if(!XName.getText().toString().equals("")||!OName.getText().toString().equals("")) {
            i.putExtra("NameX", XName.getText().toString());
            i.putExtra("NameO", OName.getText().toString());
            startActivity(i);
        }else{
            Toast toast = Toast.makeText(this, "Names are required!", Toast.LENGTH_LONG);
            toast.show();
        }
    }

}
