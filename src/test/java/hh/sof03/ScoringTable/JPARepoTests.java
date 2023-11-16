package hh.sof03.ScoringTable;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof03.ScoringTable.domain.Player;
import hh.sof03.ScoringTable.domain.PlayerRepository;
import hh.sof03.ScoringTable.domain.Team;
import hh.sof03.ScoringTable.domain.TeamRepository;

@ExtendWith(SpringExtension.class) // JUnit5 eli Jupiter
@SpringBootTest
public class JPARepoTests {

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private TeamRepository teamRepository;

	@Test
	public void createNewPlayer() {
		Player player1 = new Player("Testi", "Testaaja", teamRepository.findByName("Ilves").get(0), 0, 0);

		playerRepository.save(player1);
		assertThat(player1.getPlayer_id()).isNotNull();
	}

	@Test
	public void findByNameShouldReturnPlayer() {

		List<Player> players = playerRepository.findByName("Eemeli Suomi");

		assertThat(players).hasSize(1);
		assertThat(players.get(0).getName()).isEqualTo("Eemeli Suomi");

	}

	@Test
	public void findByNameShouldReturnTeam() {

		List<Team> teams = teamRepository.findByName("Ilves");

		assertThat(teams).hasSize(1);
		assertThat(teams.get(0).getName()).isEqualTo("Ilves");

	}

	@Test
	public void deletePlayer() {
		Player player2 = new Player("Toka", "Testaaja", teamRepository.findByName("Ilves").get(0), 0, 0);

		playerRepository.save(player2);
		playerRepository.delete(player2);
		Optional<Player> deletedPlayer = playerRepository.findById(player2.getPlayer_id());

		assertThat(deletedPlayer).isEmpty();

	}
	
	

}
