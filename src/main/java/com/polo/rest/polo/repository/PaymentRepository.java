package com.polo.rest.polo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.polo.rest.polo.entity.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long>
{
	boolean existsByCardIdAndYear(int cardId, int year);
	boolean existsByCardIdAndYearAndMonth(int cardId, int year, int monthIndex);
    List<Payment> getByCardIdAndYear( int cardId, int year );
    Payment getByCardIdAndYearAndMonth(int cardId, int year, int monthIndex );

    @Query("SELECT DISTINCT p.year FROM Payment p WHERE p.cardId =:myparam ORDER BY p.year")
    List<Integer> findDistinctYearByCardId(@Param("myparam") int cardId);

}
