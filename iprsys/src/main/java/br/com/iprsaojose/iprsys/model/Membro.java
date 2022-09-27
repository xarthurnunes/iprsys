package br.com.iprsaojose.iprsys.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TB_Membro")
@Getter
@Setter
@NoArgsConstructor
public class Membro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String nomeMembro;

    @NotBlank
    private String telefoneMembro;

    @NotBlank
    private String emailMembro;
    

    
}
