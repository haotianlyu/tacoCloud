package com.tacoCloud.haotian.repository;

import com.tacoCloud.haotian.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
