package com.csg.entity.persistence.repository;

import com.csg.entity.persistence.entity.TemplatesEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface TemplatesRepository extends R2dbcRepository<TemplatesEntity, UUID> {
    Mono<TemplatesEntity> findByTemplateName(String templateName);
}
