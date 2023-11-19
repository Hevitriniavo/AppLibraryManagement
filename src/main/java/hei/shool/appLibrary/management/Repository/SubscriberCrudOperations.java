package hei.shool.appLibrary.management.Repository;

import hei.shool.appLibrary.management.DatabaseConfig.DatabaseConnection;
import hei.shool.appLibrary.management.Entity.Subscriber;

import java.util.List;

public class SubscriberCrudOperations extends DatabaseConnection  implements CrudOperations <Subscriber>{
    @Override
    public List<Subscriber> findAll() {
        return null;
    }

    @Override
    public List<Subscriber> saveAll(List<Subscriber> toSave) {
        return null;
    }

    @Override
    public Subscriber save(Subscriber toSave) {
        return null;
    }

    @Override
    public Subscriber delete(Subscriber toDelete) {
        return null;
    }
}

