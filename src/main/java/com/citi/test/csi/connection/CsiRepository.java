package com.citi.test.csi.connection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CsiRepository extends CrudRepository<Csi, String> {

      Csi findByKey(String key);

}
