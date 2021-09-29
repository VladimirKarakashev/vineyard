package com.vtk.vineyard.service;

import com.vtk.vineyard.model.Phenophase;
import com.vtk.vineyard.repositoy.PhenophaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhenophaseService {

    @Autowired
    private PhenophaseRepo phRepo;

    public List<Phenophase> listAll(String key) {
        if (key != null) {
            return phRepo.findAll(key);
        }
        return phRepo.findAll();
    }

    public List<Phenophase> findAll() {
        return phRepo.findAll();
    }

    public void save(Phenophase phenophase) {
        phRepo.save(phenophase);
    }

    public Phenophase get(Long id) {
        return phRepo.findById(id).get();
    }

    public void delete(Long id) {
        phRepo.deleteById(id);
    }
}
