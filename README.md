# Sistema Web para Matrícula em Cursos de Extensão

A crescente demanda por capacitação e especialização profissional tem levado muitos alunos a buscarem cursos de extensão em diversas áreas do conhecimento. Com o intuito de facilitar esse processo, será desenvolvido um sistema web que permita a matrícula de alunos em cursos de extensão. O sistema deverá coletar informações relevantes dos alunos e apresentar um relatório organizado dos cursos escolhidos.

## Requisitos

### 1. Formulário de Inscrição

O sistema deve apresentar um formulário onde o aluno possa:

- Informar seu prontuário.
- Informar seu nome completo.
- Inserir um ou mais endereços de e-mail.
- Selecionar os cursos de extensão que deseja realizar, entre as opções:
  - Desenvolvimento de Aplicações Web com Java e Spring Boot
  - Kotlin para Desenvolvimento de Aplicações Android
  - Java Web Services: REST e SOAP
- O formulário deve ser claro e de fácil utilização, permitindo ao aluno escolher mais de um curso.

### 2. Processamento dos Dados

- O armazenamento de dados de matrícula será feito em memória.
- Utilize o Design Pattern Singleton para manter os dados de matrícula.

### 3. Exibição dos Resultados

Após o envio do formulário, o sistema deve redirecionar o aluno para uma nova página HTML que exiba:

- O prontuário e o nome do aluno.
- Todos os endereços de e-mail fornecidos, em parágrafos separados. Caso o e-mail seja institucional (`@aluno.ifsp.edu.br`), deve ser apresentado em **negrito**.
- Cada curso escolhido, apresentado em um parágrafo específico.

### 4. Relatório de Matrículas

O sistema deve gerar um relatório que apresente a lista de alunos matriculados por curso. O relatório é gerado por demanda, ou seja, uma consulta com a indicação do curso desejado. O relatório deve incluir:

- O prontuário e nome do aluno.
- Os e-mails informados.

Esse relatório será exibido em uma nova página HTML, de forma clara e organizada.
