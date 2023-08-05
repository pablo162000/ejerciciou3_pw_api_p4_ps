package com.example.demo.Controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.model.Vehiculo;
import com.example.demo.service.IVehiculoService;
import com.example.demo.service.to.VehiculoTO;

@RestController
@RequestMapping("/vehiculos")
@CrossOrigin
public class VehiculoControllerRestFul {

	@Autowired
	private IVehiculoService vehiculoService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<List<VehiculoTO>> consultarTodos() {
		List<VehiculoTO> lista = this.vehiculoService.buscarTodos1();

		for (VehiculoTO v : lista) {
			Link myLink = linkTo(methodOn(VehiculoControllerRestFul.class).consultarporplaca(v.getPlaca()))
					.withSelfRel();
			v.add(myLink);

		}
		return new ResponseEntity<>(lista, null, 200);

	}

	@GetMapping(path = "/{placa}")

	public ResponseEntity<Vehiculo> consultarporplaca(@PathVariable String placa) {

		Vehiculo vehiculo = this.vehiculoService.buscarPorPlaca(placa);
		return new ResponseEntity<>(vehiculo, null, 200);

	}

	// import static
	// org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

	// import static
	// org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
}
