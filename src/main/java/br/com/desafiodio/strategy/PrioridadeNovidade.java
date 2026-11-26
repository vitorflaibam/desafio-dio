package br.com.desafiodio.strategy;

import br.com.desafiodio.model.Midia;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Order(2)
public class PrioridadeNovidade implements CuradoriaStrategy {

    @Override
    public boolean seAplica(Midia midia) {
        return midia.getLancamento() != null && midia.getLancamento().isAfter(LocalDate.now().minusMonths(6));
    }

    @Override
    public String calcular() {
        return "NOVIDADE";
    }
}
