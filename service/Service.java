package libraryapp.service;

public abstract class Service <T> {
    private T repository;
    private String name;
    public Service(T repository, String name) {
        this.repository = repository;
        this.name = name;
    }

    public T getRepository() {
        return this.repository;
    }
    public String getName() {
        return this.name;
    }

}
