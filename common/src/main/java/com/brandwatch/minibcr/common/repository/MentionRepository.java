package com.brandwatch.minibcr.common.repository;

import com.brandwatch.minibcr.common.domain.Mention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentionRepository extends JpaRepository<Mention, Long> {
}
