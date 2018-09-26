package pe.edu.upc.devmobile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.devmobile.models.entity.MusicStudioOwner;
import pe.edu.upc.devmobile.models.repository.MusicStudioOwnerRepository;
import pe.edu.upc.devmobile.service.inter.IMusicStudioOwnerService;

@Service
public class MusicStudioOwnerService implements IMusicStudioOwnerService {

	@Autowired
	private MusicStudioOwnerRepository musicStudioOwnerDao;

	@Override
	public List<MusicStudioOwner> findAll() {
		return musicStudioOwnerDao.findAll();
	}

	@Override
	public MusicStudioOwner findById(Long id) {
		return musicStudioOwnerDao.findById(id).orElse(null);
	}

	@Override
	public void save(MusicStudioOwner t) {
		musicStudioOwnerDao.save(t);
	}

	@Override
	public void deleteById(Long id) {
		musicStudioOwnerDao.deleteById(id);
	}
}
