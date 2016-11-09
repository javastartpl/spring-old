package pl.javastart.service;

public interface GenericRepository<K, T> {
    T get(K id);
    void add(T obj);
}
