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

import pe.edu.upc.devmobile.models.entity.Musician;
import pe.edu.upc.devmobile.service.impl.MusicianService;
import pe.edu.upc.devmobile.service.inter.IMusicianService;

@RestController
@RequestMapping("/api/musician")
public class MusicianControllerApi {
	@Autowired
	IMusicianService musicianService=new MusicianService();

	@RequestMapping(value="/",method = RequestMethod.GET)
	   @ResponseBody
	   public List<Musician> findAll() {
	       return musicianService.findAll();
	   }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	   @ResponseBody
	   public Musician findOne(@PathVariable("id") Long id) {
	       return musicianService.findById( id );
	   }
	 
	@PostMapping("/")
	public ResponseEntity<Object> create(@RequestBody Musician musician) {
		
		musicianService.save(musician);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(musician.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	 
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@RequestBody Musician musician, @PathVariable long id) {

		Musician musicianAux=musicianService.findById(id);
		if(musicianAux!=null)
		{
			musician.setId(id);
			musicianService.save(musician);
			return ResponseEntity.noContent().build();

		}
		return ResponseEntity.notFound().build();

	}
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	   @ResponseStatus(HttpStatus.OK)
	   public void delete(@PathVariable("id") Long id) {
	       musicianService.deleteById(id);
	   }

}
