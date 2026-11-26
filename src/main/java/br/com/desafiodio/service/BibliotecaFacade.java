package br.com.desafiodio.service;

import br.com.desafiodio.model.Midia;
import br.com.desafiodio.model.StatusMidia;
import br.com.desafiodio.model.TipoMidia;
import br.com.desafiodio.repository.MidiaRepository;
import br.com.desafiodio.strategy.CuradoriaStrategy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BibliotecaFacade {

    private final MidiaRepository repository;
    private final List<CuradoriaStrategy> prioridades;

    public BibliotecaFacade(MidiaRepository repository, List<CuradoriaStrategy> prioridades) {
        this.repository = repository;
        this.prioridades = prioridades;
    }

    public List<Midia> listar() {
        return repository.findAll();
    }

    public Midia buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mídia não encontrada"));
    }

    public Midia adicionar(Midia midia) {
        validar(midia);
        midia.setId(null);
        midia.setStatus(StatusMidia.NA_LISTA);
        definirPrioridade(midia);
        return repository.save(midia);
    }

    public Midia atualizar(Long id, Midia dados) {
        Midia midia = buscar(id);
        validar(dados);
        midia.setTitulo(dados.getTitulo());
        midia.setGenero(dados.getGenero());
        midia.setTipo(dados.getTipo());
        midia.setTemporadas(dados.getTemporadas());
        midia.setLancamento(dados.getLancamento());
        definirPrioridade(midia);
        return repository.save(midia);
    }

    public Midia iniciar(Long id) {
        Midia midia = buscar(id);
        midia.setStatus(StatusMidia.ASSISTINDO);
        definirPrioridade(midia);
        return repository.save(midia);
    }

    public Midia finalizar(Long id) {
        Midia midia = buscar(id);
        midia.setStatus(StatusMidia.FINALIZADO);
        definirPrioridade(midia);
        return repository.save(midia);
    }

    public void remover(Long id) {
        repository.delete(buscar(id));
    }

    private void definirPrioridade(Midia midia) {
        String prioridade = prioridades.stream()
                .filter(estrategia -> estrategia.seAplica(midia))
                .findFirst()
                .orElseThrow()
                .calcular();
        midia.setPrioridade(prioridade);
    }

    private void validar(Midia midia) {
        if (midia.getTitulo() == null || midia.getTitulo().trim().isEmpty() || midia.getTipo() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Título e tipo são obrigatórios");
        }
        if (midia.getTipo() == TipoMidia.FILME && midia.getTemporadas() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Filmes não possuem temporadas");
        }
    }
}
