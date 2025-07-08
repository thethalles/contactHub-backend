-- Categorias

INSERT INTO categoria (id, nome) VALUES (1, 'Amigos');
INSERT INTO categoria (id, nome) VALUES (2, 'Trabalho');
INSERT INTO categoria (id, nome) VALUES (3, 'Família');

-- Contatos
INSERT INTO contato (
    id, nome, email_principal, telefone_principal, empresa, cargo, aniversario, favorito, 
    logradouro, numero, complemento, bairro, cidade, estado, cep, notas, categoria_id
) VALUES 
(1, 'Ana Silva', 'ana.silva@email.com', '11999990001', 'Empresa A', 'Analista', '1990-05-10', true,
 'Rua das Flores', '123', 'Apto 1', 'Centro', 'São Paulo', 'SP', '01000-000', 'Contato importante.', 1),
(2, 'Bruno Souza',  'bruno.souza@email.com','11999990002', 'Empresa B', 'Gerente', '1985-08-22', false,
 'Av. Brasil', '456', '', 'Jardim', 'Campinas', 'SP', '13000-000', 'Prefere contato por e-mail.', 2),
(3, 'Carla Dias',  'carla.dias@email.com', '11999990003', 'Empresa C', 'Desenvolvedora', '1992-12-15', true,
 'Rua Azul', '789', 'Casa', 'Vila Nova', 'Sorocaba', 'SP', '18000-000', 'Amiga de longa data.', 3);