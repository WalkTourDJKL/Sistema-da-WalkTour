CREATE DATABASE IF NOT EXISTS WalkTourDB;
USE WalkTourDB;
-- -----------------------------------------------------
-- Table WalkTourDB.`enderecos`
-- -----------------------------------------------------
CREATE TABLE WalkTourDB.`enderecos`(
  `endereco_id` INT NOT NULL AUTO_INCREMENT,
  `cep` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `pais` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`endereco_id`));



-- -----------------------------------------------------
-- Table WalkTourDB.`eventos`
-- -----------------------------------------------------
CREATE TABLE WalkTourDB.`eventos`(
  `id_evento` INT NOT NULL AUTO_INCREMENT,
  `dia_inicio` DATE NOT NULL,
  `dia_fim` DATE NOT NULL,
  `hora_inicio` TIME NOT NULL,
  `hora_fim` TIME NOT NULL,
  `nome_evento` VARCHAR(45) NOT NULL,
  `preco` FLOAT NOT NULL,
  `endereco_id` INT NOT NULL,
  PRIMARY KEY (`id_evento`, `endereco_id`),
  CONSTRAINT `fk_eventos_enderecos`
    FOREIGN KEY (`endereco_id`)
    REFERENCES WalkTourDB.`enderecos` (`endereco_id`));



-- -----------------------------------------------------
-- Table WalkTourDB.`pontos_tur`
-- -----------------------------------------------------
CREATE TABLE WalkTourDB.`pontos_tur` (
  `ponto_id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `hora_abre` TIME NOT NULL,
  `hora_fecha` TIME NOT NULL,
  `preco` INT NOT NULL,
  `endereco_id` INT ,
  PRIMARY KEY (`ponto_id`, `endereco_id`),
  CONSTRAINT `fk_pontos_tur_enderecos1`
    FOREIGN KEY (`endereco_id`)
    REFERENCES WalkTourDB.`enderecos` (`endereco_id`));



-- -----------------------------------------------------
-- Table WalkTourDB.`usuarios`
-- -----------------------------------------------------
CREATE TABLE WalkTourDB.`usuarios` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `nome_social` VARCHAR(45),
  `dt_nasc` DATE NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `tipo_user` INT NOT NULL,
  PRIMARY KEY (`id_usuario`));



-- -----------------------------------------------------
-- Table WalkTourDB.`hospedagens`
-- -----------------------------------------------------
CREATE TABLE WalkTourDB.`hospedagens` (
  `id_hospedagem` INT NOT NULL AUTO_INCREMENT,
  `forma_pag` VARCHAR(45) NOT NULL,
  `data_in` DATE NOT NULL,
  `data_out` DATE NOT NULL,
  `preco` INT NOT NULL,
  PRIMARY KEY (`id_hospedagem`));



-- -----------------------------------------------------
-- Table WalkTourDB.`modelo_quarto`
-- -----------------------------------------------------
CREATE TABLE WalkTourDB.`modelo_quarto` (
  `tipo_id` INT NOT NULL AUTO_INCREMENT,
  `nome_modelo` VARCHAR(45) NOT NULL,
  `qtd_banheiro` INT NOT NULL,
  `qtd_camas` INT NOT NULL,
  `frigobar` TINYINT NOT NULL,
  `servico_quarto` TINYINT NOT NULL,
  `preco` INT NOT NULL,
  PRIMARY KEY (`tipo_id`));



-- -----------------------------------------------------
-- Table WalkTourDB.`quarto`
-- -----------------------------------------------------
CREATE TABLE WalkTourDB.`quarto` (
  `num_quarto` INT NOT NULL AUTO_INCREMENT,
  `hora_limpeza` TIME NOT NULL,
  `tipo_id` INT NOT NULL ,
  PRIMARY KEY (`num_quarto`, `tipo_id`),
  CONSTRAINT `fk_quarto_modelo_quarto1`
    FOREIGN KEY (`tipo_id`)
    REFERENCES WalkTourDB.`modelo_quarto` (`tipo_id`));

-- -----------------------------------------------------
-- Table WalkTourDB.`detalhes_hospedagem`
-- -----------------------------------------------------
CREATE TABLE WalkTourDB.`detalhes_hospedagem` (
  `id_detalhe_hospedagem` INT NOT NULL AUTO_INCREMENT,
  `id_hospedagem` INT NOT NULL ,
  `id_usuario` INT NOT NULL,
  PRIMARY KEY (`id_detalhe_hospedagem`, `id_hospedagem`, `id_usuario`),
  CONSTRAINT `fk_hospedagens_has_usuarios_hospedagens1`
    FOREIGN KEY (`id_hospedagem`)
    REFERENCES WalkTourDB.`hospedagens` (`id_hospedagem`),
  CONSTRAINT `fk_hospedagens_has_usuarios_usuarios1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES WalkTourDB.`usuarios` (`id_usuario`)
    );

    
    /* Nenhuma chave estrangeira */
	insert into enderecos (cidade, estado, pais, cep) values ('BR', 'GN', 'Brazil', '95335-000');
	insert into enderecos (cidade, estado, pais, cep) values ('BR', 'CD', 'Brazil', '13315-000');
	insert into enderecos (cidade, estado, pais, cep) values ('BR', 'YE', 'Brazil', '09700-000');
	insert into enderecos (cidade, estado, pais, cep) values ('BR', 'PT', 'Brazil', '88800-000');
	insert into enderecos (cidade, estado, pais, cep) values ('BR', 'SE', 'Brazil', '11920-000');
	insert into enderecos (cidade, estado, pais, cep) values ('BR', 'ID', 'Brazil', '17350-000');
	insert into enderecos (cidade, estado, pais, cep) values ('BR', 'TJ', 'Brazil', '48730-000');
	insert into enderecos (cidade, estado, pais, cep) values ('BR', 'PH', 'Brazil', '39510-000');
	insert into enderecos (cidade, estado, pais, cep) values ('BR', 'CN', 'Brazil', '78460-000');
	insert into enderecos (cidade, estado, pais, cep) values ('BR', 'ID', 'Brazil', '68900-000');
	insert into enderecos (cidade, estado, pais, cep) values ('BR', 'SE', 'Brazil', '39100-000');
	insert into enderecos (cidade, estado, pais, cep) values ('BR', 'AM', 'Brazil', '36280-000');
	insert into enderecos (cidade, estado, pais, cep) values ('BR', 'PH', 'Brazil', '13190-000');
	insert into enderecos (cidade, estado, pais, cep) values ('BR', 'CN', 'Brazil', '95650-000');
	insert into enderecos (cidade, estado, pais, cep) values ('BR', 'DK', 'Brazil', '36300-000');
	insert into enderecos (cidade, estado, pais, cep) values ('BR', 'BR', 'Brazil', '58378-000');
	insert into enderecos (cidade, estado, pais, cep) values ('BR', 'GR', 'Brazil', '13690-000');
	insert into enderecos (cidade, estado, pais, cep) values ('BR', 'BR', 'Brazil', '27500-000');
	insert into enderecos (cidade, estado, pais, cep) values ('BR', 'SE', 'Brazil', '68600-000');
	insert into enderecos (cidade, estado, pais, cep) values ('BR', 'HR', 'Brazil', '38200-000');
    SET @endereco_id = LAST_INSERT_ID();

	/* 1 chave estrangeira */
	insert into eventos (dia_inicio, dia_fim, hora_inicio, hora_fim, nome_evento, preco, endereco_id) 
	values ('2023-06-09', '2023-10-01', '7:28', '4:44', 'Show do Leno Brega', '513.52', 20);
	insert into eventos (dia_inicio, dia_fim, hora_inicio, hora_fim, nome_evento, preco, endereco_id) 
	values ('2023-06-09', '2023-10-01', '7:28', '4:44', 'Show do Roberto Carlos', '513.52', 20);
	insert into eventos (dia_inicio, dia_fim, hora_inicio, hora_fim, nome_evento, preco, endereco_id) 
	values ('2023-06-09', '2023-10-01', '7:28', '4:44', 'Show do Lionel Messi', '513.52', 20);
	SET @id_evento = LAST_INSERT_ID();

    
    /* 1 chave estrangeira */
	insert into pontos_tur (nome,hora_abre, hora_fecha, preco, endereco_id) values ('Praça central','6:05', '8:49', '11', @endereco_id);
	insert into pontos_tur (nome,hora_abre, hora_fecha, preco, endereco_id) values ('Parque municipal','6:05', '8:49', '81', @endereco_id);
	insert into pontos_tur (nome,hora_abre, hora_fecha, preco, endereco_id) values ('Lagoa azul','6:05', '8:49', '41', @endereco_id);
    SET @ponto_id = LAST_INSERT_ID();
    
    /* Nenhuma chave estrangeira */
	insert into  usuarios (nome, nome_social, dt_nasc, cpf, login, senha, tipo_user) values ('0', null, '1989-04-25', '000.000.000-00','hosp0','0',0);
    insert into  usuarios (nome, nome_social, dt_nasc, cpf, login, senha, tipo_user) values ('1', null, '1989-04-25', '111.111.111-11','func0','1',1);
    insert into  usuarios (nome, nome_social, dt_nasc, cpf, login, senha, tipo_user) values ('Lucas Guerega', null, '1995-04-15', '156.948.741-54','lucas.g2006','0',0);
    insert into  usuarios (nome, nome_social, dt_nasc, cpf, login, senha, tipo_user) values ('José Paulo Baptista', null, '1989-02-24', '165.715.472-31','jose.p2005','1',1);
	SET @id_usuario = LAST_INSERT_ID();

    /* Organizar o resto da tabela */
    /*
    Sim = 0
    Não = 1 
    */
	insert into modelo_quarto (nome_modelo, qtd_banheiro, qtd_camas, frigobar, servico_quarto, preco) values ('Standard', 1, 2, 0, 1, 350);
	insert into modelo_quarto (nome_modelo, qtd_banheiro, qtd_camas, frigobar, servico_quarto, preco) values ('Suite Executiva', 2, 2, 1, 1, 700);
	insert into modelo_quarto (nome_modelo, qtd_banheiro, qtd_camas, frigobar, servico_quarto, preco) values ('Deluxe', 3, 3, 1, 1, 950);
     SET @tipo_id = LAST_INSERT_ID();
    
    /* 1 chave estrangeira */
	insert into quarto (hora_limpeza, tipo_id) values ('10:48',@tipo_id);
	insert into quarto (hora_limpeza, tipo_id) values ('5:58', @tipo_id);
	insert into quarto (hora_limpeza, tipo_id) values ('9:46', @tipo_id);
	insert into quarto (hora_limpeza, tipo_id) values ('2:23', @tipo_id);
	insert into quarto (hora_limpeza, tipo_id) values ('10:39',@tipo_id);
	insert into quarto (hora_limpeza, tipo_id) values ('5:35', @tipo_id);
	insert into quarto (hora_limpeza, tipo_id) values ('6:15', @tipo_id);
	insert into quarto (hora_limpeza, tipo_id) values ('10:02',@tipo_id);
	insert into quarto (hora_limpeza, tipo_id) values ('4:03', @tipo_id);
	insert into quarto (hora_limpeza, tipo_id) values ('4:11', @tipo_id);
	insert into quarto (hora_limpeza, tipo_id) values ('3:20', @tipo_id);
	insert into quarto (hora_limpeza, tipo_id) values ('10:21',@tipo_id);
	insert into quarto (hora_limpeza, tipo_id) values ('10:19',@tipo_id);
	insert into quarto (hora_limpeza, tipo_id) values ('2:45', @tipo_id);
	insert into quarto (hora_limpeza, tipo_id) values ('3:41', @tipo_id);
	insert into quarto (hora_limpeza, tipo_id) values ('3:08', @tipo_id);
	insert into quarto (hora_limpeza, tipo_id) values ('9:01', @tipo_id);
	insert into quarto (hora_limpeza, tipo_id) values ('8:27', @tipo_id);
	insert into quarto (hora_limpeza, tipo_id) values ('6:50', @tipo_id);
	insert into quarto (hora_limpeza, tipo_id) values ('3:13', @tipo_id);
    SET @num_quarto = LAST_INSERT_ID();

-- -----------------------------------------------------
-- Selects em cada tabela
-- -----------------------------------------------------

    SELECT * FROM enderecos ORDER BY endereco_id;
    SELECT * FROM eventos ORDER BY id_evento;
    SELECT * FROM pontos_tur ORDER BY ponto_id;
    SELECT * FROM usuarios ORDER BY id_usuario;
    SELECT * FROM hospedagens ORDER BY id_hospedagem;
    SELECT * FROM modelo_quarto ORDER BY tipo_id;
    SELECT * FROM quarto ORDER BY num_quarto;
    SELECT * FROM detalhes_hospedagem ORDER BY id_detalhe_hospedagem;
    

