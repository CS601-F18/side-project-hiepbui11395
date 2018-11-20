package hpbui.gamerportal.repository;

import hpbui.gamerportal.entity.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    Genre findGenreByNameAndActiveTrue(String name);
}
