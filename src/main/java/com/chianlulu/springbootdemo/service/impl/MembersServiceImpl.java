package com.chianlulu.springbootdemo.service.impl;

import com.chianlulu.springbootdemo.dao.MembersDao;
import com.chianlulu.springbootdemo.model.Members;
import com.chianlulu.springbootdemo.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MembersServiceImpl implements MembersService {

    private MembersDao membersDao;

    @Autowired
    private void setMemberDao(MembersDao membersDao) {
        this.membersDao=membersDao;
    }

    @Override
    public Members getMemberById(Integer memberId) {
        return membersDao.getMemberById(memberId);
    }
}
