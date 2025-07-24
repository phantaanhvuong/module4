package com.example.bong_da_v3.repository;

import com.example.bong_da_v3.entity.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlayerRepository extends JpaRepository<Player, Long> {
    @Query("select p from Player p where "+
            "p.name = '' or p.name like concat('%',:name,'%') "+
    "and p.location.name = '' or p.location.name like  concat('%',:nameLocation,'%') ")
    Page<Player> search(@Param("name") String name,@Param("nameLocation") String nameLocation, Pageable pageable);

    long countByStatus(String status);
}
