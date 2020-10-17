package br.com.lembrete.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.lembrete.Lembrete;
import br.com.lembrete.web.LembreteMapper;

@ManagedBean
@SessionScoped
public class lembreteBean {
	
	private Lembrete lembrete;
	private LembreteMapper mapper = new LembreteMapper();
	
	public Lembrete getLembrete() {
		
		return lembrete;
	}
	
	
	public List<Lembrete> getLembretes(){
		
		return mapper.getLembretes();
	}
	

}
