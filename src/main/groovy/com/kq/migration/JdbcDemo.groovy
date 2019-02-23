package com.kq.migration


import groovy.sql.Sql


/**
 * JdbcDemo
 *
 * @author1 kq
 * @date 2019-02-19
 */
class JdbcDemo {


    static void main(String[] args) {

        def clzLoader = JdbcDemo.getClass().getClassLoader();

        println 'classLoader '+clzLoader;

        def sql = Sql.newInstance("jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimezone=GMT&useSSL=false", "root",
                "123456", "com.mysql.cj.jdbc.Driver")

        sql.eachRow("select * from t_user"){ println it.id +  " ${it.username}"}


        // insert
//        def data = [id: 3, name:'访客', username: 'guest',password:'123456']
//        sql.execute """
//                INSERT INTO t_user (id, name,username,password)
//                VALUES (${data.id}, ${data.name},${data.username},${data.password});
//        """

        sql.eachRow("select * from t_user"){ println it.id +  " ${it.username}"}

        List athletes = sql.rows('SELECT * FROM t_user')

        athletes.each { n-> println "id=${n.id}"}
//        print athletes

        // first row
        def firstRow = sql.firstRow("select * from t_user")
        println firstRow

    }

}
