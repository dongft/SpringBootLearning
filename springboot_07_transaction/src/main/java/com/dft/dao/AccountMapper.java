package com.dft.dao;

import com.dft.entity.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AccountMapper {

    @Select("select id, name, money from account")
    List<Account> getAllAccount();

    @Select("select id ")
    Account getAccountById(@Param("id") int id);

    @Insert("insert into account(name,money) values(#{name},#{money})")
    int add(@Param("name") String name, @Param("money") double money);

    @Update("update account set name=#{name}, money=#{money} where id = #{id}")
    int updateAccount(@Param("id") int id, @Param("name") String name, @Param("money") double
            money);

    @Delete("delete from account where id = #{id}")
    int deleteAccountById(@Param("id") int id);
}
