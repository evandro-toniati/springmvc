package org.casadocodigo.loja.validation;

import org.casadocodigo.loja.models.Produto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ProdutoValidation implements Validator {
	public void valida(Produto produto, Errors errors) {
	    ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
	    ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
	    if(produto.getPaginas() <= 0){
	        errors.rejectValue("paginas", "field.required");
	    }
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}
}
