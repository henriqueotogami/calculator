<div align="center">

# Basic Calculator | Calculadora Básica

<img width="auto" src="https://github.com/henriqueotogami/calculator/blob/main/calculator.png?raw=true">
<br>
<br>
<div align="center">
<img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/henriqueotogami/calculator">
</div>
<br>
<img src="https://img.shields.io/github/issues/henriqueotogami/calculator">
<img src="https://img.shields.io/github/forks/henriqueotogami/calculator">
<img src="https://img.shields.io/github/stars/henriqueotogami/calculator">
<img src="https://img.shields.io/github/license/henriqueotogami/calculator">
</div>
<br>
<div align=center>
<a href="https://wakatime.com/badge/user/1e53636e-c916-4d50-9ce1-f3ac75a883e3/project/450f1106-c350-4299-b27b-957bde617d8e"><img src="https://wakatime.com/badge/user/1e53636e-c916-4d50-9ce1-f3ac75a883e3/project/450f1106-c350-4299-b27b-957bde617d8e.svg" alt="wakatime"></a>
</div>
<br>
<hr>

**Data:** 27/07/2022

**Curso:** [Cod3r | Java 2022 Completo](https://www.udemy.com/course/fundamentos-de-programacao-com-java/)

## 📋 Sobre o Projeto

Este projeto contém uma aplicação desktop em Java utilizando Swing para a construção de uma calculadora de operações matemáticas básicas. Desenvolvido como parte do curso de Java 2022 Completo da Cod3r, o projeto implementa os padrões de design **Singleton** e **Observer**, com arquitetura separada em camadas de modelo (model) e visão (view).

> Aplicação Desktop Java de uma calculadora de operações matemáticas básicas (soma, subtração, multiplicação e divisão), para cálculo de números inteiros e pontos flutuantes.
> Não realiza cálculos de números negativos diretamente.

<br>

## Demonstração

| Printscreen | Vídeo |
| ----------- | ----- |
| <img src="https://github.com/henriqueotogami/calculator/blob/main/src/br/com/otogamidev/img/otogami-dev-Java-desktop-calculator.png?raw=true"> | [![Watch the video](https://img.youtube.com/vi/cWrxBB0KVMg/maxresdefault.jpg)](https://youtu.be/cWrxBB0KVMg) |

<br>

## 📁 Estrutura do Projeto

### Modelo (`src/br/com/otogamidev/model/`)
- **Memory.java** — Classe singleton responsável pela lógica de cálculo, armazenamento de operandos e processamento de comandos
- **ObserverMemory.java** — Interface funcional para o padrão Observer, permitindo que o Display seja notificado das alterações

### Visão (`src/br/com/otogamidev/view/`)
- **Calculator.java** — Classe principal que inicia a aplicação e organiza o layout (Display + Keyboard)
- **Display.java** — Painel de exibição dos números, implementa ObserverMemory para atualização em tempo real
- **Keyboard.java** — Teclado numérico e operadores, implementa ActionListener para captura de cliques
- **Button.java** — Componente personalizado para os botões da calculadora

## 📂 Estrutura do Repositório

```
LICENSE
README.md
.gitignore
.github/
  FUNDING.yml
src/br/com/otogamidev/
  model/
    Memory.java          # lógica de cálculo e estado da calculadora
    ObserverMemory.java  # interface do padrão Observer
  view/
    Calculator.java      # janela principal da aplicação
    Display.java         # área de exibição dos valores
    Keyboard.java        # teclado com botões numéricos e operadores
    Button.java          # componente de botão customizado
```

## 🛠️ Tecnologias Utilizadas

- **[Java 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)** — Linguagem de programação
- **Java Swing** — Biblioteca gráfica para interface desktop
- **IntelliJ IDEA** — Ambiente de desenvolvimento recomendado

## 📝 Funcionalidades Principais

### Operações Matemáticas
- Soma (+)
- Subtração (-)
- Multiplicação (×)
- Divisão (/)
- Suporte a números decimais (vírgula como separador)
- Botão AC para limpar e resetar

### Padrões de Design
- **Singleton** — A classe `Memory` possui uma única instância global
- **Observer** — O `Display` se inscreve como observador e é notificado a cada alteração de valor
- **Separação de responsabilidades** — Model (lógica) e View (interface) bem definidos

## 🚀 Como Executar

### Pré-requisitos
- Java JDK 11 ou superior instalado
- (Opcional) IntelliJ IDEA ou outra IDE compatível

### Compilação e execução via Terminal

```bash
# Navegue até o diretório do projeto
cd calculator

# Compile os arquivos fonte
javac -d out src/br/com/otogamidev/model/*.java src/br/com/otogamidev/view/*.java

# Execute a aplicação
java -cp out br.com.otogamidev.view.Calculator
```

### Via IntelliJ IDEA
1. Abra o projeto na IDE
2. Localize a classe `Calculator.java` em `src/br/com/otogamidev/view/`
3. Execute o método `main` (clique direito → Run 'Calculator.main()')

## 📚 Conteúdos Abordados

- ✅ Programação orientada a objetos em Java
- ✅ Interface gráfica com Java Swing (JFrame, JPanel, JButton, JLabel)
- ✅ Padrão Singleton
- ✅ Padrão Observer
- ✅ Layout Managers (BorderLayout, GridBagLayout, FlowLayout)
- ✅ Eventos e ActionListener
- ✅ Interfaces funcionais (@FunctionalInterface)

## ⚙️ Como Funciona

### Fluxo da Aplicação
1. A classe `Calculator` inicia a janela e monta o layout com `Display` (norte) e `Keyboard` (centro)
2. O `Display` se registra como observador da `Memory` e exibe o valor atual
3. Ao clicar em um botão, o `Keyboard` chama `Memory.processCommand(valor)`
4. A `Memory` identifica o tipo de comando (número, operador, AC, vírgula, igual)
5. Para números: armazena em `firstBufferedText` ou `secondBufferedText` conforme o contexto
6. Para operadores: guarda o operador em `lastCommandType` e limpa o display para o próximo número
7. Para igual: executa a operação matemática, atualiza o resultado e notifica os observadores
8. O `Display` recebe a notificação via `changeValue()` e atualiza o texto exibido

### Tratamento de Comandos
- **Números (0-9)**: Concatena ou substitui conforme o estado
- **Vírgula (,)** : Adiciona separador decimal (uma única vírgula por número)
- **Operadores (+, -, ×, /)** : Armazena o operador e prepara para o segundo operando
- **AC** : Reseta todo o estado da memória
- **=** : Calcula e exibe o resultado, permitindo operações encadeadas

<hr>

## Ambiente de Desenvolvimento

### Sistema Operacional
MacOS Monterey — Versão 12.5

### IDE
IntelliJ IDEA Community Edition 2022.1

#### Plugins Recomendados
- [Atom Material Icons](https://plugins.jetbrains.com/plugin/10044-atom-material-icons)
- [Codota AI Autocomplete for Java](https://plugins.jetbrains.com/plugin/7638-codota-ai-autocomplete-for-java-and-javascript)
- [GitToolBox](https://plugins.jetbrains.com/plugin/7499-gittoolbox)
- [Nyan Progress Bar](https://plugins.jetbrains.com/plugin/8575-nyan-progress-bar)
- [Rainbow Brackets](https://plugins.jetbrains.com/plugin/10080-rainbow-brackets)
- [Wakatime](https://wakatime.com)
- [Xcode-Dark Theme](https://plugins.jetbrains.com/plugin/13106-xcode-dark-theme)

<hr>

## 📄 Licença

Este projeto está licenciado sob a MIT License — veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 📖 Referências

- [Cod3r | Java 2022 Completo](https://www.udemy.com/course/fundamentos-de-programacao-com-java/) — Curso de formação em Java
- [Documentação Java Swing](https://docs.oracle.com/javase/tutorial/uiswing/) — Oracle Tutorial
- Código-fonte em `src/br/com/otogamidev/`

<hr>

## 📝 Leia meus artigos

- [Artigos no Medium](https://medium.com/@henriqueotogami)
- [Artigos no Dev.to](https://dev.to/henriqueotogami)

## 💼 Conecte-se comigo

- [Perfil no LinkedIn](https://www.linkedin.com/in/henrique-matheus-alves-pereira)

## 🙏🏻 Apoie meu conteúdo

- [Compre-me um cafézinho | Buy me a coffee](https://ko-fi.com/henriqueotogami) ☕

<hr>

## Contribuições

> Caso você queira ajudar a melhorar este repositório, qualquer ajuda é bem-vinda.

1. Faça um **fork** deste repositório ([https://github.com/henriqueotogami/calculator/fork](https://github.com/henriqueotogami/calculator/fork))
2. Crie um **branch** com as suas modificações: `git checkout -b meu-novo-recurso`
3. Faça um **commit**: `git commit -am 'Adicionando um novo recurso...'`
4. Faça um **push**: `git push origin meu-novo-recurso`
5. Crie uma nova **pull request** neste repositório

**Depois que sua solicitação (pull request) for aceita e adicionada (merged) ao ramo principal (branch main), você pode excluir sua branch tranquilamente.**

<div align="center">

<hr>

> ### **Muito obrigado, e que a força esteja com você.**
>
> ### Desenvolvido por **HMAP | Henrique Matheus Alves Pereira** 🦁

</div>

---

### Hashtags

#Java #Swing #Calculator #DesktopApplication #ObjectOrientedProgramming #DesignPatterns #Singleton #Observer #OpenSource #GitHub #LearningJava #Cod3r

### Meta Keywords

```
Java, calculadora, Swing, desktop, aplicação Java, padrão Singleton, padrão Observer,
programação orientada a objetos, interface gráfica, JFrame, JPanel, JButton,
algoritmos matemáticos, operações básicas, código aberto, projeto acadêmico
```
