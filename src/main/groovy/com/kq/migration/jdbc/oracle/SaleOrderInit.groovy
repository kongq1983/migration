package com.kq.migration.jdbc.oracle

import com.kq.migration.jdbc.config.DatabaseConfig

import java.util.UUID;

/**
 * SaleOrderInit
 *
 * @author1 kq
 * @date 2019-03-26
 */
class SaleOrderInit {

    static void insert(def size) {

        def sql = DatabaseConfig.getOracleInstance()

        (1..size).each{
//            println it

//            println "---------开始执行第${it}条-----------"

            def uuid = UUID.randomUUID().toString().replace("-","");
//            println uuid+"  size="+uuid.length()

            if(it==1)readDataBaseSize(sql,size,"s_sale_order",true);
            //插入订单表
            insertSaleOrder(sql,uuid);
            if(it==size)readDataBaseSize(sql,size,"s_sale_order",false);

            if(it==1)readDataBaseSize(sql,size,"s_sale_order_detail",true);
            //插入订单表
            insertSaleOrderDetail(sql,uuid);
            if(it==size)readDataBaseSize(sql,size,"s_sale_order_detail",false);


            if(it==1)readDataBaseSize(sql,size,"S_PRODUCT_VOTE",true);
            //插入评价
            insertProductVote(sql,uuid);
            if(it==size)readDataBaseSize(sql,size,"S_PRODUCT_VOTE",false);


            if(it==1)readDataBaseSize(sql,size,"S_SHOPPING_CART",true);
            //购物车
            insertShoppingCard(sql,uuid);
            if(it==size)readDataBaseSize(sql,size,"S_SHOPPING_CART",false);

        }

    }

    static void main(String[] args) {

        (1..10).each{
            def newSize = it * 100;
            insert(newSize)
//            println "newSize=${newSize}"
        }

//        insert(200)

//        readDataBaseSize(DatabaseConfig.getOracleInstance(),100,"s_sale_order",true);
//        readDataBaseSize(DatabaseConfig.getOracleInstance(),100,"s_sale_order",false);
    }



    static void insertSaleOrder(def sql,def uuid){



        def str = "insert into S_SALE_ORDER (saleorderid, xsdbh, userid, xsqd, ddje, fkje, ddzt, zffs, shdz, shfs, xdsj, thzt, zfzt, fhzt, orgid, zfddh, spsj, spyj, spry, zfwcsj, ztdz, jykh, jyqb, shzd, ddbz, qhbm, sfqc, xsrq, xslb, sfdy, createuser, createtime, lastmodifyuser, lastmodifytime, active, qhzt, chsj, qhsj, tablenumber, discount, source, login, refundtype, refundstatus, thirdopenid, refundsettingtime, asyncpay, " +
                "asyncpaystatus) values ('${uuid}', '20181206015842ESTgJU', '0b33984bb2c6437180cce2903a9f7097', 6, .1, .1, 2, 1, '1233', 2, to_date('06-12-2018 01:58:42', 'dd-mm-yyyy hh24:mi:ss'), 0, 0, 0, 'd77981fad80741c38370e57733401bbc', null, null, null, null, null, '海创园', null, null, null, null, null, 0, null, null, 0, '0b33984bb2c6437180cce2903a9f7097', to_date('06-12-2018', 'dd-mm-yyyy'), '0b33984bb2c6437180cce2903a9f7097', to_date('06-12-2018', 'dd-mm-yyyy'), 1, 0, null, null, null, null, 0, 1, 0, 0, null, null, 0, 0)";

//        println str

        sql.execute(str);

    }


    static void insertSaleOrderDetail(def sql,def uuid){

        //插5条
        (1..5).each{
            def detailId = UUID.randomUUID().toString().replace("-","");

            def str = "insert into S_SALE_ORDER_DETAIL (saleorderdetailid, saleorderid, onlineproductid, inventoryid, xssl, thsl, fhsl, xsdj, xsje, xsyj, thzt, fhzt, gysid, dthsl, createuser, createtime, lastmodifyuser, lastmodifytime, active, discount) " +
                    "values ('${detailId}', '${uuid}', 'F14FF395DF704DF8A8094B734F6D9AE9', '67DACCE491054E848CBCCDD17A5FFA83', 1, null, null, .1, .1, .1, 0, 0, null, null, '0b33984bb2c6437180cce2903a9f7097', to_date('06-12-2018 14:58:40', 'dd-mm-yyyy hh24:mi:ss'), null, null, 1, null)"
//            println str

            sql.execute(str);
        }



    }

    static void insertProductVote(def sql,def uuid){

        (1..5).each{
            def detailId = UUID.randomUUID().toString().replace("-","");

            def str = "  insert into S_PRODUCT_VOTE (productvoteid, inventoryid, orgid, tpry, tpsj, tpxj, pjnr, tplx, xslb, xssj, sccs, spzt, createuser, createtime, lastmodifyuser, lastmodifytime, active) " +
                    "        values ('${detailId}', '${uuid}', 'd77981fad80741c38370e57733401bbc', '0b33984bb2c6437180cce2903a9f7097', to_date('10-12-2018 17:14:51', 'dd-mm-yyyy hh24:mi:ss'), 5, '2132133', 0, '5', to_date('10-12-2018', 'dd-mm-yyyy'), null, 1, '0b33984bb2c6437180cce2903a9f7097', to_date('10-12-2018 17:14:51', 'dd-mm-yyyy hh24:mi:ss'), '0b33984bb2c6437180cce2903a9f7097', to_date('10-12-2018 17:14:51', 'dd-mm-yyyy hh24:mi:ss'), 1)";
            sql.execute(str);
        }

    }

    static void insertShoppingCard(def sql,def uuid) {

        (1..5).each {
            def detailId = UUID.randomUUID().toString().replace("-", "");
            def str = "insert into S_SHOPPING_CART (shoppingcartid, userid, onlineproductid, gwcsl, qdlx, xsrq, xslb, orgid, createuser, createtime, lastmodifyuser, lastmodifytime, active, source, login, thirdopenid)\n" +
                    "        values ('${detailId}', '2ac79af3227d4e33b921b0b48a3e4f4f', '4ce6cf74b37e43e783ae11b3cb775a33', 1, -2, to_date('20-03-2019', 'dd-mm-yyyy'), '2', 'd77981fad80741c38370e57733401bbc', '2ac79af3227d4e33b921b0b48a3e4f4f', to_date('20-03-2019 15:56:15', 'dd-mm-yyyy hh24:mi:ss'), '2ac79af3227d4e33b921b0b48a3e4f4f', to_date('20-03-2019 15:56:15', 'dd-mm-yyyy hh24:mi:ss'), 1, 0, 1, null)";

            sql.execute(str);

        }
    }

    static void readDataBaseSize(def sql,def size,def tablename,def isStart){

        def str = "select sum(bytes)/1024 as capacity from user_segments  where segment_name=upper('${tablename}')" ;

        def dbCapacity = sql.firstRow(str)

        if(isStart){
            println "start number=${size} ${tablename} capacity= ${dbCapacity}"
        } else {
            println "-end- number=${size} ${tablename} capacity= ${dbCapacity}"
        }


    }

}
