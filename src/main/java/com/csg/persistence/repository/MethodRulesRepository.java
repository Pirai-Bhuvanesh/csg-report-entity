package com.csg.persistence.repository;

import com.csg.persistence.entity.MethodRulesEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import java.util.UUID;

@Repository
public interface MethodRulesRepository extends R2dbcRepository<MethodRulesEntity, UUID> {
    Mono<MethodRulesEntity> findByMethodName(String methodName);

}
