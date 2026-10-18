PRAGMA foreign_keys = ON;

-- 1. Inserción de Rubros
INSERT INTO Rubros (nombre) VALUES
('Golosinas'),
('Bebidas'),
('Snacks'),
('Panificados');

-- 2. Inserción de Productos
INSERT INTO Productos (nombre, precio_unitario, stock_disponible, id_rubro) VALUES
('Bon o Bon', 500.0, 1000, 1),
('Alfajor Guaymallén simple x40', 250.0, 40, 1),
('Agua mineral 500ml', 600.0, 200, 2),
('Gaseosa cola 500ml', 900.0, 150, 2);

-- 3. Inserción de Pedidos (fecha_hora toma el DEFAULT automático)
INSERT INTO Pedidos (alias, estado, total) VALUES
('eugenio', 'PENDIENTE', 1600.0);

-- 4. Inserción de Items del Pedido
INSERT INTO ItemsPedido (id_pedido, id_producto, cantidad, subtotal) VALUES
(1, 1, 2, 1000.0),
(1, 3, 1, 600.0);