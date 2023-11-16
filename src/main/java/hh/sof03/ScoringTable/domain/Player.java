package hh.sof03.ScoringTable.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="players")
public class Player implements Comparable<Player> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long player_id;
	
	private String firstName, lastName, name;
	private int goals, assists, points;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "team_id")
    private Team team;
	
	
	public Player() {
		super();
	}


	public Player(String firstName, String lastName, Team team,
			int goals, int assists) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.team = team;
		this.goals = goals;
		this.assists = assists;
		setName();
		setPoints();
		
	}


	public long getPlayer_id() {
		return player_id;
	}


	public void setPlayer_id(long id) {
		this.player_id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Team getTeam() {
		return team;
	}


	public void setTeam(Team team) {
		this.team = team;
	}


	public int getGoals() {
		return goals;
	}


	public void setGoals(int goals) {
		this.goals = goals;
		setPoints();
	}


	public int getAssists() {
		return assists;
	}


	public void setAssists(int assists) {
		this.assists = assists;
		setPoints();
	}


	public int getPoints() {
		return points;
	}


	public void setPoints() {
		this.points = goals + assists;
	}


	public String getName() {
		return name;
	}


	public void setName() {
		this.name = firstName + " " + lastName;
	}
	
    @Override
    public int compareTo(Player otherPlayer) {
        // Compare based on points
        return Integer.compare(this.points, otherPlayer.points);
    }

}
