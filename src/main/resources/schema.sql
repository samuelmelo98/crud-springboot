-- Criar a sequence seq_tb_user, caso não exista
CREATE SEQUENCE IF NOT EXISTS seq_tb_user
    START WITH 1
    INCREMENT BY 1
    NO CYCLE;

-- Criar a sequence seq_tb_aparelho, caso não exista
CREATE SEQUENCE IF NOT EXISTS seq_tb_aparelho
    START WITH 1
    INCREMENT BY 1
    NO CYCLE;

-- Criar a tabela tb_user e usar a sequence seq_tb_user
CREATE TABLE IF NOT EXISTS tb_user (
    id_user BIGINT PRIMARY KEY DEFAULT NEXTVAL('seq_tb_user'),
    nome VARCHAR(255),
    sobre_nome VARCHAR(255),
    email VARCHAR(255),
    senha VARCHAR(255),
    telefone VARCHAR(255)
);

-- Criar a tabela tb_aparelho e usar a sequence seq_tb_aparelho
CREATE TABLE IF NOT EXISTS tb_aparelho (
    id_aparelho BIGINT DEFAULT NEXTVAL('seq_tb_aparelho') PRIMARY KEY,
    marca VARCHAR(255),
    modelo VARCHAR(255),
    numero_serie VARCHAR(255),
    data_entrada TIMESTAMP,
    observacoes TEXT,
    aparelho_status VARCHAR(50) DEFAULT 'AGUARDANDO_ORCAMENTO',
    id_user BIGINT NOT NULL,
    CONSTRAINT fk_user_aparelho FOREIGN KEY (id_user) REFERENCES tb_user (id_user) ON DELETE CASCADE
);