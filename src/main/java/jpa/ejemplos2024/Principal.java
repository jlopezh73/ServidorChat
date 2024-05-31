package jpa.ejemplos2024;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpa.ejemplos2024.dto.InicioSesionDTO;
import jpa.ejemplos2024.dto.MensajeDTO;
import jpa.ejemplos2024.dto.RespuestaInicioSesionDTO;
import jpa.ejemplos2024.helpers.UsuariosHelper;
import jpa.ejemplos2024.models.CursoEntity;

import java.io.*;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// {correoElectronico:'administrador@cursos.uv.mx', password:'alfaomega'}
// {idUsuario: 1, usuario: "Administrador", mensaje: "Saludos", fechaHora: null}

public class Principal {
    public  static void main(String[] args) {
        try {
            boolean terminar = false;
            List<HiloAtencion> listaClientes = new ArrayList<HiloAtencion>();
            ServerSocket servidor  = new ServerSocket(4500, 10);
            while(!terminar) {
                try {
                    Socket cliente = servidor.accept();
                    HiloAtencion hilo = new HiloAtencion(cliente, listaClientes);
                    listaClientes.add(hilo);
                    hilo.start();
                } catch (IOException e) {

                }
            }
        } catch (Exception e) {

        }
    }
}

class HiloAtencion extends Thread{
    private final String FORMATO_FECHA = "dd/MM/yyyy";
    private Socket cliente;
    private BufferedReader entrada;
    private BufferedWriter salida;
    private List<HiloAtencion> clientes;
    private int idUsuario;
    private String usuario;
    private Type tipoInicioSesion;
    private Type tipoMensaje;
    private Gson gson;

    public HiloAtencion(Socket cliente, List<HiloAtencion> clientes) throws IOException {
        this.cliente = cliente;
        this.entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        this.salida = new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream()));
        this.clientes = clientes;
    }

    public void run() {
        boolean salir= false;
        tipoInicioSesion = new TypeToken<InicioSesionDTO>(){}.getType();
        tipoMensaje = new TypeToken<MensajeDTO>(){}.getType();
        gson = new GsonBuilder()
                .setDateFormat(FORMATO_FECHA)
                .create();
        RespuestaInicioSesionDTO respuesta = null;
        do {
            try {
                String mensajeInicioSesionJSON = entrada.readLine();
                InicioSesionDTO inicioSesion = gson.fromJson(mensajeInicioSesionJSON,
                                                             tipoInicioSesion);
                respuesta = iniciarSesion(inicioSesion);
                salida.write(gson.toJson(respuesta)+"\n");
                salida.flush();
            } catch (IOException e) {
                System.err.println("-------->"+e);
            }
        } while (!respuesta.isCorrecto());

        while(!salir) {
            try {
                String mensajeJSON = entrada.readLine();
                MensajeDTO mensaje = gson.fromJson(mensajeJSON,
                        tipoMensaje);
                procesarMensaje(mensaje);
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    private void procesarMensaje(MensajeDTO mensaje) {
        for(HiloAtencion cliente : clientes) {
            try {
                cliente.enviarMensaje(mensaje);
            } catch (Exception e) {

            }
        }
    }

    private RespuestaInicioSesionDTO iniciarSesion(InicioSesionDTO inicioSesion) {
        UsuariosHelper uh = new UsuariosHelper();
        return uh.validarUsuario(inicioSesion.getCorreoElectronico(),
                          inicioSesion.getPassword());
    }

    public void enviarMensaje(MensajeDTO mensaje) throws IOException {
        String cadMensaje=gson.toJson(mensaje);
        salida.write(cadMensaje+"\n");
        salida.flush();
    }
}
