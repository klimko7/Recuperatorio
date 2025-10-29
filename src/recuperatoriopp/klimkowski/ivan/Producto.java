/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package recuperatoriopp.klimkowski.ivan;

import java.util.Random;

/**
 *
 * @author yoivi
 */
 public abstract class Producto {
    
    protected Fabricante fabricante;
    protected String nombre;
    protected double precio;
    protected int calorias;
    protected int tiempoPreparacion;
    protected static Random generadorAleatorio;
    
    static {
        generadorAleatorio = new Random();
    }
    
    public Producto(String nombre, double precio, Fabricante fabricante) {
        this.nombre = nombre;
        this.precio = precio;
        this.fabricante = fabricante;
        this.calorias = 0;
        this.tiempoPreparacion = 0;
    }
    
    public Producto(String nombre, double precio, Fabricante fabricante, String nombreFabricante, String ciudadFabricante, int antiguedadFabricante) {
        this(nombre, precio, new Fabricante(nombreFabricante, ciudadFabricante, antiguedadFabricante));
    }
    
    public int getCalorias() {
    if (this.calorias == 0) {
        this.calorias = Producto.generadorAleatorio.nextInt(601) + 200; // 200 a 800
    }
    return this.calorias;
}
    
    public int getTiempoPreparacion() {
    if (this.tiempoPreparacion == 0) {
        this.tiempoPreparacion = Producto.generadorAleatorio.nextInt(16) + 5; // 5 a 20
    }
    return this.tiempoPreparacion;
}
    
    private static String mostrar(Producto p) {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(p.nombre).append("\n");
        sb.append("Precio: $").append(p.precio).append("\n");
        sb.append("Calorias: ").append(p.calorias).append("\n");
        sb.append("Tiempo de Preparación: ").append(p.tiempoPreparacion).append("\n");
        sb.append("Fabricante: ").append(p.fabricante.toString()).append("\n");
        return sb.toString();
        
    }
    
    private static boolean sonIguales(Producto p1, Producto p2) {
    if (p1 == null || p2 == null) {
        return false;
    }
    return p1.equals(p2) && Fabricante.sonIguales(p1.fabricante, p2.fabricante); 
    }
    
    @Override
    public boolean equals(Object obj) {
    if (obj == null) {
        return false;
    }
    if (!(obj instanceof Producto)) {
        return false;
    }
    Producto otro = (Producto) obj;
    return this.nombre.equals(otro.nombre) && Fabricante.sonIguales(this.fabricante, otro.fabricante);
}

    @Override
    public String toString() {
        return Producto.mostrar(this);
    }
 }
