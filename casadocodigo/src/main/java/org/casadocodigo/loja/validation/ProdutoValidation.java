package org.casadocodigo.loja.validation;

import org.casadocodigo.loja.models.Produto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ProdutoValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Produto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	    ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
	    ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
	    ValidationUtils.rejectIfEmpty(errors, "dataLancamento", "field.required");
	    Produto produto = (Produto) target;
	    if(produto.getPaginas() <= 0){
	        errors.rejectValue("paginas", "field.required");
	    }
	    
//	    if(produto.getPrecos().get(0).getValor() == null || produto.getPrecos().get(0).getValor().floatValue() <= 0){
//	    	errors.rejectValue("precoebook", "field.required");
//	    }
//	    if(produto.getPrecos().get(1).getValor() == null || produto.getPrecos().get(0).getValor().floatValue() <= 0){
//	    	errors.rejectValue("precoimpresso", "field.required");
//	    }
//	    if(produto.getPrecos().get(2).getValor() == null || produto.getPrecos().get(0).getValor().floatValue() <= 0){
//	    	errors.rejectValue("precocombo", "field.required");
//	    }
	}
}
