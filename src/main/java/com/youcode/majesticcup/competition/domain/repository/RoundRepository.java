package com.youcode.majesticcup.competition.domain.repository;

import com.youcode.majesticcup.competition.domain.entity.Round;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundRepository extends MongoRepository<Round, String> {
}
