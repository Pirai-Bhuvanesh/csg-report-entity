package com.csg.persistence.repository;

import com.csg.persistence.entity.ReportColumnEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;


@Repository
public interface ReportColumnRepository extends R2dbcRepository<ReportColumnEntity, UUID> {
    Mono<ReportColumnEntity> findByColumnName(String columnName);
}
