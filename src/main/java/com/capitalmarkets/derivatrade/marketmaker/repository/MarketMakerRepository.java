package com.capitalmarkets.derivatrade.marketmaker.repository;

import com.capitalmarkets.derivatrade.marketmaker.MarketMaker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MarketMakerRepository extends JpaRepository<MarketMaker, UUID> {

    boolean existsByCode(String code);

    boolean existsByName(String name);
}
