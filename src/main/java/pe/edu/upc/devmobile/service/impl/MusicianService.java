package pe.edu.upc.devmobile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.devmobile.models.entity.Musician;
import pe.edu.upc.devmobile.models.repository.MusicianRepository;
import pe.edu.upc.devmobile.service.inter.IMusicianService;

@Service
public class MusicianService implements IMusicianService {

	@Autowired
	private MusicianRepository musicianRepository;
	
	@Override
	public List<Musician> findAll() {
		return musicianRepository.findAll();
	}

	@Override
	public Musician findById(Long id) {
		return musicianRepository.findById(id).orElse(null);
	}

	@Override
	public void save(Musician t) {
		musicianRepository.save(t);
		}

	@Override
	public void deleteById(Long id) {
		musicianRepository.deleteById(id);
	}
}