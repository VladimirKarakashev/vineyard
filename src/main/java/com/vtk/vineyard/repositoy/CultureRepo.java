package com.vtk.vineyard.repositoy;

import com.vtk.vineyard.model.Culture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CultureRepo extends JpaRepository<Culture, Long> {
}
