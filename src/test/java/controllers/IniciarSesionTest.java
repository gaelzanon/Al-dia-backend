package controllers;

import model.Usuario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IniciarSesionTest {
    private static GestorUsuarios gestUsers;
    private static Sesion sesion;

    @BeforeAll
    static void init() {
        gestUsers = GestorUsuarios.getInstance();
        sesion = Sesion.getInstance();

        Usuario user = new Usuario("UserUS", "ContraDeUS", "User", "user@mail.com", "");
        gestUsers.add(user);
    }

    @AfterEach
    void clear() {
        sesion.cerrarSesion();
    }

    @AfterAll
    static void cleanUp() {
        //gestUsers.remove("UserUS");
    }

    @Test
    void login_exisitingUser_validSession() {
        System.out.println("---Inicio de sesión válido---");
        assertEquals("user@mail.com", sesion.login(""));          // Se loguea con usuario y contraseña correctos
    }

    @Test
    void login_invalidToken_exception() {
        System.out.println("---Inicio de sesión con contraseña incorrecta---");
        assertThrows(Exception.class, () -> { sesion.login(""); });      // Se envia token inválido
    }

//    @Test
//    void login_incorrectUserexception() {
//        System.out.println("---Inicio de sesión con usuario no registrado---");
//        assertThrows(Exception.class, () -> { sesion.login(""); });           // Se loguea con usuario inválido
//    }
}
