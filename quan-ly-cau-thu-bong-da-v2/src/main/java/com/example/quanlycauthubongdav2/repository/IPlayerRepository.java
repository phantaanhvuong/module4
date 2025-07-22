package com.example.quanlycauthubongdav2.repository;

import com.example.quanlycauthubongdav2.entity.Location;
import com.example.quanlycauthubongdav2.entity.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlayerRepository extends JpaRepository<Player, Long> {
    @Query("select p from Player p where "+
            "p.name = '' or p.name like concat('%',:name,'%') ")
    Page<Player> search(@Param("name") String name, Pageable pageable);
}
