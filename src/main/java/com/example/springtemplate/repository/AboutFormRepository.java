package com.example.springtemplate.repository;

import com.example.springtemplate.entity.AboutForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutFormRepository extends  JpaRepository<AboutForm, Long> {
}
