package com.example.sessionVotation.repositories;

import com.example.sessionVotation.model.SessionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface SessionRepository extends JpaRepository<SessionModel, UUID> {
}
