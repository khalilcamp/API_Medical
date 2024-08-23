package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
//    Passar para o controle após o GEt
    @Autowired
    private MedicoRepository repository;
    //    Maneira de chamar e dizer que caso chegue, está fazendo o pedido para cadastrar.
    @PostMapping
//    Será necessário um metodo de transação pro banco
    @Transactional
//    Parametro deve pegar do CORPO da requisição
//    public void cadastrar(@RequestBody String json){
//    System.out.println(json);
//    }
    // Pegar dados especificos
//    CRIE UM RECORD
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));

    }
    // Listagem
    // Paginacao
    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size=10, page = 0, sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }
}
