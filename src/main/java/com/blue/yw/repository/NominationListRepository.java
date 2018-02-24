package com.blue.yw.repository;

import com.blue.yw.model.NominationListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NominationListRepository extends JpaRepository<NominationListEntity, Integer> {
    List<NominationListEntity> findByState(String state);

    NominationListEntity findByNominationId(int nominationId);

    List<NominationListEntity> findByStateOrderByVoteCountDesc(String state);

}
