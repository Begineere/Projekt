package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JuzersyRepository extends JpaRepository<Juzersy, Long> {
    @Query(value = "SELECT * FROM Juzersy j WHERE j.NAZW = :nazwisko", nativeQuery = true)
    List<Juzersy> findByNazw(@Param("nazwisko") String nazw);
    @Query(value = "SELECT * FROM Juzersy j WHERE j.DO_ZAPLATY >= :dz", nativeQuery = true)
    List<Juzersy> findByDoZaplaty(@Param("dz") Float DoZaplaty);
}
