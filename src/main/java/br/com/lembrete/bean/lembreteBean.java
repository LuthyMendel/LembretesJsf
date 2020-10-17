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
		
		return "index.xhtml?faces-redirect=true";
		
	}
	
	public String remover() {
		
		mapper.remover(lembrete);
		
		lembrete = new Lembrete();
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null,new FacesMessage("Lembrete REMOVIDO com sucesso"));
		context.getExternalContext().getFlash().setKeepMessages(true);
		
		return "index.xhtml?faces-redirect=true";
		
		
		
	}
	
	
	public void lembretePorId() {
		lembrete = mapper.buscar(lembrete.getId());
		
		if(lembrete == null || lembrete.getId() == 0) {
			
			lembrete = new Lembrete();
			FacesMessage message = new FacesMessage(null, "Lembrete não encontrado");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		
		
	}
	
	public String editar() {
		
		mapper.editar(lembrete);
		
		lembrete = new Lembrete();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Lembrete editado com sucesso"));
		context.getExternalContext().getFlash().setKeepMessages(true);
		return "index.xhtml?faces-redirect=true";
		
		
	}

}
