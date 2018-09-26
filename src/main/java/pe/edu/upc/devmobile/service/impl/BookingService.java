package pe.edu.upc.devmobile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.devmobile.models.entity.Booking;
import pe.edu.upc.devmobile.models.repository.BookingRepository;
import pe.edu.upc.devmobile.service.inter.IBookingService;
@Service
public class BookingService implements IBookingService {
	@Autowired
	BookingRepository bookingRepository;
	@Override
	public List<Booking> findAll() {
		// TODO Auto-generated method stub
		return bookingRepository.findAll();
	}

	@Override
	public Booking findById(Long id) {
		// TODO Auto-generated method stub
		return bookingRepository.findById(id).orElse(null);
	}

	@Override
	public void save(Booking t) {
		// TODO Auto-generated method stub
		bookingRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		bookingRepository.deleteById(id);

	}

}
