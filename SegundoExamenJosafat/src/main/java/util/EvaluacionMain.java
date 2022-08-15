package util;

import dto.Departamento;
import dto.Empleado;
import service.CatalogoServicio;
import service.Servicio;

import java.sql.SQLException;

import javax.swing.*;

public class EvaluacionMain {
    public static void main(String[] args) throws SQLException {
        int opcion = 0;

        Servicio servicio = new CatalogoServicio();
        /*
        System.out.println("Prueba listar");
        Empleado empleado = new Empleado();
        Departamento departamento = new Departamento();

        servicio.listar(empleado).forEach(System.out::println);
        servicio.listar(departamento).forEach(System.out::println);

        String nombre = JOptionPane.showInputDialog("Ingresa el nombre: ");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido: ");
        String pago = JOptionPane.showInputDialog("Ingrese la forma de pago: ");*/

        do{
            String opcionesText = "\nOpciones";
            opcionesText += "\n\nDEPARTAMENTOS";
            opcionesText += "\n1. Agregar departamento";
            opcionesText += "\n2. Editar departamento";
            opcionesText += "\n3. Listar departamentos";
            opcionesText += "\n4. Buscar departamento por id";
            opcionesText += "\n5. Eliminar departamento";
            opcionesText += "\n\nEMPLEADOS";
            opcionesText += "\n6. Agregar empleado";
            opcionesText += "\n7. Editar empleado";
            opcionesText += "\n8. Listar empleados";
            opcionesText += "\n9. Buscar empleado por id";
            opcionesText += "\n10. Eliminar empleado\n";
            opcionesText += "\n11. SALIR";

            opcion = Integer.parseInt(JOptionPane.showInputDialog(opcionesText));
            Empleado empleado = new Empleado();
            Departamento departamento = new Departamento();
            switch (opcion){
                case 1:
                    departamento.setDepartamento(JOptionPane.showInputDialog("Nombre del departamento: "));
                    servicio.guardar(departamento);
                    System.out.println("Departamento guardado con exito: " + departamento.getId());
                    break;
                case 2:
                    departamento.setId(Long.valueOf(JOptionPane.showInputDialog("id departamento: ")));
                    departamento.setDepartamento(JOptionPane.showInputDialog("Nombre del departamento: "));
                    servicio.guardar(departamento);
                    System.out.println("Departamento editado con exito: " + departamento.getId());
                    break;
                case 3:
                    servicio.listar(departamento).forEach(System.out::println);
                    break;
                case 4:
                    departamento.setId(Long.valueOf(JOptionPane.showInputDialog("id departamento a buscar: ")));
                    System.out.println(servicio.porId(departamento));
                    break;
                case 5:
                    departamento.setId(Long.valueOf(JOptionPane.showInputDialog("Id departamento a ELIMINAR: ")));
                    servicio.eliminar(departamento);
                    System.out.println("Departamento eliminado, id: " + departamento.getId());
                    break;
                case 6:
                    empleado.setNombre(JOptionPane.showInputDialog("Nombre: "));
                    empleado.setApellido(JOptionPane.showInputDialog("Apellido: "));
                    empleado.setDireccion(JOptionPane.showInputDialog("Direccion: "));
                    empleado.setEmail(JOptionPane.showInputDialog("Email: "));
                    departamento.setId(Long.valueOf(JOptionPane.showInputDialog("id departamento: ")));
                    departamento.setDepartamento(JOptionPane.showInputDialog("Nombre departamento: "));
                    empleado.setDepartamento(departamento);
                    servicio.guardar(empleado);
                    System.out.println("Empleado guardado con exito: " + empleado.getId());
                    break;
                case 7:
                    empleado.setId(Long.valueOf(JOptionPane.showInputDialog("Id empleado: ")));
                    Empleado empleadoTemp = (Empleado) servicio.porId(empleado);
                    empleado.setNombre(JOptionPane.showInputDialog("Nombre: ", empleadoTemp.getNombre()));
                    empleado.setApellido(JOptionPane.showInputDialog("Apellido: ", empleadoTemp.getApellido()));
                    empleado.setDireccion(JOptionPane.showInputDialog("Direccion: ", empleadoTemp.getDireccion()));
                    empleado.setEmail(JOptionPane.showInputDialog("Email: ", empleadoTemp.getEmail()));
                    departamento.setId(Long.valueOf(JOptionPane.showInputDialog("id departamento: ", empleadoTemp.getDepartamento().getId())));
                    departamento.setDepartamento(JOptionPane.showInputDialog("Nombre departamento: ", empleadoTemp.getDepartamento().getDepartamento()));
                    empleado.setDepartamento(departamento);
                    servicio.guardar(empleado);
                    System.out.println("Empleado editado con exito: " + empleado.getId());
                    break;
                case 8:
                    servicio.listar(empleado).forEach(System.out::println);
                    break;
                case 9:
                    empleado.setId(Long.valueOf(JOptionPane.showInputDialog("id empleado a buscar: ")));
                    System.out.println(servicio.porId(empleado));
                    break;
                case 10:
                    empleado.setId(Long.valueOf(JOptionPane.showInputDialog("Id empleado a ELIMINAR: ")));
                    servicio.eliminar(empleado);
                    System.out.println("Empleado eliminado, id: " + empleado.getId());
                    break;
                case 11:
                    System.out.println("Gracias por utilizar este programa");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (opcion != 11);
    }
}
