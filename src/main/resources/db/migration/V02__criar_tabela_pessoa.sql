CREATE TABLE pessoa(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	ativo BOOLEAN,
	logradouro varchar(50),
	numero varchar(10),
	complemento varchar(50),
	bairro varchar(50),
	cep varchar(14),
	cidade varchar(50),
	estado varchar(20)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
	VALUES ('joao', true, 'casa', '507', 'condominio', 'santuario', '85555000', 'palmas', 'parana');
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
	VALUES ('rooh', false, 'casa', '507', 'condominio', 'santuario', '85555000', 'palmas', 'parana');
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
	VALUES ('pedro', true, 'casa', '811', 'condominio', 'santuario', '85555000', 'palmas', 'parana');
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
	VALUES ('paulo', true, 'casa', '507', 'condominio', 'santuario', '85555000', 'palmas', 'parana');