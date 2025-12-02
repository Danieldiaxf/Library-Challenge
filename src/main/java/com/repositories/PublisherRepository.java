package com.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long>{

}
