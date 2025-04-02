package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import application.model.Genero;
import application.repository.GeneroRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {
    private final GeneroRepository generoRepository;

    @Autowired
    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public List<Genero> findAll() {
        return (List<Genero>) generoRepository.findAll();
    }

    public Optional<Genero> findById(Long id) {
        return generoRepository.findById(id);
    }

    public Genero save(Genero genero) {
        return generoRepository.save(genero);
    }

    public void delete(Long id) {
        generoRepository.deleteById(id);
    }
}

