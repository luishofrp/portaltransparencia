package br.com.goldtarget.portaltransparencia.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.goldtarget.portaltransparencia.domain.PrestadorDeServico;
import br.com.goldtarget.portaltransparencia.repository.PrestadorDeServicoRepository;

@RequestMapping ("/prestadordeservico")

@RestController
public class PrestadorDeServicoResource {
	
@Autowired
private PrestadorDeServicoRepository prestadorDeServicoRepository;

@GetMapping 
public List<PrestadorDeServico> listarTodos(){
	return prestadorDeServicoRepository.findAll();}
	
	@PutMapping("/{codigo}")	
	public PrestadorDeServico atualizar(@PathVariable ("codigo") Long codigo,
			@RequestBody PrestadorDeServico prestadorDeServico) {
		return prestadorDeServicoRepository.findById(codigo).map(
				record-> {
					record.setCpf_cnpj(prestadorDeServico.getCpf_cnpj());
					record.setEmail(prestadorDeServico.getEmail());
					record.setEndereco(prestadorDeServico.getEndereco());
					record.setNome(prestadorDeServico.getNome());
					record.setTelefone(prestadorDeServico.getTelefone());
					return prestadorDeServicoRepository.save(record);
				}).orElse(null);
				
				}
	@GetMapping("/{codigo}")
	public PrestadorDeServico buscarPeloCodigo(@PathVariable Long codigo) {
		return prestadorDeServicoRepository.findById(codigo).orElse(null);
	}
	
}
