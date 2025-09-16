create table categoria(
id			uuid				primary key,
descricao	varchar(25)		not null unique);

create table produto(
id					uuid			 primary key,
nome				varchar(25)		    not null,
preco				varchar(100)		not null,
quantidade			varchar(100)		not null,
prioridade			varchar(10)			not null,
categoria_id 		uuid				not null,
foreign key(categoria_id)
	references categoria(id));
	
insert into categoria(id, descricao) values(gen_random_uuid(),'Cama mesa e banho');
insert into categoria(id, descricao) values(gen_random_uuid(),'Eletrônicos');
insert into categoria(id, descricao) values(gen_random_uuid(),'Vestuário');
insert into categoria(id, descricao) values(gen_random_uuid(),'Artigos para o lar');
insert into categoria(id, descricao) values(gen_random_uuid(),'Papelaria');

select id, descricao from categoria
order by descricao;