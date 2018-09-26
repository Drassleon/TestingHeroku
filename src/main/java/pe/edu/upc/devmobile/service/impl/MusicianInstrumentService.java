package pe.edu.upc.devmobile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.devmobile.models.entity.MusicianInstrument;
import pe.edu.upc.devmobile.models.repository.MusicianInstrumentRepository;
import pe.edu.upc.devmobile.service.inter.IMusicianInstrumentService;

@Service
public class MusicianInstrumentService implements IMusicianInstrumentService {

	@Autowired
	private MusicianInstrumentRepository musicianInstrumentDao;
	
	@Override
	public List<MusicianInstrument> findAll() {
		return musicianInstrumentDao.findAll();
	}

	@Override
	public MusicianInstrument findById(Long id) {
		return musicianInstrumentDao.findById(id).orElse(null);
	}

	@Override
	public void save(MusicianInstrument t) {
		musicianInstrumentDao.save(t);
	}

	@Override
	public void deleteById(Long id) {
		musicianInstrumentDao.deleteById(id);
	}
}
