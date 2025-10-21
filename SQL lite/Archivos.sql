-- Crear la base de datos 
-- Habilitar claves foráneas para integridad referencial
PRAGMA foreign_keys = ON;

-- 2. Crear tablas (con PK y FK)
-- Tabla de clientes: id como PK autoincremental
CREATE TABLE clientes (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    email TEXT UNIQUE,
    edad INTEGER
);

-- Tabla de productos: id como PK
CREATE TABLE productos (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    precio REAL,
    categoria TEXT
);

-- Tabla de pedidos: id como PK, con FK a clientes y productos
CREATE TABLE pedidos (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    cliente_id INTEGER,
    producto_id INTEGER,
    cantidad INTEGER,
    fecha TEXT DEFAULT CURRENT_DATE,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id),
    FOREIGN KEY (producto_id) REFERENCES productos(id)
);

-- 4. INSERT: Agregar datos de ejemplo
INSERT INTO clientes (nombre, email, edad) VALUES ('Juan Pérez', 'juan@example.com', 25);
INSERT INTO clientes (nombre, email, edad) VALUES ('Ana García', 'ana@example.com', 30);
INSERT INTO clientes (nombre, email, edad) VALUES ('Carlos López', 'carlos@example.com', 22);

INSERT INTO productos (nombre, precio, categoria) VALUES ('Laptop', 1200.00, 'Electrónica');
INSERT INTO productos (nombre, precio, categoria) VALUES ('Mouse', 25.50, 'Electrónica');
INSERT INTO productos (nombre, precio, categoria) VALUES ('Libro', 15.00, 'Libros');

INSERT INTO pedidos (cliente_id, producto_id, cantidad) VALUES (1, 1, 1);  -- Juan compra Laptop
INSERT INTO pedidos (cliente_id, producto_id, cantidad) VALUES (2, 2, 2);  -- Ana compra 2 Mouse
INSERT INTO pedidos (cliente_id, producto_id, cantidad) VALUES (3, 3, 1);  -- Carlos compra Libro

-- 4. SELECT: Consultar datos
-- Seleccionar todos los clientes
SELECT * FROM clientes;

-- Seleccionar productos con precio > 20 (usando WHERE y operador relacional >)
SELECT nombre, precio FROM productos WHERE precio > 20;

-- 4. UPDATE: Modificar datos
-- Actualizar edad de Juan
UPDATE clientes SET edad = 26 WHERE nombre = 'Juan Pérez';

-- 4. DELETE: Eliminar datos
-- Eliminar pedidos con cantidad < 2
DELETE FROM pedidos WHERE cantidad < 2;

-- 5. WHERE: Filtrar en consultas
-- Clientes mayores de 24
SELECT nombre, edad FROM clientes WHERE edad > 24;

-- 6. Operadores relacionales: Comparaciones
-- Productos con precio >= 20 y <= 100
SELECT nombre, precio FROM productos WHERE precio >= 20 AND precio <= 100;

-- 7. Operadores lógicos (AND/OR/NOT)
-- Pedidos de clientes con edad > 20 AND (categoria 'Electrónica' OR 'Libros')
SELECT p.id, c.nombre, pr.nombre AS producto, pr.categoria
FROM pedidos p
JOIN clientes c ON p.cliente_id = c.id
JOIN productos pr ON p.producto_id = pr.id
WHERE c.edad > 20 AND (pr.categoria = 'Electrónica' OR pr.categoria = 'Libros');

-- Usando NOT: Productos que NO son de Electrónica
SELECT nombre FROM productos WHERE NOT categoria = 'Electrónica';

-- 8. BETWEEN: Rango de precios
-- Productos con precio entre 10 y 50
SELECT nombre, precio FROM productos WHERE precio BETWEEN 10 AND 50;

-- 9. IN: Lista de valores
-- Clientes con edad en (22, 25, 30)
SELECT nombre, edad FROM clientes WHERE edad IN (22, 25, 30);

-- 10. LIKE: Búsqueda de patrones
-- Clientes cuyos nombres empiecen con 'J'
SELECT nombre FROM clientes WHERE nombre LIKE 'J%';

-- Productos con nombres que contengan 'oo' (como Mouse)
SELECT nombre FROM productos WHERE nombre LIKE '%oo%';

-- Verificar tablas y datos finales
.tables;
.schema;
SELECT * FROM clientes;
SELECT * FROM productos;
SELECT * FROM pedidos;