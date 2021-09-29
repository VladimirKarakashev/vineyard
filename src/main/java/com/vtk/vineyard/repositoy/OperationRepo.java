package com.vtk.vineyard.repositoy;

import com.vtk.vineyard.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OperationRepo extends JpaRepository<Operation, Long> {

    //List operations by keyword
    @Query("SELECT op FROM Operation op WHERE "
            + "CONCAT(op.date, op.name)"
            + " LIKE %?1%")
    public List<Operation> findAll(String key);

    //Total costs of selected operations by keyword
    @Query("SELECT SUM(cost) FROM Operation op WHERE"
            + " CONCAT(op.date, op.name)"
            + " LIKE %?1%")
    public Float findAllByCost(String key);

    //Total time spent on operations from the selection
    @Query("SELECT SUM(duration) FROM Operation op WHERE"
            + " CONCAT(op.date, op.name)"
            + " LIKE %?1%")
    public Float findAllByDuration(String Key);

    //Total number of operations from the selection
    @Query("SELECT COUNT(id) FROM Operation op WHERE"
            + " CONCAT(op.date, op.name)"
            + " LIKE %?1%")
    public Integer findAllById(String Key);

}
