package com.chianlulu.springbootdemo.rowmapper;

import com.chianlulu.springbootdemo.model.Members;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MembersRowMapper implements RowMapper<Members> {

    @Override
    public Members mapRow(ResultSet resultSet, int i) throws SQLException {
        Members member = new Members() ;
        member.setMemberName(resultSet.getString("member_name"));
        member.setEmail(resultSet.getString("email"));
        member.setMpassword(resultSet.getString("mpassword"));
        member.setPhone(resultSet.getString("phone"));
        member.setAddress(resultSet.getString("address"));
        member.setCreateDate(resultSet.getDate("create_date"));
        member.setEditDate(resultSet.getDate("edit_date"));

        return member;
    }
}
