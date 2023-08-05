package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.model.Vehiculo;

public interface IVehiculoRepository {
	
	public List<Vehiculo> buscarTodos();
	
	public Vehiculo buscarPorPlaca(String placa);

}
