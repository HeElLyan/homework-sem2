package com.he.springios.storage;

import com.he.springios.model.NameEntry;
import org.springframework.stereotype.Repository;

@Repository
public interface NameEntryRepository extends CrudRepository<Long, NameEntry> {
}
