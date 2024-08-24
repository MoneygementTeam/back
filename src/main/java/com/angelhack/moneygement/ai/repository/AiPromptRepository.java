package com.angelhack.moneygement.ai.repository;

import com.angelhack.moneygement.ai.entity.AiPrompt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AiPromptRepository extends JpaRepository<AiPrompt, String> {
}
