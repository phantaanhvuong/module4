package com.example.test_du_an_module6.service;

import com.example.test_du_an_module6.entity.ParkingSlot;
import com.example.test_du_an_module6.repository.IParkingSlotRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingSlotService {
    private final IParkingSlotRepository slotRepo;
    public List<ParkingSlot> getAllSlots() {
        return slotRepo.findAll();
    }
}
