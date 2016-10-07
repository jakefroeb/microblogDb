package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by jakefroeb on 10/7/16.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {

}
