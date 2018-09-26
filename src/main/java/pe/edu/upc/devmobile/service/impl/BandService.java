package pe.edu.upc.devmobile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.devmobile.models.entity.Band;
import pe.edu.upc.devmobile.models.repository.BandRepository;
import pe.edu.upc.devmobile.service.inter.IBandService;

@Service
public class BandService implements IBandService {

	@Autowired
	private BandRepository bandRepository;
	
	@Override
	public List<Band> findAll() {
		return bandRepository.findAll();
	}

	@Override
	public Band findById(Long id) {
		return bandRepository.findById(id).orElse(null);
	}

	@Override
	public void save(Band t) {
		bandRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		bandRepository.deleteById(id);
	}
}
