package com.kq.migration.jdbc.demo

import groovy.sql.Sql

/**
 * DatabaseConfig
 *
 * @author1 kq
 * @date 2019-02-21
 */
class DatabaseConfig {


    static def getSqlInstance(){
        def sql = Sql.newInstance("jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimezone=GMT&useSSL=false", "root",
                "123456", "com.mysql.cj.jdbc.Driver")

       sql
    }

}
