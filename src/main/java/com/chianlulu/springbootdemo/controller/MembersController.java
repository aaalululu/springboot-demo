package com.chianlulu.springbootdemo.controller;

import com.chianlulu.springbootdemo.model.Members;
import com.chianlulu.springbootdemo.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MembersController {

    private MembersService membersService;

    @Autowired
    private void setMembersService(MembersService membersService) {
        this.membersService=membersService;
    }

    @RequestMapping("/members/{memberId}")
    private String getMemberById(Model model,@PathVariable Integer memberId) {
        Members members=membersService.getMemberById(memberId);
        model.addAttribute("members",members);
        return "members";
    }

}
