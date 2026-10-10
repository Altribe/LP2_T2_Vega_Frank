package com.examenT2.lp2_t2_vega_frank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.lp2_t2_vega_frank.model.RubroVegaFrank;
import com.examenT2.lp2_t2_vega_frank.repository.RubroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RubroService {

    private final RubroRepository rubroRepository;

    public List<RubroVegaFrank> getAll() {
        return rubroRepository.findAll();
    }
}
