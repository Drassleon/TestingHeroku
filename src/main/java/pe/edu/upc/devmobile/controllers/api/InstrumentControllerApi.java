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

import pe.edu.upc.devmobile.models.entity.Instrument;
import pe.edu.upc.devmobile.service.impl.InstrumentService;
import pe.edu.upc.devmobile.service.inter.IInstrumentService;

@RestController
@RequestMapping("/api/instrument")
public class InstrumentControllerApi {
	@Autowired
	IInstrumentService instrumentService=new InstrumentService();

	@RequestMapping(value="/",method = RequestMethod.GET)
	   @ResponseBody
	   public List<Instrument> findAll() {
	       return instrumentService.findAll();
	   }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	   @ResponseBody
	   public Instrument findOne(@PathVariable("id") Long id) {
	       return instrumentService.findById( id );
	   }
	 
	@PostMapping("/")
	public ResponseEntity<Object> create(@RequestBody Instrument instrument) {
		
		instrumentService.save(instrument);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(instrument.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	 
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@RequestBody Instrument instrument, @PathVariable long id) {

		Instrument instrumentAux=instrumentService.findById(id);
		if(instrumentAux!=null)
		{
			instrument.setId(id);
			instrumentService.save(instrument);
			return ResponseEntity.noContent().build();

		}
		return ResponseEntity.notFound().build();

	}
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	   @ResponseStatus(HttpStatus.OK)
	   public void delete(@PathVariable("id") Long id) {
	       instrumentService.deleteById(id);
	   }

}
