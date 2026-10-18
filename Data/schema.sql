-- Activa la validación de claves foráneas en SQLite
PRAGMA foreign_keys = ON;

CREATE TABLE Rubros (
    id_rubro INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL
);

CREATE TABLE Productos (
    id_producto INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    precio_unitario REAL NOT NULL,
    stock_disponible INTEGER NOT NULL DEFAULT 0,
    id_rubro INTEGER NOT NULL,
    CONSTRAINT fk_producto_rubro
        FOREIGN KEY (id_rubro) REFERENCES Rubros(id_rubro)
);

CREATE TABLE Pedidos (
    id_pedido INTEGER PRIMARY KEY AUTOINCREMENT,
    alias TEXT NOT NULL,
    fecha_hora TEXT NOT NULL DEFAULT (datetime('now', 'localtime')),
    estado TEXT NOT NULL DEFAULT 'PENDIENTE',
    total REAL NOT NULL DEFAULT 0.0
);

CREATE TABLE ItemsPedido (
    id_item INTEGER PRIMARY KEY AUTOINCREMENT,
    id_pedido INTEGER NOT NULL,
    id_producto INTEGER NOT NULL,
    cantidad INTEGER NOT NULL,
    subtotal REAL NOT NULL,
    CONSTRAINT fk_item_pedido
        FOREIGN KEY (id_pedido) REFERENCES Pedidos(id_pedido),
    CONSTRAINT fk_item_producto
        FOREIGN KEY (id_producto) REFERENCES Productos(id_producto)
);