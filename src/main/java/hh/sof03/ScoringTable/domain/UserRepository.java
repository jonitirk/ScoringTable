package hh.sof03.ScoringTable.domain;

import org.springframework.data.repository.CrudRepository;

//rajapinta CRUD-operaatioita varten
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);

}

