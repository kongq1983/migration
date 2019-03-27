package com.kq.migration.jdbc.config

import groovy.sql.Sql

/**
 * DatabaseConfig
 *
 * @author1 kq
 * @date 2019-02-21
 */
class DatabaseConfig {


//    static def getSqlInstance(){
//        Sql.newInstance("jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimezone=GMT&useSSL=false", "root",
//                "123456", "com.mysql.cj.jdbc.Driver")
//
//    }


    static def getOracleInstance() {

         Sql.newInstance("jdbc:oracle:thin:@192.168.5.232:1521:restaurant", "kq",
                "kq", "oracle.jdbc.OracleDriver")

    }



}
