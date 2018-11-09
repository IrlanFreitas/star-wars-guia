package br.com.overthikingprojects.starwarsguia.retrofit;

import java.util.concurrent.TimeUnit;

import br.com.overthikingprojects.starwarsguia.service.PeopleService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitInicializador {

    private Retrofit retrofit;

    public RetrofitInicializador() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        /* Configurando o nível de detalhes */
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        this.retrofit = new Retrofit.Builder().baseUrl("https://swapi.co/api/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client)
                .build();
    }

    public PeopleService getPeopleService() {
        return retrofit.create(PeopleService.class);
    }

}
