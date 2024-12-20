package com.youcode.majesticcup.team.domain.repository;

import com.youcode.majesticcup.team.domain.entity.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {
}
