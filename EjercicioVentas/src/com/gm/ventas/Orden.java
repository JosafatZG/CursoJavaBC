package com.gm.ventas;

public class Orden {
    private int idOrden;
    private static final int maxProductos = 5;
    private Producto[] productos;
    private static int contadorOrden;
    private static int contadorProducto;

    public Orden() {
        this.productos = new Producto[maxProductos];
        this.idOrden = ++contadorOrden;
    }

    public void agregarProducto(Producto producto){
        if(contadorProducto < maxProductos){
            this.productos[contadorProducto++] = producto;
        }
        else {
            System.out.println("Maximo de productos alcanzado: " + maxProductos);
        }
    }

    public double calcularTotal(){

        double total = 0;
        for (Producto producto :productos) {
            if(producto != null)
                total += producto.getPrecio();
        }
        return total;
    }

    @Override
    public String toString(){
        String msg;
        msg = "\nID Orden: " + idOrden;
        for (Producto producto:productos) {
            if (producto != null)
                msg += producto;
        }
        msg += "\nTotal: $" + calcularTotal();
        return msg;
    }
}
