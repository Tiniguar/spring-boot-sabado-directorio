package com.company.intecap.directorio.models.service;

import com.company.intecap.directorio.models.entity.Cliente;

import java.util.List;

public interface IClienteService {
    public List<Cliente> findAll();

    public void save(Cliente cliente);

    public  Cliente findOne(Long id);

    public  void delete(Long id);

    //Metodo para verificar si existe un cliente con el mismo nombre
    public boolean existeClienteConNombreCompleto(String nombreCompleto);
}
