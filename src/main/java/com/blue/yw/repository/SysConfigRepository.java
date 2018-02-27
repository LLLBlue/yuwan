package com.blue.yw.repository;

import com.blue.yw.model.SysConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysConfigRepository extends JpaRepository<SysConfigEntity, Integer> {
    List<SysConfigEntity> findByGuideKey(String guideKey);

    List<SysConfigEntity> findByGuideKeyOrderBySortAsc(String guideKey);
}
