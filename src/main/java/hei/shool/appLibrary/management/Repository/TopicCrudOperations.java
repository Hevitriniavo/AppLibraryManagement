package hei.shool.appLibrary.management.Repository;

import hei.shool.appLibrary.management.DatabaseConfig.DatabaseConnection;
import hei.shool.appLibrary.management.Entity.Topic;

import java.util.List;

public class TopicCrudOperations extends DatabaseConnection implements CrudOperations<Topic> {
    @Override
    public List<Topic> findAll() {
        return null;
    }

    @Override
    public List<Topic> saveAll(List<Topic> toSave) {
        return null;
    }

    @Override
    public Topic save(Topic toSave) {
        return null;
    }

    @Override
    public Topic delete(Topic toDelete) {
        return null;
    }
}
