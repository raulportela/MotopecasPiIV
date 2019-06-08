create database motopecasbd;

use motopecasbd;

select * from produto;

describe produto;

create database motopecasbd;
use motopecasbd;
describe produto;
select * from cliente;
insert into papel values (default, "FISICA");

insert into papel values (default, "JURIDICA");

insert into cliente values (default, 11111111,	'2019-05-23 17:43:54',	0,	'jeferson_nls@hotmail.com',	'Jeferson', '2019',	'1', 'Nls', '1195544', '1');

insert into endereco values (default, 'Luso', '04421070', 'CASA 8', 20, 'Rua Xpto',1 , 1);

insert into produto values (default, 'preto', '2019-05-11', 'Produto 01 bla bla bla', '', 'Produto 01', 10,17,2,50);

insert into produto values (default, 'preto', '2019-05-11', 'Produto 02 bla bla bla', '', 'Produto 02', 15,0,2,44);

insert into produto values (default, 'preto', '2019-05-11', 'Produto 03 bla bla bla', '', 'Produto 03', 20,0,2,55);

insert into produto values (default, 'preto', '2019-05-11', 'Produto 04 bla bla bla', '', 'Produto 04', 5,0,2,7);

insert into produto values (default, 'preto', '2019-05-11', 'Produto 05 bla bla bla', '', 'Produto 05', 10,17,2,50);

insert into produto values (default, 'preto', '2019-05-11', 'Produto 06 bla bla bla', '', 'Produto 06', 18,0,6,12);

insert into produto values (default, 'preto', '2019-05-11', 'Produto 07 bla bla bla', '', 'Produto 07', 2,0,8,16);

insert into produto values (default, 'preto', '2019-05-11', 'Produto 08 bla bla bla', '', 'Produto 08', 22,0,2,23);

insert into produto values (default, 'preto', '2019-05-11', 'Produto 09 bla bla bla', '', 'Produto 09', 22,0,2,23);

insert into produto values (default, 'preto', '2019-05-11', 'Produto 10 bla bla bla', '', 'Produto 10', 4,0,2,47);

insert into produto values (default, 'preto', '2019-05-11', 'Produto 11 bla bla bla', '', 'Produto 11', 6,0,2,19);

insert into produto values (default, 'preto', '2019-05-11', 'Produto 12 bla bla bla', '', 'Produto 12', 12,0,2,3);


CREATE TABLE [dbo].[Cartao] (
    [ID]          INT                                                                       IDENTITY (1, 1) NOT NULL,
    [TIPO]        VARCHAR (MAX)                                                             NOT NULL,
    [NOME]        VARCHAR (MAX)                                                             NOT NULL,
    [NUMERO]      VARCHAR (MAX) MASKED WITH (FUNCTION = 'partial(0, "xxxx-xxxx-xxxx-", 4)') NULL,
    [VALIDADE]    DATE                                                                      NOT NULL,
    [CODIGO]      VARCHAR (3)                                                               NOT NULL,
    [CPF]         VARCHAR (11)                                                              NOT NULL,
    [CLIENTEID]   INT                                                                       NOT NULL,
    [SELECIONADO] BIT                                                                       NOT NULL,
    CONSTRAINT [PK_Cartao] PRIMARY KEY CLUSTERED ([ID] ASC),
    CONSTRAINT [FK_ClienteCartao] FOREIGN KEY ([CLIENTEID]) REFERENCES [dbo].[Cliente] ([ID])
);

CREATE TABLE [dbo].[Cliente] (
    [ID]             INT           IDENTITY (1, 1) NOT NULL,
    [NOME]           VARCHAR (MAX) NOT NULL,
    [SOBRENOME]      VARCHAR (MAX) NOT NULL,
    [TELEFONE]       VARCHAR (11)  NULL,
    [CPF]            VARCHAR (11)  NOT NULL,
    [SEXO]           VARCHAR (MAX) NOT NULL,
    [DATANASCIMENTO] DATE          NOT NULL,
    [RG]             VARCHAR (9)   NULL,
    [EMAIL]          VARCHAR (MAX) NOT NULL,
    [SENHA]          VARCHAR (MAX) NOT NULL,
    CONSTRAINT [PK_Cliente] PRIMARY KEY CLUSTERED ([ID] ASC)
);

CREATE TABLE [dbo].[Endereco] (
    [ID]          INT           IDENTITY (1, 1) NOT NULL,
    [LOGRADOURO]  VARCHAR (MAX) NOT NULL,
    [COMPLEMENTO] VARCHAR (MAX) NOT NULL,
    [BAIRRO]      VARCHAR (MAX) NOT NULL,
    [CEP]         VARCHAR (8)   NOT NULL,
    [CIDADE]      VARCHAR (MAX) NOT NULL,
    [ESTADO]      VARCHAR (MAX) NOT NULL,
    [CLIENTEID]   INT           NULL,
    [SELECIONADO] BIT           NOT NULL,
    CONSTRAINT [PK_Endereco] PRIMARY KEY CLUSTERED ([ID] ASC),
    CONSTRAINT [FK_CLIENTEED] FOREIGN KEY ([CLIENTEID]) REFERENCES [dbo].[Cliente] ([ID])
);

CREATE TABLE [dbo].[Produto] (
    [ID]          INT            IDENTITY (1, 1) NOT NULL,
    [NOME]        VARCHAR (MAX)  NOT NULL,
    [DESCRICAO]   NVARCHAR (MAX) NOT NULL,
    [CATEGORIA]   VARCHAR (MAX)  NOT NULL,
    [ESTOQUE]     INT            NOT NULL,
    [PRECO]       FLOAT (53)     NOT NULL,
    [IMAGEM]      IMAGE          NULL,
    [TAMANHO]     VARCHAR (MAX)  NULL,
    [COR]         VARCHAR (MAX)  NULL,
    [DATAENTRADA] DATETIME       NULL,
    CONSTRAINT [PK_Produto] PRIMARY KEY CLUSTERED ([ID] ASC)
);

CREATE TABLE [dbo].[Venda] (
    [ID]               INT           IDENTITY (1, 1) NOT NULL,
    [NUMERO]           INT           NOT NULL,
    [CLIENTEID]        INT           NOT NULL,
    [DATACOMPRA]       DATE          NOT NULL,
    [ENTREGA]          INT           NOT NULL,
    [TOTALCOMPRA]      FLOAT (53)    NOT NULL,
    [ESTADOATUAL]      VARCHAR (MAX) NOT NULL,
    CONSTRAINT [PK_Venda] PRIMARY KEY CLUSTERED ([ID] ASC),
    CONSTRAINT [FK_Cliente] FOREIGN KEY ([CLIENTEID]) REFERENCES [dbo].[Cliente] ([ID]),   
    CONSTRAINT [FK_EnderecoV] FOREIGN KEY ([ENTREGA]) REFERENCES [dbo].[Endereco] ([ID])
);

CREATE TABLE [dbo].[ItemVenda] (
    [VENDAID]    INT NOT NULL,
    [PRODUTOID]  INT NOT NULL,
    [QUANTIDADE] INT NOT NULL,
    CONSTRAINT [PK_ItemVenda] PRIMARY KEY CLUSTERED ([VENDAID] ASC, [PRODUTOID] ASC),
    CONSTRAINT [FK_Venda] FOREIGN KEY ([VENDAID]) REFERENCES [dbo].[Venda] ([ID]),
    CONSTRAINT [FK_Produto] FOREIGN KEY ([PRODUTOID]) REFERENCES [dbo].[Produto] ([ID])
);