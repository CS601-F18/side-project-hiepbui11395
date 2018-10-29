package hpbui.gamerportal.repository;

import org.springframework.data.repository.CrudRepository;

import hpbui.gamerportal.entity.Genre;

public interface GenreRepository extends CrudRepository<Genre, Integer> {
	Genre findByGenre(String name);
}
