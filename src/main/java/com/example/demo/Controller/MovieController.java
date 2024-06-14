package com.example.demo.Controller;

import com.example.demo.Dao.MovieDao;
import com.example.demo.Entity.Movie;
import com.example.demo.Entity.User;
import com.example.demo.Entity.result;
import com.example.demo.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieDao movieDao;

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/movie")
    public Object getMovies(){
        return movieDao.listarPeliculas();
    }

    @PostMapping("/movie")
    public Object agregarMovie(@RequestBody Movie movie){
        HashMap<String,Object> responseMap = new HashMap<>();
        List<result> resultados = (List<result>) movieDao.agregarPelicula();
        for(result r: resultados){
            if(r.getOriginal_title().equals(movie.getTitulo())){
                User user = new User();
                user.setId(1);
                movie.setIduser(user);
                movie.setOverview(r.getOverview());
                movie.setPopularidad(r.getPopularity());
                movie.setFecha(r.getRelease_date());
                movieRepository.save(movie);
                responseMap.put("status","creado");
                responseMap.put("pelicula",r);
                break;
            }
        }
        return ResponseEntity.ok().body(responseMap);
    }
}
