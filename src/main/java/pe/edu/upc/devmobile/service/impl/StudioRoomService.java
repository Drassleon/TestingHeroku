package pe.edu.upc.devmobile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.devmobile.models.entity.StudioRoom;
import pe.edu.upc.devmobile.models.repository.StudioRoomRepository;
import pe.edu.upc.devmobile.service.inter.IStudioRoomService;

@Service
public class StudioRoomService implements IStudioRoomService {

	@Autowired
	private StudioRoomRepository studioRoomRepository;
	
	@Override
	public List<StudioRoom> findAll() {
		return studioRoomRepository.findAll();
	}

	@Override
	public StudioRoom findById(Long id) {
		return studioRoomRepository.findById(id).orElse(null);
	}

	@Override
	public void save(StudioRoom t) {
		studioRoomRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		studioRoomRepository.deleteById(id);
	}
}
