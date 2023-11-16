package hh.sof03.ScoringTable.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Team {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long team_id;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
	@JsonIgnore
	private List<Player> players;
	
	public Team() {
		super();
	}

	public Team(String name) {
		super();
		this.name = name;
	}

	public long getTeam_id() {
		return team_id;
	}

	public void setTeam_id(long team_id) {
		this.team_id = team_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	
	
	
	
}
