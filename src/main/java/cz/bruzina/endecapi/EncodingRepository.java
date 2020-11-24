package cz.bruzina.endecapi;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EncodingRepository extends CrudRepository<Encoding, Long> {

    List<Encoding> findByName(String name);

    Encoding findById(long Id);

}
