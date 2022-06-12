package com.chianlulu.springbootdemo.controller;

import com.chianlulu.springbootdemo.model.Members;
import com.chianlulu.springbootdemo.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MembersRESTController {

    private MembersService membersService;

    @Autowired
    private void setMembersService(MembersService membersService) {
        this.membersService=membersService;
    }

    @GetMapping("/restful/members/{memberId}")
    public ResponseEntity<Members> getMemberById(@PathVariable Integer memberId) {
        Members members=membersService.getMemberById(memberId);
        if(members!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(members);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }



    }
}
