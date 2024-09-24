package com.project.shopapp.repositories;

import com.project.shopapp.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategryRepository extends JpaRepository<Category, Long> {
}
