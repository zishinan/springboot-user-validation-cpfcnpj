package service.validation;

import domain.TipoCliente;
import dto.UserDto;
import resources.exceptions.FieldMessage;
import service.validation.utils.BR;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UserInsertValidator implements ConstraintValidator<UserInsert, UserDto> {

    @Override
    public void initialize(UserInsert userInsert) {}

    @Override
    public boolean isValid(UserDto objDto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
            list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
        }

        if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
            list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
        }

        return list.isEmpty();
    }
}