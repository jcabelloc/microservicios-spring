DROP TABLE IF EXISTS prestamo;

CREATE TABLE prestamo (
  	cod_prestamo        SERIAL PRIMARY KEY,
	fecha_solicitud		DATE NOT NULL,
	monto				NUMERIC(10,2) NOT NULL,
	cod_cliente			INT NOT NULL, 
	estado				TEXT NOT NULL);

INSERT INTO prestamo(cod_prestamo, fecha_solicitud, monto, cod_cliente, estado)
VALUES (100001, '2019-07-01', 1200.00, 1001, 'SOLICITADO');
INSERT INTO prestamo(cod_prestamo, fecha_solicitud, monto, cod_cliente, estado)
VALUES (100002, '2019-07-02', 1400.00, 1002, 'SOLICITADO');
INSERT INTO prestamo(cod_prestamo, fecha_solicitud, monto, cod_cliente, estado)
VALUES (100003, '2019-07-04', 1500.00, 1003, 'SOLICITADO');
INSERT INTO prestamo(cod_prestamo, fecha_solicitud, monto, cod_cliente, estado)
VALUES (100004, '2019-07-07', 1300.00, 1004, 'SOLICITADO');

DROP TABLE IF EXISTS cliente;

CREATE TABLE cliente (
  	cod_cliente        	SERIAL PRIMARY KEY,
	nombre              TEXT NOT NULL,
	email          		TEXT NOT NULL,
	telefono       		TEXT NOT NULL
	);

INSERT INTO cliente(cod_cliente, nombre, email, telefono)
VALUES (1001, 'Maziel Alzamora', 'ma@gmail.com', '987654321');
INSERT INTO cliente(cod_cliente, nombre, email, telefono)
VALUES (1002, 'Ivan Ale Caceres', 'iac@gmail.com', '987654321');
INSERT INTO cliente(cod_cliente, nombre, email, telefono)
VALUES (1003, 'Marco Comun', 'mc@gmail.com', '987654321');
INSERT INTO cliente(cod_cliente, nombre, email, telefono)
VALUES (1004, 'Ivan Oscco Cossio', 'ioc@gmail.com', '987654321');