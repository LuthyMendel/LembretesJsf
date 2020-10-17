package br.com.lembrete.web;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.lembrete.Lembrete;

public class LembreteMapper {

	private List<Lembrete> lembretes = new ArrayList<Lembrete>();

	public List<Lembrete> getLembretes() {

		return lembretes;
	}

	public void adicionar(Lembrete lembrete) {
		lembrete.setId(lembretes.size() + 1);

		// Data Criação
		Instant agora = LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
		Date hoje = Date.from(agora);
		lembrete.setDataCadastro(hoje);
	

		lembretes.add(lembrete);
	}

	public void remover(Lembrete lembrete) {

		try {

			lembrete = buscar(lembrete.getId());

			lembretes.remove(lembrete);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void editar(Lembrete lembrete) {

		try {
			for (Lembrete it : lembretes) {

				if (it.getId() == lembrete.getId()) {
					it = lembrete;
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Lembrete buscar(long id) {
		Lembrete lembrete = null;

		try {
			for (Lembrete it : lembretes) {
				if (it.getId() == id) {

					lembrete = it;
					break;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lembrete;
	}

}
