package com.codingdojo.lookify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.codingdojo.lookify.models.Song;

public interface SongRepository extends CrudRepository<Song, Long>{
	
	//Este método recupera todas las canciones de la base de datos
    List<Song> findAll();
    //Este método encuentra una cancion por su titulo
    List<Song> findByArtistContaining(String artist);
    //Ordena en top 10 una lista
    @Query (value="SELECT * FROM songs ORDER BY rating DESC LIMIT 10", nativeQuery=true)
    List<Song> findTopTenByRatingDESC();
}
