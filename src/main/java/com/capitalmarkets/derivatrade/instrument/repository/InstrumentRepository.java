package com.capitalmarkets.derivatrade.instrument.repository;

import com.capitalmarkets.derivatrade.instrument.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface InstrumentRepository extends JpaRepository<Instrument, UUID> {

    boolean existsBySymbol(String symbol);

}
