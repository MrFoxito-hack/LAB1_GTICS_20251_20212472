package com.example.lab1_gtics_20212472.controllers;

import com.example.lab1_gtics_20212472.models.OrderConfig;
import com.example.lab1_gtics_20212472.models.OrderSession;
import com.example.lab1_gtics_20212472.models.RatingForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PedidoController {

    @GetMapping("/")
    public String mostrarFormularioPedido(Model model) {
        model.addAttribute("pedido", new OrderConfig());
        return "formulariom";
    }

    @PostMapping("/procesar-pedido")
    public String procesarPedido(@ModelAttribute("pedido") OrderConfig pedido, Model model) {
        OrderSession resumen = new OrderSession();

        resumen.setNombreCliente(pedido.getNombreCliente());
        resumen.setNumeroMesa(pedido.getNumeroMesa());
        resumen.setListaProductos(pedido.getProductosSeleccionados());
        resumen.setTamanio(pedido.getTamanio());
        resumen.setCantidad(pedido.getCantidad());
        resumen.setOpcionesAdicionales(pedido.getOpcionesAdicionales());

        double precioBase = 6.0;  // tú puedes definir el precio
        double extra = 1.5;       // por cada adicional
        double total = (precioBase * resumen.getCantidad()) + (extra * resumen.getOpcionesAdicionales().size());
        resumen.setTotal(total);

        model.addAttribute("resumenPedido", resumen);
        model.addAttribute("formularioCalificacion", new RatingForm());

        return "resumenpedidom";
    }

    @PostMapping("/enviar-calificacion")
    public String recibirCalificacion(@ModelAttribute("formularioCalificacion") RatingForm calificacion, Model model) {
        model.addAttribute("mensaje", "¡Gracias por calificar con " + calificacion.getEstrellas() + " estrellas!");
        return "graciasm";
    }
}
