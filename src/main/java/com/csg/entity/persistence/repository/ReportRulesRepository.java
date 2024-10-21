package com.csg.entity.persistence.repository;

import com.csg.entity.persistence.entity.ReportRulesEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface ReportRulesRepository extends R2dbcRepository<ReportRulesEntity, UUID> {

    Flux<ReportRulesEntity> findByReportId(UUID reportId);
}
