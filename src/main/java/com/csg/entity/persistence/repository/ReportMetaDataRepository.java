package com.csg.entity.persistence.repository;

import com.csg.entity.persistence.entity.ReportMetaDataDetailsEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReportMetaDataRepository extends R2dbcRepository<ReportMetaDataDetailsEntity, UUID> {
}
