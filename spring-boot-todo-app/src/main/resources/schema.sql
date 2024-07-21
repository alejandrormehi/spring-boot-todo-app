-- Crear la tabla Address si no existe
CREATE TABLE IF NOT EXISTS address (
    id SERIAL PRIMARY KEY,
    street VARCHAR(255),
    city VARCHAR(255),
    zipcode VARCHAR(20),
    country VARCHAR(100)
);

-- Crear la tabla Users si no existe
CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    username VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    address_id INTEGER,
    FOREIGN KEY (address_id) REFERENCES address(id)
);

-- Insertar datos en la tabla Address
INSERT INTO address (street, city, zipcode, country) VALUES
('Olympus Street', 'Olympia', '12345', 'Greece'),
('Ocean Drive', 'Atlantis', '67890', 'Peru'),
('Wisdom Avenue', 'Athens', '11111', 'Alemania'),
('Sunset Boulevard', 'Delphi', '22222', 'Portugal'),
('Underworld Lane', 'Hades', '33333', 'Chile');

-- Insertar datos en la tabla Users
INSERT INTO users (name, username, password, address_id) VALUES
('Zeus', 'zeus_god', 'password123', 1),
('Hera', 'hera_queen', 'password123', 1),
('Poseidon', 'poseidon_sea', 'password123', 2),
('Athena', 'athena_wisdom', 'password123', 3),
('Apollo', 'apollo_sun', 'password123', 4);

-- Crear la tabla TodoItem si no existe
CREATE TABLE IF NOT EXISTS todo_items (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    is_complete BOOLEAN,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    user_id INTEGER,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Insertar datos de ejemplo en la tabla TodoItem
INSERT INTO todo_items (title, is_complete, created_at, updated_at, user_id) VALUES
('Rule Olympus', FALSE, NOW(), NOW(), (SELECT id FROM users WHERE username = 'zeus_god')),
('Guard Olympus', TRUE, NOW(), NOW(), (SELECT id FROM users WHERE username = 'hera_queen')),
('Control the Seas', TRUE, NOW(), NOW(), (SELECT id FROM users WHERE username = 'poseidon_sea')),
('Strategize Battle Plans', FALSE, NOW(), NOW(), (SELECT id FROM users WHERE username = 'athena_wisdom')),
('Chariot Ride', FALSE, NOW(), NOW(), (SELECT id FROM users WHERE username = 'apollo_sun'));
