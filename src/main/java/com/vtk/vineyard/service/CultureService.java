package com.vtk.vineyard.service;

import com.vtk.vineyard.model.Culture;
import com.vtk.vineyard.repositoy.CultureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CultureService {

    @Autowired
    private CultureRepo cRepo;

    public List<Culture> listAll() {
        return cRepo.findAll();
    }

    public void save(Culture culture) {
        cRepo.save(culture);
    }

    public Culture get(Long id) {
        return cRepo.findById(id).get();
    }

    public void delete(Long id) {
        cRepo.deleteById(id);
    }

}
