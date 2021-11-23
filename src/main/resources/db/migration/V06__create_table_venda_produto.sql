CREATE TABLE venda_produto (

	id BIGINT(20) NOT NULL AUTO_INCREMENT,
	id_venda BIGINT(20) NOT NULL,
	id_produto BIGINT(20) NOT NULL,
	quantidade INTEGER NOT NULL,
	valor_unitario DOUBLE,
	valor_desconto DOUBLE,
	
	PRIMARY KEY (id, id_venda),
	
	FOREIGN KEY (id_venda) REFERENCES venda(id),
	FOREIGN KEY (id_produto) REFERENCES produto(id)
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8;