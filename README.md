# Novidades Java


## Por Versão


#### 8

 - Default methods - interfaces agora podem ter métodos com implementação padrão usando a palavra reservada *default*.
 - Espressões Lambda - trabalhando com interfaces funcionais (possuem apenas um método abstrato). Exemplo: *novidades.java8.ExpressoesLambda.java*.
 - Stream API - métodos que permitem encadeamento, paralelismo, imutabilidade e facilidade ao trabalhar com *Collections*.


#### 9

 - Factory methods para *Collections* - constroem coleções imutáveis de objetos. Exemplo: *novidades.java9.FabricaCollections.java*
 - JShell - um terminal iterativo para receber e processar comandos Java. Basta digitar *jshell* no prompt e começar a iteragir com o console que permite comandos *Java*.
 - Flow API - fluxo reativo assíncrono, não bloqueante, usando o padrão Observer (*publish-subscribe*)
 - JigSaw - modularização


#### 10

 - Inferência de variáveis - com a palavra reservada *var*, somente em métodos (com inicialização imediata), não pode ser usado como atributo de uma classe, nem para assinatura de um método. Exemplo: *novidades.java10.InferenciaVariaveis.java*


#### 11

 - Http/2 - Client API - implementa HTTP/2 e *Web Socket*, com requisições em paralelo e assíncronas. Exemplos: *novidades.java11.HttpClientApi.java* e *novidades.java11..java*


#### 13

 - Socket API - agora com implementação modernizada
 - Text Blocks - permite formatação prévia de literais de conjuntos de caracteres com várias linhas sem o uso de sequências de caracteres de escape, usando simplesmente três aspas duplas de cada lado ("""Exemplo"""). Exemplo: *novidades.java13.BlocosTexto.java*


#### 14

 - Helpful NullpointerException - descrevendo precisamente qual variável tem o valor *null*


## Lambda

As expressões Lambda foram introduzidas no *Java* 8, e utiliza conceitos de programação funcional. Pode ser criada sem pertencer a nenhuma classe e pode ser passada como um objeto (funções de alta ordem), sendo executada quando necessário. Como principais utilizdades temos *event listeners* e com a *Java Streams API*. 


#### Paradigma Funcional

Uma definição de programação funcional muito bem aceita é dada por [Eric Elliott](https://medium.com/javascript-scene/master-the-javascript-interview-what-is-functional-programming-7f218c68b3a0):

"Functional programming (often abbreviated FP) is the process of building software by composing pure functions, avoiding shared state, mutable data, and side-effects. Functional programming is declarative rather than imperative, and application state flows through pure functions. Contrast with object oriented programming, where application state is usually shared and colocated with methods in objects."

Algumas ideias por trás do paradigma de programação funcional são:

 - Funções puras - sempre que se efetua uma chamada a uma função pura com o mesmo valor de entrada, obtém-se o mesmo resultado como saída.
 - Composição de funções - funções podem receber outras funções como entrada de forma a gerar um novo comportamento.
 - Evitar estado compartilhado - uma propriedade ou valor compartilhado por várias funções ou escopos do código.
 - Imutabilidade - prefira objetos imutáveis, uma vez criados não devem ser modificados.
 - Evitar efeitos colaterais - ao executar uma função, o único resultado esperado deve ser seu valor de retorno, evitando alterações em outros objetos, contexto, ou dados.
 - Interfaces funcionais - apresentam apenas um método abstrato. Podem ser declaradas com a anotação *@FunctionalInterface*. Utilizam o paradigma funcional.
 - Funções de alta ordem - recebe ou retorna uma função.
 - Consumer - recebem um parâmetro e não possuem um retorno (*void*). Possuem a assinatura *Consumer<T>*, são executadas através do método *void accept(T)*.
 - Supplier - não recebem parâmetro e possuem um tipo de retorno. Possuem a assinatura *Supplier<T>*, são executadas através do método *T get()*.
 - Function - recebem um parâmetro e possuem um retorno. Possuem a assinatura *Function<T, R>*, são executadas através do método *R apply(T)*.
 - Predicate - recebem um parâmetro e possuem um retorno *boolean*. Possuem a assinatura *Predicate<T>*, são executadas através do método *boolean test(T)*.


#### Extrutura de uma Expressão Labda

Quando a Lambda possui apenas uma instrução em sua lógica:

```
InterfaceFuncional variavel = parametro -> logica;
```

Quando possui mais de uma instrução em sua lógica é necessário usar um bloco de código e definir o retorno explícitamente (caso não seja *void*).

```
InterfaceFuncional variavel = parametro -> {
        ...
        //comandos
        ...
        return ...
    };
```

## Stream API

Um *Stream* é um fluxo de elementos, a partir de uma fonte de dados, que permite diferentes tipos de operações de agregação. Ajuda a manipular coleções (*Collections*) com o uso de programação funcional. Com o uso de um *Stream* o programador ganha:

 - velocidade - uso de paralelismo no processamento dos dados - especialmente com o uso de *parallel()*, a partir de um *stream* ou *parallelStream()*, a partir de uma coleção - tornando a execução do código possívelmente mais rápida;
 - encapsulamento não se preocupar em como a coleção é acessada e percorrida, a API faz isso;
 - menor *verbosidade* - redução na quantidade de laços (*loops*), consequentemente, diminuição do número de linhas escritas para um mesmo comportamento, tal controle fica a cargo da API.
 
Permite a criação de um *pool* de *threads*, limitando o uso de recursos.

## Fluxos Reativos (Reactive Streams)

Especifica um padrão para processamento de fluxo assíncrono não bloqueante, definindo um conjunto mínimo de interfaces para atingir esses fins:

 - *org.reactivestreams.Publisher* é um provedor de dados que publica dados para os assinantes com base em sua demanda;
 - *org.reactivestreams.Subscriber* é o consumidor de dados - ele pode receber dados após se inscrever em um editor;
 - *org.reactivestreams.Subscription* é criado quando um editor aceita um assinante;
 - *org.reactivestreams.Processor* é assinante e editor - ele se inscreve em um editor, processa os dados e, em seguida, passa os dados processados para o assinante.


## Modularização (Jigsaw)

Modularização no *Java* tem como objetivo principal resolver dois problemas: listas gigantes de diretórios no *claspath* e grandes programas monolíticos. As dependênias externas podem ser determinadas agora no arquivo *module-info.java*.
Esse novo recurso permite também que classes internas a uma aplicação não sejam visíveis no mundo externo. Para isto é necessário criar os módulos adicionando no arquivo *module-info.java* as informações dos pacotes a serem utilizados:

- no módulo a ser exportado, o arquivo *module-info.java* deve ser:

```
module modulo.a.ser.exportado {
  requires java.base  // import padrão, mesmo que você não coloque o compilador vai adicionar

  // o que está entre colchetes é opcional, utilizado para definir para qual módulo exportar
  exports caminho.completo.do.pacote.a.ser.disponibilizado [to modulo.que.utiliza.a.dependencia];
}
```

- no módulo onde se deseja utilizar o módulo exportado, o arquivo *module-info.java* deve ser:

```
module modulo.que.utiliza.a.dependencia {
  requires caminho.completo.do.pacote.a.ser.disponibilizado;
  
  exports ...;
}
```

*IMPORTANTE*!!! Digamos que haja um outro módulo que depende do acima declarado, utilizando um serviço que retorne um objeto de uma classe de um outro módulo, do qual a acima declarada depende. É depender da dependência!!! :)
Para que não seja necessário declarar a dependência da dependência, sempre que for retornar um objeto definido em outra dependência, use não apenas o *requires*, mas sim o *requires transitive*, que significa que o require será passado para outros módulos que dependam do que está fazendo este tipo de import.

Os módulos também devem determinar suas dependências externas, mesmo em relação à linguagem, por exemplo:

```
module modulo.que.utiliza.a.dependencia {
  requires java.base  // import padrão, mesmo que você não coloque o compilador vai adicionar
  requires java.sql;  // para fazer import do java.sql.Date
  requires java.net.http;  // para fazer import do java.net.HttpClient
}
```


## Referências

[Alura](https://www.alura.com.br/) - Curso "Novidades do Java: Produtividade com novos recursos" - instrutor João Victor

[Digital Innovation One](https://digitalinnovation.one/) - Curso "Desenvolvimento avançado em Java" - instrutor João Paulo Oliveira Santos

[Oracle](https://www.oracle.com/) - Technical Resources

[Baeldung](https://www.baeldung.com/)