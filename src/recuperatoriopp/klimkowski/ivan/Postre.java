/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package recuperatoriopp.klimkowski.ivan;

/**
 *
 * @author yoivi
 */
public class Postre extends Producto implements IVendible{
    
    private TipoPostre tipoPostre;
    
    public Postre (String nombre, double precio, Fabricante fabricante, TipoPostre tipoPostre) {
        super(nombre, precio, fabricante);
        this.tipoPostre = tipoPostre;
    }
    
    @Override
    public double getPrecioTotal() {
        double precioTotal = this.precio;
        
        switch (tipoPostre) {
            case TIRAMISU:
                return precioTotal * 1.20; 
            case HELADO:
                return precioTotal * 1.15; 
            case FLAN:
                return precioTotal * 1.10; 
            default:
                return precioTotal; 
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("\n");
        sb.append("Tipo de postre: ").append(this.tipoPostre).append("\n");
        sb.append("Precio Total: $").append(this.getPrecioTotal());
        return sb.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof Postre)) {
            return false;
        }
        Postre otro = (Postre) obj;
        return this.tipoPostre == otro.tipoPostre;
    }
       
}
