package com.coding.fitness.service;

import com.coding.fitness.entity.MemberShip;
import org.springframework.stereotype.Component;

@Component
public class UserMemberShipTransactionService {

    private final MemberShipService memberShipService;

    public UserMemberShipTransactionService(MemberShipService memberShipService) {
        this.memberShipService = memberShipService;
    }

    public void deleteMemberShipByUserId(String userId) {
        memberShipService.deleteMemberShipByUserId(userId);
    }
}
