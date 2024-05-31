package jpa.ejemplos2024.helpers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpa.ejemplos2024.dto.RespuestaInicioSesionDTO;
import jpa.ejemplos2024.models.UsuarioEntity;

import java.security.MessageDigest;

public class UsuariosHelper {
    private EntityManager em;
    public RespuestaInicioSesionDTO validarUsuario(String email, String password) {
        em = Conexion.obtenerEM();
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            String passwordMD5 = bytesToHex(digest).toLowerCase();

            email = email.replace(" or ","");
            email = email.replace("'","");

            UsuarioEntity usuario = (UsuarioEntity) em.createNamedQuery("Usuario.PorEmailyPassword")
                    .setParameter("email", email)
                    .setParameter("password", passwordMD5)
                    .getSingleResult();
            return new RespuestaInicioSesionDTO(true,
                    "Correcto",
                    usuario.getId(),
                    usuario.getPaterno()+" "+usuario.getMaterno()+" "+usuario.getNombre());
        } catch (Exception e) {
            return new RespuestaInicioSesionDTO(false,
                    "Error de conexión - "+e.toString(),
                    -1,
                    "");
        }
    }

    private static final char[] HEX_ARRAY = "0123456789abcdef".toCharArray();
    private static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
}
