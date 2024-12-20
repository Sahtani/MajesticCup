package com.youcode.majesticcup.team.domain.repository;

import com.youcode.majesticcup.team.domain.entity.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends MongoRepository<Team, String> {
}
