package com.example.springtemplate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutFormRepository extends  JpaRepository<AboutForm, Long> {
}
