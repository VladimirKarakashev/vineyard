package com.vtk.vineyard.service;

import com.vtk.vineyard.model.Operation;
import com.vtk.vineyard.repositoy.OperationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {

    @Autowired
    private OperationRepo opRepo;

    public List<Operation> listAll(String key) {
        if (key != null) {
            return opRepo.findAll(key);
        }
        return opRepo.findAll();
    }

    public void save (Operation operation) {
        opRepo.save(operation);
    }

    public Operation get(Long id) {
        return opRepo.findById(id).get();
    }

    public void delete(Long id) {
        opRepo.deleteById(id);
    }
}
