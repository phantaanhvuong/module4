package com.example.test_du_an_module6.repository;

import com.example.test_du_an_module6.entity.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IParkingSlotRepository extends JpaRepository<ParkingSlot,Long> {
}
