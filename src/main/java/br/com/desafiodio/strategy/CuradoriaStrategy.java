package br.com.desafiodio.strategy;

import br.com.desafiodio.model.Midia;

public interface CuradoriaStrategy {
    boolean seAplica(Midia midia);
    String calcular();
}
