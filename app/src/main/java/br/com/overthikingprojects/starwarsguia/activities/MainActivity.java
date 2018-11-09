package br.com.overthikingprojects.starwarsguia.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.swapi4j.model.Person;

import java.util.List;

import br.com.overthikingprojects.starwarsguia.R;
import br.com.overthikingprojects.starwarsguia.retrofit.RetrofitInicializador;
import br.com.overthikingprojects.starwarsguia.service.PeopleService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    PeopleService peopleService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mudando a politica de Thread Principal
        // https://stackoverflow.com/questions/19740604/how-to-fix-networkonmainthreadexception-in-android


        Button btnPersonagens = findViewById(R.id.main_btn_personagens);

        peopleService = new RetrofitInicializador().getPeopleService();

        btnPersonagens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Call<List<Person>> peopleCall = peopleService.getAll();

                peopleCall.enqueue(new Callback<List<Person>>() {
                    @Override
                    public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                        Toast.makeText(MainActivity.this, "Ação realizada com sucesso!",
                                Toast.LENGTH_SHORT).show();
                        Log.i("onResponse", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<List<Person>> call, Throwable t) {

                    }
                });

            }
        });


    }



}
