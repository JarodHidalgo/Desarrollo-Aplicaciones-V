-- Ingresos
INSERT INTO categoria (nombre, tipo) VALUES ('Salario Neto', 'INGRESO');
INSERT INTO categoria (nombre, tipo) VALUES ('Remesas', 'INGRESO');
INSERT INTO categoria (nombre, tipo) VALUES ('Beca', 'INGRESO');
INSERT INTO categoria (nombre, tipo) VALUES ('Viáticos', 'INGRESO');

-- Egresos
INSERT INTO categoria (nombre, tipo) VALUES ('Agua', 'EGRESO');
INSERT INTO categoria (nombre, tipo) VALUES ('Luz', 'EGRESO');
INSERT INTO categoria (nombre, tipo) VALUES ('Internet + Cable', 'EGRESO');
INSERT INTO categoria (nombre, tipo) VALUES ('Plan de Datos', 'EGRESO');
INSERT INTO categoria (nombre, tipo) VALUES ('Recargas', 'EGRESO');
INSERT INTO categoria (nombre, tipo) VALUES ('Transporte', 'EGRESO');
INSERT INTO categoria (nombre, tipo) VALUES ('Comidas', 'EGRESO');
INSERT INTO categoria (nombre, tipo) VALUES ('Extras', 'EGRESO');
-- IDs generados: 1-4 (ingresos), 5-12 (egresos)


INSERT INTO usuario (username, password) VALUES ('test', 'test');
-- ID generado: 1


-- Ingresos (usuario_id=1, fechas en enero 2025)
INSERT INTO transaccion (usuario_id, categoria_id, monto, fecha, descripcion, es_recurrencia, frecuencia) 
VALUES (1, 1, 3000.00, '2025-01-01', 'Salario mensual', 1, 'MENSUAL');

INSERT INTO transaccion (usuario_id, categoria_id, monto, fecha, descripcion, es_recurrencia, frecuencia) 
VALUES (1, 2, 500.00, '2025-01-15', 'Remesa familiar', 0, '');

INSERT INTO transaccion (usuario_id, categoria_id, monto, fecha, descripcion, es_recurrencia, frecuencia) 
VALUES (1, 3, 1500.00, '2025-01-10', 'Beca universitaria', 1, 'MENSUAL');

-- Egresos (usuario_id=1, fechas en enero 2025)
INSERT INTO transaccion (usuario_id, categoria_id, monto, fecha, descripcion, es_recurrencia, frecuencia) 
VALUES (1, 5, 200.00, '2025-01-05', 'Pago de agua', 1, 'MENSUAL');

INSERT INTO transaccion (usuario_id, categoria_id, monto, fecha, descripcion, es_recurrencia, frecuencia) 
VALUES (1, 6, 300.00, '2025-01-10', 'Pago de luz', 1, 'MENSUAL');

INSERT INTO transaccion (usuario_id, categoria_id, monto, fecha, descripcion, es_recurrencia, frecuencia) 
VALUES (1, 7, 150.00, '2025-01-15', 'Internet y cable', 1, 'MENSUAL');

INSERT INTO transaccion (usuario_id, categoria_id, monto, fecha, descripcion, es_recurrencia, frecuencia) 
VALUES (1, 8, 100.00, '2025-01-20', 'Plan de datos móvil', 1, 'MENSUAL');

INSERT INTO transaccion (usuario_id, categoria_id, monto, fecha, descripcion, es_recurrencia, frecuencia) 
VALUES (1, 9, 50.00, '2025-01-25', 'Recarga telefónica', 0, '');

INSERT INTO transaccion (usuario_id, categoria_id, monto, fecha, descripcion, es_recurrencia, frecuencia) 
VALUES (1, 10, 200.00, '2025-01-12', 'Transporte público', 0, '');

INSERT INTO transaccion (usuario_id, categoria_id, monto, fecha, descripcion, es_recurrencia, frecuencia) 
VALUES (1, 11, 400.00, '2025-01-18', 'Comidas diarias', 0, '');

INSERT INTO transaccion (usuario_id, categoria_id, monto, fecha, descripcion, es_recurrencia, frecuencia) 
VALUES (1, 12, 150.00, '2025-01-28', 'Gastos extras (cine)', 0, '');
-- IDs generados: 1-11


-- Para Salario (transaccion_id=1)
INSERT INTO recurrencia (transaccion_id, fecha_inicio, fecha_fin) 
VALUES (1, '2025-01-01', '2025-12-31');

-- Para Beca (transaccion_id=3)
INSERT INTO recurrencia (transaccion_id, fecha_inicio, fecha_fin) 
VALUES (3, '2025-01-10', '2025-12-31');

-- Para Agua (transaccion_id=4)
INSERT INTO recurrencia (transaccion_id, fecha_inicio, fecha_fin) 
VALUES (4, '2025-01-05', '2025-12-31');

-- Para Luz (transaccion_id=5)
INSERT INTO recurrencia (transaccion_id, fecha_inicio, fecha_fin) 
VALUES (5, '2025-01-10', '2025-12-31');

-- Para Internet (transaccion_id=6)
INSERT INTO recurrencia (transaccion_id, fecha_inicio, fecha_fin) 
VALUES (6, '2025-01-15', '2025-12-31');

-- Para Plan de Datos (transaccion_id=7)
INSERT INTO recurrencia (transaccion_id, fecha_inicio, fecha_fin) 
VALUES (7, '2025-01-20', '2025-12-31');