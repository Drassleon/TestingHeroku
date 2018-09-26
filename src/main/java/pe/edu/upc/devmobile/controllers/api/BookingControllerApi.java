package pe.edu.upc.devmobile.controllers.api;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pe.edu.upc.devmobile.models.entity.Booking;
import pe.edu.upc.devmobile.service.impl.BookingService;
import pe.edu.upc.devmobile.service.inter.IBookingService;



@RestController
@RequestMapping("/api/booking")
public class BookingControllerApi {
	@Autowired
	IBookingService bookingService=new BookingService();

	@RequestMapping(value="/",method = RequestMethod.GET)
	   @ResponseBody
	   public List<Booking> findAll() {
	       return bookingService.findAll();
	   }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	   @ResponseBody
	   public Booking findOne(@PathVariable("id") Long id) {
	       return bookingService.findById( id );
	   }
	 
	@PostMapping("/")
	public ResponseEntity<Object> create(@RequestBody Booking booking) {
		
		bookingService.save(booking);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(booking.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	 
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@RequestBody Booking booking, @PathVariable long id) {

		Booking bookingAux=bookingService.findById(id);
		if(bookingAux!=null)
		{
			booking.setId(id);
			bookingService.save(booking);
			return ResponseEntity.noContent().build();

		}
		return ResponseEntity.notFound().build();

	}
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	   @ResponseStatus(HttpStatus.OK)
	   public void delete(@PathVariable("id") Long id) {
	       bookingService.deleteById(id);
	   }

}
