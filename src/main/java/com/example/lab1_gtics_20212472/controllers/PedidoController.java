package com.example.lab1_gtics_20212472.controllers;

//improtamos
import com.example.lab1_gtics_20212472.models.OrderConfig;
import com.example.lab1_gtics_20212472.models.OrderSession;
import com.example.lab1_gtics_20212472.models.RatingForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//se coloca controller  para que sea reconocida por spring como un controlador
@Controller
public class PedidoController {

    //no piden mapear rutas
    //usamos la forma reducidad los rewquestmapping, sabemos que para que peuda gesrionar una solicitud HTTP, se debe indicar la ruta web q identiifcara el controlador
    @GetMapping("/")
    public String mostrarFormularioPedido(Model model) {
        model.addAttribute("pedido", new OrderConfig());
        return "formulariom"; //no es necesario colocar el html
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

        //colocamos de precios a nuestra eleccion (aqui podremos cambiarlo)
        double precioBase = 6.0;

        double extra = 1.0;
        //formula dada
        double total = (precioBase * resumen.getCantidad()) + (extra * resumen.getOpcionesAdicionales().size());
        resumen.setTotal(total);

        model.addAttribute("resumenPedido", resumen);
        model.addAttribute("formularioCalificacion", new RatingForm());

        return "resumenpedidom"; //no es necesario colocar el html
    }




    @PostMapping("/enviar-calificacion")

    public String recibirCalificacion(@ModelAttribute("formularioCalificacion") RatingForm calificacion, Model model) {
        model.addAttribute("mensaje", "Gracias por colocarle " + calificacion.getEstrellas() + " estrellas!");
        return "graciasm"; //no es necesario colocar el html
    }
}
