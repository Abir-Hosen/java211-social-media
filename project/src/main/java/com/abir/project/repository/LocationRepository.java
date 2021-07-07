package com.abir.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abir.project.modal.Location;

@Repository("shortainerRepository")
public interface LocationRepository extends JpaRepository<Location, Long> {

}
