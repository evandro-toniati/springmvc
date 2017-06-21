package org.casadocodigo.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.casadocodigo.loja.daos.ProdutoDAO;
import org.casadocodigo.loja.models.Produto;
import org.casadocodigo.loja.models.TipoPreco;
import org.casadocodigo.loja.validation.ProdutoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("produtos")
public class ProdutosController {

	@RequestMapping("/form")
    public ModelAndView form(){

        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoPreco.values());

        return modelAndView;
    }
	
	@Autowired
    private ProdutoDAO produtoDao;
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView gravar(@Valid Produto produto, RedirectAttributes redirectAttributes){
	 System.out.println(produto);
	 produtoDao.gravar(produto);
	 redirectAttributes.addFlashAttribute("sucesso","Produto cadastrado com sucesso!");
	 return new ModelAndView("redirect:produtos");
	}
	@InitBinder
	public void InitBinder(WebDataBinder binder){
	    binder.addValidators(new ProdutoValidation());
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar(){
	    List<Produto> produtos = produtoDao.listar();
	    ModelAndView modelAndView = new ModelAndView("/produtos/lista");
	    modelAndView.addObject("produtos", produtos);
	    return modelAndView;
	}
}
