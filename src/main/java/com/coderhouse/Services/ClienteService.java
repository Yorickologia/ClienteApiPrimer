package com.coderhouse.Services;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.Repository.ClienteRepository;
import com.coderhouse.entidades.Cliente;

@Service
public class ClienteService {
	@Autowired
    private ClienteRepository clienteRepository;

	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();
	}

	public Cliente mostrarClientePorDNI(Integer dni) {
		return clienteRepository.findById(dni).orElse(null);
	}

	public Cliente agregarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
    public int calcularEdad(Cliente cliente) {
        LocalDate fechaNacimiento = cliente.getFechaDeNacimiento();
        LocalDate fechaActual = LocalDate.now();
        return Period.between(fechaNacimiento, fechaActual).getYears();
    }
}
