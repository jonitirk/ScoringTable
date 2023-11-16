package hh.sof03.ScoringTable.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof03.ScoringTable.domain.Player;
import hh.sof03.ScoringTable.domain.PlayerRepository;
import hh.sof03.ScoringTable.domain.Team;
import hh.sof03.ScoringTable.domain.TeamRepository;


@Controller
public class RestController {
	
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private TeamRepository teamRepository;


	

	// RESTful metodi pelaajaistan hakemiseen
	@RequestMapping(value = "/playerlist", method = RequestMethod.GET)
	public @ResponseBody List<Player> playerListRest() {

		return (List<Player>) playerRepository.findAll();

	}
	
	@RequestMapping(value = "/teamlist", method = RequestMethod.GET)
	public @ResponseBody List<Team> teamListRest() {

		return (List<Team>) teamRepository.findAll();

	}

	// RESTful metodi pelaajan hakemiseen id:n avulla
	@RequestMapping(value = "/playerlist/{player_id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Player> findPlayerRest(@PathVariable("player_id") Long player_Id) {
		return playerRepository.findById(player_Id);
	}

	// RESTful metodi pelaajan hakemiseen id:n avulla
	@RequestMapping(value = "/teamlist/{team_id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Team> findTeamRest(@PathVariable("team_id") Long team_id) {
		return teamRepository.findById(team_id);
	}
	
	// RESTful metodi pelaajan tallentamiseen
	@RequestMapping(value = "/playerlist", method = RequestMethod.POST)
	public @ResponseBody Player savePlayerRest(@RequestBody Player player) {
		return playerRepository.save(player);

	}

}
