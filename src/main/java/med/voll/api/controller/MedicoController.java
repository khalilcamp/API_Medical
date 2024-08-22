package med.voll.api.controller;

import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
//    Passar para o controle após o GEt
    @Autowired
    private MedicoRepository repository;
    //    Maneira de chamar e dizer que caso chegue, está fazendo o pedido para cadastrar.
    @PostMapping
//    Parametro deve pegar do CORPO da requisição
//    public void cadastrar(@RequestBody String json){
//    System.out.println(json);
//    }
    // Pegar dados especificos
//    CRIE UM RECORD
    public void cadastrar(@RequestBody DadosCadastroMedico dados){
        repository.save(new Medico(dados));

    }
}
