package hh.sof03.ScoringTable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.ScoringTable.domain.Player;
import hh.sof03.ScoringTable.domain.PlayerRepository;
import hh.sof03.ScoringTable.domain.Team;
import hh.sof03.ScoringTable.domain.TeamRepository;
import hh.sof03.ScoringTable.domain.User;
import hh.sof03.ScoringTable.domain.UserRepository;



@SpringBootApplication
public class ScoringTableApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ScoringTableApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ScoringTableApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PlayerRepository playerRepository, TeamRepository teamRepository, UserRepository userRepository) {
		return (args) -> {
			teamRepository.save(new Team("HIFK"));
			teamRepository.save(new Team("HPK"));
			teamRepository.save(new Team("Ilves"));
			teamRepository.save(new Team("Jukurit"));
			teamRepository.save(new Team("JYP"));
			teamRepository.save(new Team("Kalpa"));
			teamRepository.save(new Team("Kookoo"));
			teamRepository.save(new Team("Kärpät"));
			teamRepository.save(new Team("Lukko"));
			teamRepository.save(new Team("Pelicans"));
			teamRepository.save(new Team("Saipa"));
			teamRepository.save(new Team("Sport"));
			teamRepository.save(new Team("Tappara"));
			teamRepository.save(new Team("TPS"));
			teamRepository.save(new Team("Ässät"));
			

			playerRepository.save(new Player("Eemeli", "Suomi", teamRepository.findByName("Ilves").get(0), 5, 15));
			playerRepository.save(new Player("Jerry", "Turkulainen", teamRepository.findByName("JYP").get(0), 10, 17));
			playerRepository.save(new Player("Sami", "Niku", teamRepository.findByName("JYP").get(0), 9, 17));
			playerRepository.save(new Player("Anton", "Levtchi", teamRepository.findByName("Tappara").get(0), 6, 19));
			playerRepository.save(new Player("Reid", "Gardiner", teamRepository.findByName("JYP").get(0), 7, 16));
			playerRepository.save(new Player("Kristian", "Vesalainen", teamRepository.findByName("HIFK").get(0), 10, 12));
			playerRepository.save(new Player("Nick", "Halloran", teamRepository.findByName("Tappara").get(0), 11, 10));
			playerRepository.save(new Player("Oula", "Palve", teamRepository.findByName("Ilves").get(0), 5, 16));
			playerRepository.save(new Player("Carter", "Camper", teamRepository.findByName("Tappara").get(0), 8, 12));
			playerRepository.save(new Player("Jori", "Lehterä", teamRepository.findByName("HIFK").get(0), 1, 19));
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
			
			
			log.info("Fetch all the teams");
			for (Team team : teamRepository.findAll()) {
			log.info(team.toString());
			}
			log.info("Fetch all the players");
			for (Player player : playerRepository.findAll()) {
			log.info(player.toString());
			}


		};
	}

}
