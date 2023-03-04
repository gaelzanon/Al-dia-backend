package application;

import controllers.DatabaseController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {

        SpringApplication.run(BackendApplication.class, args);

        DatabaseController databaseController = DatabaseController.getInstance();

        databaseController.inicializarBD();


        /* Codigo prueba para escribir en base de datos */
        /* Después de lanzar borrar manualmente "UserUS" en Realtime Database y cuenta "user@mail.com" en Authentication */

//        GestorUsuarios gestorUsuarios = GestorUsuarios.getInstance();
//        gestorUsuarios.add(new Usuario("UserUS", "ContraDeUS", "User", "user@mail.com", "testus"));
    }

}
