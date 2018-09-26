package pe.edu.upc.devmobile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.devmobile.models.entity.MusicStudio;
import pe.edu.upc.devmobile.models.repository.MusicStudioRepository;
import pe.edu.upc.devmobile.service.inter.IMusicStudioService;
@Service
public class MusicStudioService implements IMusicStudioService {
	
	@Autowired
	MusicStudioRepository musicStudioRepository;
	
	@Override
	public List<MusicStudio> findAll() {
		// TODO Auto-generated method stub
		return musicStudioRepository.findAll();
	}

	@Override
	public MusicStudio findById(Long id) {
		// TODO Auto-generated method stub
		return musicStudioRepository.findById(id).orElse(null);
	}

	@Override
	public void save(MusicStudio t) {
		// TODO Auto-generated method stub
		musicStudioRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		musicStudioRepository.deleteById(id);
	}

}
