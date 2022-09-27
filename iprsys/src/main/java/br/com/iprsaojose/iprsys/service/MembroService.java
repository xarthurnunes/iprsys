package br.com.iprsaojose.iprsys.service;

import java.util.List;

import br.com.iprsaojose.iprsys.model.Membro;

public interface MembroService {
    List<Membro> findAll();
    Membro findById(long id);
    Membro save(Membro membro);
    List<Membro> findBynomeMembroContainingIgnoreCase(String nomeMembro);
    
}
