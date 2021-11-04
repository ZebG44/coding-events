package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Events;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends CrudRepository<Events, Integer> {
}
