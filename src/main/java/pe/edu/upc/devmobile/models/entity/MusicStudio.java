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

import pe.edu.upc.devmobile.models.entity.MusicStudioOwner;

@Entity
@Table(name="MusicStudios")
public class MusicStudio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String address;
	
	@NotNull
	@Column(name="phone_number")
	private String phoneNumber;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="music_studio_owner_id")
	//@JsonBackReference
	private MusicStudioOwner musicStudioOwner;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public MusicStudioOwner getMusicStudioOwner() {
		return musicStudioOwner;
	}

	public void setMusicStudioOwner(MusicStudioOwner musicStudioOwner) {
		this.musicStudioOwner = musicStudioOwner;
	}
}
