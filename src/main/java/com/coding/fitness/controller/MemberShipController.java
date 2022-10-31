package com.coding.fitness.controller;

import com.coding.fitness.dto.CreateMemberShipDto;
import com.coding.fitness.dto.GetMemberShipDto;
import com.coding.fitness.service.MemberShipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/memberShip")
public class MemberShipController {

    private final MemberShipService memberShipService;

    public MemberShipController(MemberShipService memberShipService) {
        this.memberShipService = memberShipService;
    }

    @PostMapping("/createMemberShip")
    public ResponseEntity<GetMemberShipDto> createMemberShip(@RequestBody CreateMemberShipDto createMemberShipDto) {
        return ResponseEntity.ok(memberShipService.createMemberShip(createMemberShipDto));
    }

    @GetMapping("/getAllMemberShipsHasCompany")
    public ResponseEntity<List<GetMemberShipDto>> getAllMemberShipsHasCompany(@RequestParam String companyId) {
        return ResponseEntity.ok(memberShipService.getAllMemberShipsHasCompany(companyId));
    }
    @GetMapping("/getUserMemberShip")
    public ResponseEntity<GetMemberShipDto> getUserMemberShip(@RequestParam String userId) {
        return ResponseEntity.ok(memberShipService.getUserMemberShip(userId));
    }
}
