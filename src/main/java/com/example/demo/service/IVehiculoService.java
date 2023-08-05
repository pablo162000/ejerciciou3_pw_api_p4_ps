package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.model.Vehiculo;
import com.example.demo.service.to.VehiculoTO;

public interface IVehiculoService {

	public List<Vehiculo> buscarTodos();

	public Vehiculo buscarPorPlaca(String placa);
	
	public VehiculoTO convertir(Vehiculo vehiculo);
	
	public List<VehiculoTO> buscarTodos1();

}
