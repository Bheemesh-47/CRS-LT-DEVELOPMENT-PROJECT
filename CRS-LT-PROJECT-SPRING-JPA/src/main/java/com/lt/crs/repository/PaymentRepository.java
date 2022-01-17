package com.lt.crs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lt.crs.model.Payment;

/**
 * @author deepika, Shiva, Shiva Amancha, Dinesh, Rajneesh, Bheemesh
 */

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
