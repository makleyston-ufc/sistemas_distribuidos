# sistemas_distribuidos

## 1 - Sockets em Java

1. Compile os arquivos .java
    - Execute dentro do diretório com os .java (./src)
    - `javac -d ../bin *.java`
    - `javac -d ../bin *.java`

2. Execute o Servidor
    - Execute dentro do diretório com os .class (./bin)
    - `java CalculadoraServerSocket`

3. Execute o Cliente
   - Execute dentro do diretório com os .class (./bin)
   - `java CalculadoraCliente`

## 2 - HTTP em Java

1. Compile os arquivos .java
    - Execute dentro do diretório com os .java (./src)
    - `javac -d ../bin *.java`
  
2. Execute o Cliente
    - Execute dentro do diretório com os .class (./bin)
    - `java CalculadoraClientHTTP`

## 3 - RMI em Java

1. Compile os arquivos
    - Execute dentro do diretório com os .java (./src)
    - `javac -d ../bin *.java`

2. Execute o servidor de Nomes (<b><i>rmiregistry</i></b>)
    - Execute dentro do diretório que possui os .class (./bin)
    - `rmiregistry`
  
3. Execute o servidor
    - Execute dentro do diretório que possui os .class (./bin)
    - `java -Djava.server.rmi.codebaseile://rmi/ -Djava.security.policy=policy CalculadoraServer`
  
4. Execute o cliente
    - Execute dentro do diretório que possui os .class (./bin)
    - `java -Djava.security.policy=policy CalculadoraCliente`