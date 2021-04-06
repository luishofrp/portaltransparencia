package br.com.goldtarget.portaltransparencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.goldtarget.portaltransparencia.domain.Conta;

public interface ContaRepository extends JpaRepository <Conta, Long > {

}
