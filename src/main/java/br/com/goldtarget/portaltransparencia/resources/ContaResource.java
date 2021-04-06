package br.com.goldtarget.portaltransparencia.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.goldtarget.portaltransparencia.domain.Conta;
import br.com.goldtarget.portaltransparencia.repository.ContaRepository;


@RequestMapping ("/conta")

@RestController

public class ContaResource {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@GetMapping
	public List<Conta> listarTodos(){
		return contaRepository.findAll();
		
	}
	
	@GetMapping
	public Conta buscarPeloCodigo(@PathVariable Long codigo) {
		return contaRepository.findById(codigo).orElse(null);
		
	}
	
	@PutMapping("/{codigo}")
	public Conta atualizar(@PathVariable ("codigo") Long codigo,
			@RequestBody Conta conta) {
		return contaRepository.findById(codigo).map(
				record -> {
					record.setDataPgto(conta.getDataPgto());
					record.setDataVencimento(conta.getDataVencimento());
					record.setNomeConta(conta.getNomeConta());
					record.setValor(conta.getValor());
					record.setNumero_nota(conta.getNumero_nota());
					record.setNumero_documento(conta.getNumero_documento());
					record.setInseridaPor(conta.getInseridaPor());
					record.setPrestadorDeServico(conta.getPrestadorDeServico());
					record.setCategoriaTermoColaborativo(conta.getCategoriaTermoColaborativo());
					record.setTermoColaborativo(conta.getTermoColaborativo());
					
					return contaRepository.save(record);
				}).orElse(null);
		
		
				
				
	
			
		}
	
	@PostMapping 
	public Conta cadastrarConta (@RequestBody Conta conta) {
		return contaRepository.save(conta);
		
	
	}
	
	

}
