package br.com.goldtarget.portaltransparencia.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.goldtarget.portaltransparencia.domain.CategoriaTermoColaborativo;
import br.com.goldtarget.portaltransparencia.repository.CategoriaTermoColaborativoRepository;


@RequestMapping("/categoriatermocolaborativo")


@RestController
public class CategoriaTermoColaborativoResources {
	@Autowired
	private CategoriaTermoColaborativoRepository categoriaTermoColaborativoRepository;
	
	@GetMapping
	public List<CategoriaTermoColaborativo> listarTodos(){
		return categoriaTermoColaborativoRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public CategoriaTermoColaborativo buscarPeloCodigo(@PathVariable long codigo) {
		return categoriaTermoColaborativoRepository.findById(codigo).orElse(null);
	}
	
	@PutMapping("/{codigo}")	
	public CategoriaTermoColaborativo atualizar(@PathVariable ("codigo") Long codigo,
			@RequestBody CategoriaTermoColaborativo categoriaTermoColaborativo) {
		return categoriaTermoColaborativoRepository.findById(codigo).map(
				record -> {
					record.setNomeCategoria(categoriaTermoColaborativo.getNomeCategoria());
					return categoriaTermoColaborativoRepository.save(record);
					}).orElse(null);
	}	

	}

