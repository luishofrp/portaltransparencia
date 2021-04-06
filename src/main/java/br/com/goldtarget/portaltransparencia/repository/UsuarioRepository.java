package br.com.goldtarget.portaltransparencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.goldtarget.portaltransparencia.domain.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
