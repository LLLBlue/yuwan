package com.blue.yw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NominationListRepository extends JpaRepository<NominationListRepository, Integer> {
}
