-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 05-Jan-2016 às 00:36
-- Versão do servidor: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `odin`
--
DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_InserirTipoUsuario` (IN `tipo` VARCHAR(20), IN `cpf` VARCHAR(20))  BEGIN
	if (tipo = 'Aluno') THEN
    	insert into aluno(cpf) values(cpf);
        ELSEIF (tipo = 'Professor') THEN
        insert into professor(professor.cpf) VALUES(cpf);
        END if;
END$$

DELIMITER ;
-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `codigo_aluno` int(11) NOT NULL,
  `cpf` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno_por_disciplina`
--

CREATE TABLE `aluno_por_turma` (
  `nota_final` decimal(4,2) DEFAULT NULL,
  `nota_2` decimal(4,2) DEFAULT NULL,
  `faltas` int(11) DEFAULT NULL,
  `nota_1` decimal(4,2) DEFAULT NULL,
  `codigo_aluno` int(11) DEFAULT NULL,
  `codigo_turma` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplina`
--

CREATE TABLE `disciplina` (
  `carga_horaria` int(11) DEFAULT NULL,
  `nome_disciplina` varchar(40) DEFAULT NULL,
  `codigo_disciplina` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplina_por_professor`
--

CREATE TABLE `disciplina_por_professor` (
  `codigo_disciplina` int(11) DEFAULT NULL,
  `codigo_professor` int(11) DEFAULT NULL,
  `codigo_turma` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

CREATE TABLE `professor` (
  `codigo_professor` int(11) NOT NULL,
  `cpf` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `turma`
--

CREATE TABLE `turma` (
  `codigo_turma` int(11) NOT NULL,
  `nome_turma` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `cpf` varchar(20) NOT NULL,
  `nome` varchar(60) DEFAULT NULL,
  `usuario` varchar(20) DEFAULT NULL,
  `senha` varchar(16) DEFAULT NULL,
  `tipo_usuario` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`cpf`, `usuario`, `nome`, `senha`, `tipo_usuario`) VALUES
('000', 'admin', 'admin', 'admin', 'admin');

--
-- Acionadores `usuario`
--
DELIMITER $$
CREATE TRIGGER `trg_entradaUsuario` AFTER INSERT ON `usuario` FOR EACH ROW BEGIN
	CALL sp_inserirTipoUsuario(new.tipo_usuario,new.cpf) ;
end
$$
DELIMITER ;
--
-- Indexes for dumped tables
--

--
-- Indexes for table `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`codigo_aluno`),
  ADD KEY `cpf` (`cpf`);

--
-- Indexes for table `aluno_por_turma`
--
ALTER TABLE `aluno_por_turma`
  ADD KEY `codigo_aluno` (`codigo_aluno`),
  ADD KEY `codigo_turma` (`codigo_turma`);
  
--
-- Indexes for table `disciplina`
--
ALTER TABLE `disciplina`
  ADD PRIMARY KEY (`codigo_disciplina`);

--
-- Indexes for table `disciplina_por_professor`
--
ALTER TABLE `disciplina_por_professor`
  ADD KEY `codigo_disciplina` (`codigo_disciplina`),
  ADD KEY `codigo_professor` (`codigo_professor`),
  ADD KEY `codigo_turma` (`codigo_turma`);

--
-- Indexes for table `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`codigo_professor`),
  ADD KEY `cpf` (`cpf`);

--
-- Indexes for table `turma`
--
ALTER TABLE `turma`
  ADD PRIMARY KEY (`codigo_turma`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`cpf`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aluno`
--
ALTER TABLE `aluno`
  MODIFY `codigo_aluno` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `disciplina`
--
ALTER TABLE `disciplina`
  MODIFY `codigo_disciplina` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `professor`
--
ALTER TABLE `professor`
  MODIFY `codigo_professor` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `turma`
  MODIFY `codigo_turma` int(11) not null AUTO_INCREMENT;
 --
-- Constraints for dumped tables
--


--
-- Limitadores para a tabela `aluno`
--
ALTER TABLE `aluno`
  ADD CONSTRAINT `aluno_ibfk_1` FOREIGN KEY (`cpf`) REFERENCES `usuario` (`cpf`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `aluno_por_disciplina`
--
ALTER TABLE `aluno_por_disciplina`
  ADD CONSTRAINT `aluno_por_disciplina_ibfk_1` FOREIGN KEY (`codigo_aluno`) REFERENCES `aluno` (`codigo_aluno`) ON DELETE CASCADE,
  ADD CONSTRAINT `aluno_por_disciplina_ibfk_2` FOREIGN KEY (`codigo_turma`) REFERENCES `turma` (`codigo_turma`) ON DELETE CASCADE;
  
--
-- Limitadores para a tabela `disciplina_por_professor`
--
ALTER TABLE `disciplina_por_professor`
  ADD CONSTRAINT `disciplina_por_professor_ibfk_1` FOREIGN KEY (`codigo_disciplina`) REFERENCES `disciplina` (`codigo_disciplina`) ON DELETE CASCADE,
  ADD CONSTRAINT `disciplina_por_professor_ibfk_2` FOREIGN KEY (`codigo_professor`) REFERENCES `professor` (`codigo_professor`) ON DELETE CASCADE,
  ADD CONSTRAINT `disciplina_por_professor_ibfk_3` FOREIGN KEY (`codigo_turma`) REFERENCES `turma` (`codigo_turma`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `professor`
--
ALTER TABLE `professor`
  ADD CONSTRAINT `professor_ibfk_1` FOREIGN KEY (`cpf`) REFERENCES `usuario` (`cpf`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
