package com.unab.g04nosql.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unab.g04nosql.Collection.MeasuredUnits;
import com.unab.g04nosql.IService.IMeasuredUnitsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/measuredUnits")
public class MeasuredUnitsController {

    @Autowired
    private IMeasuredUnitsService service;

    @GetMapping
    public List<MeasuredUnits> all() {
        return service.all();
    }

    @GetMapping("{id}")
    public Optional<MeasuredUnits> show(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public MeasuredUnits save(@RequestBody MeasuredUnits measuredUnits) {
        return service.save(measuredUnits);
    }

    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public MeasuredUnits update(@PathVariable String id, @RequestBody MeasuredUnits measuredUnits) {
        Optional<MeasuredUnits> op = service.findById(id);

        if (!op.isEmpty()) {
            MeasuredUnits measuredUnitsUpdate = op.get();
            measuredUnitsUpdate.setCodigo(measuredUnits.getCodigo());
            measuredUnitsUpdate.setNombre(measuredUnits.getNombre());
            measuredUnitsUpdate.setDescripcion(measuredUnits.getDescripcion());
            measuredUnitsUpdate.setEstado(measuredUnits.getEstado());
            return service.save(measuredUnitsUpdate);
        }

        return measuredUnits;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

}
