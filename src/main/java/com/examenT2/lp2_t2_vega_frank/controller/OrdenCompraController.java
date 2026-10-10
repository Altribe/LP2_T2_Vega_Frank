package com.examenT2.lp2_t2_vega_frank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examenT2.lp2_t2_vega_frank.model.OrdenCompraVegaFrank;
import com.examenT2.lp2_t2_vega_frank.service.OrdenCompraService;
import com.examenT2.lp2_t2_vega_frank.service.ProveedorService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("ordencompra")
@RequiredArgsConstructor
public class OrdenCompraController {

    private final OrdenCompraService ordenCompraService;
    private final ProveedorService proveedorService;

    @GetMapping("listado")
    public String listado(Model model) {
        model.addAttribute("lstOrdenes", ordenCompraService.getAll());

        return "ordencompra/listadoVegaFrank";
    }

    @GetMapping("nuevo")
    public String nuevo(Model model) {
        model.addAttribute("lstProveedores", proveedorService.getAll());
        model.addAttribute("ordenCompra", new OrdenCompraVegaFrank());

        return "ordencompra/nuevoVegaFrank";
    }

    @PostMapping("registrar")
    public String registrar(
            @ModelAttribute OrdenCompraVegaFrank ordenCompra,
            RedirectAttributes flash) {

        var response = ordenCompraService.create(ordenCompra);

        flash.addFlashAttribute("mensaje", response.mensaje());
        flash.addFlashAttribute("success", response.success());

        return "redirect:/ordencompra/listado";
    }

    @GetMapping("edicion/{id}")
    public String edicion(@PathVariable Integer id, Model model) {

        var ordenCompra = ordenCompraService.getOne(id);

        if (ordenCompra == null) {
            return "redirect:/ordencompra/listado";
        }

        model.addAttribute("lstProveedores", proveedorService.getAll());
        model.addAttribute("ordenCompra", ordenCompra);

        return "ordencompra/edicionVegaFrank";
    }

    @PostMapping("guardar")
    public String guardar(
            @ModelAttribute OrdenCompraVegaFrank ordenCompra,
            RedirectAttributes flash) {

        var response = ordenCompraService.update(ordenCompra);

        flash.addFlashAttribute("mensaje", response.mensaje());
        flash.addFlashAttribute("success", response.success());

        return "redirect:/ordencompra/listado";
    }
}
