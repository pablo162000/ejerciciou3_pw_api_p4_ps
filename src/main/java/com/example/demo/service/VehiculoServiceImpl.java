package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IVehiculoRepository;
import com.example.demo.repository.model.Vehiculo;
import com.example.demo.service.to.VehiculoTO;

@Service
public class VehiculoServiceImpl implements IVehiculoService {
	@Autowired
	private IVehiculoRepository vehiculoRepository;

	@Override
	public List<Vehiculo> buscarTodos() {
		// TODO Auto-generated method stub
		return this.vehiculoRepository.buscarTodos();
	}

	@Override
	public Vehiculo buscarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		return this.vehiculoRepository.buscarPorPlaca(placa);
	}

	@Override
	public VehiculoTO convertir(Vehiculo vehiculo) {
		// TODO Auto-generated method stub

		VehiculoTO vehiculoTO = new VehiculoTO();
		vehiculoTO.setId(vehiculo.getId());
		vehiculoTO.setMarca(vehiculo.getMarca());
		vehiculoTO.setModelo(vehiculo.getModelo());
		vehiculoTO.setPlaca(vehiculo.getPlaca());
		vehiculoTO.setPrecio(vehiculo.getPrecio());

		return vehiculoTO;
	}

	@Override
	public List<VehiculoTO> buscarTodos1() {
		// TODO Auto-generated method stub
		List<Vehiculo> lista = buscarTodos();
		List<VehiculoTO> listavto= lista.stream().map(vehiculo-> this.convertir(vehiculo)).collect(Collectors.toList());
		
		return listavto;
	}

}
