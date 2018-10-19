package br.com.overthikingprojects.starwarsguia.activities;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.swapi4j.SwapiClient;
import com.github.swapi4j.model.Person;

import java.util.List;

import br.com.overthikingprojects.starwarsguia.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mudando a politica de Thread Principal

        // https://stackoverflow.com/questions/19740604/how-to-fix-networkonmainthreadexception-in-android

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        final SwapiClient client = new SwapiClient();

        Button btnPersonagens = findViewById(R.id.main_btn_personagens);

        btnPersonagens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person person = client.getPersonById(1L);

                Toast.makeText(MainActivity.this , person.toString(), Toast.LENGTH_LONG ).show();

            }
        });


    }
}
