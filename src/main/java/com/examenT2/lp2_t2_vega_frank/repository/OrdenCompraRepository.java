package com.examenT2.lp2_t2_vega_frank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examenT2.lp2_t2_vega_frank.model.OrdenCompraVegaFrank;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompraVegaFrank, Integer> {

    List<OrdenCompraVegaFrank> findAllByOrderByNroOrdenDesc();

}
