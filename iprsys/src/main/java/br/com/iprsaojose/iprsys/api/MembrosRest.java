package br.com.iprsaojose.iprsys.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import br.com.iprsaojose.iprsys.model.Membro;
import br.com.iprsaojose.iprsys.repository.MembroRepository;


@Controller
@ResponseBody
@CrossOrigin
@RequestMapping("/api/membros")
public class MembrosRest {
    
    @Autowired
    private MembroRepository membroRepository;

    @GetMapping(value = "/buscarmembros") 
        public List<Membro> getListar(){
        //listar todos os membros
        List<Membro> lista = membroRepository.findAll();
        return lista;
        }
    
    @GetMapping(value = "/buscarmembro/{id}")
    public Membro getMostrar(@PathVariable Long id) {
        //listar o membro referente ao id
        Membro membro = membroRepository.findById(id).get();
        return membro;
    }

    
    @PostMapping(value="/cadastrarmembros")
    public Membro postCadastrar(@RequestBody Membro membro) {
        //recebe o membro preenchido no formulário e grava no banco
        Membro membroSalvo = membroRepository.save(membro);
        return membroSalvo;
    }

    @DeleteMapping(value="/deletar/{id}")
    public void getDeletar(@PathVariable Long id) {
        // deleta o membro referente ao id
        membroRepository.deleteById(id);        
    }
    
    @GetMapping(value="/buscarmembronome/{nomeMembro}")
        //Busca o membro referente pelo nome
    public List<Membro> getPesquisarPorNome(@PathVariable String nomeMembro) {
        List<Membro> lista = membroRepository.findByNomeMembroContainingIgnoreCase(nomeMembro);
        return lista;
    }
    
        
}
