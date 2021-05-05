package com.everis.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.everis.data.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
