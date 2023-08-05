package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Vehiculo> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v", Vehiculo.class);

		List<Vehiculo> vehiculos = myQuery.getResultList();
		return vehiculos;
	}

	@Override
	public Vehiculo buscarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.placa =:datoPlaca", Vehiculo.class);

		myQuery.setParameter("datoPlaca", placa);
		return myQuery.getSingleResult();
	}

}
