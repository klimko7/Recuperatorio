/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package recuperatoriopp.klimkowski.ivan;

/**
 *
 * @author yoivi
 */
public class Fabricante {
    
    private String nombre;
    private String ciudad;
    private int antiguedad;

    public Fabricante(String nombre, String ciudad, int antiguedad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.antiguedad = antiguedad;
    }
    
    public static boolean sonIguales(Fabricante f1, Fabricante f2) {
    if (f1 == null || f2 == null) {
        return false;
    }
    return f1.equals(f2); 
}
    
    private String getInfoFabricante() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(this.nombre).append("\n");
        sb.append("Ciudad: ").append(this.ciudad).append("\n");
        sb.append("Antigüedad: ").append(this.antiguedad).append(" años");
        return sb.toString();
    }
    
    public String toString() {
        return this.getInfoFabricante();
}
    
}
