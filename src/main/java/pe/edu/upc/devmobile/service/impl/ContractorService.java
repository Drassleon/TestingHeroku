package pe.edu.upc.devmobile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.devmobile.models.entity.Contractor;
import pe.edu.upc.devmobile.models.repository.ContractorRepository;
import pe.edu.upc.devmobile.service.inter.IContractorService;

@Service
public class ContractorService implements IContractorService {

	@Autowired
	private ContractorRepository contractorRepository;
	
	@Override
	public List<Contractor> findAll() {
		return contractorRepository.findAll();
	}

	@Override
	public Contractor findById(Long id) {
		return contractorRepository.findById(id).orElse(null);
	}

	@Override
	public void save(Contractor t) {
		contractorRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		contractorRepository.deleteById(id);
	}
}
