package ventas;
import com.gm.ventas.*;

public class Ventas {
    public static void main(String[] args) {
        Producto p1 = new Producto("Manzana", 1.5);
        Producto p2 = new Producto("Pescado", 2.5);
        Producto p3 = new Producto("Salchicha", 1);
        Producto p4 = new Producto("Pollo", 1.35);
        Producto p5 = new Producto("Sal", 0.65);

        Orden o1 = new Orden();
        o1.agregarProducto(p1);
        o1.agregarProducto(p2);
        o1.agregarProducto(p3);

        Orden o2 = new Orden();
        o2.agregarProducto(p4);
        o2.agregarProducto(p5);
        o2.agregarProducto(p1);

        System.out.println(o1);
        System.out.println(o2);
    }
}