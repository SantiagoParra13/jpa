package com.santiago.springboot.app.datajpa.models.service;

import java.util.List;

import com.santiago.springboot.app.datajpa.models.entity.Cliente;

public interface IClienteService {
    public List<Cliente> findAll();

    public void save(Cliente cliente);

    public Cliente findONe(Long id);

    public void delete(long id);
}
