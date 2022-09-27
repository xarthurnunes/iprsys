package br.com.iprsaojose.iprsys.repository;

import java.util.List;

import br.com.iprsaojose.iprsys.model.Membro;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

public interface MembroRepository extends CrudRepository<Membro, Long> {
    //@Cacheable("membros")
    List<Membro> findByNomeMembroContainingIgnoreCase(String nomeMembro);

    //@Cacheable("membros")
    List<Membro> findAll();

    //@Cacheable("membros")
    List<Membro> findByNomeMembro(String nomeMembro);
}
