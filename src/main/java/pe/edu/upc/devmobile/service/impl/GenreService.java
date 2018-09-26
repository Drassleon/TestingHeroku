package pe.edu.upc.devmobile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.devmobile.models.entity.Genre;
import pe.edu.upc.devmobile.models.repository.GenreRepository;
import pe.edu.upc.devmobile.service.inter.IGenreService;

@Service
public class GenreService implements IGenreService {

	@Autowired
	private GenreRepository genreRepository;
	
	@Override
	public List<Genre> findAll() {
		return genreRepository.findAll();
	}

	@Override
	public Genre findById(Long id) {
		return genreRepository.findById(id).orElse(null);
	}

	@Override
	public void save(Genre t) {
		genreRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		genreRepository.deleteById(id);
	}
}
