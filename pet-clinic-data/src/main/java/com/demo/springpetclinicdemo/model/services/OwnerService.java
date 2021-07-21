package com.demo.springpetclinicdemo.model.services;

import com.demo.springpetclinicdemo.model.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findById(Long id);

    Owner findByLastName(String lastName);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
