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

import com.unilins.springp2.entities.Carro;
import com.unilins.springp2.services.CarroService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/carros")
public class CarroResource {
		@Autowired
		private CarroService carroServ;

		@CrossOrigin(origins = "*")
		@GetMapping
		public ResponseEntity<List<Carro>> findAll() {
			List<Carro> list = carroServ.findAll();
			return ResponseEntity.ok().body(list);
		}
		@CrossOrigin(origins = "*")
		@GetMapping(value = "/{id}")
		public ResponseEntity<Carro> findById(@PathVariable Long id){
			Carro obj = carroServ.findById(id);
			return ResponseEntity.ok().body(obj);
		}
		@CrossOrigin(origins = "*")
		@PostMapping
		public ResponseEntity<Carro> insert(@RequestBody Carro obj) {
			obj = carroServ.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(obj.getIdCarro()).toUri();
			return ResponseEntity.created(uri).body(obj);
		}
		@CrossOrigin(origins = "*")
		@DeleteMapping(value = "/{id}")
		public ResponseEntity<Void> delete(@PathVariable Long id) {
			carroServ.delete(id);
			return ResponseEntity.noContent().build();
		}
		@CrossOrigin(origins = "*")
		@PutMapping(value = "/{id}")
		public ResponseEntity<Carro> update(@PathVariable Long id, @RequestBody Carro obj) {
			obj = carroServ.update(id, obj);
			return ResponseEntity.ok().body(obj);
		}
}
