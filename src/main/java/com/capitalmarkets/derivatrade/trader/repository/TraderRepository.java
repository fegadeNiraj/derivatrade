package com.capitalmarkets.derivatrade.trader.repository;

import com.capitalmarkets.derivatrade.trader.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TraderRepository extends JpaRepository<Trader, UUID> {

    boolean existsByEmail(String email);

    boolean existsByContactNumber(String contactNumber);
}
