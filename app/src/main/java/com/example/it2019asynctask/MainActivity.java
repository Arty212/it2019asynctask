package com.example.it2019asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editURL;
    private Button btnLoad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editURL = findViewById(R.id.edit_url);
        btnLoad = findViewById(R.id.btn_load);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String url = editURL.getText().toString();
                    Intent intent = new Intent(getApplicationContext(), ImageActivity.class);
                    intent.putExtra(ImageActivity.URL_KEY, url);
                    startActivity(intent);
                }catch (Exception e){
                    showError("Error URL");
                }
            }
        });

    }

    private void showError(String error){
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
    }
}
