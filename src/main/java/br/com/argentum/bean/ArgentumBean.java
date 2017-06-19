package br.com.argentum.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.argentum.model.Negociacao;
import br.com.argentum.ws.ClientWebService;

@ViewScoped
@ManagedBean
public class ArgentumBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6955708258884337359L;

	private List<Negociacao> negociacoes = new ArrayList<>();

	public ArgentumBean() {
		this.negociacoes = new ClientWebService().getNegociacoes();
	}

	public List<Negociacao> getNegociacoes() {
		return this.negociacoes;
	}
}
