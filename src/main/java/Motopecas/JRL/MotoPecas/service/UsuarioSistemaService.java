/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.service;

import Motopecas.JRL.MotoPecas.entidade.cliente.Cliente;
import Motopecas.JRL.MotoPecas.repository.cliente.ClienteRepository;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author jrl
 */
@Service
public class UsuarioSistemaService implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Cliente c = clienteRepository.findByEmail(username);
        if (c != null) {
            return c;
        }
        throw new UsernameNotFoundException("Usuário não encontrado");
    }

}
