package com.ex.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
