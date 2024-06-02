-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 01-Abr-2022 às 09:42
-- Versão do servidor: 10.4.18-MariaDB
-- versão do PHP: 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `antigo_combatente`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cargo`
--

CREATE TABLE `cargo` (
  `idCargo` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cargo`
--

INSERT INTO `cargo` (`idCargo`, `nome`) VALUES
(1, 'FUNCIONARIO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`idCategoria`, `nome`) VALUES
(1, 'SARGENTO'),
(2, 'CAPITÃO'),
(3, 'GENERAL'),
(4, 'CORONEL'),
(5, 'SOLDADO'),
(6, 'CABO'),
(7, 'TENENTE'),
(8, 'TENENTE CORONEL'),
(9, 'MAJOR');

-- --------------------------------------------------------

--
-- Estrutura stand-in para vista `consultar`
-- (Veja abaixo para a view atual)
--
CREATE TABLE `consultar` (
`codigo` int(11)
,`desmobilizado` varchar(255)
,`estado` varchar(150)
,`data` date
,`sexo` varchar(10)
,`datac` date
,`salario` int(11)
,`categoria` varchar(45)
,`cidade` varchar(45)
,`provincia` varchar(45)
);

-- --------------------------------------------------------

--
-- Estrutura stand-in para vista `decategoria`
-- (Veja abaixo para a view atual)
--
CREATE TABLE `decategoria` (
`CODIGO` int(11)
,`NOME` varchar(255)
,`GENERO` varchar(10)
,`BI` varchar(15)
,`NASCIMENTO` date
,`CADASTRO` date
,`CATEGORIA` varchar(45)
,`SALARIO` int(11)
,`MUNICIPIO` varchar(45)
,`PROVINCIA` varchar(45)
);

-- --------------------------------------------------------

--
-- Estrutura da tabela `departamento`
--

CREATE TABLE `departamento` (
  `idDepartamento` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `departamento`
--

INSERT INTO `departamento` (`idDepartamento`, `nome`) VALUES
(1, 'MINISTERIO DO INTERIOR'),
(2, 'MINISTERIO DA DEFESA');

-- --------------------------------------------------------

--
-- Estrutura da tabela `desmobilizado`
--

CREATE TABLE `desmobilizado` (
  `idMobilizado` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `bi` varchar(15) NOT NULL,
  `dataNascimento` date NOT NULL,
  `dataCadastro` date NOT NULL,
  `idCategoria` int(11) NOT NULL,
  `idEndereco` int(11) NOT NULL,
  `salario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `desmobilizado`
--

INSERT INTO `desmobilizado` (`idMobilizado`, `nome`, `sexo`, `bi`, `dataNascimento`, `dataCadastro`, `idCategoria`, `idEndereco`, `salario`) VALUES
(1, 'ALFREDO CACONDA', 'Masculino', '12345678BA012', '1990-08-08', '2022-03-25', 5, 8, 192000),
(2, 'DOMINGOS FERNANDOS', 'Masculino', '12345678BA098', '1998-09-08', '2022-03-25', 3, 7, 1232343),
(3, 'EDUARDO NHANI', 'Masculino', '121312323', '1998-09-09', '2022-03-28', 4, 1, 1908765);

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `idEndereco` int(11) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `provincia` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`idEndereco`, `cidade`, `provincia`) VALUES
(1, 'BOCOIO', 'BENGUELA'),
(2, 'BENGUELA', 'BENGUELA'),
(3, 'BALOMBO', 'BENGUELA'),
(4, 'CUBAL', 'BENGUELA'),
(5, 'CHONGOROI', 'BENGUELA'),
(6, 'BAÍA FARTA', 'BENGUELA'),
(7, 'CATUMBELA', 'BENGUELA'),
(8, 'LOBITO', 'BENGUELA'),
(9, 'GANDA', 'BENGUELA');

-- --------------------------------------------------------

--
-- Estrutura stand-in para vista `func`
-- (Veja abaixo para a view atual)
--
CREATE TABLE `func` (
`CODIGO` int(11)
,`NOME` varchar(255)
,`GENERO` varchar(10)
,`BI` varchar(15)
,`NASCIMENTO` date
,`CADASTRO` date
,`USUARIO` varchar(45)
,`SENHA` varchar(255)
,`CARGO` varchar(45)
,`DEPARTAMENTO` varchar(100)
,`MUNICIPIO` varchar(45)
,`PROVINCIA` varchar(45)
);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `idFuncionario` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `Usuario` varchar(45) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `BI` varchar(15) NOT NULL,
  `dataNascimento` date NOT NULL,
  `dataCadastro` date NOT NULL,
  `Endereco_id` int(11) NOT NULL,
  `Departamento_id` int(11) NOT NULL,
  `Cargo_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`idFuncionario`, `nome`, `Usuario`, `senha`, `sexo`, `BI`, `dataNascimento`, `dataCadastro`, `Endereco_id`, `Departamento_id`, `Cargo_id`) VALUES
(1, 'ALFREDO BINJI ARMINDO CACONDA', 'ALFREDO', 'ALFREDO', 'MASCULINO', '123456BA045', '1997-09-09', '2022-03-25', 1, 1, 1),
(2, 'DOMINGOS FERNANDO CAYO', 'CAYO', 'CAYO', 'Masculino', '123456789BA098', '1998-09-09', '2022-03-25', 2, 1, 1),
(4, 'ERMELINDA DA SILVA KAPINGALA', 'jeny', 'jeny', 'Femenino', '12345ba06', '1999-09-25', '2022-03-27', 8, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura stand-in para vista `mvtarefa`
-- (Veja abaixo para a view atual)
--
CREATE TABLE `mvtarefa` (
`CODIGO` int(11)
,`TAREFA` varchar(250)
,`INICIO` date
,`TERMINO` date
,`ESTADO` varchar(10)
,`DESCRICAO` longtext
,`DEPARTAMENTO` varchar(100)
);

-- --------------------------------------------------------

--
-- Estrutura da tabela `prova_vida`
--

CREATE TABLE `prova_vida` (
  `idProvaVida` int(11) NOT NULL,
  `estado` varchar(150) NOT NULL,
  `data` date NOT NULL,
  `id_desmobilizado` int(11) NOT NULL,
  `id_funcionario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `prova_vida`
--

INSERT INTO `prova_vida` (`idProvaVida`, `estado`, `data`, `id_desmobilizado`, `id_funcionario`) VALUES
(1, 'Vivo', '2022-03-25', 2, 1),
(2, 'Morto', '2022-03-26', 1, 2),
(3, 'Vivo', '2022-03-28', 3, 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tarefa`
--

CREATE TABLE `tarefa` (
  `idt` int(11) NOT NULL,
  `tarefa` varchar(250) COLLATE utf8mb4_unicode_ci NOT NULL,
  `inicio` date NOT NULL,
  `termino` date NOT NULL,
  `estado` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `descricao` longtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `departamento_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `tarefa`
--

INSERT INTO `tarefa` (`idt`, `tarefa`, `inicio`, `termino`, `estado`, `descricao`, `departamento_id`) VALUES
(1, 'Cadastrar todos os desmobilizado ', '2022-03-27', '2022-03-29', 'Por Fazer', 'Listar todos os desmobilizado e mostrar os que fazeram o comprovativo de vida', 2);

-- --------------------------------------------------------

--
-- Estrutura para vista `consultar`
--
DROP TABLE IF EXISTS `consultar`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `consultar`  AS SELECT `p`.`idProvaVida` AS `codigo`, `d`.`nome` AS `desmobilizado`, `p`.`estado` AS `estado`, `p`.`data` AS `data`, `d`.`sexo` AS `sexo`, `d`.`dataCadastro` AS `datac`, `d`.`salario` AS `salario`, `c`.`nome` AS `categoria`, `e`.`cidade` AS `cidade`, `e`.`provincia` AS `provincia` FROM (((`prova_vida` `p` join `desmobilizado` `d` on(`p`.`id_desmobilizado` = `d`.`idMobilizado`)) join `categoria` `c` on(`d`.`idCategoria` = `c`.`idCategoria`)) join `endereco` `e` on(`d`.`idEndereco` = `e`.`idEndereco`)) ;

-- --------------------------------------------------------

--
-- Estrutura para vista `decategoria`
--
DROP TABLE IF EXISTS `decategoria`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `decategoria`  AS SELECT `d`.`idMobilizado` AS `CODIGO`, `d`.`nome` AS `NOME`, `d`.`sexo` AS `GENERO`, `d`.`bi` AS `BI`, `d`.`dataNascimento` AS `NASCIMENTO`, `d`.`dataCadastro` AS `CADASTRO`, `c`.`nome` AS `CATEGORIA`, `d`.`salario` AS `SALARIO`, `e`.`cidade` AS `MUNICIPIO`, `e`.`provincia` AS `PROVINCIA` FROM ((`desmobilizado` `d` join `categoria` `c` on(`c`.`idCategoria` = `d`.`idCategoria`)) join `endereco` `e` on(`e`.`idEndereco` = `d`.`idEndereco`)) ;

-- --------------------------------------------------------

--
-- Estrutura para vista `func`
--
DROP TABLE IF EXISTS `func`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `func`  AS SELECT `f`.`idFuncionario` AS `CODIGO`, `f`.`nome` AS `NOME`, `f`.`sexo` AS `GENERO`, `f`.`BI` AS `BI`, `f`.`dataNascimento` AS `NASCIMENTO`, `f`.`dataCadastro` AS `CADASTRO`, `f`.`Usuario` AS `USUARIO`, `f`.`senha` AS `SENHA`, `c`.`nome` AS `CARGO`, `d`.`nome` AS `DEPARTAMENTO`, `e`.`cidade` AS `MUNICIPIO`, `e`.`provincia` AS `PROVINCIA` FROM (((`funcionario` `f` join `endereco` `e` on(`e`.`idEndereco` = `f`.`Endereco_id`)) join `cargo` `c` on(`c`.`idCargo` = `f`.`Cargo_id`)) join `departamento` `d` on(`d`.`idDepartamento` = `f`.`Departamento_id`)) ;

-- --------------------------------------------------------

--
-- Estrutura para vista `mvtarefa`
--
DROP TABLE IF EXISTS `mvtarefa`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `mvtarefa`  AS SELECT `t`.`idt` AS `CODIGO`, `t`.`tarefa` AS `TAREFA`, `t`.`inicio` AS `INICIO`, `t`.`termino` AS `TERMINO`, `t`.`estado` AS `ESTADO`, `t`.`descricao` AS `DESCRICAO`, `d`.`nome` AS `DEPARTAMENTO` FROM (`tarefa` `t` join `departamento` `d` on(`d`.`idDepartamento` = `t`.`departamento_id`)) ;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`idCargo`);

--
-- Índices para tabela `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Índices para tabela `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`idDepartamento`);

--
-- Índices para tabela `desmobilizado`
--
ALTER TABLE `desmobilizado`
  ADD PRIMARY KEY (`idMobilizado`),
  ADD KEY `idCategoria` (`idCategoria`),
  ADD KEY `idEndereco` (`idEndereco`);

--
-- Índices para tabela `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`idEndereco`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`idFuncionario`);

--
-- Índices para tabela `prova_vida`
--
ALTER TABLE `prova_vida`
  ADD PRIMARY KEY (`idProvaVida`);

--
-- Índices para tabela `tarefa`
--
ALTER TABLE `tarefa`
  ADD PRIMARY KEY (`idt`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cargo`
--
ALTER TABLE `cargo`
  MODIFY `idCargo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `categoria`
--
ALTER TABLE `categoria`
  MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de tabela `departamento`
--
ALTER TABLE `departamento`
  MODIFY `idDepartamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `desmobilizado`
--
ALTER TABLE `desmobilizado`
  MODIFY `idMobilizado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `endereco`
--
ALTER TABLE `endereco`
  MODIFY `idEndereco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `idFuncionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `prova_vida`
--
ALTER TABLE `prova_vida`
  MODIFY `idProvaVida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `tarefa`
--
ALTER TABLE `tarefa`
  MODIFY `idt` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `desmobilizado`
--
ALTER TABLE `desmobilizado`
  ADD CONSTRAINT `desmobilizado_ibfk_1` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `desmobilizado_ibfk_2` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`idEndereco`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
