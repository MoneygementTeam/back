package com.angelhack.moneygement.theme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angelhack.moneygement.theme.entity.ThemeInvestReturn;

@Repository
public interface ThemeInvestReturnRepository extends JpaRepository<ThemeInvestReturn, String> {
}
