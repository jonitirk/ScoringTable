package hh.sof03.ScoringTable.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//rajapinta CRUD-operaatioita varten
public interface TeamRepository extends CrudRepository<Team, Long>  {
	
	List<Team> findByName(String name);

}
