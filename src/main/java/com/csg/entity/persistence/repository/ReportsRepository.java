package com.csg.entity.persistence.repository;

import com.csg.entity.persistence.entity.ReportsEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface ReportsRepository extends R2dbcRepository<ReportsEntity,UUID> {
    Mono<ReportsEntity> findByReportName(String reportName);
}

