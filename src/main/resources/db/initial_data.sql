INSERT INTO role (id, nome) VALUES (1, 'ROLE_ADMIN');

insert into Usuario (id, email, nome, senha) values (1, 'admin@casadocodigo.com.br', 'Administrador', '$2a$04$qP517gz1KNVEJUTCkUQCY.JzEoXzHFjLAhPQjrg5iP6Z/UmWjvUhq');

insert into usuario_role(usuario_id, roles_id) values (1, 1);

insert into produto (id, caminhoimagemcapa, datalancamento, descricao, paginas, titulo)
VALUES (1, 'imagens-capa/pt.jpg', current_date, 'Governo para todos', 200, 'Livro PT');

insert into preco (id, tipo, valor, produto_id)
  select 1, 0, 54.00, id
  from produto
  where titulo = 'Livro PT';

insert into preco (id, tipo, valor, produto_id)
  select 2, 1, 64.00, id
  from produto
  where titulo = 'Livro PT';

insert into preco (id, tipo, valor, produto_id)
  select 3, 2, 79.90, id
  from produto
  where titulo = 'Livro PT';

insert into produto (id, caminhoimagemcapa, datalancamento, descricao, paginas, titulo)
VALUES (2, 'imagens-capa/anti-pt.jpg', current_date, 'Movimento Brasil Livre', 200, 'MBL');

insert into preco (id, tipo, valor, produto_id)
  select 4, 0, 32.00, id
  from produto
  where titulo = 'MBL';

insert into preco (id, tipo, valor, produto_id)
  select 5, 1, 37.90, id
  from produto
  where titulo = 'MBL';

insert into preco (id, tipo, valor, produto_id)
  select 6, 2, 48.50, id
  from produto
  where titulo = 'MBL';