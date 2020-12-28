package com.anhkhoido.game.EmergencyTaskForce.dao.firearm;

import com.anhkhoido.game.EmergencyTaskForce.model.firearm.Firearm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FirearmService implements FirearmRepository {

    private FirearmRepository firearmRepository;

    @Autowired
    public FirearmService(FirearmRepository firearmRepository) {
        this.firearmRepository = firearmRepository;
    }

    @Override
    public Firearm save(Firearm firearm) {
        return firearmRepository.findById(firearm.getId()).orElse(firearmRepository.save(firearm));
    }

    @Override
    public <S extends Firearm> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Firearm> findById(Integer integer) {
        return firearmRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return firearmRepository.existsById(integer);
    }

    @Override
    public Iterable<Firearm> findAll() {
        return firearmRepository.findAll();
    }

    @Override
    public Iterable<Firearm> findAllById(Iterable<Integer> iterable) {
        return firearmRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return firearmRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        firearmRepository.deleteById(integer);
    }

    @Override
    public void delete(Firearm firearm) {
        firearmRepository.delete(firearm);
    }

    @Override
    public void deleteAll(Iterable<? extends Firearm> iterable) {
        firearmRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        firearmRepository.deleteAll();
    }

    @Override
    public Optional<Firearm> findByName(@Param("name") String name) {
        return firearmRepository.findByName(name);
    }

    @Override
    public List<Firearm> findByManufacturer(@Param("manufacturer") String manufacturer) {
        return firearmRepository.findByManufacturer(manufacturer);
    }

}
