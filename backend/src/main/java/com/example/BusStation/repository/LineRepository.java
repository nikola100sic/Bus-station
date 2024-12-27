package com.example.BusStation.repository;

import com.example.BusStation.model.Line;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LineRepository extends JpaRepository<Line, Long> {

    @Query("SELECT l FROM Line l JOIN l.carriers c " +
            "WHERE (:carrierId IS NULL OR c.id = :carrierId) " +
            "AND (:destination IS NULL OR LOWER(l.destination) LIKE LOWER(CONCAT('%', :destination, '%'))) " +
            "AND (:maxPrice IS NULL OR l.price <= :maxPrice)")
    List<Line> searchLines(@Param("carrierId") Long carrierId,
                           @Param("destination") String destination,
                           @Param("maxPrice") Integer maxPrice, Pageable pageable);

}
