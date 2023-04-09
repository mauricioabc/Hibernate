# Hibernate
## O que é?
Hibernate é um framework de mapeamento objeto-relacional (ORM) para Java. Ele fornece um mecanismo para mapear objetos Java para tabelas em um banco de dados relacional. Isso significa que você pode trabalhar com objetos Java em vez de lidar diretamente com SQL e tabelas do banco de dados.

O Hibernate permite que você trabalhe com objetos Java persistentes, ou seja, objetos que podem ser salvos e recuperados do banco de dados. Ele também fornece um conjunto de ferramentas para gerenciar a conexão com o banco de dados, executar consultas e transações.

O Hibernate é amplamente utilizado no desenvolvimento de aplicativos Java para simplificar a comunicação com o banco de dados. Ele reduz a quantidade de código necessário para trabalhar com o banco de dados, tornando o desenvolvimento mais rápido e eficiente. Além disso, o Hibernate fornece recursos de segurança, como a prevenção de injeção de SQL, o que torna o desenvolvimento mais seguro.

Em resumo, o Hibernate é uma ferramenta útil para desenvolvedores Java que desejam trabalhar com bancos de dados de forma mais eficiente, segura e produtiva. Ele simplifica a comunicação com o banco de dados, permitindo que os desenvolvedores se concentrem no desenvolvimento de recursos de aplicativos em vez de lidar diretamente com o banco de dados.

## Como usar?
Para usar o Hibernate em um projeto Java, você precisará seguir alguns passos básicos:

1. Adicionar a biblioteca Hibernate no seu projeto: Você pode fazer isso adicionando o arquivo JAR do Hibernate ao seu classpath ou configurando o Maven ou Gradle para baixar a biblioteca automaticamente.
```
<dependency>
  <groupId>org.hibernate</groupId>
  <artifactId>hibernate-core</artifactId>
  <version>5.5.7.Final</version>
</dependency>
```
2. Configurar as propriedades do Hibernate: Para que o Hibernate possa se comunicar com o banco de dados, você precisará configurar algumas propriedades, como o endereço do banco de dados, nome de usuário, senha e outros parâmetros específicos do banco de dados.
```
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.2"
  xmlns="http://xmlns.jcp.org/xml/ns/persistence"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
                      http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd">
  <persistence-unit name="myPU" transaction-type="RESOURCE_LOCAL">
    <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
    <class>com.hibernate.Entities.Pedido</class>
    <class>com.hibernate.Entities.Produto</class>
    <class>com.hibernate.Entities.ProdutoPedido</class>
    <properties>
		<!--  Propriedades JDBC SQL SERVER  -->
    <property name="javax.persistence.jdbc.driver" value="com.microsoft.sqlserver.jdbc.SQLServerDriver"/>
    <property name="javax.persistence.jdbc.url" value="jdbc:sqlserver://localhost:1433;databaseName=Dados;encrypt=false"/>
    <property name="javax.persistence.jdbc.user" value="sa"/>
    <property name="javax.persistence.jdbc.password" value="P@ssw0rd!"/>

	<!-- Configurações específicas do Hibernate -->
    <property name="hibernate.dialect" value="org.hibernate.dialect.SQLServerDialect"/>
    <property name="hibernate.hbm2ddl.auto" value="create"/>
    <property name="hibernate.show_sql" value="true"/>
    <property name="hibernate.format_sql" value="true"/>
    
	</properties>
  </persistence-unit>
</persistence>
```
3. Criar as classes de modelo: Você precisará criar as classes que representam as tabelas do banco de dados em formato de objetos Java. Cada classe deve representar uma tabela do banco de dados e seus atributos devem corresponder aos campos da tabela.

4. Mapear as classes de modelo para as tabelas do banco de dados: Você precisa usar as anotações do Hibernate ou arquivos de mapeamento XML para informar ao Hibernate como as classes de modelo correspondem às tabelas do banco de dados.

5. Usar o Hibernate para executar operações no banco de dados: Agora que as classes de modelo estão mapeadas, você pode usar as classes e métodos do Hibernate para executar operações no banco de dados, como inserir, atualizar, recuperar e excluir registros.

## Exemplo
No de código desse repositório, temos três classes: Produto, Pedido e ProdutoPedido. A classe Produto representa um produto que pode ser associado a um pedido. A classe Pedido representa um pedido realizado por um cliente, que pode conter vários produtos. Já a classe ProdutoPedido representa um item de pedido que relaciona um produto a um pedido específico.

A classe Produto tem três atributos: id, nome e preco. Esses atributos representam, respectivamente, o identificador do produto, o nome do produto e o preço do produto.

A classe Pedido tem três atributos: id, cliente e data. Esses atributos representam, respectivamente, o identificador do pedido, o nome do cliente que realizou o pedido e a data em que o pedido foi realizado.

A classe ProdutoPedido tem três atributos: id, pedido e produto. O atributo id representa o identificador do item de pedido, o atributo pedido representa o pedido ao qual esse item pertence e o atributo produto representa o produto associado a esse item de pedido. Além disso, a classe ProdutoPedido tem um atributo quantidade, que representa a quantidade do produto associada a esse item de pedido.

Para estabelecer a relação entre as classes, temos algumas anotações. Na classe ProdutoPedido, temos duas anotações: @ManyToOne que indica que um item de pedido está associado a um produto e @ManyToOne que indica que um item de pedido está associado a um pedido.

Para persistir os dados dessas classes usando o Hibernate, podemos criar os objetos Produto, Pedido e ProdutoPedido. Em seguida, podemos usar o EntityManager para persistir os objetos no banco de dados.

A dinâmica de funcionamento é a seguinte: primeiro, criamos os objetos Produto, Pedido e ProdutoPedido e associamos os produtos ao item de pedido e o item de pedido ao pedido. Por fim, usamos o EntityManager para persistir os objetos no banco de dados. O Hibernate é responsável por gerenciar a relação entre as classes e persistir os objetos corretamente no banco de dados.

## Referências
#### Framework Hibernate:
1. [https://hibernate.org](https://hibernate.org)
#### JDBC para SQLServer:
2. [https://learn.microsoft.com/pt-br/sql/connect/jdbc/deploying-the-jdbc-driver?view=sql-server-ver16](https://learn.microsoft.com/pt-br/sql/connect/jdbc/deploying-the-jdbc-driver?view=sql-server-ver16)
