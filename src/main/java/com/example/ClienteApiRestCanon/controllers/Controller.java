package com.example.ClienteApiRestCanon.controllers;

import com.example.ClienteApiRestCanon.modelos.Cliente;
import com.example.ClienteApiRestCanon.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controller {
    @Autowired
    private Repository repo;

    @GetMapping
    public  String index(){
        return "Conectado";
    }
    @GetMapping("clientes")
    public List<Cliente> getClientes() {
        List<Cliente> clientes = repo.findAll();
        return clientes.stream()
                .map(this::calcularEdadCliente)
                .collect(Collectors.toList());
    }
    private int calcularEdad(LocalDate fechaNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        return fechaActual.getYear() - fechaNacimiento.getYear();
    }
    private Cliente calcularEdadCliente(Cliente cliente) {
        if (cliente.getFechaNacimiento() != null) {
            int edadP = calcularEdad(cliente.getFechaNacimiento());
            cliente.setEdad(edadP);
        }

        return cliente;
    }



}
