package com.examenT2.lp2_t2_vega_frank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.lp2_t2_vega_frank.dto.ResultadoResponse;
import com.examenT2.lp2_t2_vega_frank.model.OrdenCompraVegaFrank;
import com.examenT2.lp2_t2_vega_frank.repository.OrdenCompraRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdenCompraService {

    private final OrdenCompraRepository ordenCompraRepository;

    public List<OrdenCompraVegaFrank> getAll() {
        return ordenCompraRepository.findAllByOrderByNroOrdenDesc();
    }

    @Transactional
    public ResultadoResponse create(OrdenCompraVegaFrank ordenCompra) {
        try {
            var registrado = ordenCompraRepository.save(ordenCompra);

            var mensaje = String.format(
                "Orden de compra Nro. %d registrada.",
                registrado.getNroOrden()
            );

            return new ResultadoResponse(true, mensaje);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultadoResponse(
                false, "Hubo un error en la transacción"
            );
        }
    }

    public OrdenCompraVegaFrank getOne(Integer id) {
        return ordenCompraRepository.findById(id).orElse(null);
    }

    @Transactional
    public ResultadoResponse update(OrdenCompraVegaFrank ordenCompra) {
        try {
            var actualizado = ordenCompraRepository.save(ordenCompra);

            var mensaje = String.format(
                "Orden de compra Nro. %d actualizada.",
                actualizado.getNroOrden()
            );

            return new ResultadoResponse(true, mensaje);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultadoResponse(
                false, "Hubo un error en la transacción"
            );
        }
    }
}
