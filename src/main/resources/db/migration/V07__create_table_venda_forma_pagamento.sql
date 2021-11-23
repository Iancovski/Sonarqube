CREATE TABLE venda_forma_pagamento (

	id BIGINT(20) NOT NULL AUTO_INCREMENT,
	id_venda BIGINT(20) NOT NULL,
	id_forma_pagamento BIGINT(20) NOT NULL,
	valor DOUBLE NOT NULL,
	
	PRIMARY KEY (id, id_venda),
	
	FOREIGN KEY (id_venda) REFERENCES venda(id),
	FOREIGN KEY (id_forma_pagamento) REFERENCES forma_pagamento(id)
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8;