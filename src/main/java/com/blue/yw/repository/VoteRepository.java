package com.blue.yw.repository;

import com.blue.yw.model.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<VoteEntity, Integer> {
    List<VoteEntity> findByState(String state);

    Integer countByNominationId(Integer nominationId);

}
