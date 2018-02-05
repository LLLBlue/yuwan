package com.blue.yw.repository;

import com.blue.yw.model.NominationListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NominationListRepository extends JpaRepository<NominationListEntity, Integer> {
}
