package com.example.lab1_gtics_20212472.models;

import java.util.List;

public class OrderConfig {
    private String nombreCliente;
    private int numeroMesa;
    private List<String> productosSeleccionados;
    private String tamanio;
    private int cantidad;
    private List<String> opcionesAdicionales;

    // Getter y Setter para nombreCliente
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    // Getter y Setter para numeroMesa
    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    // Getter y Setter para productosSeleccionados
    public List<String> getProductosSeleccionados() {
        return productosSeleccionados;
    }

    public void setProductosSeleccionados(List<String> productosSeleccionados) {
        this.productosSeleccionados = productosSeleccionados;
    }

    // Getter y Setter para tamanio
    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    // Getter y Setter para cantidad
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Getter y Setter para opcionesAdicionales
    public List<String> getOpcionesAdicionales() {
        return opcionesAdicionales;
    }

    public void setOpcionesAdicionales(List<String> opcionesAdicionales) {
        this.opcionesAdicionales = opcionesAdicionales;
    }
}
