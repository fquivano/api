package apiForo2.api.domain.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void crearUsuario(String login, String clave) {
        String claveEncriptada = passwordEncoder.encode(clave);
        Usuario usuario = new Usuario(login, claveEncriptada);
        usuarioRepository.save(usuario);
    }
}