DROP DATABASE IF EXISTS WalkTourDB;
CREATE DATABASE IF NOT EXISTS WalkTourDB;
USE WalkTourDB;
-- -----------------------------------------------------
-- Table WalkTourDB.`enderecos`
-- -----------------------------------------------------
CREATE TABLE WalkTourDB.`enderecos` (
  `endereco_id` INT NOT NULL AUTO_INCREMENT,
  `cep` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `pais` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`endereco_id`));



-- -----------------------------------------------------
-- Table WalkTourDB.`eventos`
-- -----------------------------------------------------
CREATE TABLE WalkTourDB.`eventos` (
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
  `hora_abre` TIME NOT NULL,
  `hora_fecha` TIME NOT NULL,
  `preco` FLOAT NOT NULL,
  `endereco_id` INT NOT NULL,
  PRIMARY KEY (`ponto_id`, `endereco_id`),
  CONSTRAINT `fk_pontos_tur_enderecos1`
    FOREIGN KEY (`endereco_id`)
    REFERENCES WalkTourDB.`enderecos` (`endereco_id`));



-- -----------------------------------------------------
-- Table WalkTourDB.`hospedes`
-- -----------------------------------------------------
CREATE TABLE WalkTourDB.`hospedes` (
  `id_hospede` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `nome_social` VARCHAR(45),
  `dt_nasc` DATE NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_hospede`));



-- -----------------------------------------------------
-- Table WalkTourDB.`hospedagens`
-- -----------------------------------------------------
CREATE TABLE WalkTourDB.`hospedagens` (
  `id_hospedagem` INT NOT NULL AUTO_INCREMENT,
  `forma_pag` VARCHAR(45) NOT NULL,
  `data_in` DATE NOT NULL,
  `data_out` DATE NOT NULL,
  `preco` FLOAT NOT NULL,
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
  `id_detalhe_hospedagem` INT NOT NULL ,
  `id_hospedagem` INT NOT NULL ,
  `id_hospede` INT NOT NULL ,
  `num_quarto` INT NOT NULL ,
  PRIMARY KEY (`id_detalhe_hospedagem`, `id_hospedagem`, `id_hospede`, `num_quarto`),
  CONSTRAINT `fk_hospedagens_has_hospedes_hospedagens1`
    FOREIGN KEY (`id_hospedagem`)
    REFERENCES WalkTourDB.`hospedagens` (`id_hospedagem`),
  CONSTRAINT `fk_hospedagens_has_hospedes_hospedes1`
    FOREIGN KEY (`id_hospede`)
    REFERENCES WalkTourDB.`hospedes` (`id_hospede`),
  CONSTRAINT `fk_hospedagens_has_hospedes_quarto1`
    FOREIGN KEY (`num_quarto`)
    REFERENCES WalkTourDB.`quarto` (`num_quarto`)
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
	insert into eventos (dia_inicio, dia_fim, hora_inicio, hora_fim, nome_evento, preco, endereco_id) values ('2023-06-09', '2023-10-01', '7:28', '4:44', 'Bogan LLC', '513.52', @endereco_id);
	insert into eventos (dia_inicio, dia_fim, hora_inicio, hora_fim, nome_evento, preco, endereco_id)values ('2023-09-19', '2023-11-01', '7:29', '8:37', 'Vandervort, Ward and O''Kon', '405.95', @endereco_id);
insert into eventos (dia_inicio, dia_fim, hora_inicio, hora_fim, nome_evento, preco, endereco_id)
values ('2023-02-21', '2023-05-26', '7:15', '8:03', 'Keeling LLC', '29.79', @endereco_id);
insert into eventos (dia_inicio, dia_fim, hora_inicio, hora_fim, nome_evento, preco, endereco_id)
values ('2023-06-21', '2023-01-27', '7:11', '12:43', 'Dickinson Inc', '100.95', @endereco_id);
insert into eventos (dia_inicio, dia_fim, hora_inicio, hora_fim, nome_evento, preco, endereco_id)
values ('2022-12-29', '2022-12-04', '7:05', '8:25', 'Pfannerstill, Blick and Franecki', '532.80', @endereco_id);
insert into eventos (dia_inicio, dia_fim, hora_inicio, hora_fim, nome_evento, preco, endereco_id)
values ('2023-01-21', '2023-03-29', '7:08', '7:56', 'Schowalter, Mueller and Watsica', '478.88', @endereco_id);
insert into eventos (dia_inicio, dia_fim, hora_inicio, hora_fim, nome_evento, preco, endereco_id)
values ('2023-06-14', '2023-04-30', '7:25', '6:47', 'Friesen and Sons', '461.64', @endereco_id);
insert into eventos (dia_inicio, dia_fim, hora_inicio, hora_fim, nome_evento, preco, endereco_id)
values ('2023-01-15', '2022-11-23', '7:08', '7:51', 'Goldner and Sons', '398.27', @endereco_id);
insert into eventos (dia_inicio, dia_fim, hora_inicio, hora_fim, nome_evento, preco, endereco_id)
values ('2023-03-21', '2022-11-10', '7:11', '5:19', 'Hansen, Hauck and Quitzon', '105.47', @endereco_id);
insert into eventos (dia_inicio, dia_fim, hora_inicio, hora_fim, nome_evento, preco, endereco_id)
values ('2023-04-20', '2023-06-14', '7:17', '8:54', 'Carroll-Thompson', '549.21', @endereco_id);
insert into eventos (dia_inicio, dia_fim, hora_inicio, hora_fim, nome_evento, preco, endereco_id)
values ('2023-10-15', '2023-10-06', '7:20', '2:13', 'Cruickshank, Veum and Howe', '207.15', @endereco_id);
insert into eventos (dia_inicio, dia_fim, hora_inicio, hora_fim, nome_evento, preco, endereco_id)
values ('2023-01-04', '2023-06-08', '7:13', '7:48', 'Bartoletti-Wintheiser', '148.63', @endereco_id);
insert into eventos (dia_inicio, dia_fim, hora_inicio, hora_fim, nome_evento, preco, endereco_id)
values ('2023-07-11', '2023-08-11', '7:21', '8:51', 'Lowe, Christiansen and Ledner', '363.98', @endereco_id);
insert into eventos (dia_inicio, dia_fim, hora_inicio, hora_fim, nome_evento, preco, endereco_id)
values ('2023-02-13', '2023-04-01', '7:16', '1:45', 'Crona Inc', '262.66', @endereco_id);
insert into eventos (dia_inicio, dia_fim, hora_inicio, hora_fim, nome_evento, preco, endereco_id)
values ('2022-10-28', '2023-08-15', '7:02', '11:23', 'Casper Inc', '297.29', @endereco_id);
insert into eventos (dia_inicio, dia_fim, hora_inicio, hora_fim, nome_evento, preco, endereco_id)
values ('2023-09-28', '2023-05-03', '7:22', '4:09', 'Cremin Inc', '264.03', @endereco_id);
insert into eventos (dia_inicio, dia_fim, hora_inicio, hora_fim, nome_evento, preco, endereco_id)
values ('2022-11-20', '2022-12-25', '7:04', '7:15', 'Jast Inc', '406.40', @endereco_id);
insert into eventos (dia_inicio, dia_fim, hora_inicio, hora_fim, nome_evento, preco, endereco_id)
values ('2022-12-11', '2023-02-25', '7:24', '7:39', 'Torphy, Shields and Davis', '76.38', @endereco_id);
insert into eventos (dia_inicio, dia_fim, hora_inicio, hora_fim, nome_evento, preco, endereco_id)
values ('2023-08-06', '2023-07-12', '7:23', '11:20', 'Kunde Inc', '441.18', @endereco_id);
insert into eventos (dia_inicio, dia_fim, hora_inicio, hora_fim, nome_evento, preco, endereco_id)
values ('2023-09-21', '2022-11-16', '7:07', '11:03', 'Hermann-Howell', '535.89', @endereco_id);
SET @id_evento = LAST_INSERT_ID();

    
    /* 1 chave estrangeira */
	insert into pontos_tur (hora_abre, hora_fecha, preco, endereco_id) values ('6:05', '8:49', '113.98', @endereco_id);
	insert into pontos_tur (hora_abre, hora_fecha, preco, endereco_id) values ('6:26', '8:11', '37.56', @endereco_id);
	insert into pontos_tur (hora_abre, hora_fecha, preco, endereco_id) values ('6:16', '10:52', '56.51', @endereco_id);
	insert into pontos_tur (hora_abre, hora_fecha, preco, endereco_id) values ('6:13', '8:29', '66.96', @endereco_id);
	insert into pontos_tur (hora_abre, hora_fecha, preco, endereco_id) values ('6:10', '9:39', '73.72', @endereco_id);
	insert into pontos_tur (hora_abre, hora_fecha, preco, endereco_id) values ('6:21', '8:17', '83.58', @endereco_id);
	insert into pontos_tur (hora_abre, hora_fecha, preco, endereco_id) values ('6:00', '9:25', '76.19', @endereco_id);
	insert into pontos_tur (hora_abre, hora_fecha, preco, endereco_id) values ('6:01', '10:44', '73.44', @endereco_id);
	insert into pontos_tur (hora_abre, hora_fecha, preco, endereco_id) values ('6:11', '8:07', '93.62', @endereco_id);
	insert into pontos_tur (hora_abre, hora_fecha, preco, endereco_id) values ('6:02', '10:12', '38.94', @endereco_id);
	insert into pontos_tur (hora_abre, hora_fecha, preco, endereco_id) values ('6:23', '9:18', '119.06', @endereco_id);
	insert into pontos_tur (hora_abre, hora_fecha, preco, endereco_id) values ('6:23', '8:13', '76.35', @endereco_id);
	insert into pontos_tur (hora_abre, hora_fecha, preco, endereco_id) values ('6:01', '8:38', '118.22', @endereco_id);
	insert into pontos_tur (hora_abre, hora_fecha, preco, endereco_id) values ('6:20', '10:38', '80.22', @endereco_id);
   	insert into pontos_tur (hora_abre, hora_fecha, preco, endereco_id) values ('6:24', '10:48', '87.31', @endereco_id);
	insert into pontos_tur (hora_abre, hora_fecha, preco, endereco_id) values ('6:21', '9:33', '75.68', @endereco_id);
	insert into pontos_tur (hora_abre, hora_fecha, preco, endereco_id) values ('6:10', '9:24', '81.30', @endereco_id);
	insert into pontos_tur (hora_abre, hora_fecha, preco, endereco_id) values ('6:03', '10:01', '69.47', @endereco_id);
	insert into pontos_tur (hora_abre, hora_fecha, preco, endereco_id) values ('6:14', '9:09', '81.52', @endereco_id);
	insert into pontos_tur (hora_abre, hora_fecha, preco, endereco_id) values ('6:10', '10:41', '87.33', @endereco_id);
    SET @ponto_id = LAST_INSERT_ID();
    
    /* Nenhuma chave estrangeira */
	insert into  hospedes (nome, nome_social, dt_nasc, cpf) values ('Gerry', 'Daryl', '1930-01-16', '17672839653');
insert into  hospedes (nome, nome_social, dt_nasc, cpf) values ('Emmalynne', 'Zeke', '1987-03-15', '91920920872');
insert into  hospedes (nome, nome_social, dt_nasc, cpf) values ('Blake', 'Brittani', '1920-10-13', '185497552');
insert into  hospedes (nome, nome_social, dt_nasc, cpf) values ('Kiersten', 'Waldo', '1974-12-21', '13733984851');
insert into  hospedes (nome, nome_social, dt_nasc, cpf) values ('Mattheus', 'Sherlock', '1989-09-12', '69273392867');
insert into  hospedes (nome, nome_social, dt_nasc, cpf) values ('Berta', 'Boigie', '1954-02-19', '73912143461');
insert into  hospedes (nome, nome_social, dt_nasc, cpf) values ('Dory', 'Erin', '1954-10-12', '62843506504');
insert into  hospedes (nome, nome_social, dt_nasc, cpf) values ('Kara', 'Lyman', '1918-04-26', '8098559818');
insert into  hospedes (nome, nome_social, dt_nasc, cpf) values ('Manolo', 'Zelig', '1929-10-01', '42146997535');
insert into  hospedes (nome, nome_social, dt_nasc, cpf) values ('Valene', 'Alessandro', '1902-06-08', '12982996281');
insert into  hospedes (nome, nome_social, dt_nasc, cpf) values ('Way', 'Dana', '1975-12-25', '80554866441');
insert into  hospedes (nome, nome_social, dt_nasc, cpf) values ('Tammy', 'Darryl', '1927-03-10', '64184002232');
insert into  hospedes (nome, nome_social, dt_nasc, cpf) values ('Rainer', 'Howard', '1929-05-18', '39980131978');
insert into  hospedes (nome, nome_social, dt_nasc, cpf) values ('Bastian', 'Gabriella', '1970-11-04', '39034704162');
insert into  hospedes (nome, nome_social, dt_nasc, cpf) values ('Edan', 'Hansiain', '1972-05-10', '70186535840');
insert into  hospedes (nome, nome_social, dt_nasc, cpf) values ('Schuyler', 'Mylo', '1922-12-18', '57953832660');
insert into  hospedes (nome, nome_social, dt_nasc, cpf) values ('Wells', 'Shaina', '1953-05-10', '67462715744');
insert into  hospedes (nome, nome_social, dt_nasc, cpf) values ('Clare', 'Peg', '1990-04-18', '52917878261');
insert into  hospedes (nome, nome_social, dt_nasc, cpf) values ('Eartha', 'Yoshi', '1901-04-14', '8080951120');
insert into  hospedes (nome, nome_social, dt_nasc, cpf) values ('Chlo', 'Desmond', '1935-07-22', '39102928415');
SET @id_hospede = LAST_INSERT_ID();

    
    /* Nenhuma chave estrangeira */
insert into  hospedagens (forma_pag, data_in, data_out, preco) values ('dinheiro', '2088-11-11', '2046-01-12', '464.24');
insert into  hospedagens (forma_pag, data_in, data_out, preco) values ('dinheiro', '2095-02-10', '1909-07-13', '383.5');
insert into  hospedagens (forma_pag, data_in, data_out, preco) values ('dinheiro', '1908-05-03', '1927-04-17', '174.28');
insert into  hospedagens (forma_pag, data_in, data_out, preco) values ('cartão(3x)', '2059-02-04', '1970-08-30', '200.9');
insert into  hospedagens (forma_pag, data_in, data_out, preco) values ('dinheiro', '2092-10-23', '1925-08-14', '359.4');
insert into  hospedagens (forma_pag, data_in, data_out, preco) values ('dinheiro', '1926-09-28', '2043-07-19', '482.72');
insert into  hospedagens (forma_pag, data_in, data_out, preco) values ('boleto', '2016-01-16', '1969-02-18', '478.68');
insert into  hospedagens (forma_pag, data_in, data_out, preco) values ('dinheiro', '1941-05-01', '1955-04-13', '110.42');
insert into  hospedagens (forma_pag, data_in, data_out, preco) values ('cartão(3x)', '1937-10-06', '1920-04-17', '238.92');
insert into  hospedagens (forma_pag, data_in, data_out, preco) values ('cartão(3x)', '2042-09-15', '1966-12-20', '459.63');
insert into  hospedagens (forma_pag, data_in, data_out, preco) values ('pix', '1961-01-16', '2005-04-20', '258.3');
insert into  hospedagens (forma_pag, data_in, data_out, preco) values ('boleto', '1931-04-29', '1917-01-21', '445.89');
insert into  hospedagens (forma_pag, data_in, data_out, preco) values ('pix', '2014-12-04', '1954-11-07', '468.65');
insert into  hospedagens (forma_pag, data_in, data_out, preco) values ('cartão(3x)', '2091-09-08', '1951-09-10', '143.17');
insert into  hospedagens (forma_pag, data_in, data_out, preco) values ('cartão(3x)', '1984-02-14', '1988-01-24', '381.82');
insert into  hospedagens (forma_pag, data_in, data_out, preco) values ('dinheiro', '1988-07-17', '2070-07-07', '327.34');
insert into  hospedagens (forma_pag, data_in, data_out, preco) values ('pix', '2062-06-20', '1995-10-27', '259.66');
insert into  hospedagens (forma_pag, data_in, data_out, preco) values ('boleto', '2053-10-18', '2021-10-18', '170.21');
insert into  hospedagens (forma_pag, data_in, data_out, preco) values ('dinheiro', '2055-11-22', '1946-12-27', '418.83');
insert into  hospedagens (forma_pag, data_in, data_out, preco) values ('pix', '2000-07-20', '2080-06-09', '509.54');
SET @id_hospedagem = LAST_INSERT_ID();



    
    /* Organizar o resto da tabela */
    /*
    Sim = 0
    Não = 1 
    */
	insert into modelo_quarto (nome_modelo, qtd_banheiro, qtd_camas, frigobar, servico_quarto) values ('Standard', 1, 2, 0, 1);
	insert into modelo_quarto (nome_modelo, qtd_banheiro, qtd_camas, frigobar, servico_quarto) values ('Suite Executiva', 2, 2, 1, 1);
	insert into modelo_quarto (nome_modelo, qtd_banheiro, qtd_camas, frigobar, servico_quarto) values ('Deluxe', 3, 3, 1, 1);
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

    
    /* 1 chave estrangeira */
	insert into hoteis(hora_checkin,hora_checkout,endereco_id)values('2:57','7:58',@endereco_id);
	insert into hoteis(hora_checkin,hora_checkout,endereco_id)values('3:03','12:37',@endereco_id);
	insert into hoteis(hora_checkin,hora_checkout,endereco_id)values('5:33','4:31',@endereco_id);
	insert into hoteis(hora_checkin,hora_checkout,endereco_id)values('6:04','5:13',@endereco_id);
	insert into hoteis(hora_checkin,hora_checkout,endereco_id)values('12:43','1:45',@endereco_id);
	insert into hoteis(hora_checkin,hora_checkout,endereco_id)values('9:41','3:57',@endereco_id);
	insert into hoteis(hora_checkin,hora_checkout,endereco_id)values('7:32','9:03',@endereco_id);
	insert into hoteis(hora_checkin,hora_checkout,endereco_id)values('4:11','4:13',@endereco_id);
	insert into hoteis(hora_checkin,hora_checkout,endereco_id)values('7:45','10:27',@endereco_id);
	insert into hoteis(hora_checkin,hora_checkout,endereco_id)values('6:52','11:51',@endereco_id);
	insert into hoteis(hora_checkin,hora_checkout,endereco_id)values('10:05','12:04',@endereco_id);
	insert into hoteis(hora_checkin,hora_checkout,endereco_id)values('11:40','9:06',@endereco_id);
	insert into hoteis(hora_checkin,hora_checkout,endereco_id)values('6:40','5:27',@endereco_id);
	insert into hoteis(hora_checkin,hora_checkout,endereco_id)values('3:23','5:16',@endereco_id);
	insert into hoteis(hora_checkin,hora_checkout,endereco_id)values('9:08','6:30',@endereco_id);
	insert into hoteis(hora_checkin,hora_checkout,endereco_id)values('11:18','12:19',@endereco_id);
	insert into hoteis(hora_checkin,hora_checkout,endereco_id)values('9:39','11:57',@endereco_id);
	insert into hoteis(hora_checkin,hora_checkout,endereco_id)values('2:14','2:31',@endereco_id);
	insert into hoteis(hora_checkin,hora_checkout,endereco_id)values('5:00','4:14',@endereco_id);
	insert into hoteis(hora_checkin,hora_checkout,endereco_id)values('7:03','11:04',@endereco_id);
    SET @hotel_id = LAST_INSERT_ID();

    
    /* Tabela formada por chaves estrangeiras */
    
	insert into detalhes_hospedagem (id_detalhe_hospedagem, id_hospedagem, id_hospede, num_quarto) values (1,  @id_hospedagem, @id_hospede,@num_quarto);
	insert into detalhes_hospedagem (id_detalhe_hospedagem, id_hospedagem, id_hospede, num_quarto) values (2,  @id_hospedagem, @id_hospede,@num_quarto);
	insert into detalhes_hospedagem (id_detalhe_hospedagem, id_hospedagem, id_hospede, num_quarto) values (3,  @id_hospedagem, @id_hospede,@num_quarto);
	insert into detalhes_hospedagem (id_detalhe_hospedagem, id_hospedagem, id_hospede, num_quarto) values (4,  @id_hospedagem, @id_hospede,@num_quarto);
	insert into detalhes_hospedagem (id_detalhe_hospedagem, id_hospedagem, id_hospede, num_quarto) values (5,  @id_hospedagem, @id_hospede,@num_quarto);
	insert into detalhes_hospedagem (id_detalhe_hospedagem, id_hospedagem, id_hospede, num_quarto) values (6,  @id_hospedagem, @id_hospede,@num_quarto);
	insert into detalhes_hospedagem (id_detalhe_hospedagem, id_hospedagem, id_hospede, num_quarto) values (7,  @id_hospedagem, @id_hospede,@num_quarto);
	insert into detalhes_hospedagem (id_detalhe_hospedagem, id_hospedagem, id_hospede, num_quarto) values (8,  @id_hospedagem, @id_hospede,@num_quarto);
	insert into detalhes_hospedagem (id_detalhe_hospedagem, id_hospedagem, id_hospede, num_quarto) values (9,  @id_hospedagem, @id_hospede,@num_quarto);
	insert into detalhes_hospedagem (id_detalhe_hospedagem, id_hospedagem, id_hospede, num_quarto) values (10, @id_hospedagem, @id_hospede,@num_quarto);
	insert into detalhes_hospedagem (id_detalhe_hospedagem, id_hospedagem, id_hospede, num_quarto) values (11, @id_hospedagem, @id_hospede,@num_quarto);
	insert into detalhes_hospedagem (id_detalhe_hospedagem, id_hospedagem, id_hospede, num_quarto) values (12, @id_hospedagem, @id_hospede,@num_quarto);
	insert into detalhes_hospedagem (id_detalhe_hospedagem, id_hospedagem, id_hospede, num_quarto) values (13, @id_hospedagem, @id_hospede,@num_quarto);
	insert into detalhes_hospedagem (id_detalhe_hospedagem, id_hospedagem, id_hospede, num_quarto) values (14, @id_hospedagem, @id_hospede,@num_quarto);
	insert into detalhes_hospedagem (id_detalhe_hospedagem, id_hospedagem, id_hospede, num_quarto) values (16, @id_hospedagem, @id_hospede,@num_quarto);
	insert into detalhes_hospedagem (id_detalhe_hospedagem, id_hospedagem, id_hospede, num_quarto) values (15, @id_hospedagem, @id_hospede,@num_quarto);
	insert into detalhes_hospedagem (id_detalhe_hospedagem, id_hospedagem, id_hospede, num_quarto) values (17, @id_hospedagem, @id_hospede,@num_quarto);
	insert into detalhes_hospedagem (id_detalhe_hospedagem, id_hospedagem, id_hospede, num_quarto) values (19, @id_hospedagem, @id_hospede,@num_quarto);
	insert into detalhes_hospedagem (id_detalhe_hospedagem, id_hospedagem, id_hospede, num_quarto) values (18, @id_hospedagem, @id_hospede,@num_quarto);
	insert into detalhes_hospedagem (id_detalhe_hospedagem, id_hospedagem, id_hospede, num_quarto) values (20, @id_hospedagem, @id_hospede,@num_quarto);
-- -----------------------------------------------------
-- Selects em cada tabela
-- -----------------------------------------------------

    SELECT * FROM enderecos ORDER BY endereco_id;
    SELECT * FROM eventos ORDER BY id_evento;
    SELECT * FROM pontos_tur ORDER BY ponto_id;
    SELECT * FROM hospedes ORDER BY id_hospede;
    SELECT * FROM hospedagens ORDER BY id_hospedagem;
    SELECT * FROM modelo_quarto ORDER BY tipo_id;
    SELECT * FROM quarto ORDER BY num_quarto;
    SELECT * FROM hoteis ORDER BY hotel_id;
    SELECT * FROM detalhes_hospedagem ORDER BY id_detalhe_hospedagem;
    

