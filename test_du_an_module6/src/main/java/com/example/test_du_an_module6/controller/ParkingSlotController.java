package com.example.test_du_an_module6.controller;

import com.example.test_du_an_module6.entity.ParkingSlot;
import com.example.test_du_an_module6.service.ParkingSlotService;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parking-slots")
@CrossOrigin(origins = "http://localhost:5173") // cho React Vite gọi API
public class ParkingSlotController {

    private final ParkingSlotService service;

    public ParkingSlotController(ParkingSlotService service) {
        this.service = service;
    }

    @GetMapping
    public List<ParkingSlot> getAllSlots() {
        return service.getAllSlots();
    }
}