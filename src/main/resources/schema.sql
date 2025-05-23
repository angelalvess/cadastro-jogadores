CREATE TABLE IF NOT EXISTS Jogadores (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(20),
    codinome VARCHAR(255),
    grupo_codinome VARCHAR(255) NOT NULL,
    CONSTRAINT unique_codinome_grupo UNIQUE (codinome, grupo_codinome)
);