package com.youcode.majesticcup.competition.domain.repository;

import com.youcode.majesticcup.competition.domain.entity.Competition;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends MongoRepository<Competition, String> {
}
