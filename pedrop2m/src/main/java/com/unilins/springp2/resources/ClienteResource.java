package com.unilins.springp2.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.unilins.springp2.entities.Cliente;
import com.unilins.springp2.services.ClienteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/clients")
public class ClienteResource {

	@Autowired
	private ClienteService clienteServ;

	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {

		List<Cliente> list = clienteServ.findAll();
		return ResponseEntity.ok().body(list);
	}
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id){
		Cliente obj = clienteServ.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@CrossOrigin(origins = "*")
	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody Cliente obj) {
		obj = clienteServ.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdCliente()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		clienteServ.delete(id);
		return ResponseEntity.noContent().build();
	}
	@CrossOrigin(origins = "*")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente obj) {
		obj = clienteServ.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
