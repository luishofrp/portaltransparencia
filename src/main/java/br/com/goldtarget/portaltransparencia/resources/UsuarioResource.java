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

import br.com.goldtarget.portaltransparencia.domain.Usuario;
import br.com.goldtarget.portaltransparencia.repository.UsuarioRepository;
@RequestMapping("/usuario")





@RestController
public class UsuarioResource {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<Usuario> listarTodos(){
		return usuarioRepository.findAll();

}
	@PostMapping
		public Usuario cadastrarUsuario (@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
		
		
			}
	@PutMapping("/{codigo}")	
		public Usuario atualizar(@PathVariable ("codigo") Long codigo,
				@RequestBody Usuario usuario) {
			return usuarioRepository.findById(codigo).map(
					record -> {
						record.setCargo(usuario.getCargo());
						record.setNome(usuario.getNome());
						record.setCpf(usuario.getCpf());
						record.setEmail(usuario.getEmail());
						record.setTelefone(usuario.getTelefone());
						return usuarioRepository.save(record);
					}).orElse(null);
		}
	@GetMapping("/{codigo}")
	public Usuario buscarPeloCodigo(@PathVariable Long codigo) {
		return usuarioRepository.findById(codigo).orElse(null);
		
	}
	
		
}