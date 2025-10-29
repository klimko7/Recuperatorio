/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package recuperatoriopp.klimkowski.ivan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author yoivi
 */
public class Pizzeria implements Iterable<Producto>{
    
    //Profe, por los nervios, me olvide que la ñ no es soportado por el sistema, entonces al correr se printea un simbolo de interrogacion, eso solo
    
    private String nombre;
    private int capacidad;
    private Collection<Producto> productos;
    
    public Pizzeria(String nombre) {
        this.nombre = nombre;
        this.capacidad = 3;
        this.productos = new ArrayList<>();
    }
     
    public Pizzeria(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.productos = new ArrayList<>();
    } 
    
    private boolean sonIguales(Producto producto) {
        for (Producto p : productos) {
            if (p.equals(producto)) {
                return true;
            }
        }
        return false;
    }
    
    public void agregar(Producto producto) {
        if (productos.size() >= capacidad) {
            System.out.println("No se puede agregar el producto. Capacidad máxima alcanzada.");
            return;
        }
        
        if (sonIguales(producto)) {
            System.out.println("El producto ya se encuentra en la pizzería.");
            return;
        }
        
        productos.add(producto);
        System.out.println("Producto agregado correctamente.");
    }
    
     private double getPrecioProductos(TipoProducto tipo) {
        double total = 0.0;
        
        switch (tipo) {
            
            case PIZZAS -> total = this.getPrecioDePizzas();
            case POSTRES -> total = this.getPrecioDePostres();
            case TODOS -> total = this.getPrecioTotal();
        }
        
        return total;
    }
    
    private double getPrecioDePizzas() {
        
        double total = 0.0;
        
        for (Producto producto : this.productos) {
            if (producto instanceof Pizza pizza) {
                total += pizza.getPrecioTotal();
            }
        }
        
        return total;
    }
    
    private double getPrecioDePostres() {
        double total = 0.0;
        
        for (Producto producto : this.productos) {
            if (producto instanceof Postre postre) {
                total += postre.getPrecioTotal();
            }
        }
        
        return total;
    }
    
    private double getPrecioTotal() {
        return this.getPrecioDePizzas() + this.getPrecioDePostres();
    }
    
    
    @Override
    public Iterator<Producto> iterator() {
        return productos.iterator();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        // Información básica de la pizzería
        sb.append("=== PIZZERÍA === ").append(nombre.toUpperCase()).append(" ===\n");
        sb.append("Capacidad: ").append(capacidad).append("\n");
        sb.append("Productos almacenados: ").append(productos.size()).append("\n\n");
        
        // Detalle de productos
        sb.append("=== DETALLE DE PRODUCTOS ===\n");
        if (productos.isEmpty()) {
            sb.append("No hay productos almacenados.\n");
        } else {
            int contador = 1;
            for (Producto producto : productos) {
                sb.append(contador).append(". ").append(producto.toString()).append("\n");
                contador++;
            }
        }
        
        sb.append("\n=== PRECIOS TOTALES ===\n");
        sb.append("Pizzas: $").append(this.getPrecioDePizzas()).append("\n");
        sb.append("Postres: $").append(this.getPrecioDePostres()).append("\n");
        sb.append("TOTAL: $").append(this.getPrecioTotal());
        
        return sb.toString();
    }
}
