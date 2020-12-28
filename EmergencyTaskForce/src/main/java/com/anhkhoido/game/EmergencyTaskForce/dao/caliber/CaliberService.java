package com.anhkhoido.game.EmergencyTaskForce.dao.caliber;

import com.anhkhoido.game.EmergencyTaskForce.model.firearm.Caliber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CaliberService implements CaliberRepository {

    private CaliberRepository caliberRepository;

    @Autowired
    public CaliberService(CaliberRepository caliberRepository) {
        this.caliberRepository = caliberRepository;
    }

    @Override
    public Caliber save(Caliber caliber) {
        return caliberRepository.save(caliber);
    }

    @Override
    public <S extends Caliber> Iterable<S> saveAll(Iterable<S> iterable) {
        return caliberRepository.saveAll(iterable);
    }

    @Override
    public Optional<Caliber> findById(Integer id) {
        return caliberRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return caliberRepository.existsById(id);
    }

    @Override
    public Iterable<Caliber> findAll() {
        return caliberRepository.findAll();
    }

    @Override
    public Iterable<Caliber> findAllById(Iterable<Integer> iterable) {
        return caliberRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return caliberRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        caliberRepository.deleteById(id);
    }

    @Override
    public void delete(Caliber caliber) {
        caliberRepository.delete(caliber);
    }

    @Override
    public void deleteAll(Iterable<? extends Caliber> iterable) {
        caliberRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        caliberRepository.deleteAll();
    }

    @Override
    public Optional<Caliber> findByName(@Param("name") String name) {
        return caliberRepository.findByName(name);
    }
}
