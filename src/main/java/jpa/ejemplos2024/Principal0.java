package jpa.ejemplos2024;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Principal0 {
    public  static void main(String[] args) {
        try {
            //Acepta una conexiónd desde un cliente
            ServerSocket servidor  = new ServerSocket(4500, 10);
            List<HiloAtencion0> clientes = new ArrayList<HiloAtencion0>();
            boolean terminar = false;
            while(!terminar) {
                Socket cliente = servidor.accept();
                System.out.println("Se ha conectado un cliente: " + cliente);

                HiloAtencion0 hilo = new HiloAtencion0(cliente, clientes);
                clientes.add(hilo);
                hilo.start();
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

class HiloAtencion0 extends Thread {
    private BufferedReader entrada;
    private BufferedWriter salida;
    private Socket cliente;
    private List<HiloAtencion0> clientes;
    public HiloAtencion0(Socket cliente, List<HiloAtencion0> clientes) throws IOException {
        //Crea los objetos de entrada de datos desde la conexión al cliente
        entrada = new BufferedReader(
                new InputStreamReader(cliente.getInputStream()));
        salida = new BufferedWriter(
                new OutputStreamWriter(cliente.getOutputStream()));
        this.cliente = cliente;
        this.clientes = clientes;
    }
    public void enviarMensaje(String mensaje) throws IOException {
        salida.write(mensaje+"\n");
        salida.flush();
    }

    public void run() {
        try {
            boolean salir = false;
            while (!salir) {
                //Lee una línea desde el ciente
                String cadEntrada = entrada.readLine();
                if (cadEntrada.equals("*_*_*_")) {
                    salir = true;
                    continue;
                }
                System.out.println("El cliente envió: " + cadEntrada);
                for(HiloAtencion0 hilo : clientes)
                    hilo.enviarMensaje(cadEntrada);
                //String cadSalida = cadEntrada.toUpperCase();
                //Envía un mensaje de respuesta al cliente
                //salida.write(cadSalida + "\n");
                //salida.flush();
            }
            //Cerrar el socket de comunicación con el cliente
            cliente.close();
        } catch (IOException e) {

        }
    }
}

