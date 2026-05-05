## 1.1 Sistema de comércio eletrônico
Um produto tem uma descrição, um preço e uma quantidade em estoque. Um cliente tem um nome, um
e-mail e um ou mais endereços de entrega. Um cliente pode fazer um ou mais pedidos. Um pedido tem uma
data, uma situação (pendente, pago, entregue, cancelado), um ou mais produtos, sendo que cada produto
tem uma quantidade e um preço unitário.

```mermaid
classDiagram
    
    class Produto {
        - descricao: String
        - preco: double
        - quantidadeEstoque: int
        + atualizarEstoque() void
    }
    
    class Cliente {
        - nome: String
        - email: String
        - enderecos: ArrayList~Endereco~
        - pedidos: ArrayList~Pedido~
        + adicionarEndereco (Endereco endereco) void
        + adicionarPedido (Pedido pedido) void
    }
    
    class Endereco {
        - rua: String
        - bairro: String
        - cidade: String
        - cep: String
    }
    
    class Pedido {
        - dataPedido: LocalDate
        - situacaoPedido: String
        - produtos: ArrayList~Produto~
        - quantidade: ArrayList~Integer~
        + fazerPedido(Produto produto, int qtd) void
        + cancelarPedido() void
        + marcarComoEntregue() void
        + valorTotal(double total) double
    }
    Cliente "1" *-- "1..*" Endereco
    Cliente "1" o-- "0..*" Pedido
    Pedido "1" o-- "1..*" Produto
    
```

## 1.2 Sistema de avaliação de filmes
Um filme tem um título, um ano de lançamento, um gênero, um diretor e um ou mais atores. Um ator tem
um nome e uma data de nascimento. Um filme pode ter uma ou mais avaliações, e cada avaliação está
associada a um único filme e a um único usuário. Um usuário tem um nome, um e-mail e uma senha. Um
usuário pode avaliar um ou mais filmes. Uma avaliação tem uma nota (de 1 a 5) e um comentário.

```mermaid
classDiagram 
    class Filme {
        - titulo: String
        - anoLancamento: String
        - genero: String
        - diretor: String
        - atores: ArrayList~Ator~
        + adicionarAtor(Ator ator)
        + adicionarAvaliacao(Avaliacao avaliacao)
        + calcularMediaAvaliacoes() double
    }
    class Avaliacao {
        - nota: int
        - comentario: String
        - usuario: Usuario
        + getNota(): int
        + getComentario(): String
        + getUsuario(): Usuario
    }
    
    class Ator {
        - nome: String
        - dataNascimento: LocalDate
        + getNome() String
        + getDataNascimento() LocalDate
    }
    
    class Usuario {
        - nome: String
        - email: String
        - senha: String
        + avaliarFilme(Filme filme, int nota, String comentario) Avaliacao
        + getNome() String
        + getEmail() String
    }
    
    Ator "0..*" --o "1..*" Filme
    Filme "1" *-- "0..*" Avaliacao
    Usuario "1" *-- "0..*" Avaliacao
```

## 1.3 Sistema de Gestão de Frotas
Uma empresa possui uma frota de veículos. Cada veículo tem um modelo, uma placa e um ano de fabricação.
A empresa tem vários motoristas, e cada motorista pode dirigir um ou mais veículos. A empresa
registra o uso de cada veículo, incluindo a data, o motorista e a distância percorrida.

```mermaid
classDiagram 
    class Empresa {
        - frota: ArrayList~Veiculo~
        - motoristas: ArrayList~Motorista~
        - registros: ArrayList~RegistroUso~
    }

    class RegistroUso {
        - data: LocalDate
        - distanciaPercorrida: double
        - veiculo: Veiculo
        - motorista: Motorista
    }
    
    class Motorista {
        - nome: String
        - cnh: String
        - veiculosHabiitados: ArrayList~Veiculo~
    }

    class Veiculo {
        - modelo: String
        - placa: String
        - anoFabricacao: int
    }

    Empresa "1" *-- "0..*" Veiculo
    Empresa "1" *-- "0..*" RegistroUso
    Empresa "1" *-- "0..*" Motorista
    Motorista "1" o-- "1..*" Veiculo
    RegistroUso "1" o-- "1" Motorista
    RegistroUso "1" o-- "1" Veiculo
```

## 1.4 Sistema de reserva de passagens aéreas
Uma companhia aérea oferece voos para diversos destinos. Cada voo tem um número de voo, um destino,
uma data e uma hora de partida, e uma capacidade máxima de passageiros. Os passageiros podem reservar
assentos em um voo, e cada reserva está associada a um único passageiro e a um único voo. Um passageiro
tem um nome, um e-mail e um número de telefone.

```mermaid
classDiagram 
    class Voo {
        numeroVoo: int
        destino: String
        data: LocalDate
        hora: LocalTime
        capacidadeMax: int
        reservas: ArrayList~Reserva~
    }
    class Passageiro {
        - nome: String
        - email: String
        - telefone: String
    }
    
    class Reserva {
        numAssento: int
        voo: Voo
        passageiro: Passageiro
    }
    
    Passageiro "1" *-- "0..*" Reserva
    Voo "1" o-- "0..*" Reserva
```

