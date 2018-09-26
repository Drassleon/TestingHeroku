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

import pe.edu.upc.devmobile.models.entity.Contractor;
import pe.edu.upc.devmobile.service.impl.ContractorService;
import pe.edu.upc.devmobile.service.inter.IContractorService;

@RestController
@RequestMapping("/api/contractor")
public class ContractorControllerApi {
	@Autowired
	IContractorService contractorService=new ContractorService();

	@RequestMapping(value="/",method = RequestMethod.GET)
	   @ResponseBody
	   public List<Contractor> findAll() {
	       return contractorService.findAll();
	   }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	   @ResponseBody
	   public Contractor findOne(@PathVariable("id") Long id) {
	       return contractorService.findById( id );
	   }
	 
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> create(@RequestBody Contractor contractor) {
		
		contractorService.save(contractor);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(contractor.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	 
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@RequestBody Contractor contractor, @PathVariable long id) {

		Contractor contractorAux=contractorService.findById(id);
		if(contractorAux!=null)
		{
			contractor.setId(id);
			contractorService.save(contractor);
			return ResponseEntity.noContent().build();

		}
		return ResponseEntity.notFound().build();

	}
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	   @ResponseStatus(HttpStatus.OK)
	   public void delete(@PathVariable("id") Long id) {
	       contractorService.deleteById(id);
	   }
}
