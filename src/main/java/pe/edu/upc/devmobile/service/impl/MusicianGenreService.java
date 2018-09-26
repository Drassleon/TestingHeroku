package pe.edu.upc.devmobile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.devmobile.models.entity.MusicianGenre;
import pe.edu.upc.devmobile.models.repository.MusicianGenreRepository;
import pe.edu.upc.devmobile.service.inter.IMusicianGenreService;

@Service
public class MusicianGenreService implements IMusicianGenreService {

	@Autowired
	private MusicianGenreRepository musicianGenreRepository;
	
	@Override
	public List<MusicianGenre> findAll() {
		return musicianGenreRepository.findAll();
	}

	@Override
	public MusicianGenre findById(Long id) {
		return musicianGenreRepository.findById(id).orElse(null);
	}

	@Override
	public void save(MusicianGenre t) {
		musicianGenreRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		musicianGenreRepository.deleteById(id);
	}

}
