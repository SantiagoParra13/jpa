package com.santiago.springboot.app.datajpa.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santiago.springboot.app.datajpa.models.dao.IClienteDao;
import com.santiago.springboot.app.datajpa.models.entity.Cliente;

@Service
public class ClienteServiceImplements implements IClienteService {
    @Autowired
    private IClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {

        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findONe(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(long id) {

        clienteDao.deleteById(id);
    }

}
