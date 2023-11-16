package hh.sof03.ScoringTable.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import hh.sof03.ScoringTable.domain.Team;
import hh.sof03.ScoringTable.domain.TeamRepository;

@CrossOrigin
@Controller
public class TeamController {
	


	@Autowired
	private TeamRepository teamRepository;

	// Metodi, joka hakee kaikki joukkueet h2-tietokannasta ja lähettää ne
	// teams.html thymeleaf-sivulle
	@RequestMapping(value = {"/teams" })
	public String teamList(Model model) {

		model.addAttribute("teams", teamRepository.findAll());

		return "teams";
	}

	// Metodi pelaajan lisäämistä varten
	@RequestMapping(value = "/addteam")
	public String addTeam(Model model) {
		model.addAttribute("team", new Team());
		return "addteam";
	}

	// addteam.html -sivulla tehtävä joukkueen tallentamismetodi, joka ohjaa
	// takaisin joukkuesivulle
	@RequestMapping(value = "/saveteam", method = RequestMethod.POST)
	public String save(Team team) {
		teamRepository.save(team);
		return "redirect:teams";
	}


}
