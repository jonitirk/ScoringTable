package hh.sof03.ScoringTable.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//rajapinta CRUD-operaatioita varten
public interface PlayerRepository extends CrudRepository<Player, Long> {
	
	List<Player> findByName(String name);

}
