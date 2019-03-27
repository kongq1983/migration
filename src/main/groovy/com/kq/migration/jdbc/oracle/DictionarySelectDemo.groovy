package com.kq.migration.jdbc.oracle;

import com.kq.migration.jdbc.config.DatabaseConfig;


/**
 * DictionarySelectDemo
 * 读取数据字典
 * @author kq
 * @date 2019-03-26
 */
public class DictionarySelectDemo {


    static void main(String[] args) {


        def sql = DatabaseConfig.getOracleInstance();

//        sql.eachRow("select zdlx,zdbm,zdmc from s_dictionary d where d.zdlx='SaleType'"){ println it.id +  " ${it.zdlx}" +" ${it.zdbm}"+" ${it.zdmc}"}


        List athletes = sql.rows("select zdlx,zdbm,zdmc from s_dictionary d where d.zdlx='SaleType'")

        print athletes.size()

        athletes.each { n-> println "zdlx=${n.zdlx} code=${n.zdbm} name=${n.zdmc}"}


    }

}
