package com.pruebas.springboot.jpa.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pruebas.springboot.jpa.dto.UserDto;
import com.pruebas.springboot.jpa.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	
	@Query("select u from User u where u.email=?1")
	Optional<User> findByEmail(String email);
	
	@Query("select u from User u where u.nombre like %?1%")
	List<User> findAndSort(String name, Sort sort);
	
	List<User> findByNombre(String nombre);
	
	Optional<User> findByEmailAndNombre(String email, String nombre);
	
	List<User> findByNombreLike(String nombre);
	
	List<User> findByNombreLikeOrNombreLike(String nombre1, String nombre2);
	
	List<User> findByFechaCumpleaniosBetween(LocalDate begin, LocalDate end);
	
	List<User> findByNombreContainingIgnoreCaseOrderByIdDesc(String nombre);
	
	@Query("select new com.pruebas.springboot.jpa.dto.UserDto(u.id,u.nombre,u.fechaCumpleanios)"
			+ " from User u "
			+ " where u.fechaCumpleanios=:fecha"
			+ " and u.email=:email")
	Optional<UserDto> getAllByFechaCumpleaniosAndEmail(@Param("fecha")LocalDate date,@Param("email") String email);

}
