package controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private static final Sesion sesion = Sesion.getInstance();
    private static final GestorUsuarios gestUsers = GestorUsuarios.getInstance();

    @GetMapping("/login")
    public String login(@RequestParam(value = "token", defaultValue = "") String token) {
        return sesion.login(token);
    }

    @GetMapping("/add")
    public String registrar(@RequestParam(value = "token", defaultValue = "") String token) {
        return sesion.login(token);
    }

    @GetMapping("/logout")
    public void logout() {
        sesion.cerrarSesion();
    }

    @GetMapping("/delete")
    public void borrar() {
        String uid = sesion.getSesion().getUid();
        gestUsers.remove(uid);
    }

}
