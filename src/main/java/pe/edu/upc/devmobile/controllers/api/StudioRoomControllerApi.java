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

import pe.edu.upc.devmobile.models.entity.StudioRoom;
import pe.edu.upc.devmobile.service.impl.StudioRoomService;
import pe.edu.upc.devmobile.service.inter.IStudioRoomService;

@RestController
@RequestMapping("/api/studioroom")
public class StudioRoomControllerApi {
	@Autowired
	IStudioRoomService studioroomService=new StudioRoomService();

	@RequestMapping(value="/",method = RequestMethod.GET)
	   @ResponseBody
	   public List<StudioRoom> findAll() {
	       return studioroomService.findAll();
	   }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	   @ResponseBody
	   public StudioRoom findOne(@PathVariable("id") Long id) {
	       return studioroomService.findById( id );
	   }
	 
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> create(@RequestBody StudioRoom studioroom) {
		
		studioroomService.save(studioroom);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(studioroom.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	 
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@RequestBody StudioRoom studioroom, @PathVariable long id) {

		StudioRoom studioroomAux=studioroomService.findById(id);
		if(studioroomAux!=null)
		{
			studioroom.setId(id);
			studioroomService.save(studioroom);
			return ResponseEntity.noContent().build();

		}
		return ResponseEntity.notFound().build();

	}
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	   @ResponseStatus(HttpStatus.OK)
	   public void delete(@PathVariable("id") Long id) {
	       studioroomService.deleteById(id);
	   }

}
