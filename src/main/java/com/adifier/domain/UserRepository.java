package com.adifier.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By StevenWu
 */

public interface UserRepository extends JpaRepository<User, Long> {
}
