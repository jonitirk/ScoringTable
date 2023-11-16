package hh.sof03.ScoringTable.web;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import hh.sof03.ScoringTable.domain.Player;
import hh.sof03.ScoringTable.domain.PlayerRepository;
import hh.sof03.ScoringTable.domain.TeamRepository;

@CrossOrigin
@Controller
public class PlayerController {

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private TeamRepository teamRepository;

	// Metodi, joka hakee kaikki pelaajat h2-tietokannasta ja lähettää ne
	// players.html thymeleaf-sivulle
	@RequestMapping(value = { "/", "/players" })
	public String playerList(Model model) {
		
		 List<Player> players = new ArrayList<>();
		    for (Player player : playerRepository.findAll()) {
		        players.add(player);
		    }

		Collections.sort(players, Collections.reverseOrder());

		model.addAttribute("players", players);

		return "players";
	}

	// Metodi pelaajan lisäämistä varten
	@RequestMapping(value = "/add")
	public String addPlayer(Model model) {
		model.addAttribute("player", new Player());
		model.addAttribute("teams", teamRepository.findAll());
		return "addplayer";
	}

	// addplayer.html -sivulla tehtävä pelaajan tallentamismetodi, joka ohjaa
	// takaisin etusivulle
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Player player) {
		player.setName();
		playerRepository.save(player);
		return "redirect:players";
	}

	// pelaajan poistamismetodi
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deletePlayer(@PathVariable("id") Long player_id, Model model) {
		playerRepository.deleteById(player_id);
		return "redirect:../players";
	}

	// pelaajan tietojen muokkaukseen käytettävä metodi
	@RequestMapping(value = "/edit/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editPlayer(@PathVariable("id") Long player_id, Model model) {
		model.addAttribute("player", playerRepository.findById(player_id));
		model.addAttribute("teams", teamRepository.findAll());
		return "editplayer";
	}

}
