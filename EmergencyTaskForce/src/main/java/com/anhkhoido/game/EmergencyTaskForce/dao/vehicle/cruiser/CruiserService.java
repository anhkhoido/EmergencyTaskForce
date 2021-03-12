package com.anhkhoido.game.EmergencyTaskForce.dao.vehicle.cruiser;

import com.anhkhoido.game.EmergencyTaskForce.model.vehicle.Cruiser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CruiserService implements CruiserRepository {

    private CruiserRepository cruiserRepository;

    @Autowired
    public CruiserService(CruiserRepository cruiserRepository) {
        this.cruiserRepository = cruiserRepository;
    }

    @Override
    public Cruiser save(Cruiser cruiser) {
        return cruiserRepository.findById(cruiser.getId()).orElse(cruiserRepository.save(cruiser));
    }

    @Override
    public <S extends Cruiser> Iterable<S> saveAll(Iterable<S> iterable) {
        return cruiserRepository.saveAll(iterable);
    }

    @Override
    public Optional<Cruiser> findById(Integer id) {
        return cruiserRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return cruiserRepository.existsById(id);
    }

    @Override
    public Iterable<Cruiser> findAll() {
        return cruiserRepository.findAll();
    }

    @Override
    public Iterable<Cruiser> findAllById(Iterable<Integer> iterable) {
        return cruiserRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return cruiserRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        if (cruiserRepository.findById(id).isPresent()) {
            cruiserRepository.deleteById(id);
        }
    }

    @Override
    public void delete(Cruiser cruiser) {
        if (cruiserRepository.findById(cruiser.getId()).isPresent()) {
            cruiserRepository.delete(cruiser);
        }
    }

    @Override
    public void deleteAll(Iterable<? extends Cruiser> iterable) {
        cruiserRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        cruiserRepository.deleteAll();
    }
}
