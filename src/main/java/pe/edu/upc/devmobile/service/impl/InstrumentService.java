package pe.edu.upc.devmobile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.devmobile.models.entity.Instrument;
import pe.edu.upc.devmobile.models.repository.InstrumentRepository;
import pe.edu.upc.devmobile.service.inter.IInstrumentService;

@Service
public class InstrumentService implements IInstrumentService {

	@Autowired
	private InstrumentRepository instrumentRepository;
	
	@Override
	public List<Instrument> findAll() {
		return instrumentRepository.findAll();
	}

	@Override
	public Instrument findById(Long id) {
		return instrumentRepository.findById(id).orElse(null);
	}

	@Override
	public void save(Instrument t) {
		instrumentRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		instrumentRepository.deleteById(id);
	}
}