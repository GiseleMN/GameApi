package my.Top.Game.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;


@Entity(name = "games")
public class Game extends BaseEntity {
	
	
    
	private String name;
	@Column(length = 500)
	private String description;
	private String cover;
	private String vote;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getVote() {
		return vote;
	}
	public void setVote(String vote) {
		this.vote = vote;
	}

}


