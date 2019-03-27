package com.kq.migration.jdbc.demo

import com.kq.migration.jdbc.config.DatabaseConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * BatchDemo
 *
 * @author1 kq
 * @date 2019-02-21
 */
class BatchDemo {

    protected static Logger logger = LoggerFactory.getLogger(BatchDemo.class);


    static void batchInsert() {

        logger.debug("BatchDemo main is call.");

        def sql = DatabaseConfig.getSqlInstance()
        sql.eachRow("select * from t_user"){ println it.id +  " ${it.username}"}


        def qry = '''
        INSERT INTO t_user (id, name,username,password)
                VALUES (?,?,?,?);
        '''
        sql.withBatch(3, qry) { ps ->   //batchSize 0 一起提交   3:3条提交1次
            ps.addBatch(18, 'jack','jack', '123456')
            ps.addBatch(19, 'jack1','jack1', '123456')
            ps.addBatch(20, 'jack2','jack2', '123456')
        }
        sql.eachRow("select * from t_user"){ println it.id +  " ${it.username}"}

        sql.close()
    }



    static void batchUpdate() {

        logger.debug("BatchDemo batchUpdate is call.");

        def sql = DatabaseConfig.getSqlInstance()
        sql.eachRow("select * from t_user"){ println it.id +  " ${it.username}"}


        def qry = '''
        update t_user set name=? where id=?;
        '''
        sql.withBatch(3, qry) { ps ->   //batchSize 0 一起提交   3:3条提交1次
            ps.addBatch('jack',18)
            ps.addBatch('jack1',19)
            ps.addBatch('jack2',20)
        }
        sql.eachRow("select * from t_user"){ println it.id +  " ${it.username}"}

        sql.close()
    }


    static void main(String[] args) {

//        batchInsert();
        batchUpdate();
    }

}
