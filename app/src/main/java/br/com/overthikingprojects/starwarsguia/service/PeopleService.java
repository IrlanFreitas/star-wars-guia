package br.com.overthikingprojects.starwarsguia.service;

import com.github.swapi4j.model.Person;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PeopleService {

    @GET("people")
    Call< List< Person > > getAll();

    @GET("people/{IdParam}")
    Call<Person> getById(@Path("param") String id);

}
