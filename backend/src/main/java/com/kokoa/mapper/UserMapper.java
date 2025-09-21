package com.kokoa.mapper;

import com.kokoa.entity.common.Account;
import com.kokoa.entity.common.AccountUser;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserMapper {

    @Select("select * from account where username = #{text} or email = #{text}")
    Account findAccountByNameOrEmail(String text);

    @Select("select * from account where username = #{text} or email = #{text}")
    AccountUser findAccountUserByNameOrEmail(String text);

    @Insert("insert into account (email, username, password) values (#{email}, #{username}, #{password})")
    int createAccount(String username, String password, String email);

    @Update("update account set password = #{password} where email = #{email}")
    int resetPasswordByEmail(String password, String email);

    @Delete("delete from account where username = #{username}")
    void deleteAccount(String username);
}