package br.com.desafiodio.strategy;

import br.com.desafiodio.model.Midia;
import br.com.desafiodio.model.StatusMidia;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class PrioridadeAcompanhamento implements CuradoriaStrategy {

    @Override
    public boolean seAplica(Midia midia) {
        return midia.getStatus() == StatusMidia.ASSISTINDO;
    }

    @Override
    public String calcular() {
        return "CONTINUAR";
    }
}
