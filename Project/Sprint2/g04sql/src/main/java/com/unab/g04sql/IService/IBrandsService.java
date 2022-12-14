package com.unab.g04sql.IService;

import java.util.List;
import java.util.Optional;

import com.unab.g04sql.Entity.Brands;

public interface IBrandsService {

    public List<Brands> all();

    public Optional<Brands> findById(Integer id);

    public Brands save(Brands brands);

    public void delete(Integer id);
}
