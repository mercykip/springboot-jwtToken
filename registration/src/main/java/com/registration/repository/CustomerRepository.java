package com.registration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registration.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

	Optional<Customer> findByUsername(String username);
	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
