package com.vtk.vineyard.repositoy;

import com.vtk.vineyard.model.Phenophase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhenophaseRepo extends JpaRepository<Phenophase, Long> {

    @Query("SELECT ph FROM Phenophase ph WHERE ph.name LIKE %?1%")
    public List<Phenophase> findAll(String key);
}
