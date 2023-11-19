package hei.shool.appLibrary.management.Repository;

import hei.shool.appLibrary.management.DatabaseConfig.DatabaseConnection;
import hei.shool.appLibrary.management.Entity.Borrowing;

import java.util.List;

public class BorrowingCrudOperations extends DatabaseConnection implements CrudOperations<Borrowing> {

    @Override
    public List<Borrowing> findAll() {
    
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public List<Borrowing> saveAll(List<Borrowing> toSave) {
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    @Override
    public Borrowing save(Borrowing toSave) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Borrowing delete(Borrowing toDelete) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


}
