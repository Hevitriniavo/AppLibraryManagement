package hei.shool.appLibrary.management.Repository;

import hei.shool.appLibrary.management.DatabaseConfig.DatabaseConnection;
import hei.shool.appLibrary.management.Entity.Topic;
import java.util.List;

public class TopicCrudOperations extends DatabaseConnection implements CrudOperations<Topic> {

    @Override
    public List<Topic> findAll() {

        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public List<Topic> saveAll(List<Topic> toSave) {
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    @Override
    public Topic save(Topic toSave) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Topic delete(Topic toDelete) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
   
}
