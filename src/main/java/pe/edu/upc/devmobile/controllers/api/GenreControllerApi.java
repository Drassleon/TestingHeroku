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

import pe.edu.upc.devmobile.models.entity.Genre;
import pe.edu.upc.devmobile.service.impl.GenreService;
import pe.edu.upc.devmobile.service.inter.IGenreService;

@RestController
@RequestMapping("/api/genre")
public class GenreControllerApi {
	@Autowired
	IGenreService genreService=new GenreService();

	@RequestMapping(value="/",method = RequestMethod.GET)
	   @ResponseBody
	   public List<Genre> findAll() {
	       return genreService.findAll();
	   }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	   @ResponseBody
	   public Genre findOne(@PathVariable("id") Long id) {
	       return genreService.findById( id );
	   }
	 
	@PostMapping("/")
	public ResponseEntity<Object> create(@RequestBody Genre genre) {
		
		genreService.save(genre);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(genre.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	 
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@RequestBody Genre genre, @PathVariable long id) {

		Genre genreAux=genreService.findById(id);
		if(genreAux!=null)
		{
			genre.setId(id);
			genreService.save(genre);
			return ResponseEntity.noContent().build();

		}
		return ResponseEntity.notFound().build();

	}
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	   @ResponseStatus(HttpStatus.OK)
	   public void delete(@PathVariable("id") Long id) {
	       genreService.deleteById(id);
	   }

}
