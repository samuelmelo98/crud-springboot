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

    -- Criar a sequence seq_tb_marca, caso não exista
CREATE SEQUENCE IF NOT EXISTS seq_tb_marca
    START WITH 1
    INCREMENT BY 1
    NO CYCLE;

-- Criar a sequence seq_tb_modelo, caso não exista
    CREATE SEQUENCE IF NOT EXISTS seq_tb_modelo
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

-- Criar a tabela tb_marca e usar a sequence seq_tb_marca
CREATE TABLE IF NOT EXISTS tb_marca (
    id_marca BIGINT DEFAULT NEXTVAL('seq_tb_marca') PRIMARY KEY,
    nome VARCHAR(255),
    id_user BIGINT NOT NULL,
    CONSTRAINT fk_user_aparelho FOREIGN KEY (id_user) REFERENCES tb_marca (id_marca) ON DELETE CASCADE
);

--Criar a tabela tb_modelo e usar a sequence seq_tb_modelo
CREATE TABLE IF NOT EXISTS tb_modelo(
    id_modelo BIGINT DEFAULT NEXTVAL('seq_tb_modelo') PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,     -- Nome do modelo
    descricao TEXT,                 -- Descrição do modelo
    infor_adicionais TEXT,          -- Informações adicionais
    dt_adicionado TIMESTAMP,       -- Data de adição
    id_user BIGINT NOT NULL,        -- Chave estrangeira para User
    id_marca BIGINT NOT NULL,       -- Chave estrangeira para Marca
    CONSTRAINT fk_user FOREIGN KEY (id_user) REFERENCES tb_user(id_user) ON DELETE CASCADE,
    CONSTRAINT fk_marca FOREIGN KEY (id_marca) REFERENCES tb_marca(id_marca) ON DELETE CASCADE
);