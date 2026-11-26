# Minha biblioteca de filmes e séries

API REST para manter uma lista pessoal do que assistir. Cada mídia recebe uma prioridade: continuar uma série já iniciada, ver uma novidade lançada nos últimos meses ou deixar na lista.

O projeto aplica Repository na persistência, Strategy para a curadoria e Facade nas operações da biblioteca. Os componentes gerenciados pelo Spring também usam o ciclo de vida singleton.

## Executando

```bash
mvn spring-boot:run
```

A API inicia em `http://localhost:8080/midias`.

Exemplo de cadastro:

```json
{
  "titulo": "Ruptura",
  "genero": "Ficção científica",
  "tipo": "SERIE",
  "temporadas": 2,
  "lancamento": "2025-01-17"
}
```

Rotas: `GET /midias`, `GET /midias/{id}`, `POST /midias`, `PUT /midias/{id}`, `PATCH /midias/{id}/iniciar`, `PATCH /midias/{id}/finalizar` e `DELETE /midias/{id}`.
