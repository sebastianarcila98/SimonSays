package com.simonsays.repository;

import com.simonsays.model.Command;
import org.springframework.data.repository.CrudRepository;


public interface CommandRepository extends CrudRepository<Command, Integer> {


}
