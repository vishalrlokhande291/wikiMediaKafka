package vishal.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import vishal.springboot.entity.WikimediaData;

public interface WikimediaDataRepository extends MongoRepository<WikimediaData, Long> {

}
