package com.kq.migration

import com.kq.migration.vo.Capacity

/**
 * EntityDemo
 * @author1 kq
 * @date 2019-03-27
 */
class EntityDemo {

    static void main(String[] args) {
        def dto = new Capacity();
        dto.startSaleOrder = 100;
        dto.setEndSaleOrder(200);

        println dto

        def dto1 = new Capacity();
        dto1.startProductVote=300
        dto1.setEndProductVote(500)

        println dto1
    }

}
