package ar.edu.unju.fi.html.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.Usuario;
import ar.edu.unju.fi.html.repository.IUsuarioDAO;

@Service
public class LoginUsuariosServiceImp implements UserDetailsService{
    
	@Autowired
    IUsuarioDAO iUsuario;		
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//Buscar 
		Usuario usuarioEncontrado = iUsuario.findById(Long.parseLong(username)).orElseThrow(()-> new UsernameNotFoundException("Usuario no existe."));
		
		List<GrantedAuthority> tipos = new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioEncontrado.getTipo()); 
		tipos.add(grantedAuthority);
		
		UserDetails user = (UserDetails) new User(username,usuarioEncontrado.getContraseña(),tipos);
		return user;
	}
     
}
