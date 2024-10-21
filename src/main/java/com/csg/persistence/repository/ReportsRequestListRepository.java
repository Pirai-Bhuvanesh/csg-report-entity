package com.csg.persistence.repository;

import com.csg.persistence.entity.ReportsRequestListEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface ReportsRequestListRepository extends R2dbcRepository<ReportsRequestListEntity, UUID> {

    Mono<ReportsRequestListEntity> findByFileName(String fileName);
}
