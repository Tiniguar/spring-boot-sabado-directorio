package com.company.intecap.directorio.models.dao;


import com.company.intecap.directorio.models.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface IClienteDao extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByNombreCompleto(String nombreCompleto);

}
