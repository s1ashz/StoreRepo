package com.polo.rest.polo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.polo.rest.polo.entity.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long>
{

	boolean existsByCardIdAndYear(int cardId, int year);
    List<Payment> getByCardIdAndYear( int cardId, int year );

}
