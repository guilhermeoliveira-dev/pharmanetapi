
truncate table cargo restart identity cascade;

truncate table categoria restart identity cascade;

truncate table cliente restart identity cascade;

truncate table endereco restart identity cascade;

truncate table estoque restart identity cascade;

truncate table farmacia restart identity cascade;

truncate table feedback restart identity cascade;

truncate table fornecedor restart identity cascade;

truncate table funcionario restart identity cascade;

truncate table item_pedido restart identity cascade;

truncate table notificacao restart identity cascade;

truncate table pagamento restart identity cascade;

truncate table pedido_compra restart identity cascade;

truncate table permissao restart identity cascade;

truncate table produto restart identity cascade;

truncate table receita restart identity cascade;

truncate table tarja restart identity cascade;

truncate table venda restart identity cascade;

-- Endereços

INSERT INTO endereco
(id, bairro, cep, cidade, complemento, logradouro, numero, uf)
VALUES(nextval('endereco_id_seq'::regclass), 'Fábrica', '36080-001',
       'Juiz de Fora', ' ', 'R. Bernardo Mascarenhas', '1283', 'MG');

INSERT INTO endereco
(id, bairro, cep, cidade, complemento, logradouro, numero, uf)
VALUES(nextval('endereco_id_seq'::regclass), 'São Pedro', '36036-900',
       'Juiz de Fora', 'Campus Universitário', 'R. José Lourenço Kelmer', 's/n', 'MG');

INSERT INTO endereco
(id, bairro, cep, cidade, complemento, logradouro, numero, uf)
VALUES(nextval('endereco_id_seq'::regclass), 'Fábrica', '36080-001',
       'Juiz de Fora', ' ', 'R. Bernardo Mascarenhas', '1045', 'MG');

INSERT INTO endereco
(id, bairro, cep, cidade, complemento, logradouro, numero, uf)
VALUES(nextval('endereco_id_seq'::regclass), 'Fábrica', '36080-001',
       'Juiz de Fora', ' ', 'R. Bernardo Mascarenhas', '223', 'MG');

INSERT INTO endereco
(id, bairro, cep, cidade, complemento, logradouro, numero, uf)
VALUES(nextval('endereco_id_seq'::regclass), 'Fábrica', '36080-001',
       'Juiz de Fora', ' ', 'R. Bernardo Mascarenhas', '784', 'MG');

INSERT INTO endereco
(id, bairro, cep, cidade, complemento, logradouro, numero, uf)
VALUES(nextval('endereco_id_seq'::regclass), 'Fábrica', '36080-001',
       'Juiz de Fora', ' ', 'R. Bernardo Mascarenhas', '1283', 'MG');

-- Farmácias

INSERT INTO public.farmacia
(id, cnpj, email, nome, telefone, endereco_id)
VALUES(nextval('farmacia_id_seq'::regclass), '3123123123',
       'farmacianumero1@gmail.com', 'Farmácia 1', '4444-4444', 1);

INSERT INTO public.farmacia
(id, cnpj, email, nome, telefone, endereco_id)
VALUES(nextval('farmacia_id_seq'::regclass), '3123123123',
       'farmacianumero2@gmail.com', 'Farmácia 2', '5555-5555', 2);

INSERT INTO public.farmacia
(id, cnpj, email, nome, telefone, endereco_id)
VALUES(nextval('farmacia_id_seq'::regclass), '3123123123',
       'farmacianumero3@gmail.com', 'Farmácia 3', '6266-6266', 3);

-- Cargos

INSERT INTO public.cargo
(id, nome)
VALUES(nextval('cargo_id_seq'::regclass), 'Farmacêutico');

INSERT INTO public.cargo
(id, nome)
VALUES(nextval('cargo_id_seq'::regclass), 'Gerente');

INSERT INTO public.cargo
(id, nome)
VALUES(nextval('cargo_id_seq'::regclass), 'Administrador');

-- Permissões

INSERT INTO public.permissao
(id, nome, cargo_id)
VALUES(nextval('permissao_id_seq'::regclass), 'Cadastrar Produtos', 1);

INSERT INTO public.permissao
(id, nome, cargo_id)
VALUES(nextval('permissao_id_seq'::regclass), 'Cadastrar Produtos', 2);

INSERT INTO public.permissao
(id, nome, cargo_id)
VALUES(nextval('permissao_id_seq'::regclass), 'Cadastrar Funcionários', 2);

INSERT INTO public.permissao
(id, nome, cargo_id)
VALUES(nextval('permissao_id_seq'::regclass), 'Cadastrar Funcionários', 3);

INSERT INTO public.permissao
(id, nome, cargo_id)
VALUES(nextval('permissao_id_seq'::regclass), 'Cadastrar Farmácias', 3);

-- Categorias

INSERT INTO public.categoria
(id, descricao, nome, categoria_pai_id)
VALUES(nextval('categoria_id_seq'::regclass), 'Medicamento', 'Medicamentos no geral.', null);

INSERT INTO public.categoria
(id, descricao, nome, categoria_pai_id)
VALUES(nextval('categoria_id_seq'::regclass), 'Produto Alimentício', 'Produtos alimentícios em geral.', null);

INSERT INTO public.categoria
(id, descricao, nome, categoria_pai_id)
VALUES(nextval('categoria_id_seq'::regclass), 'Betabloqueadores', 'Calmantes.', 1);

INSERT INTO public.categoria
(id, descricao, nome, categoria_pai_id)
VALUES(nextval('categoria_id_seq'::regclass), 'Ração Animal', 'Ração e alimentos para animais.', 2);

INSERT INTO public.categoria
(id, descricao, nome, categoria_pai_id)
VALUES(nextval('categoria_id_seq'::regclass), 'Suplemento alimentício', 'Medicamentos destinados a complementar a nutrição.', 2);

INSERT INTO public.categoria
(id, descricao, nome, categoria_pai_id)
VALUES(nextval('categoria_id_seq'::regclass), 'Benzodiazepínicos', 'Não sei o que isso faz mas é remédio', 1);

-- Tarjas

INSERT INTO public.tarja
(id, cor, nome, requer_receita, retem_receita)
VALUES(nextval('tarja_id_seq'::regclass), 'Vermelha', 'Vermelha sem Retenção', true, false);

INSERT INTO public.tarja
(id, cor, nome, requer_receita, retem_receita)
VALUES(nextval('tarja_id_seq'::regclass), 'Vermelha', 'Vermelha com Retenção', true, true);

INSERT INTO public.tarja
(id, cor, nome, requer_receita, retem_receita)
VALUES(nextval('tarja_id_seq'::regclass), 'Preta', 'Preta', true, true);

INSERT INTO public.tarja
(id, cor, nome, requer_receita, retem_receita)
VALUES(nextval('tarja_id_seq'::regclass), 'Sem Tarja', '', false, false);

-- Produtos

INSERT INTO public.produto
(id, descricao, generico, nome, peso, preco, requer_lote, categoria_id, tarja_id)
VALUES(nextval('produto_id_seq'::regclass), 'Faz bem para a saúde.', false, 'Omega 3', 50, 50.0, true, 5, 4);

INSERT INTO public.produto
(id, descricao, generico, nome, peso, preco, requer_lote, categoria_id, tarja_id)
VALUES(nextval('produto_id_seq'::regclass), 'Sachê de ração para gatos.', false, 'Sachê Whiskas', 100, 4.0, true, 4, 4);

INSERT INTO public.produto
(id, descricao, generico, nome, peso, preco, requer_lote, categoria_id, tarja_id)
VALUES(nextval('produto_id_seq'::regclass), 'Cloridrato de Propranolol 40 mg, genérico Pharlab, 30 comprimidos.', true, 'Cloridrato de Propranolol', 50, 8.99, true, 3, 2);

INSERT INTO public.produto
(id, descricao, generico, nome, peso, preco, requer_lote, categoria_id, tarja_id)
VALUES(nextval('produto_id_seq'::regclass), 'Faz bem para convulsão, pânico e ansiedade.', false, 'Clonazepam', 60, 80.0, true, 6, 3);

-- Fornecedores

INSERT INTO public.fornecedor
(id, cnpj, email, nome, telefone, endereco_id)
VALUES(nextval('fornecedor_id_seq'::regclass), '3123123123', 'fornecedorletraa@email.com', 'Fornecedor A', '4444-4444', 1);

INSERT INTO public.fornecedor
(id, cnpj, email, nome, telefone, endereco_id)
VALUES(nextval('fornecedor_id_seq'::regclass), '3123123123', 'fornecedorletrab@email.com', 'Fornecedor B', '4444-4444', 3);

INSERT INTO public.fornecedor
(id, cnpj, email, nome, telefone, endereco_id)
VALUES(nextval('fornecedor_id_seq'::regclass), '3123123123', 'fornecedorletrac@email.com', 'Fornecedor C', '4444-4444', 2);

-- Estoques
-- coluna type representa qual tipo de estoque é, sendo valores válidos "estoque" ou "estoqueLote".

INSERT INTO public.estoque
("type", id, quantidade, data_fabricacao, data_validade, lote, farmacia_id, fornecedor_id, produto_id)
VALUES('estoqueLote', nextval('estoque_id_seq'::regclass), 10, '10-10-2024', '30-02-2025', '10-2024-0038', 1, 1, 1);

INSERT INTO public.estoque
("type", id, quantidade, data_fabricacao, data_validade, lote, farmacia_id, fornecedor_id, produto_id)
VALUES('estoqueLote', nextval('estoque_id_seq'::regclass), 50, '07-10-2024', '15-08-2025', '10-2024-0012', 1, 1, 2);

INSERT INTO public.estoque
("type", id, quantidade, data_fabricacao, data_validade, lote, farmacia_id, fornecedor_id, produto_id)
VALUES('estoqueLote', nextval('estoque_id_seq'::regclass), 34, '02-10-2024', '27-09-2025', '10-2024-0002', 1, 1, 3);

INSERT INTO public.estoque
("type", id, quantidade, data_fabricacao, data_validade, lote, farmacia_id, fornecedor_id, produto_id)
VALUES('estoqueLote', nextval('estoque_id_seq'::regclass), 21, '02-11-2024', '27-10-2025', '11-2024-0107', 1, 1, 3);

-- Clientes

-- INSERT INTO public.cliente
-- (id, cpf, data_admissao, email, nome, senha, telefone, endereco_id, fidelidade_pontos)
-- VALUES(nextval('_id_seq'::regclass), '', '', '', '', '', '', 0, 0);

-- Funcionários

-- INSERT INTO public.funcionario
-- (id, cpf, data_admissao, email, nome, senha, telefone, endereco_id, expediente, salario, cargo_id, farmacia_id)
-- VALUES(nextval('estoque_id_seq'::regclass), '', '', '', '', '', '', 0, '', 0, 0, 0);



