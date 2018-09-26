package pe.edu.upc.devmobile.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import pe.edu.upc.devmobile.models.entity.Genre;

@Entity
@Table(name="Bands")
public class Band implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@Column(name="social_media")
	private String socialMedia;
	
	@Column(name="music_respository")
	private String musicRepository;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="genre_id")
	//@JsonBackReference
	private Genre genre;
	
	//Access methods

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSocialMedia() {
		return socialMedia;
	}

	public void setSocialMedia(String socialMedia) {
		this.socialMedia = socialMedia;
	}

	public String getMusicRepository() {
		return musicRepository;
	}

	public void setMusicRepository(String musicRepository) {
		this.musicRepository = musicRepository;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
}
