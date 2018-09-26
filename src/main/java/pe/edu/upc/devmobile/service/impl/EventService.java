package pe.edu.upc.devmobile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.devmobile.models.entity.Event;
import pe.edu.upc.devmobile.models.repository.EventRepository;
import pe.edu.upc.devmobile.service.inter.IEventService;

@Service
public class EventService implements IEventService {

	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public List<Event> findAll() {
		return eventRepository.findAll();
	}

	@Override
	public Event findById(Long id) {
		return eventRepository.findById(id).orElse(null);
	}

	@Override
	public void save(Event t) {
		eventRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		eventRepository.deleteById(id);
	}
}