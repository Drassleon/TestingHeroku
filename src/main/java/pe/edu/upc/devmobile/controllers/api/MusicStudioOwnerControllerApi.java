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

import pe.edu.upc.devmobile.models.entity.MusicStudioOwner;
import pe.edu.upc.devmobile.service.impl.MusicStudioOwnerService;
import pe.edu.upc.devmobile.service.inter.IMusicStudioOwnerService;

@RestController
@RequestMapping("/api/musicstudioowner")
public class MusicStudioOwnerControllerApi {
	@Autowired
	IMusicStudioOwnerService musicstudioownerService=new MusicStudioOwnerService();

	@RequestMapping(value="/",method = RequestMethod.GET)
	   @ResponseBody
	   public List<MusicStudioOwner> findAll() {
	       return musicstudioownerService.findAll();
	   }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	   @ResponseBody
	   public MusicStudioOwner findOne(@PathVariable("id") Long id) {
	       return musicstudioownerService.findById( id );
	   }
	 
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> create(@RequestBody MusicStudioOwner musicstudioowner) {
		
		musicstudioownerService.save(musicstudioowner);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(musicstudioowner.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	 
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@RequestBody MusicStudioOwner musicstudioowner, @PathVariable long id) {

		MusicStudioOwner musicstudioownerAux=musicstudioownerService.findById(id);
		if(musicstudioownerAux!=null)
		{
			musicstudioowner.setId(id);
			musicstudioownerService.save(musicstudioowner);
			return ResponseEntity.noContent().build();

		}
		return ResponseEntity.notFound().build();

	}
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	   @ResponseStatus(HttpStatus.OK)
	   public void delete(@PathVariable("id") Long id) {
	       musicstudioownerService.deleteById(id);
	   }

}
