package br.com.iprsaojose.iprsys.service.serviceImpl;

import java.util.List;

import br.com.iprsaojose.iprsys.model.Membro;
import br.com.iprsaojose.iprsys.repository.MembroRepository;
import br.com.iprsaojose.iprsys.service.MembroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembroServiceImpl implements MembroService {

    @Autowired
    MembroRepository membroRepository;



    @Override
    public List<Membro> findAll() {
        return membroRepository.findAll();
    }

    @Override
    public Membro findById(long id) {
        return membroRepository.findById(id).get();
    }

    @Override
    public Membro save(Membro membro) {
        return membroRepository.save(membro);
    }

    @Override
    public List<Membro> findBynomeMembroContainingIgnoreCase(String nomeMembro) {
        return membroRepository.findByNomeMembroContainingIgnoreCase(nomeMembro);
    }

    

    

    
    
}
