import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.Normalizer;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
/**
 * Clase principal que se encargara de la ejecucion de programa
 * @author Sus nombres
 * @author Sus nombres
 * @author Sus nombres
 * @version 1.0;
 */
public class Sistema {

    //Lista donde se alamcenaran los datos de las cuentas de los clientes.
    LinkedList<Cuenta> cuentas = new LinkedList<>();
    //Lista donde se almacenaran los datos de las cuentas de los trabajadores del banco.
    LinkedList<Cuenta> ejecutivos = new LinkedList<>();
    //Lista donde se alamacenaran los contratos de las aperturas de cuentas en el día para su posterior registro.
    LinkedList<String> cuentasApertura = new LinkedList<>();
    //Variable que nos permitira leer desde la terminal las respuestas de la terminal del usuario.
    static Scanner sc = new Scanner(System.in);
    //Variable para generar el numero aleatorio de la sucursal.
    Random rd = new Random();
    // Sujerir almacenar el numero de clientes y actualizarlo al leer los archivos
    int numeroCliente = 1;
    int numeroTarjeta = 1;
    //Variables que ayudaran a distinguir las instancias de la clase Cuenta.
    Debito b = new Debito();
    Credito c = new Credito();
    Nomina n = new Nomina();
    //Archivos donde se almacena los datos de las cuentas.
    File client = new File("cuentas.txt");
    File eje = new File("ejecutivos.txt");
    //Variables que ayuan a la escritura de los archivos de texto.
    FileOutputStream paraClientes;
    FileOutputStream paraEjecutivos;
    PrintStream writerClientes;
    PrintStream writerEjecutivos;
    //Variable local auxiliar para la generacion del archivo cuentasAperturas.txt.
    static String fechaDelSistema;

    public Sistema() {
        
    }

    /**
     * Método encargado de leer los archivo de texto donde se encuentran almacenadas las cuentas
     * de anteriores ejecuciones del programa, estos archivos deben encontrarse dentro del directorio
     * src/
     */
    public void inciaPrograma() {
        try {
            //Lectura de los archivos
            BufferedReader lineasCuenta = new BufferedReader(new FileReader(client));
            BufferedReader lineasEjecutivo = new BufferedReader(new FileReader(eje));
            String cuenta;
            //Lectura de datos del archivo Clientes.txt
            while ((cuenta = lineasCuenta.readLine()) != null) {
                //División de datos separados por comas su alacenamiento en la lista de las cuentas de los clientes.
                String[] datos = cuenta.split(",");
                //En caso de que los datos sean 10, se refire a una cuenta de Debito.
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
                    //En caso de ser 13 los datos tenemos que considerar dos casos
                    //Caso 1: identidicador de cuenta (el primer dato) refire a una cuenta de credito
                    if (datos[0].equals("credito")) {
                        System.out.println("leyendo credito");
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
                        //Caso 2: identidicador de cuenta (el primer dato) refire a una cuenta de nomina
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
            //Lectura de datos del archivo Clientes.txt
            while ((ejecutivo = lineasEjecutivo.readLine()) != null) {
                //División de datos separados por comas su alacenamiento en la lista de las cuentas de los ejecutivos.
                String[] datos = ejecutivo.split(",");
                System.out.println(datos.toString());
                //En caso de que los datos sean 10, se refire a una cuenta de Debito.
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
                    //En caso de ser 13 los datos tenemos que considerar dos casos
                    //Caso 1: identidicador de cuenta (el primer dato) refire a una cuenta de credito
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
                        //Caso 2: identidicador de cuenta (el primer dato) refire a una cuenta de nomina
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

    /**
     * Método auxiliar para la generación del informe al final de la ejecución del programa.
     * @return Regresa el saldo promedio de las cuentas de los clientes y las cuentas de los ejecutivos.
     */
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

    /**
     * Método auxiliar para la generacion de contratos, mismos que se almacenaran la lista 
     * cuentasApertura para la generación del reporte diario.
     * @param numeroEmpleado Número de empleado que genera la apertura de la cuenta.
     * @param c Cuenta con la cual obtendremos los datos necesario para la generación del contrato.
     * @return Representación en cadena del contrato, según sea la instancia de Cuenta (Débito, Crédito o Nómina).
     */
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

    /**
     * Método auxiliar para la generación del informe al final de la ejecución del programa.
     * @return Regresa el credto promedio de las cuentas de credito de los clientes y las cuentas de los ejecutivos.
     */
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
    
    /**
     * Método auxiliar para la generación del informe al final de la ejecución del programa.
     * @return Regresa el saldo menor de las cuentas de los clientes y las cuentas de los ejecutivos.
     */
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

    /**
     * Método auxiliar para la generación del informe al final de la ejecución del programa.
     * @return Regresa el deuda menor de las cuentas de crédito de los clientes y las cuentas de los ejecutivos.
     */
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

    /**
     * Método auxiliar para la generación del informe al final de la ejecución del programa.
     * @return Regresa el saldo mayor de las cuentas de los clientes y las cuentas de los ejecutivos.
     */
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

    /**
     * Método auxiliar para la generación del informe al final de la ejecución del programa.
     * @return Regresa el deuda mayor de las cuentas de crédito de los clientes y las cuentas de los ejecutivos.
     */
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

    /**
     * Método auxiliar para la generación del informe al final de la ejecución del programa.
     * @return Regresa la suma de las cuentas de debito de las cuentas de los clientes y las cuentas de los ejecutivos.
     */
    public int getDebito() {
        int total = 0;
        for (Cuenta c : cuentas) {
            if (c.getClase().equals("debito")) {
                total ++;
            }
        }
        return total;
    }

    /**
     * Método auxiliar para la generación del informe al final de la ejecución del programa.
     * @return Regresa la suma de las cuentas de nómina de las cuentas de los clientes y las cuentas de los ejecutivos.
     */
    public int getNomina() {
        int total = 0;
        for (Cuenta c : cuentas) {
            if (c.getClase().equals("nomina")) {
                total ++;
            }
        }
        return total;
    }

    /**
     * Método auxiliar para la generación del informe al final de la ejecución del programa.
     * @return Regresa la suma de las cuentas de crédito de las cuentas de los clientes y las cuentas de los ejecutivos.
     */
    public int getCredito() {
        int total = 0;
        for (Cuenta c : cuentas) {
            if (c.getClase().equals("credito")) {
                total ++;
            }
        }
        return total;
    }

    /**
     * Método encargado de la generación del repote diario, así como la generación del archivo cuentasAperturas.txt 
     * al finalizar la ejecución del programa
     * @throws FileNotFoundException En caso fallar al intentar crear el archivo cuentasAperturas.txt.
     */
    public void generaReporteDiario() throws FileNotFoundException {
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
        String file = "cuentasAperturas" + this.fechaDelSistema;
        FileOutputStream aperturas = new FileOutputStream(file);
        PrintStream generaReporte = new PrintStream(aperturas);
        for (String contrato : this.cuentasApertura) {
            generaReporte.println(contrato);
        }
        generaReporte.close();
    }

    /**
     * Método que dado un estado de cuenta (Activo o inactivo) busca en las cuentas de los clientes 
     * y los ejecutivos las cuentas con el mismo estado.
     * @param dato Representación en cadena del estado de las cuentas.
     * @return Lista con las cuentas con el mismo estado.
     */
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

    /**
     * Método encargado de realizar la consulta por medio de datos en cadena como lo son, el 
     * nombre del cliente, el rfc de la empresa, o el nombre de la empresa, busqueda que se 
     * realiza, tanto en las cuentas de los clientes como en las de los ejecutivos.
     * @param dato Representación en cadena de los posibles buscaqueda mencionadas.
     * @param id Número que indicará que tipo de busqueda se realizará en base al dato obtenido.
     * @return La cuenta con la coincidencia. En caso de no haber encontrado alguna coincidencia
     * con los datos recibidos regresará una cuenta vacía (null).
     */
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

    /**
     * Método encargado de realizar la consulta por medio de datos en enteros como lo son, el 
     * número de cliente, el npumero de cuenta, o el número de sucursal, busqueda que se 
     * realiza, tanto en las cuentas de los clientes como en las de los ejecutivos.
     * @param dato Representación en entero de los posibles buscaquedas mencionadas.
     * @param id Número que indicará que tipo de busqueda se realizará en base al dato obtenido.
     * @return La cuenta con la coincidencia. En caso de no haber encontrado alguna coincidencia
     * con los datos recibidos regresará una cuenta vacía (null).
     */
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

    /**
     * Método auxiliar para la busqueda de cuentas, que nos ayuda a validar la entrada del usuario.
     * @param cuenta Tipo de cuenta sugerida por el usuario.
     * @return <true>En caso de ser válida la cuenta</true> 
     *         <false>En caso contrario</false>
     */
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

    /**
     * Método auxiliar que nos muestra el menú principal que mostrará las acciones 
     * del proograma.
     */
    public void menu() {
        System.out.println("Bienvenido al sistema, por favor seleccione una opcion");
        System.out.println("1) Consulta");
        System.out.println("2) Dar de alta una cuenta");
        System.out.println("3) Actualizar datos de cuenta");
        System.out.println("4) Registrar un deposito");
        System.out.println("5) Realizar un retiro");
        System.out.println("6) Realizar pago de tarjeta de credito");
        System.out.println("7) Salir");
    }

    /**
     * Método que nos muestra un menú con las opciones de los datos a 
     * modificar de la cuenta de débito.
     */
    public void menuDebito() {
        System.out.println("1) nombre del cliente");
        System.out.println("2) numero de cuenta");
        System.out.println("3) fecha de corte");
        System.out.println("4) estado");
        System.out.println("5) correo");
        System.out.println("6) telefono");
    }

    /**
     * Método auxiliar que nos indica si se seguirá actualizando los datos 
     * de alguna cuenta
     * @return <true> En caso de que el usuario quiera actualizar mas datos </true>
     *         <False> En caso contrario </False>
     */
    public boolean continuaActualizando() {
        int eleccion = tomaEntero();
        System.out.println("¿Quieres actualizar otro dato de la cuenta?");
        System.out.println("1) Si");
        System.out.println("2) No");
        while (eleccion != 1 || eleccion != 2) {
            System.out.println("Opcion invalida");
            System.out.println("¿Quieres actualizar otro dato de la cuenta?");
            System.out.println("1) Si");
            System.out.println("2) No");
            eleccion = tomaEntero();
        }
        if (eleccion == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método encargado de actualizar el dato de una cuenta de débito.
     * @param opcion Entero que indica cual dato se actualizará.
     * @param c Cuenta de Debito a actualizar.
     * @return <true> En caso de que el usuario haya decidido continuar 
     *                actulizando datos de la misma cuenta </true>
     *         <false> En caso contrario </false>
     */
    public boolean actualizaDebito(int opcion, Debito c) {
        switch (opcion) {
        case 1:
            System.out.println("Introduza el nuevo nombre");
            String nombre = tomaCadena();
            c.setNombreCliente(nombre);
            break;
        case 2:
            System.out.println("Introduza el nuevo numero de cuenta");
            int numeroCuenta = tomaEntero();
            c.setNumeroCuenta(numeroCuenta);
            break;
        case 3:
            System.out.println("Introduza la nueva fecha de corte");
            String fechaCorte = tomaCadena();
            c.setFechaCorte(fechaCorte);
            break;
        case 4:
            System.out.println("Introduza el nuevo estado");
            System.out.println("1)Activo");
            System.out.println("2) Inactivo");
            int estado = tomaEntero();
            while (estado != 1 || estado != 2) {
                System.out.println("Opcion invalida");
                System.out.println("Introduza el nuevo estado");
                System.out.println("(Activo, Inactivo");
                estado = tomaEntero();
            }
            if (estado == 1) {
                c.setEstado(true);
            } else {
                c.setEstado(false);
            }
            break;
        case 5:
            System.out.println("Introduza el nuevo correo electronico");
            String correo = tomaCadena();
            c.setCorreoElectronico(correo);
            break;
        default:
            System.out.println("Introduza el nuevo numero telefonico");
            String telefono = tomaCadena();
            c.setNumeroTelefono(telefono);
            break;
        }
        return continuaActualizando();
    }

    /**
     * Método que nos muestra un menú con las opciones de los datos a 
     * modificar de la cuenta de crédito.
     */
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

    /**
     * Método auxiliar que nos indica si se seguirá actualizando los datos 
     * de alguna cuenta
     * @return <true> En caso de que el usuario quiera actualizar mas datos </true>
     *         <False> En caso contrario </False>
     */
    public boolean actualizaCredito(int opcion, Credito c) {
        switch (opcion) {
        case 1:
            System.out.println("Introduza el nuevo nombre");
            String nombre = tomaCadena();
            c.setNombreCliente(nombre);
            break;
        case 2:
            System.out.println("Introduza el nuevo importe de credito");
            int importeCredito = tomaEntero();
            c.setImporteCredito(importeCredito);
            break;
        case 3:
            System.out.println("Introduza el nuevo monto de credito");
            int montoCredito = tomaEntero();
            c.setImporteCredito(montoCredito);
            break;
        case 4:
            System.out.println("Introduza la nueva fecha de pago");
            String fechaPago = tomaCadena();
            c.setFechaPago(fechaPago);
            break;
        case 5:
            System.out.println("Introduza la nueva fecha de vencimiento");
            String fechaVencimiento = tomaCadena();
            c.setFechaVencimiento(fechaVencimiento);
            break;
        case 6:
            System.out.println("Introduza el nuevo estado");
            System.out.println("1)Activo");
            System.out.println("2) Inactivo");
            int estado = tomaEntero();
            while (estado != 1 || estado != 2) {
                System.out.println("Opcion invalida");
                System.out.println("Introduza el nuevo estado");
                System.out.println("(Activo, Inactivo");
                estado = tomaEntero();
            }
            if (estado == 1) {
                c.setEstado(true);
            } else {
                c.setEstado(false);
            }
            break;
        case 7:
            System.out.println("Introduza el nuevo correo electronico");
            String correo = tomaCadena();
            c.setCorreoElectronico(correo);
            break;
        default:
            System.out.println("Introduza el nuevo numero telefonico");
            String telefono = tomaCadena();
            c.setNumeroTelefono(telefono);
            break;

        }
        return continuaActualizando();
    }

    /**
     * Método que nos muestra un menú con las opciones de los datos a 
     * modificar de la cuenta de débito.
     */
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

    /**
     * Método auxiliar que nos indica si se seguirá actualizando los datos 
     * de alguna cuenta
     * @return <true> En caso de que el usuario quiera actualizar mas datos </true>
     *         <False> En caso contrario </False>
     */
    public boolean actualizaNomina(int opcion, Nomina n) {
        switch (opcion) {
        case 1:
            System.out.println("Introduza el nuevo nombre");
            String nombre = tomaCadena();
            n.setNombreCliente(nombre);
            break;
        case 2:
            System.out.println("Introduza el nuevo numero de cuenta");
            int numeroCuenta = tomaEntero();
            n.setNumeroCuenta(numeroCuenta);
            break;
        case 3:
            System.out.println("Introduza el nuevo correo electronico");
            String correo = tomaCadena();
            c.setCorreoElectronico(correo);
            break;
        case 4:
            System.out.println("Introduza el nuevo numero telefonico");
            String telefono = tomaCadena();
            c.setNumeroTelefono(telefono);
            break;
        case 5:
            System.out.println("Introduza el nuevo RFC de la empresa");
            String rfc = tomaCadena();
            n.setRfc(rfc);
            break;
        case 6:
            System.out.println("Introduza el nuevo nombre de la empresa");
            String nombreEmpresa = tomaCadena();
            n.setNombreEmpresa(nombreEmpresa);
            break;
        case 7:
            System.out.println("Introduza el nuevo estado");
            System.out.println("1)Activo");
            System.out.println("2) Inactivo");
            int estado = tomaEntero();
            while (estado != 1 || estado != 2) {
                System.out.println("Opcion invalida");
                System.out.println("Introduza el nuevo estado");
                System.out.println("(Activo, Inactivo");
                estado = tomaEntero();
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

    /**
     * Método que se encarga de verificar a que instancia de Cuenta pertenece
     * la cuenta consultada por el usuario para modificar los datos en ella.
     */
    public void menuActualizacionDatos(Cuenta c) {
        System.out.println("Indique los datos a actualizar de la cuenta");
        int opcion;

        if (c.getClass() == b.getClass()) {
            menuDebito();
            opcion = tomaEntero();
            while (opcion < 1 || opcion > 6) {
                System.out.println("Opcion invalida");
                menuDebito();
                opcion = tomaEntero();
            }
            @SuppressWarnings("unchecked")
            boolean actualizarDebito = actualizaDebito(opcion, (Debito) c);
            while (actualizarDebito) {
                actualizarDebito = actualizaDebito(opcion, (Debito) c);
            }
            System.out.println(c.toString());
        } else if (c.getClass() == this.c.getClass()) {
            menuCredito();
            opcion = tomaEntero();
            while (opcion < 1 || opcion > 8) {
                System.out.println("Opcion invalida");
                menuDebito();
                opcion = tomaEntero();
            }
            @SuppressWarnings("unchecked")
            boolean actualizarCredito = actualizaCredito(opcion, (Credito) c);
            while (actualizarCredito) {
                actualizarCredito = actualizaCredito(opcion, (Credito) c);
            }
            System.out.println(c.toString());
        } else {
            menuNomina();
            opcion = tomaEntero();
            while (opcion < 1 || opcion > 8) {
                System.out.println("Opcion invalida");
                menuDebito();
                opcion = tomaEntero();
            }
            @SuppressWarnings("unchecked")
            boolean actualizarNomina = actualizaNomina(opcion, (Nomina) c);
            while (actualizarNomina) {
                actualizarNomina = actualizaNomina(opcion, (Nomina) c);
            }
            System.out.println(c.toString());
        }
    }

    /**
     * Método que nos muestra un menú con las opciones de los datos a 
     * consultar de alguna cuenta.
     */
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

    /**
     * Método que dado un tipo de cuenta (Débito, Crédito o Nómina) busca en las cuentas de los clientes 
     * y los ejecutivos las cuentas con el mismo tipo.
     * @param dato Representación en cadena del tipo de las cuentas.
     * @return Lista con las cuentas con el mismo tipo.
     */
    public LinkedList<Cuenta> busquedaPortTipo(String tipo) {
        LinkedList<Cuenta> tipos = new LinkedList<>();
        for (Cuenta c : this.cuentas) {
            if (c.getClase().equals(tipo)) {
                tipos.add(c);
            }
        }
        return tipos;
    }

    /**
     * Método que se encarga de realizar la busqueda de una cuenta según el 
     * tipo de dato que el usuaio desee.
     * @param subOcion Opcion correspondiete al tipo de busqueda.
     * @return lista con los resultados de las cuentas.
     */
    public LinkedList<Cuenta> subMenuConsulta(int subOpcion) {
        LinkedList<Cuenta> cc = new LinkedList<>();
        Cuenta c;
        int dato;
        String info;
        String filtro;
        switch (subOpcion) {
        // Consulta por numero de cliente
        case 1:
            System.out.println("Por favor introduzca el numero del cliente");
            dato = tomaEntero();
            c = consulta(dato, 1);
            cc.add(c);
            return cc;
        case 2:
            System.out.println("Por favor introduzca el tipo de cuenta");
            info = tomaCadena();
            filtro = cleanString(info);
            boolean noEsValida = cuentaInvalida(filtro);
            while (noEsValida) {
                System.out.println("Cuenta invalida, intente nuevamente");
                info = tomaCadena();
            }
            cc = busquedaPortTipo(info);
            return cc;
        case 3:
            System.out.println("Por favor introduzca el tipo de cuenta");
            info = tomaCadena();
            filtro = cleanString(info);
            c = consulta(filtro, 2);
            cc.add(c);
            return cc;
        case 4:
            System.out.println("Por favor introduzca el numero de cuenta");
            dato = tomaEntero();
            c = consulta(dato, 2);
            cc.add(c);
            return cc;
        case 5:
            System.out.println("Por favor introduzca numero de sucursal");
            dato = tomaEntero();
            c = consulta(dato, 3);
            cc.add(c);
            return cc;
        case 6:
            System.out.println("Por favor introduzca el RFC del ejecutivo");
            info = tomaCadena();
            filtro = cleanString(info);
            c = consulta(filtro, 3);
            cc.add(c);
            return cc;
        case 7:
            System.out.println("Por favor introduzca el RFC de la empresa");
            info = tomaCadena();
            filtro = cleanString(info);
            c = consulta(filtro, 4);
            cc.add(c);
            return cc;
        default:
            System.out.println("Por favor introduzca el estado a buscar");
            System.out.println("Activo o Inactivo");
            info = tomaCadena();
            filtro = cleanString(info);
            return busquedaPortTipo(filtro);
        }
    }

    /**
     * Método encargado de mostrar un menú con los distintos tipos de cuentas.
     */
    public void menuAltaCuenta() {
        System.out.println("Seleccione el tipo de cuenta que quiera dar de alta");
        System.out.println("1) Debito");
        System.out.println("2) Credito");
        System.out.println("3) Nomina");

    }

    /**
     * Método encargado de la creación de una nueva cuenta de Débito.
     * @param esEjecutivo Bandera que nos indica si la apertura de cuenta le corresponde 
     * a algún ejecutivo, que nos ayudará a decidir en que lista meteneros la nueva cuenta.
     */
    public void nuevaDebito(boolean esEjecutivo) {
        System.out.println("Introduce tu numero de trabajador");
        int numeroTrabajador = tomaEntero();
        System.out.println("Por favor introduzca un nombre");
        String nombreDebito = sc.next();
        System.out.println("Por favor introduzca un numero de cuenta");
        int numeroCuenta = tomaEntero();
        System.out.println("Por favor introduzca el saldo incial");
        int saldo = tomaEntero();
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

    /**
     * Método encargado de la creación de una nueva cuenta de Crédito.
     * @param esEjecutivo Bandera que nos indica si la apertura de cuenta le corresponde 
     * a algún ejecutivo, que nos ayudará a decidir en que lista meteneros la nueva cuenta.
     */
    public void nuevaCredito(boolean esEjecutivo) {
        System.out.println("Introduce tu numero de trabajador");
        int numeroTrabajador = tomaEntero();
        int numeroSucursal = rd.nextInt(6) + 1;
        System.out.println("Por favor introduzca un nombre");
        String nombre = sc.next();
        System.out.println("Por favor introduzca el importe de credito");
        int importeCredito = tomaEntero();
        System.out.println("Por favor introduzca el monto de credito utilizado");
        int montoUtilizado = tomaEntero();
        System.out.println("Por favor introduzca el monto de credito");
        double montoCredito = tomaDouble();
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

    /**
     * Método encargado de la creación de una nueva cuenta de Nómina.
     * @param esEjecutivo Bandera que nos indica si la apertura de cuenta le corresponde 
     * a algún ejecutivo, que nos ayudará a decidir en que lista meteneros la nueva cuenta.
     */
    public void nuevaNomina(boolean esEjecutivo) {
        System.out.println("Introduce tu numero de trabajador");
        int numeroTrabajador = tomaEntero();
        int numeroSucursal = rd.nextInt(6) + 1;
        System.out.println("Por favor introduzca un nombre");
        String nombre = sc.next();
        if (nombre.equals("")) {
            System.out.println("NO toma nombres");
        } else {
            System.out.println("Algo raro pasa");
        }
        System.out.println("Por favor introduzca el numero de cuenta");
        int numeroCuenta = tomaEntero();
        System.out.println("Por favor introduzca el saldo incial");
        int saldo = tomaEntero();
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

    /**
     * Método principal que se encarga de la ejecución completa del programa
     * @throws FileNotFoundException En caso de haber algún problema al cargar el archivo de texto 
     * donde almacenamos los datos de las cuentas de clientes y ejecutivos.
     */
    public void run() throws FileNotFoundException {
        int opcion;
        int subOpcion;
        boolean ejecucionPrograma = true;
        int opcionEjecutivo;
        boolean esEjecutivo;
        LinkedList<Cuenta> c;
        Cuenta aux;
        inciaPrograma();
        System.out.println("Por favor ingrese la fecha del dia de hoy");
        String fecha = tomaCadena();
        fechaDelSistema = fecha;
        while (ejecucionPrograma) {
            menu();
            opcion = tomaEntero();
            while (opcion > 7 || opcion < 1) {
                System.out.println("Opcion incorrecta, intentelo nuevamente");
                opcion = tomaEntero();
            }
            switch (opcion) {
            case 1:
                menuConsulta();
                subOpcion = tomaEntero();
                while (subOpcion < 1 || subOpcion > 8) {
                    System.out.println("Opcion incorrecta, intentelo nuevamente");
                    subOpcion = tomaEntero();
                }
                c = subMenuConsulta(subOpcion);
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
                opcionEjecutivo = tomaEntero();
                while (opcionEjecutivo < 1 || opcionEjecutivo > 2) {
                    System.out.println("Opcion incorrecta, intentelo nuevamente");
                    opcionEjecutivo = tomaEntero();
                }
                if (opcionEjecutivo == 1) {
                    esEjecutivo = true;
                } else {
                    esEjecutivo = false;
                }
                menuAltaCuenta();
                subOpcion = tomaEntero();
                while (subOpcion < 1 || subOpcion > 3) {
                    System.out.println("Opcion incorrecta, intentelo nuevamente");
                    subOpcion = tomaEntero();
                }
                if (subOpcion == 1) {
                    nuevaDebito(esEjecutivo);
                } else if (subOpcion == 2) {
                    nuevaCredito(esEjecutivo);
                } else {
                    nuevaNomina(esEjecutivo);
                }
                break;
            case 3:
                System.out.println("Indique si la cuenta a acatualizar corresponde a un ejecutivo");
                System.out.println("1) Si");
                System.out.println("2) No");
                opcionEjecutivo = tomaEntero();
                while (opcionEjecutivo < 1 || opcionEjecutivo > 2) {
                    System.out.println("Opcion incorrecta, intentelo nuevamente");
                    opcionEjecutivo = tomaEntero();
                }
                if (opcionEjecutivo == 1) {
                    esEjecutivo = true;
                } else {
                    esEjecutivo = false;
                }
                c = subMenuConsulta(2);
                if (c == null) {
                    System.out.println("No se encontro la cuenta");
                } else {
                    aux = c.getFirst();
                    menuActualizacionDatos(aux);
                }
                break;
            //Deposito
            case 4:
                c = subMenuConsulta(1);
                aux = c.getFirst();
                if (aux.getClase().equals("credito")) {
                    System.out.println("No se puede realizar la transaccion");
                    break;
                } else if (aux.getClase().equals("debito")) {
                    double deposito = tomaDouble();
                    aux.deposito(deposito);
                    System.out.println("Ingrese el nombre de referencia de la persona que deposita");
                    String nombreReferencia = tomaCadena();
                    break;
                } else {
                    double deposito = tomaDouble();
                    aux.deposito(deposito);
                }
                break;
            //retiro
            case 5:
                c = subMenuConsulta(1);
                aux = c.getFirst();
                System.out.println("Ingrese la cantidad a retirar");
                double retiro = tomaDouble();
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
                c = subMenuConsulta(1);
                aux = c.getFirst();
                if (!aux.getClase().equals("credito")) {
                    System.out.println("Solo se puede realizar el pago de tarjetas a cuentas de credito");
                    break;
                } else {
                    System.out.println("Ingrese la cantidad de pago");
                    double pago = tomaDouble();
                    aux = c.getFirst();
                    aux.pagoCredito(pago);
                }
                break;
            default:
                generaReporteDiario();
                cierraPrograma();
                ejecucionPrograma = false;
                break;
            } 
        }

    }

    /**
     * Método que se encarga de eliminar espacios, acentos
     * y demas caracteres para la correcta comparación de parámetros.
     * @param texto Cadena a filtrar.
     * @return texto Cadena filtrada. 
     */
    public static String cleanString(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return texto;
    }

    /**
     * Método encargado de almacenar los datos generado y preciamente 
     * cargados en dos archivos de texto (cuentas.txt y  ejecutivos.txt)
     */
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
                writerClientes.println(linea);
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

    /**
     * Método auxiliar que se encarga de verificar que lo que envíe el ususario
     * sea un entero.
     */
    public int tomaEntero() {
        int entero;
        do {
            try {
                entero = sc.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: valor no válido.");
                entero = 0;
                sc = new Scanner(System.in);
            }
        } while (entero < 1); 
        //entero = Integer.parseInt(tomaCadena();
        return entero;
    }

    /**
     * Método auxiliar que se encarga de verificar que lo que envíe el ususario
     * sea una cadena.
     */
    public String tomaCadena() {
        String cadena;
        cadena = String.valueOf(sc.nextLine());
        return cadena;
    }

    /**
     * Método auxiliar que se encarga de verificar que lo que envíe el ususario
     * sea un double.
     */
    public double tomaDouble() {
        double number;
        do {
            try {
                number = sc.nextDouble();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: valor no válido.");
                number = 0;
                sc = new Scanner(System.in);
            }
        } while (number < 1); 
        //number = Double.parseDouble(tomaCadena();
        return number;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Sistema si = new Sistema();
        si.run();
    }
}
