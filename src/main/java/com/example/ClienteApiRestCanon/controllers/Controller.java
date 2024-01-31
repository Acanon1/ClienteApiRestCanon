package com.example.ClienteApiRestCanon.controllers;

import com.example.ClienteApiRestCanon.modelos.Cliente;
import com.example.ClienteApiRestCanon.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    private Repository repo;

    @GetMapping
    public  String index(){
        return "Conectado";
    }
    @GetMapping("clientes")
    public List<Cliente> getClientes(){
        return  repo.findAll();
    }
}
