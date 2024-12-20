package com.youcode.majesticcup.match.domain.repository;

import com.youcode.majesticcup.match.domain.entity.Match;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends MongoRepository<Match, String> {
}
