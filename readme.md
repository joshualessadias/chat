# Getting Started

### Como rodar o backend
1. Instale as dependências do projeto e crie o jar
   * `mvn clean install`
2. Construa a imagem do docker
   * `docker build -t chat-application .`
3. Rode o seguinte comando para iniciar o ambiente no docker
   * `docker-compose up --build`