package com.angelhack.moneygement.theme.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angelhack.moneygement.theme.domain.ThemeInvestReturn;

@Repository
public interface ThemeInvestReturnRepository extends JpaRepository<ThemeInvestReturn, String> {
}