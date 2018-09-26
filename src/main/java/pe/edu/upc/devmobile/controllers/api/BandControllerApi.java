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

import pe.edu.upc.devmobile.models.entity.Band;
import pe.edu.upc.devmobile.service.impl.BandService;
import pe.edu.upc.devmobile.service.inter.IBandService;
@RestController
@RequestMapping("/api/band")
public class BandControllerApi {
	@Autowired
	IBandService bandService=new BandService();
	

	@RequestMapping(value="/",method = RequestMethod.GET)
	   @ResponseBody
	   public List<Band> findAll() {
	       List<Band> bandas = bandService.findAll();
	    
	       
	       return bandas;
	   }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	   @ResponseBody
	   public Band findOne(@PathVariable("id") Long id) {
	       return bandService.findById( id );
	   }
	@PostMapping("/")
	public ResponseEntity<Object> create(@RequestBody Band band) {
		
		bandService.save(band);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(band.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	 
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@RequestBody Band band, @PathVariable long id) {

		Band bandAux=bandService.findById(id);
		if(bandAux!=null)
		{
			band.setId(id);
			bandService.save(band);
			return ResponseEntity.noContent().build();

		}
		return ResponseEntity.notFound().build();

	}

	   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	   @ResponseStatus(HttpStatus.OK)
	   public void delete(@PathVariable("id") Long id) {
	       bandService.deleteById(id);
	   }

}
