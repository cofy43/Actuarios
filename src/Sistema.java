import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Sistema {

    LinkedList<Cuenta> cuentas = new LinkedList<>();
    LinkedList<Cuenta> ejecutivos = new LinkedList<>();
    LinkedList<String> cuentasApertura = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);
    Random rd = new Random();
    // Sujerir almacenar el numero de clientes y actualizarlo al leer los archivos
    int numeroCliente = 1;
    int numeroTarjeta = 1;
    Debito b = new Debito();
    Credito c = new Credito();
    Nomina n = new Nomina();
    File client = new File("cuentas.txt");
    File eje = new File("ejecutivos.txt");
    FileOutputStream paraClientes;
    FileOutputStream paraEjecutivos;
    PrintStream writerClientes;
    PrintStream writerEjecutivos;


    public Sistema() {
        
    }

    public void inciaPrograma() {
        try {
            FileReader lecturaCuetas = new FileReader(client);
            FileReader lecturaEjecutivos = new FileReader(eje);
            BufferedReader lineasCuenta = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader lineasEjecutivo = new BufferedReader(new InputStreamReader(System.in));
            String cuenta;
            while ((cuenta = lineasCuenta.readLine()) != null) {
                String[] datos = cuenta.split(",");
                if (datos.length == 10) {
                    String nombre = datos[0];
                    int numeroCliente = Integer.parseInt(datos[1]);
                    int numeroCuenta = Integer.parseInt(datos[2]);
                    double saldo = Double.parseDouble(datos[3]);
                    String fechaApertura = datos[4];
                    String fechaCorte = datos[5];
                    int numeroSucursal = Integer.parseInt(datos[7]);
                    boolean estado;
                    if (datos[6].equals("activo")) {
                        estado = true;
                    } else {
                        estado = false;
                    }
                    String correo = datos[8];
                    String telefono = datos[9];
                    cuentas.add(new Debito(nombre, numeroCliente, numeroCuenta, saldo, fechaApertura, fechaCorte, estado, numeroSucursal, correo, telefono));
                } else if (datos.length == 13) {
                    if (datos[0].equals("credito")) {
                        String nombre = datos[1];
                        int numeroCliente = Integer.parseInt(datos[2]);
                        int numeroTarjeta = Integer.parseInt(datos[3]);
                        double importeCredito = Double.parseDouble(datos[4]);
                        double montoCredito = Double.parseDouble(datos[5]);
                        String fechaApertura = datos[6];
                        String fechaPago = datos[7];
                        String fechaVencimiento = datos[8];
                        int numeroSucursal = Integer.parseInt(datos[9]);
                        String correo = datos[10];
                        String telefono = datos[11];
                        boolean estado;
                        if (datos[12].equals("activo")) {
                            estado = true;
                        } else {
                            estado = false;
                        }
                        cuentas.add(new Credito(nombre, numeroCliente, numeroTarjeta, importeCredito, montoCredito, fechaApertura, fechaPago, fechaVencimiento, numeroSucursal, correo, telefono, estado));
                    } else {
                        String nombre = datos[1];
                        int numeroCliente = Integer.parseInt(datos[2]);
                        int numeroCuenta = Integer.parseInt(datos[3]);
                        double saldo = Double.parseDouble(datos[4]);
                        String fechaApertura = datos[5];
                        int numeroSucursal = Integer.parseInt(datos[6]);
                        String correo = datos[7];
                        String telefono = datos[8];
                        String rfc = datos[9];
                        String nombreEmpresa = datos[10];
                        String fechaDeposito = datos[11];
                        boolean estado;
                        if (datos[12].equals("activo")) {
                            estado = true;
                        } else {
                            estado = false;
                        }
                        cuentas.add(new Nomina(nombre, numeroCliente, numeroCuenta, saldo, fechaApertura, numeroSucursal, correo, telefono, rfc, nombreEmpresa, fechaDeposito, estado));
                    }
                }
            }
            String ejecutivo;
            while ((ejecutivo = lineasEjecutivo.readLine()) != null) {
                String[] datos = ejecutivo.split(",");
                if (datos.length == 10) {
                    String nombre = datos[0];
                    int numeroCliente = Integer.parseInt(datos[1]);
                    int numeroCuenta = Integer.parseInt(datos[2]);
                    double saldo = Double.parseDouble(datos[3]);
                    String fechaApertura = datos[4];
                    String fechaCorte = datos[5];
                    int numeroSucursal = Integer.parseInt(datos[7]);
                    boolean estado;
                    if (datos[6].equals("activo")) {
                        estado = true;
                    } else {
                        estado = false;
                    }
                    String correo = datos[8];
                    String telefono = datos[9];
                    ejecutivos.add(new Debito(nombre, numeroCliente, numeroCuenta, saldo, fechaApertura, fechaCorte, estado, numeroSucursal, correo, telefono));
                } else if (datos.length == 13) {
                    if (datos[0].equals("credito")) {
                        String nombre = datos[1];
                        int numeroCliente = Integer.parseInt(datos[2]);
                        int numeroTarjeta = Integer.parseInt(datos[3]);
                        double importeCredito = Double.parseDouble(datos[4]);
                        double montoCredito = Double.parseDouble(datos[5]);
                        String fechaApertura = datos[6];
                        String fechaPago = datos[7];
                        String fechaVencimiento = datos[8];
                        int numeroSucursal = Integer.parseInt(datos[9]);
                        String correo = datos[10];
                        String telefono = datos[11];
                        boolean estado;
                        if (datos[12].equals("activo")) {
                            estado = true;
                        } else {
                            estado = false;
                        }
                        ejecutivos.add(new Credito(nombre, numeroCliente, numeroTarjeta, importeCredito, montoCredito, fechaApertura, fechaPago, fechaVencimiento, numeroSucursal, correo, telefono, estado));
                    } else {
                        String nombre = datos[1];
                        int numeroCliente = Integer.parseInt(datos[2]);
                        int numeroCuenta = Integer.parseInt(datos[3]);
                        double saldo = Double.parseDouble(datos[4]);
                        String fechaApertura = datos[5];
                        int numeroSucursal = Integer.parseInt(datos[6]);
                        String correo = datos[7];
                        String telefono = datos[8];
                        String rfc = datos[9];
                        String nombreEmpresa = datos[10];
                        String fechaDeposito = datos[11];
                        boolean estado;
                        if (datos[12].equals("activo")) {
                            estado = true;
                        } else {
                            estado = false;
                        }
                        ejecutivos.add(new Nomina(nombre, numeroCliente, numeroCuenta, saldo, fechaApertura, numeroSucursal, correo, telefono, rfc, nombreEmpresa, fechaDeposito, estado));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("No se encontraron los archivos");
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public double getSaldoPromedio() {
        double total = 0;
        double suma = 0;
        for (Cuenta c : cuentas) {
            if (!c.getClase().equals("credito")) {
                total ++;
                suma += c.getSaldo();
            }
        }
        return suma / total;
    }

    public String generaContrato(int numeroEmpleado, Cuenta c) {
        String contrato = "\t\tInstitucion bancaria\n--------------------------------------------------------------------------------";
        if (c.getClase().equals("credito")) {
            contrato += String.format("Numero de empleado que realiza el contrato: %d\nNumero de sucursal: %d\nFecha: %s\nYo : %s acepto la creacion de la cuenta de %s con numero de cliente %d\nCuenta cuyo importe de credito sera de: %f\nCuyos pagos seran: %s\nCon numero de tarjeta %d\nCorreo electronico: %s\nNumero telefonico: %s", numeroEmpleado, c.getNueroSucursal(), c.getFechaApertura(), c.getNombreCliente(), c.getClase(), c.getNumeroCliente(), c.getImporte(), c.getFechaPago(), c.getNumeroTarjeta(), c.getCorreroElectronico(), c.getNumeroTelefono());
        } else if (c.getClase().equals("debito")) {
            contrato += String.format("Numero de empleado que realiza el contrato: %d\nNumero de sucursal: %d\nFecha: %s\nYo : %s acepto la creacion de la cuenta de %s con numero de cliente %d\nCreo la cuenta con un monto de %f\nCorreo electronico: %s\nNumero telefonico: %s", numeroEmpleado, c.getNueroSucursal(), c.getFechaApertura(),c.getNombreCliente(), c.getClase(),c.getNumeroCliente(), c.getSaldo(), c.getCorreroElectronico(), c.getNumeroTelefono());
        } else {
            contrato += String.format("Numero de empleado que realiza el contrato: %d\nNumero de sucursal: %d\nFecha: %s\nYo : %s acepto la creacion de la cuenta de %s con numero de cliente %d\nCorreo electronico: %s\nNumero telefonico: %s", numeroEmpleado, c.getNueroSucursal(),c.getFechaApertura(),c.getNombreCliente(),c.getClase(), c.getNumeroCliente(), c.getCorreroElectronico(), c.getNumeroTelefono());
        }
        return "--------------------------------------------------------------------------------\n" + contrato + "\n";
    }

    public double getCreditoPromedio() {
        double total = 0;
        double suma = 0;
        for (Cuenta c : cuentas) {
            if (c.getClase().equals("credito")) {
                total ++;
                suma += c.getImporte();
            }
        }
        return suma / total;
    }

    public double getSaldoMenor() {
        double min = Double.MAX_VALUE;
        for (Cuenta c : cuentas) {
            if (!c.getClase().equals("credito")) {
                if (c.getSaldo() < min) {
                    min = c.getSaldo();
                }
            }
        }
        return min;
    }

    public double getDeudaMenor() {
        double min = Double.MAX_VALUE;
        for (Cuenta c : cuentas) {
            if (c.getClase().equals("credito")) {
                if (c.getSaldo() < min) {
                    min = c.getSaldo();
                }
            }
        }
        return min;
    }

    public double getSaldoMayor() {
        double max = 0;
        for (Cuenta c : cuentas) {
            if (!c.getClase().equals("credito")) {
                if (c.getSaldo() > max) {
                    max = c.getSaldo();
                }
            }
        }
        return max;
    }

    public double getDeudaMayor() {
        double max = 0;
        for (Cuenta c : cuentas) {
            if (c.getClase().equals("credito")) {
                if (c.getSaldo() > max) {
                    max = c.getSaldo();
                }
            }
        }
        return max;
    }

    public int getDebito() {
        int total = 0;
        for (Cuenta c : cuentas) {
            if (c.getClase().equals("debito")) {
                total ++;
            }
        }
        return total;
    }

    public int getNomina() {
        int total = 0;
        for (Cuenta c : cuentas) {
            if (c.getClase().equals("nomina")) {
                total ++;
            }
        }
        return total;
    }

    public int getCredito() {
        int total = 0;
        for (Cuenta c : cuentas) {
            if (c.getClase().equals("credito")) {
                total ++;
            }
        }
        return total;
    }

    public void generaReporteDiario() {
        double saldoPromedio = getSaldoPromedio();
        double creditoPromedio = getCreditoPromedio();
        double saldoMenor = getSaldoMenor();
        double deudaMenor = getDeudaMenor();
        double saldoMayor = getSaldoMayor();
        double deudaMayor = getDeudaMayor();
        int cuentasDebito = getDebito();
        int cuentasCredito = getCredito();
        int cuentasNomina = getNomina();
        String reporte = String.format("Saldo promedio: %f\nCredito promedo: %f\nSaldo menor: %f\n Deudo menor: %f\n Saldo mayor: %f\n Deuda mayor: %f\nNumero de cuentas de debito: %d\n NUmero de cuentas de credito: %d\n Numero de cuentas de nommina: %d", saldoPromedio, creditoPromedio, saldoMenor, deudaMenor, saldoMayor, deudaMayor, cuentasDebito, cuentasCredito, cuentasNomina);
        System.out.println(reporte);
    }

    public LinkedList<Cuenta> busquedaPorEstado(String dato) {
        LinkedList<Cuenta> estados = new LinkedList<>();
        boolean estado;
        if (dato.equals("activo")) {
            estado = true;
        } else {
            estado = false;
        }
        for (Cuenta c : this.cuentas) {
            if (c.getEstadoCuenta() == estado) {
                estados.add(c);
            }
        }

        for (Cuenta c : this.ejecutivos) {
            if (c.getEstadoCuenta() == estado) {
                estados.add(c);
            }
        }
        return estados;
    }

    public Cuenta consulta(String dato, int id) {
        switch (id) {
        // Busqueda por nombre del cliente.    
        case 1:
            for (Cuenta c : this.cuentas) {
                if (c.getNombreCliente().equals(dato)) {
                    return c;
                }
            }
            for (Cuenta c : this.ejecutivos) {
                if (c.getNombreCliente().equals(dato)) {
                    return c;
                }
            }
            break;
        // Busqueda por RFC ejecutivo.
        case 2:
            for (Cuenta c : this.cuentas) {
                if (c.getRfcEmpresa().equals(dato)) {
                    return c;
                }
            }
            for (Cuenta c : this.ejecutivos) {
                if (c.getRfcEmpresa().equals(dato)) {
                    return c;
                }
            }
            break;
        // Busqueda por RFC de la empresa.
        case 3:
            for (Cuenta c : this.cuentas) {
                if (c.getRfcEmpresa().equals(dato)) {
                    return c;
                }
            }
            for (Cuenta c : this.ejecutivos) {
                if (c.getRfcEmpresa().equals(dato)) {
                    return c;
                }
            }
            break;
        }
        return null;
    }

    public Cuenta consulta(int dato, int id) {
        switch (id) {
        // Busqueda por numero de cliente.
        case 1:
            for (Cuenta c : this.cuentas) {
                if (c.getNumeroCliente() == dato) {
                    return c;
                }
            }
            for (Cuenta c : this.ejecutivos) {
                if (c.getNumeroCliente() == dato) {
                    return c;
                }
            }
        break;
        // Busqueda por numero de cuenta.
        case 2:
            for (Cuenta c : this.cuentas) {
                if (c.getNumeroCuenta() == dato) {
                    return c;
                }
            }
            for (Cuenta c : this.ejecutivos) {
                if (c.getNumeroCuenta() == dato) {
                    return c;
                }
            }
            break;
        // Busqueda por numero de sucursal.
        case 3:
            for (Cuenta c : this.cuentas) {
                if (c.getNueroSucursal() == dato) {
                    return c;
                }
            }
            for (Cuenta c : this.ejecutivos) {
                if (c.getNueroSucursal() == dato) {
                    return c;
                }
            }
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
            String telefono = sc.nextLine();
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
            String telefono = sc.nextLine();
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
            String telefono = sc.nextLine();
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

    public LinkedList<Cuenta> busquedaPortTipo(String tipo) {
        LinkedList<Cuenta> tipos = new LinkedList<>();
        for (Cuenta c : this.cuentas) {
            if (c.getClase().equals(tipo)) {
                tipos.add(c);
            }
        }
        return tipos;
    }

    public LinkedList<Cuenta> subMenuConsulta(int subOpcion) {
        LinkedList<Cuenta> cc = new LinkedList<>();
        Cuenta c;
        int dato;
        String info;
        switch (subOpcion) {
        // Consulta por numero de cliente
        case 1:
            System.out.println("Por favor introduzca el numero del cliente");
            dato = sc.nextInt();
            c = consulta(dato, 1);
            cc.add(c);
            return cc;
        case 2:
            System.out.println("Por favor introduzca el tipo de cuenta");
            info = sc.nextLine();
            // Falta volcer minusculas y quitar acentos.
            boolean noEsValida = cuentaInvalida(info);
            while (noEsValida) {
                System.out.println("Cuenta invalida, intente nuevamente");
                info = sc.nextLine();
            }
            //aqui
            //c = consulta(info, 1);
            cc = busquedaPortTipo(info);
            return cc;
        case 3:
            System.out.println("Por favor introduzca el tipo de cuenta");
            info = sc.nextLine();
            // Falta volcer minusculas y quitar acentos.
            c = consulta(info, 2);
            cc.add(c);
            return cc;
        case 4:
            System.out.println("Por favor introduzca el numero de cuenta");
            dato = sc.nextInt();
            c = consulta(dato, 2);
            cc.add(c);
            return cc;
        case 5:
            System.out.println("Por favor introduzca numero de sucursal");
            dato = sc.nextInt();
            // Falta volcer minusculas y quitar acentos.
            c = consulta(dato, 3);
            cc.add(c);
            return cc;
        case 6:
            System.out.println("Por favor introduzca el RFC del ejecutivo");
            info = sc.nextLine();
            // Falta volcer minusculas y quitar acentos.
            c = consulta(info, 3);
            cc.add(c);
            return cc;
        case 7:
            System.out.println("Por favor introduzca el RFC de la empresa");
            info = sc.nextLine();
            // Falta volcer minusculas y quitar acentos.
            c = consulta(info, 4);
            cc.add(c);
            return cc;
        default:
            System.out.println("Por favor introduzca el estado a buscar");
            // Encontrar un sinonimo para pasivo.
            System.out.println("Activo o Inactivo");
            info = sc.nextLine();
            // Falta volcer minusculas y quitar acentos.
            //c = consulta(info, 5);
            return busquedaPortTipo(info);
        }
    }

    public void menuAltaCuenta() {
        System.out.println("Seleccione el tipo de cuenta que quiera dar de alta");
        System.out.println("1) Debito");
        System.out.println("2) Credito");
        System.out.println("3) Nomina");

    }

    public void nuevaDebito(boolean esEjecutivo) {
        System.out.println("Introduce tu numero de trabajador");
        int numeroTrabajador = sc.nextInt();
        System.out.println("Por favor introduzca un nombre");
        String nombreDebito = sc.next();
        System.out.println("Por favor introduzca un numero de cuenta");
        int numeroCuenta = sc.nextInt();
        System.out.println("Por favor introduzca el saldo incial");
        int saldo = sc.nextInt();
        // Mejorar fecha
        System.out.println("Por favor introduzca la fecha del dia");
        System.out.println("Con el siguiente formato:");
        System.out.println("dia mes ultimos dos digitos del año separados por un punto");
        System.out.println("Ejemplo 12.03.99");
        String fechaApertura = sc.next();
        System.out.println("Por favor introduzca la fecha de corte");
        String fechaCorte = sc.next();
        System.out.println("Por favor introduzca un correo electronico");
        String correo = sc.next();
        System.out.println("Por favor introduzca un numero de telefono");
        String telefono = sc.next();
        int numeroSucursal = rd.nextInt(6) + 1;
        Debito nuevaDebito = new Debito(nombreDebito, numeroCliente, numeroCuenta, saldo, fechaApertura, fechaCorte, true,
        numeroSucursal, correo, telefono);
        if (esEjecutivo) {
            this.ejecutivos.add(nuevaDebito);
        } else {
            this.cuentas.add(nuevaDebito);
        }
        numeroCliente++;
        String contrato = generaContrato(numeroTrabajador, nuevaDebito);
        System.out.println(contrato);
        cuentasApertura.add(contrato);
    }

    public void nuevaCredito(boolean esEjecutivo) {
        System.out.println("Introduce tu numero de trabajador");
        int numeroTrabajador = sc.nextInt();
        int numeroSucursal = rd.nextInt(6) + 1;
        System.out.println("Por favor introduzca un nombre");
        String nombre = sc.next();
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
        String fechaApertura = sc.next();
        System.out.println("Por favor introduzca la fecha de pago");
        System.out.println("Indicando unicamente el dia");
        String fechaPago = sc.next();
        System.out.println("Por favor introduzca la fecha del dia");
        System.out.println("Con el siguiente formato:");
        System.out.println("dia mes ultimos dos digitos del año separados por un punto");
        System.out.println("Ejemplo 12.03.99");
        String fechaVencimiento = sc.next();
        System.out.println("Por favor introduzca un correo electronico");
        String correo = sc.next();
        System.out.println("Por favor introduzca un numero de telefono");
        String telefono = sc.next();
        Credito nuevaCredito = new Credito(nombre, numeroCliente, numeroTarjeta, importeCredito, montoCredito,
        fechaApertura, fechaPago, fechaVencimiento, numeroSucursal, correo, telefono, true);
        if (esEjecutivo) {
            this.ejecutivos.add(nuevaCredito);
        } else {
            this.cuentas.add(nuevaCredito);
        }
        numeroCliente++;
        numeroTarjeta++;
        String contrato = generaContrato(numeroTrabajador, nuevaCredito);
        System.out.println(contrato);
        cuentasApertura.add(contrato);
    }

    public void nuevaNomina(boolean esEjecutivo) {
        System.out.println("Introduce tu numero de trabajador");
        int numeroTrabajador = sc.nextInt();
        int numeroSucursal = rd.nextInt(6) + 1;
        System.out.println("Por favor introduzca un nombre");
        String nombre = sc.next();
        if (nombre.equals("")) {
            System.out.println("NO toma nombres");
        } else {
            System.out.println("Algo raro pasa");
        }
        System.out.println("Por favor introduzca el numero de cuenta");
        int numeroCuenta = sc.nextInt();
        System.out.println("Por favor introduzca el saldo incial");
        int saldo = sc.nextInt();
        // Mejorar fecha
        System.out.println("Por favor introduzca la fecha del dia");
        System.out.println("Con el siguiente formato:");
        System.out.println("dia mes ultimos dos digitos del año separados por un punto");
        System.out.println("Ejemplo 12.03.99");
        String fechaApertura = sc.next();
        System.out.println("Por favor introduzca un correo electronico");
        String correo = sc.next();
        System.out.println("Por favor introduzca un numero de telefono");
        String telefono = sc.next();
        System.out.println("Por favor introduzca el RFC de la empresa");
        String rfc = sc.next();
        System.out.println("Por favor introduzca el nombre de la empresa");
        String nombreEmpresa = sc.next();
        System.out.println("Por favor introduzca la fecha de deposito por parte de la empresa");
        String fechaDeposito = sc.next();
        Nomina nuevaNomina = new Nomina(nombre, numeroCliente, numeroCuenta, saldo, fechaApertura, numeroSucursal,
        correo, telefono, rfc, nombreEmpresa, fechaDeposito, true);
        if (esEjecutivo) {
            this.ejecutivos.add(nuevaNomina);
        } else {
            this.cuentas.add(nuevaNomina);
        }
        numeroCliente++;
        String contrato = generaContrato(numeroTrabajador, nuevaNomina);
        System.out.println(contrato);
        cuentasApertura.add(contrato);
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
        LinkedList<Cuenta> c;
        Cuenta aux;
        si.inciaPrograma();
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
                if (c.size() == 0) {
                    System.out.println("Cuenta no existente");
                } else {
                    System.out.println(c.toString());
                }
                break;
            case 2:
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
                c = si.subMenuConsulta(2);
                if (c == null) {
                    System.out.println("No se encontro la cuenta");
                } else {
                    aux = c.getFirst();
                    si.menuActualizacionDatos(aux);
                }
                break;
            //Deposito
            case 4:
                c = si.subMenuConsulta(1);
                aux = c.getFirst();
                if (aux.getClase().equals("credito")) {
                    System.out.println("No se puede realizar la transaccion");
                    break;
                } else if (aux.getClase().equals("debito")) {
                    double deposito = sc.nextDouble();
                    aux.deposito(deposito);
                    System.out.println("Ingrese el nombre de referencia de la persona que deposita");
                    String nombreReferencia = sc.nextLine();
                    break;
                } else {
                    double deposito = sc.nextDouble();
                    aux.deposito(deposito);
                }
                break;
            //retiro
            case 5:
                c = si.subMenuConsulta(1);
                aux = c.getFirst();
                System.out.println("Ingrese la cantidad a retirar");
                double retiro = sc.nextDouble();
                boolean retiroValido = aux.retiroValido(retiro);
                if (retiroValido) {
                    aux.efectuaRetiro(retiro);
                    if (aux.getClase().equals("credito")) {
                        aux.incrementaMontoRetirado(retiro);
                    }
                } else {
                    System.out.println("Fondos insuficientes");
                }
                break;
            //pago de tarjeta
            case 6:
                c = si.subMenuConsulta(1);
                aux = c.getFirst();
                if (!aux.getClase().equals("credito")) {
                    System.out.println("Solo se puede realizar el pago de tarjetas a cuentas de credito");
                    break;
                } else {
                    System.out.println("Ingrese la cantidad de pago");
                    double pago = sc.nextDouble();

                }
                break;
            default:
                si.generaReporteDiario();
                si.cierraPrograma();
                ejecucionPrograma = false;
                break;
            } 
        }

    }

    public void cierraPrograma() {
        try {
            paraClientes = new FileOutputStream(client);
            paraEjecutivos = new FileOutputStream(eje);
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
