package hei.shool.appLibrary.management.Repository;

import hei.shool.appLibrary.management.DatabaseConfig.DatabaseConnection;
import hei.shool.appLibrary.management.Entity.Borrowing;

import java.util.List;

public class BorrowingCrudOperations extends DatabaseConnection implements CrudOperations<Borrowing> {
    @Override
    public List<Borrowing> findAll() {
        return null;
    }

    @Override
    public List<Borrowing> saveAll(List<Borrowing> toSave) {
        return null;
    }

    @Override
    public Borrowing save(Borrowing toSave) {
        return null;
    }

    @Override
    public Borrowing delete(Borrowing toDelete) {
        return null;
    }
}
