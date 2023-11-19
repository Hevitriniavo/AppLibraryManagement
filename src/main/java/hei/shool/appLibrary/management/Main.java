package hei.shool.appLibrary.management;
import hei.shool.appLibrary.management.Entity.Administrator;
import hei.shool.appLibrary.management.Repository.AdministratorCrudOperations;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Administrator admin1 = new Administrator(
                2, "Admin1", "Admin", "admin(@example.com", "password1", LocalDateTime.now()
        );

        Administrator admin2 = new Administrator(
                3, "Admin2", "Admin", "admin8@example.com", "password2", LocalDateTime.now()
        );

         List<Administrator> administrators = List.of(
            admin1,
            admin2
         );
         
        AdministratorCrudOperations op = new AdministratorCrudOperations();
        op.saveAll(administrators);
    }
}