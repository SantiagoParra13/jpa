package com.santiago.springboot.app.datajpa.models.dao;



import org.springframework.data.repository.CrudRepository;

import com.santiago.springboot.app.datajpa.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

    

}

   
