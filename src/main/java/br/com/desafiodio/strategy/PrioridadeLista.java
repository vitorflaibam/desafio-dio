package br.com.desafiodio.strategy;

import br.com.desafiodio.model.Midia;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class PrioridadeLista implements CuradoriaStrategy {

    @Override
    public boolean seAplica(Midia midia) {
        return true;
    }

    @Override
    public String calcular() {
        return "MINHA LISTA";
    }
}
