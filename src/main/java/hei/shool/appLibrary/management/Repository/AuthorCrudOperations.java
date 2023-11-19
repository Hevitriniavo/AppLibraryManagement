package hei.shool.appLibrary.management.Repository;


import hei.shool.appLibrary.management.DatabaseConfig.DatabaseConnection;
import hei.shool.appLibrary.management.Entity.Author;

import java.util.List;

public class AuthorCrudOperations extends DatabaseConnection implements CrudOperations<Author> {
    @Override
    public List<Author> findAll() {
        this.getConnection();
        return List.of();
    }

    @Override
    public List<Author> saveAll(List<Author> toSave) {
        return null;
    }

    @Override
    public Author save(Author toSave) {
        return null;
    }

    @Override
    public Author delete(Author toDelete) {
        return null;
    }
}

