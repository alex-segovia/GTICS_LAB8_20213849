package com.example.demo.Dao;

import com.example.demo.Entity.Movie;
import com.example.demo.Entity.aiuda;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@Component
public class MovieDao {
    public Object listarPeliculas(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlODhlMTQ2YzcwZDgyMWZjYzYzNzA5NzViNWZlMzRiYyIsInN1YiI6IjY2NjkwMjc4MTcwMGEwMGFhNTFkZGFkOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.1UdT-TDzIUQD4E7n0ED8O9C4YDI68Flm1QNCmq5_-JM");
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<aiuda> response = restTemplate.exchange("https://api.themoviedb.org/3/movie/now_playing?language=en-US&page=1", HttpMethod.GET, httpEntity, aiuda.class);
        return response.getBody().getResults();
    }

    public Object agregarPelicula(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlODhlMTQ2YzcwZDgyMWZjYzYzNzA5NzViNWZlMzRiYyIsInN1YiI6IjY2NjkwMjc4MTcwMGEwMGFhNTFkZGFkOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.1UdT-TDzIUQD4E7n0ED8O9C4YDI68Flm1QNCmq5_-JM");
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<aiuda> response = restTemplate.exchange("https://api.themoviedb.org/3/discover/movie", HttpMethod.GET, httpEntity, aiuda.class);
        return response.getBody().getResults();
    }
}