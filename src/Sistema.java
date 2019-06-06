import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Sistema {

    LinkedList<Cuenta> cuentas = new LinkedList<>();
    LinkedList<Cuenta> ejecutivos = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);
    Random rd = new Random();
    // Sujerir almacenar el numero de clientes y actualizarlo al leer los archivos
    int numeroCliente = 1;
    int numeroTarjeta = 1;
    Debito b = new Debito();
    Credito c = new Credito();
    Nomina n = new Nomina();

    public void creaCuenta() {

    }

    public Cuenta consulta(String dato, int id) {
        switch (id) {
        // Busqueda por tipo de cuenta.
        case 1:
            break;
        // Busqueda por nombre del cliente.
        case 2:
            break;
        // Busqueda por RFC ejecutivo.
        case 3:
            break;
        // Busqueda por RFC de la empresa.
        case 4:
            break;
        // Busqueda por estado
        default:
            break;
        }
        return null;
    }

    public Cuenta consulta(int dato, int id) {
        switch (id) {
        // Busqueda por numero de cliente.
        case 1:
            break;
        // Busqueda por numero de cuenta.
        case 2:
            break;
        // Busqueda por numero de sucursal.
        case 3:
            break;
        }
        return null;
    }

    public boolean cuentaInvalida(String cuenta) {
        switch (cuenta) {
        case "debito":
            return false;
        case "credito":
            return false;
        case "nomina":
            return false;
        default:
            return true;
        }
    }

    public void menu() {
        System.out.println("Bienvenido al sistema, por favor seleccione una opcion");
        System.out.println("1) Consulta");
        System.out.println("2) Dar de alta una cuenta");
        System.out.println("3) Actualizar datos de cuenta");
        System.out.println("4) Registrar una nueva apertura de cuenta");
        System.out.println("5) Dar de alta un nuevo empleado");
        System.out.println("6) Actualizar datos de empleado");
        System.out.println("7) Salir");
    }

    public void menuDebito() {
        System.out.println("1) nombre del cliente");
        System.out.println("2) numero de cuenta");
        System.out.println("3) fecha de corte");
        System.out.println("4) estado");
        System.out.println("5) correo");
        System.out.println("6) telefono");
    }

    public boolean continuaActualizando() {
        int eleccion = sc.nextInt();
        System.out.println("¿Quieres actualizar otro dato de la cuenta?");
        System.out.println("1) Si");
        System.out.println("2) No");
        while (eleccion != 1 || eleccion != 2) {
            System.out.println("Opcion invalida");
            System.out.println("¿Quieres actualizar otro dato de la cuenta?");
            System.out.println("1) Si");
            System.out.println("2) No");
            eleccion = sc.nextInt();
        }
        if (eleccion == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean actualizaDebito(int opcion, Debito c) {
        switch (opcion) {
        case 1:
            System.out.println("Introduza el nuevo nombre");
            String nombre = sc.nextLine();
            c.setNombreCliente(nombre);
            break;
        case 2:
            System.out.println("Introduza el nuevo numero de cuenta");
            int numeroCuenta = sc.nextInt();
            c.setNumeroCuenta(numeroCuenta);
            break;
        case 3:
            System.out.println("Introduza la nueva fecha de corte");
            String fechaCorte = sc.nextLine();
            c.setFechaCorte(fechaCorte);
            break;
        case 4:
            System.out.println("Introduza el nuevo estado");
            System.out.println("1)Activo");
            System.out.println("2) Inactivo");
            // Falta quitar mayusculas y acentos
            int estado = sc.nextInt();
            while (estado != 1 || estado != 2) {
                System.out.println("Opcion invalida");
                System.out.println("Introduza el nuevo estado");
                System.out.println("(Activo, Inactivo");
                // Falta quitar mayusculas y acentos
                estado = sc.nextInt();
            }
            if (estado == 1) {
                c.setEstado(true);
            } else {
                c.setEstado(false);
            }
            break;
        case 5:
            System.out.println("Introduza el nuevo correo electronico");
            String correo = sc.nextLine();
            c.setCorreoElectronico(correo);
            break;
        default:
            System.out.println("Introduza el nuevo numero telefonico");
            int telefono = sc.nextInt();
            c.setNumeroTelefono(telefono);
            break;
        }
        return continuaActualizando();
    }

    public void menuCredito() {
        System.out.println("1) nombre del cliente");
        System.out.println("2) importe de credito");
        System.out.println("3) monto de credito");
        System.out.println("4) fecha de pago");
        System.out.println("5) fecha de vencimiento");
        System.out.println("6) estado");
        System.out.println("7) correo");
        System.out.println("8) telefono");
    }

    public boolean actualizaCredito(int opcion, Credito c) {
        switch (opcion) {
        case 1:
            System.out.println("Introduza el nuevo nombre");
            String nombre = sc.nextLine();
            c.setNombreCliente(nombre);
            break;
        case 2:
            System.out.println("Introduza el nuevo importe de credito");
            int importeCredito = sc.nextInt();
            c.setImporteCredito(importeCredito);
            break;
        case 3:
            System.out.println("Introduza el nuevo monto de credito");
            int montoCredito = sc.nextInt();
            c.setImporteCredito(montoCredito);
            break;
        case 4:
            System.out.println("Introduza la nueva fecha de pago");
            String fechaPago = sc.nextLine();
            c.setFechaPago(fechaPago);
            break;
        case 5:
            System.out.println("Introduza la nueva fecha de vencimiento");
            String fechaVencimiento = sc.nextLine();
            c.setFechaVencimiento(fechaVencimiento);
            break;
        case 6:
            System.out.println("Introduza el nuevo estado");
            System.out.println("1)Activo");
            System.out.println("2) Inactivo");
            // Falta quitar mayusculas y acentos
            int estado = sc.nextInt();
            while (estado != 1 || estado != 2) {
                System.out.println("Opcion invalida");
                System.out.println("Introduza el nuevo estado");
                System.out.println("(Activo, Inactivo");
                // Falta quitar mayusculas y acentos
                estado = sc.nextInt();
            }
            if (estado == 1) {
                c.setEstado(true);
            } else {
                c.setEstado(false);
            }
            break;
        case 7:
            System.out.println("Introduza el nuevo correo electronico");
            String correo = sc.nextLine();
            c.setCorreoElectronico(correo);
            break;
        default:
            System.out.println("Introduza el nuevo numero telefonico");
            int telefono = sc.nextInt();
            c.setNumeroTelefono(telefono);
            break;

        }
        return continuaActualizando();
    }

    public void menuNomina() {
        System.out.println("1) nombre del cliente");
        System.out.println("2) numero de cuenta");
        System.out.println("3) correo");
        System.out.println("4) telefono");
        System.out.println("5) RFC de la empresa");
        System.out.println("6) nombre de la empresa");
        System.out.println("7) fecha de deposito");
        System.out.println("8) estado");
    }

    public boolean actualizaNomina(int opcion, Nomina n) {
        switch (opcion) {
        case 1:
            System.out.println("Introduza el nuevo nombre");
            String nombre = sc.nextLine();
            n.setNombreCliente(nombre);
            break;
        case 2:
            System.out.println("Introduza el nuevo numero de cuenta");
            int numeroCuenta = sc.nextInt();
            n.setNumeroCuenta(numeroCuenta);
            break;
        case 3:
            System.out.println("Introduza el nuevo correo electronico");
            String correo = sc.nextLine();
            c.setCorreoElectronico(correo);
            break;
        case 4:
            System.out.println("Introduza el nuevo numero telefonico");
            int telefono = sc.nextInt();
            c.setNumeroTelefono(telefono);
            break;
        case 5:
            System.out.println("Introduza el nuevo RFC de la empresa");
            String rfc = sc.nextLine();
            n.setRfc(rfc);
            break;
        case 6:
            System.out.println("Introduza el nuevo nombre de la empresa");
            String nombreEmpresa = sc.nextLine();
            n.setNombreEmpresa(nombreEmpresa);
            break;
        case 7:
            System.out.println("Introduza el nuevo estado");
            System.out.println("1)Activo");
            System.out.println("2) Inactivo");
            // Falta quitar mayusculas y acentos
            int estado = sc.nextInt();
            while (estado != 1 || estado != 2) {
                System.out.println("Opcion invalida");
                System.out.println("Introduza el nuevo estado");
                System.out.println("(Activo, Inactivo");
                // Falta quitar mayusculas y acentos
                estado = sc.nextInt();
            }
            if (estado == 1) {
                c.setEstado(true);
            } else {
                c.setEstado(false);
            }
            break;
        }
        return continuaActualizando();
    }

    public void menuActualizacionDatos(Cuenta c) {
        System.out.println("Indique los datos a actualizar de la cuenta");
        int opcion;

        if (c.getClass() == b.getClass()) {
            menuDebito();
            opcion = sc.nextInt();
            while (opcion < 1 || opcion > 6) {
                System.out.println("Opcion invalida");
                menuDebito();
                opcion = sc.nextInt();
            }
            @SuppressWarnings("unchecked")
            boolean actualizarDebito = actualizaDebito(opcion, (Debito) c);
            while (actualizarDebito) {
                actualizarDebito = actualizaDebito(opcion, (Debito) c);
            }
            System.out.println(c.toString());
        } else if (c.getClass() == this.c.getClass()) {
            menuCredito();
            opcion = sc.nextInt();
            while (opcion < 1 || opcion > 8) {
                System.out.println("Opcion invalida");
                menuDebito();
                opcion = sc.nextInt();
            }
            @SuppressWarnings("unchecked")
            boolean actualizarCredito = actualizaCredito(opcion, (Credito) c);
            while (actualizarCredito) {
                actualizarCredito = actualizaCredito(opcion, (Credito) c);
            }
            System.out.println(c.toString());
        } else {
            menuNomina();
            opcion = sc.nextInt();
            while (opcion < 1 || opcion > 8) {
                System.out.println("Opcion invalida");
                menuDebito();
                opcion = sc.nextInt();
            }
            @SuppressWarnings("unchecked")
            boolean actualizarNomina = actualizaNomina(opcion, (Nomina) c);
            while (actualizarNomina) {
                actualizarNomina = actualizaNomina(opcion, (Nomina) c);
            }
            System.out.println(c.toString());
        }
    }

    public void menuConsulta() {
        System.out.println("Seleccione el numero correspondiente a su consulta");
        System.out.println("1) Consulta por numero de cliente");
        System.out.println("2) Consulta por tipo de cuenta");
        System.out.println("3) Consulta por nombre del cliente");
        System.out.println("4) Consulta por numero de cuenta");
        System.out.println("5) Consulta por numero de sucursal");
        System.out.println("6) Consulta por RFC del ejecutivo");
        System.out.println("7) Consulta por RFC de la empresa");
        System.out.println("8) Consulta por estado");
    }

    public void menuActualiza() {
        System.out.println("Seleccione el tipo de cuenta a ");

    }

    public Cuenta subMenuConsulta(int subOpcion) {
        Cuenta c;
        int dato;
        String info;
        switch (subOpcion) {
        // Consulta por numero de cliente
        case 1:
            System.out.println("Por favor introduzca el numero del cliente");
            dato = sc.nextInt();
            c = consulta(dato, 1);
            return c;
        case 2:
            System.out.println("Por favor introduzca el tipo de cuenta");
            info = sc.nextLine();
            // Falta volcer minusculas y quitar acentos.
            boolean noEsValida = cuentaInvalida(info);
            while (noEsValida) {
                System.out.println("Cuenta invalida, intente nuevamente");
                info = sc.nextLine();
            }
            c = consulta(info, 1);
            return c;
        case 3:
            System.out.println("Por favor introduzca el tipo de cuenta");
            info = sc.nextLine();
            // Falta volcer minusculas y quitar acentos.
            c = consulta(info, 2);
            return c;
        case 4:
            System.out.println("Por favor introduzca el numero de cuenta");
            dato = sc.nextInt();
            c = consulta(dato, 2);
            return c;
        case 5:
            System.out.println("Por favor introduzca numero de sucursal");
            dato = sc.nextInt();
            // Falta volcer minusculas y quitar acentos.
            c = consulta(dato, 3);
            return c;
        case 6:
            System.out.println("Por favor introduzca el RFC del ejecutivo");
            info = sc.nextLine();
            // Falta volcer minusculas y quitar acentos.
            c = consulta(info, 3);
            return c;
        case 7:
            System.out.println("Por favor introduzca el RFC de la empresa");
            info = sc.nextLine();
            // Falta volcer minusculas y quitar acentos.
            c = consulta(info, 4);
            return c;
        default:
            System.out.println("Por favor introduzca el estado a buscar");
            // Encontrar un sinonimo para pasivo.
            System.out.println("Activo o ");
            info = sc.nextLine();
            // Falta volcer minusculas y quitar acentos.
            c = consulta(info, 5);
            return c;
        }
    }

    public void menuAltaCuenta() {
        System.out.println("Seleccione el tipo de cuenta que quiera dar de alta");
        System.out.println("1) Debito");
        System.out.println("2) Credito");
        System.out.println("3) Nomina");

    }

    public void nuevaDebito(boolean esEjecutivo) {
        int numeroSucursal = rd.nextInt(6) + 1;
        System.out.println("Por favor introduzca un nombre");
        String nombre = sc.nextLine();
        System.out.println("Por favor introduzca un numero de cuenta");
        int numeroCuenta = sc.nextInt();
        System.out.println("Por favor introduzca el saldo incial");
        int saldo = sc.nextInt();
        // Mejorar fecha
        System.out.println("Por favor introduzca la fecha del dia");
        System.out.println("Con el siguiente formato:");
        System.out.println("dia mes ultimos dos digitos del año separados por un punto");
        System.out.println("Ejemplo 12.03.99");
        String fechaApertura = sc.nextLine();
        System.out.println("Por favor introduzca la fecha de corte");
        String fechaCorte = sc.nextLine();
        System.out.println("Por favor introduzca un correo electronico");
        String correo = sc.nextLine();
        System.out.println("Por favor introduzca un numero de telefono");
        int telefono = sc.nextInt();
        if (esEjecutivo) {
            this.ejecutivos.add(new Debito(nombre, numeroCliente, numeroCuenta, saldo, fechaApertura, fechaCorte,
                    numeroSucursal, correo, telefono));
        } else {
            this.cuentas.add(new Debito(nombre, numeroCliente, numeroCuenta, saldo, fechaApertura, fechaCorte,
                    numeroSucursal, correo, telefono));
        }
        numeroCliente++;
    }

    public void nuevaCredito(boolean esEjecutivo) {
        int numeroSucursal = rd.nextInt(6) + 1;
        System.out.println("Por favor introduzca un nombre");
        String nombre = sc.nextLine();
        System.out.println("Por favor introduzca el importe de credito");
        int importeCredito = sc.nextInt();
        System.out.println("Por favor introduzca el monto de credito utilizado");
        int montoUtilizado = sc.nextInt();
        System.out.println("Por favor introduzca el monto de credito");
        double montoCredito = sc.nextDouble();
        // Mejorar fecha
        System.out.println("Por favor introduzca la fecha del dia");
        System.out.println("Con el siguiente formato:");
        System.out.println("dia mes ultimos dos digitos del año separados por un punto");
        System.out.println("Ejemplo 12.03.99");
        String fechaApertura = sc.nextLine();
        System.out.println("Por favor introduzca la fecha de pago");
        System.out.println("Indicando unicamente el dia");
        String fechaPago = sc.nextLine();
        System.out.println("Por favor introduzca la fecha del dia");
        System.out.println("Con el siguiente formato:");
        System.out.println("dia mes ultimos dos digitos del año separados por un punto");
        System.out.println("Ejemplo 12.03.99");
        String fechaVencimiento = sc.nextLine();
        System.out.println("Por favor introduzca un correo electronico");
        String correo = sc.nextLine();
        System.out.println("Por favor introduzca un numero de telefono");
        int telefono = sc.nextInt();
        if (esEjecutivo) {
            this.ejecutivos.add(new Credito(nombre, numeroCliente, numeroTarjeta, importeCredito, montoCredito,
                    fechaApertura, fechaPago, fechaVencimiento, numeroSucursal, correo, telefono));
        } else {
            this.cuentas.add(new Credito(nombre, numeroCliente, numeroTarjeta, importeCredito, montoCredito,
                    fechaApertura, fechaPago, fechaVencimiento, numeroSucursal, correo, telefono));
        }
        numeroCliente++;
        numeroTarjeta++;
    }

    public void nuevaNomina(boolean esEjecutivo) {
        int numeroSucursal = rd.nextInt(6) + 1;
        System.out.println("Por favor introduzca un nombre");
        String nombre = sc.nextLine();
        System.out.println("Por favor introduzca el numero de cuenta");
        int numeroCuenta = sc.nextInt();
        System.out.println("Por favor introduzca el saldo incial");
        int saldo = sc.nextInt();
        // Mejorar fecha
        System.out.println("Por favor introduzca la fecha del dia");
        System.out.println("Con el siguiente formato:");
        System.out.println("dia mes ultimos dos digitos del año separados por un punto");
        System.out.println("Ejemplo 12.03.99");
        String fechaApertura = sc.nextLine();
        System.out.println("Por favor introduzca un correo electronico");
        String correo = sc.nextLine();
        System.out.println("Por favor introduzca un numero de telefono");
        int telefono = sc.nextInt();
        System.out.println("Por favor introduzca el RFC de la empresa");
        String rfc = sc.nextLine();
        System.out.println("Por favor introduzca el nombre de la empresa");
        String nombreEmpresa = sc.nextLine();
        System.out.println("Por favor introduzca la fecha de deposito por parte de la empresa");
        String fechaDeposito = sc.nextLine();
        if (esEjecutivo) {
            this.ejecutivos.add(new Nomina(nombre, numeroCliente, numeroCuenta, saldo, fechaApertura, numeroSucursal,
                    correo, telefono, rfc, nombreEmpresa, fechaDeposito));
        } else {
            this.cuentas.add(new Nomina(nombre, numeroCliente, numeroCuenta, saldo, fechaApertura, numeroSucursal,
                    correo, telefono, rfc, nombreEmpresa, fechaDeposito));
        }
        numeroCliente++;
    }

    public void muestraListas() {
        System.out.println("Cuentas:\n" + this.cuentas.toString());
        System.out.println("\nEjecutivos:\n" + this.ejecutivos.toString());
    }

    public static void main(String[] args) {
        Sistema si = new Sistema();
        int opcion;
        int subOpcion;
        boolean ejecucionPrograma = true;
        int opcionEjecutivo;
        boolean esEjecutivo;
        Cuenta c;
        while (ejecucionPrograma) {
            si.muestraListas();
            si.menu();
            opcion = sc.nextInt();
            while (opcion > 7 || opcion < 1) {
                System.out.println("Opcion incorrecta, intentelo nuevamente");
                opcion = sc.nextInt();
            }
            switch (opcion) {
            case 1:
                si.menuConsulta();
                subOpcion = sc.nextInt();
                while (subOpcion < 1 || subOpcion > 8) {
                    System.out.println("Opcion incorrecta, intentelo nuevamente");
                    subOpcion = sc.nextInt();
                }
                c = si.subMenuConsulta(subOpcion);
                if (c == null) {
                    System.out.println("Cuenta no existente");
                } else {
                    System.out.println(c.toString());
                }
                break;
            case 2:
                opcionEjecutivo = sc.nextInt();
                System.out.println("Indique si la cuenta nueva corresponde a un ejecutivo");
                System.out.println("1) Si");
                System.out.println("2) No");
                opcionEjecutivo = sc.nextInt();
                while (opcionEjecutivo < 1 || opcionEjecutivo > 2) {
                    System.out.println("Opcion incorrecta, intentelo nuevamente");
                    opcionEjecutivo = sc.nextInt();
                }
                if (opcionEjecutivo == 1) {
                    esEjecutivo = true;
                } else {
                    esEjecutivo = false;
                }
                si.menuAltaCuenta();
                subOpcion = sc.nextInt();
                while (subOpcion < 1 || subOpcion > 3) {
                    System.out.println("Opcion incorrecta, intentelo nuevamente");
                    subOpcion = sc.nextInt();
                }
                if (subOpcion == 1) {
                    si.nuevaDebito(esEjecutivo);
                } else if (subOpcion == 2) {
                    si.nuevaCredito(esEjecutivo);
                } else {
                    si.nuevaNomina(esEjecutivo);
                }
                break;
            case 3:
                System.out.println("Indique si la cuenta a acatualizar corresponde a un ejecutivo");
                System.out.println("1) Si");
                System.out.println("2) No");
                opcionEjecutivo = sc.nextInt();
                while (opcionEjecutivo < 1 || opcionEjecutivo > 2) {
                    System.out.println("Opcion incorrecta, intentelo nuevamente");
                    opcionEjecutivo = sc.nextInt();
                }
                if (opcionEjecutivo == 1) {
                    esEjecutivo = true;
                } else {
                    esEjecutivo = false;
                }
                System.out.println("Indique el tipo de cuenta que desea agregar");
                System.out.println("1) Debito");
                System.out.println("2) Credito");
                System.out.println("3) Nomina");
                int tipoCuenta = sc.nextInt();
                while (tipoCuenta < 1 || tipoCuenta > 3) {
                    System.out.println("Opcion incorrecta, intentelo nuevamente");
                    tipoCuenta = sc.nextInt();
                }
                if (tipoCuenta == 1) {
                    si.nuevaDebito(esEjecutivo);
                } else if (tipoCuenta == 2) {
                    si.nuevaCredito(esEjecutivo);
                } else {
                    si.nuevaNomina(esEjecutivo);
                }
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                si.cierraPrograma();
                ejecucionPrograma = false;
                break;
            }
        }

    }

    public void cierraPrograma() {
        File c = new File("cuentas.txt");
        File e = new File("ejecutivos.txt");
        FileOutputStream paraClientes;
        FileOutputStream paraEjecutivos;
        PrintStream writerClientes;
        PrintStream writerEjecutivos;
        try {
            paraClientes = new FileOutputStream(c);
            paraEjecutivos = new FileOutputStream(e);
            writerClientes = new PrintStream(paraClientes);
            writerEjecutivos = new PrintStream(paraEjecutivos);
            String linea;
            for (Cuenta cliente : cuentas) {
                if (cliente.getClass() == b.getClass()) {
                    linea = cliente.paraAlmacenar();
                } else if (cliente.getClass() == this.c.getClass()) {
                    linea = cliente.paraAlmacenar();
                } else {
                    linea = cliente.paraAlmacenar();
                }
                writerClientes.println(linea+"\n");
            }   

            linea = "";
            for (Cuenta ejecutivo: ejecutivos) {
                if (ejecutivo.getClass() == b.getClass()) {
                    linea = ejecutivo.paraAlmacenar();
                } else if (ejecutivo.getClass() == this.c.getClass()) {
                    linea = ejecutivo.paraAlmacenar();
                } else {
                    linea = ejecutivo.paraAlmacenar();
                }
                writerEjecutivos.println(linea);
            }

            writerClientes.close();
            writerEjecutivos.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            System.out.println("Error al intentar guardar el archivo");
            System.exit(1);
        }
    }
}
