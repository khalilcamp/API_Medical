package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

// Criar enum especialidade
public record DadosCadastroMedico(
//        Criar validação
        @NotNull
                @NotBlank
        String nome,
        @NotNull
            @NotBlank
        String email,
        @NotNull
//        Um padrao usado
            @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        String telefone ,
        @NotNull
        Especialidade especialidade,
        @NotNull @Valid DadosEndereco endereco
) {
}
