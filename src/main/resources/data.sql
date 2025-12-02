-- Limpiar tablas
DELETE FROM usuarios_roles;
DELETE FROM usuarios;
DELETE FROM roles;
DELETE FROM curso;

-- Insertar roles
INSERT INTO roles (id, nombre) VALUES 
(1, 'ROLE_ADMIN'), 
(2, 'ROLE_USER');

-- Insertar usuarios (contraseña: 12345)
INSERT INTO usuarios (id, username, password, enabled, nombre, apellido, email) VALUES 
(1, 'admin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBpwTTK8GMce5C', 1, 'Admin', 'Sistema', 'admin@example.com'),
(2, 'usuario', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBpwTTK8GMce5C', 1, 'Usuario', 'Normal', 'usuario@example.com');

-- Asignar roles
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES
(1, 1), -- admin tiene ROLE_ADMIN
(2, 2); -- usuario tiene ROLE_USER

-- Cursos de ejemplo
INSERT INTO curso (nombre, descripcion, creditos) VALUES 
('Matemáticas', 'Curso de matemáticas básicas', 5),
('Programación', 'Introducción a la programación', 6),
('Bases de Datos', 'Fundamentos de bases de datos', 4);