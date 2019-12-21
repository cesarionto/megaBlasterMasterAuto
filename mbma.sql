create DATABASE mbma;
use mbma;

create table clientes(
	id smallint auto_increment,
	nome varchar(100),
	cpf varchar(100),
	rg varchar(100),
	data_nascimento date,
	nomeMae varchar(100),
	telefone_celular varchar(100),
	email varchar(100),
	estado varchar(100),
	cidade varchar(100),
	bairro varchar(100),
	rua varchar(100),
	cep varchar(100),
	numeroCasa varchar(100),
	data_cadastro date,
	primary key(id)
);
create table produtos(
	id smallint auto_increment,
	nome_produto varchar(100),
	tipo_produto varchar(100),
	detalhes_produtos varchar(100),
	altura_produto real,
	largura_produto real,
	profundidade_produto real,
	peso_produto real,
	preco_compra real,
	preco_venda real,
	data_cadastro date,
	primary key(id)
)