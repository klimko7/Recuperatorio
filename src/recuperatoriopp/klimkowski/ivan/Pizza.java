/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package recuperatoriopp.klimkowski.ivan;

/**
 *
 * @author yoivi
 */
public class Pizza extends Producto implements IVendible{
    
    private TipoPizza sabor;
    private TamañoPizza tamaño;
    
    
    public Pizza (String nombre, double precio, Fabricante fabricante, TipoPizza sabor, TamañoPizza tamaño) {
        super(nombre, precio, fabricante);
        this.sabor = sabor;
        this.tamaño = tamaño;
    }
    
    @Override
    public double getPrecioTotal() {
        
        double precioTotal = this.precio;
        
        return switch (this.tamaño) {
            
            case CHICA -> precioTotal * 1.05;
            case MEDIANA -> precioTotal * 1.10;
            case GRANDE -> precioTotal * 1.20;
            default -> precioTotal;
        };
     }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("\n");
        sb.append("Tipo de pizza: ").append(this.sabor).append("\n");
        sb.append("Tamaño de la pizza: ").append(this.tamaño).append("\n");
        sb.append("Precio Total: $").append(this.getPrecioTotal());
        return sb.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Pizza)) {
            return false;
        }
        Pizza otro = (Pizza) obj;
        return super.equals(otro) && this.sabor.equals(otro.sabor) && this.tamaño.equals(otro.tamaño);

    }
    
    
    
}
