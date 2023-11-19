package hei.shool.appLibrary.management;

import hei.shool.appLibrary.management.Repository.AuthorCrudOperations;

public class Main {
    public static void main(String[] args) {
        AuthorCrudOperations ap = new AuthorCrudOperations();
        ap.findAll();
    }
}