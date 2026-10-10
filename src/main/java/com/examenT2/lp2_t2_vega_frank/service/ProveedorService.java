package com.examenT2.lp2_t2_vega_frank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.lp2_t2_vega_frank.model.ProveedorVegaFrank;
import com.examenT2.lp2_t2_vega_frank.repository.ProveedorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public List<ProveedorVegaFrank> getAll() {
        return proveedorRepository.findAll();
    }
}
