package com.unab.g04sql.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unab.g04sql.Entity.Departments;


public interface IDepartamentsRepository extends JpaRepository<Departments, Integer> {

}
