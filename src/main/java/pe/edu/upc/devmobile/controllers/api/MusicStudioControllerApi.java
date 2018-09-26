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

import pe.edu.upc.devmobile.models.entity.MusicStudio;
import pe.edu.upc.devmobile.service.impl.MusicStudioService;
import pe.edu.upc.devmobile.service.inter.IMusicStudioService;

@RestController
@RequestMapping("/api/musicstudio")
public class MusicStudioControllerApi {
	@Autowired
	IMusicStudioService musicstudioService=new MusicStudioService();

	@RequestMapping(value="/",method = RequestMethod.GET)
	   @ResponseBody
	   public List<MusicStudio> findAll() {
	       return musicstudioService.findAll();
	   }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	   @ResponseBody
	   public MusicStudio findOne(@PathVariable("id") Long id) {
	       return musicstudioService.findById( id );
	   }
	 
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> create(@RequestBody MusicStudio musicstudio) {
		
		musicstudioService.save(musicstudio);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(musicstudio.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	 
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@RequestBody MusicStudio musicstudio, @PathVariable long id) {

		MusicStudio musicstudioAux=musicstudioService.findById(id);
		if(musicstudioAux!=null)
		{
			musicstudio.setId(id);
			musicstudioService.save(musicstudio);
			return ResponseEntity.noContent().build();

		}
		return ResponseEntity.notFound().build();

	}
	   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	   @ResponseStatus(HttpStatus.OK)
	   public void delete(@PathVariable("id") Long id) {
	       musicstudioService.deleteById(id);
	   }

}
