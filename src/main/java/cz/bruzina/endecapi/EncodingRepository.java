package cz.bruzina.endecapi;

import org.springframework.data.repository.CrudRepository;

public interface EncodingRepository extends CrudRepository<Encoding, Long> {
    Encoding findById(long Id);
}
