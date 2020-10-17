package br.com.lembrete.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.lembrete.Lembrete;
import br.com.lembrete.web.LembreteMapper;


@ManagedBean
@SessionScoped
public class lembreteBean {
	
	
	private Lembrete lembrete;
	private LembreteMapper mapper = new LembreteMapper();
	
	//Não recomendado apenas para teste
	@PostConstruct
	public void init() {
		
		lembrete = new Lembrete();
	}
	
	public Lembrete getLembrete() {
		
		return lembrete;
	}
	
	
	public List<Lembrete> getLembretes(){
		
		return mapper.getLembretes();
	}
	
	public String adicionar() {
		
		mapper.adicionar(lembrete);
		
		//É preciso reiniciar pois os dados estão dentro da sessão
		lembrete = new Lembrete();
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null,new FacesMessage("Lembrete adicionando com sucesso"));
		context.getExternalContext().getFlash().setKeepMessages(true);
		
		return "index.xhtml";
		
	}

}
