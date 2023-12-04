package org.enoca.utility;

import java.util.List;
import java.util.Optional;

public interface ICrudService <T,ID>{
    T save (T t);
    Iterable <T> saveAll(Iterable<T> t);

    T update(T t);
    void delete(T t);
    List<T> findAll();
    void deleteById(ID id);

    Optional<T> findById(ID id);
}
