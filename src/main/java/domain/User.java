package domain;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Document
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 100, message = "O nome deve deve ter tamanho entre 5 e 100 caracters!")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "Email inválido")
    private String email;

    private String cpf;
    private String cnpj;

}
