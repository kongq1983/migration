package com.kq.migration.vo

/**
 * Capacity
 *
 * @author1 kq
 * @date 2019-03-27
 */
class Capacity {

    int startSaleOrder;
    int endSaleOrder;

    int startSaleOrderDetail;
    int endSaleOrderDetail;

    int startProductVote;
    int endProductVote;

    int startShoppingCart;
    int endShoppingCart;


    @Override
    String toString() {

        return """\
            Capacity{
                startSaleOrder=$startSaleOrder, 
                endSaleOrder=$endSaleOrder, 
                startSaleOrderDetail=$startSaleOrderDetail, 
                endSaleOrderDetail=$endSaleOrderDetail, 
                startProductVote=$startProductVote, 
                endProductVote=$endProductVote, 
                startShoppingCart=$startShoppingCart, 
                endShoppingCart=$endShoppingCart
            }"""
    }
}
