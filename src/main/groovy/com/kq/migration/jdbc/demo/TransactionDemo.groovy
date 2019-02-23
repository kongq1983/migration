package com.kq.migration.jdbc.demo

/**
 * TransactionDemo
 *
 * @author1 kq
 * @date 2019-02-22
 */
class TransactionDemo {

    static void insert(){

        def sql = DatabaseConfig.getSqlInstance()

        //事务
        sql.withTransaction {

            sql.execute '''
                INSERT INTO t_user (id, name,username,password)
                VALUES (30,'test30','test30','123456');
            '''


            sql.execute '''
                INSERT INTO t_user (id, name,username,password)
                VALUES (1,'test30','test30','123456');
            '''

        }

    }


    static void main(String[] args) {
        insert();
    }


}
