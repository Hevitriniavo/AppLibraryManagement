package hei.shool.appLibrary.management.Repository;

import hei.shool.appLibrary.management.DatabaseConfig.DatabaseConnection;
import hei.shool.appLibrary.management.Entity.Administrator;
import java.util.List;

public class AdministratorCrudOperations extends DatabaseConnection implements CrudOperations<Administrator>{
    @Override
    public List<Administrator> findAll() {
        return null;
    }

    @Override
    public List<Administrator> saveAll(List<Administrator> toSave) {
        return null;
    }

    @Override
    public Administrator save(Administrator toSave) {
        return null;
    }

    @Override
    public Administrator delete(Administrator toDelete) {
        return null;
    }
}
