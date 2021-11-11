package com.cinyema.app.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinyema.app.entidades.Asiento;
import com.cinyema.app.entidades.Pelicula;

@Repository
public interface AsientoRepositorio extends JpaRepository<Asiento, Long>{

	@Query("SELECT a FROM Asiento a where a.numeroDeAsiento = :numeroDeAsiento")
	public Asiento buscarPorNumeroDeAsiento(@Param("numeroDeAsiento") Integer numeroDeAsiento);
	
	@Query("SELECT a FROM Asiento a WHERE a.libre = :true")
	public List<Pelicula> listarAsientosLibres();
	
	@Query("SELECT a FROM Asiento a WHERE a.libre = :false")
	public List<Pelicula> listarAsientosOcupados();
}
