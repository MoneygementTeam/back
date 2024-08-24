package com.angelhack.moneygement.theme.repository;

import com.angelhack.moneygement.theme.entity.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, String> {
}
