package pe.edu.upc.devmobile.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import pe.edu.upc.devmobile.models.entity.Instrument;
import pe.edu.upc.devmobile.models.entity.Musician;

@Entity
@Table(name="MusicInstruments")
public class MusicianInstrument implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="musician_id")
	//@JsonBackReference
	private Musician musician;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="instrument_id")
	//@JsonBackReference
	private Instrument instrument;
	
	//Access methods

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Musician getMusician() {
		return musician;
	}

	public void setMusician(Musician musician) {
		this.musician = musician;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
}
