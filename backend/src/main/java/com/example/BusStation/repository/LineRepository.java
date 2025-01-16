package com.example.BusStation.repository;

import com.example.BusStation.model.Line;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface LineRepository extends JpaRepository<Line, Long> {

    @Query("SELECT l FROM Line l JOIN l.carriers c " +
            "WHERE (:date IS NULL OR l.departureTime = :date) " +
            "AND (:destination IS NULL OR LOWER(l.destination) LIKE LOWER(CONCAT('%', :destination, '%'))) " +
            "AND (:departure IS NULL OR LOWER(l.departure) LIKE LOWER(CONCAT('%', :departure, '%'))) " +
            "AND (:maxPrice IS NULL OR l.price <= :maxPrice)" +
            "AND (:minPrice IS NULL OR l.price >= :minPrice)")
    List<Line> searchLines(@Param("date") LocalDateTime date,
                           @Param("destination") String destination,
                           @Param("departure") String departure,
                           @Param("maxPrice") Integer maxPrice,
                           @Param("minPrice") Integer minPrice,
                           Pageable pageable);

}
