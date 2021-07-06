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

## 4 - Implementação Android
1. Para utilizar a aplicação via socket com um servidor calculadora
    - Utilize o servidor socket presente no item #1 deste trabalho
    - Edite o endereço de IP do servidor socket dentro do arquivo MainApplication 
    - Compile os arquivos
2. A comunicação via HTTP já está implementada e não precisa fazer nenhuma alteração nessa implementação

## 5 - Implementação do Sistema de Alarmes
1. Verifique o endereço de IP do broker MQTT utilizado
    - Edite os arquivos em cada projeto, inserindo o endereço de IP do broker
    - CAT: Alterar o arquivo `MqttPublish` inserindo na variável `broker` o endereço IP adequado.
    - Alarms: Alterar o arquivo `AlarmSubscriber` inserindo na variável `serverURI` o endereço IP adequado.
    - TemperatureEventGenerator: Alterar o arquivo `MqttPublish` inserindo na variável `broker` o endereço IP adequado.
2. Compile os códigos
    - `javac *`
3. Execute cada projeto
    - `java [projeto]`
