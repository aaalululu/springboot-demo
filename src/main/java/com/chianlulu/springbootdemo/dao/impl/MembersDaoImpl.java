package com.chianlulu.springbootdemo.dao.impl;

import com.chianlulu.springbootdemo.dao.MembersDao;
import com.chianlulu.springbootdemo.model.Members;
import com.chianlulu.springbootdemo.rowmapper.MembersRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MembersDaoImpl implements MembersDao {



    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;
    }


    @Override
    public Members getMemberById(Integer memberId) {
        String sql="SELECT * FROM public.members WHERE member_id=:member_id";
        Map<String,Object> map = new HashMap<>();
        map.put("member_id",memberId);
        List<Members> memberList = namedParameterJdbcTemplate.query(sql,map,new MembersRowMapper());

        if(memberList.size()>0) {
            return memberList.get(0);
        } else {
            return null;
        }
    }
}
