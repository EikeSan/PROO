-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 29-Dez-2015 às 23:53
-- Versão do servidor: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `odin`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_InserirTipoUsuario`(IN `tipo` VARCHAR(20), IN `cpf` VARCHAR(20))
BEGIN
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

CREATE TABLE IF NOT EXISTS `aluno` (
`codigo_aluno` int(11) NOT NULL,
  `cpf` varchar(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno_por_disciplina`
--

CREATE TABLE IF NOT EXISTS `aluno_por_disciplina` (
  `nota_1` decimal(2,2) DEFAULT NULL,
  `nota_2` decimal(2,2) DEFAULT NULL,
  `nota_final` decimal(2,2) DEFAULT NULL,
  `faltas` int(11) DEFAULT NULL,
  `codigo_disciplina` int(11) DEFAULT NULL,
  `codigo_aluno` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplina`
--

CREATE TABLE IF NOT EXISTS `disciplina` (
`codigo_disciplina` int(11) NOT NULL,
  `nome_disciplina` varchar(40) DEFAULT NULL,
  `carga_horaria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplina_por_professor`
--

CREATE TABLE IF NOT EXISTS `disciplina_por_professor` (
  `codigo_disciplina` int(11) DEFAULT NULL,
  `codigo_professor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

CREATE TABLE IF NOT EXISTS `professor` (
`codigo_professor` int(11) NOT NULL,
  `cpf` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `cpf` varchar(20) NOT NULL,
  `usuario` varchar(20) DEFAULT NULL,
  `nome` varchar(60) DEFAULT NULL,
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
DELIMITER //
CREATE TRIGGER `trg_entradaUsuario` AFTER INSERT ON `usuario`
 FOR EACH ROW BEGIN
	CALL sp_inserirTipoUsuario(new.tipo_usuario,new.cpf) ;
end
//
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aluno`
--
ALTER TABLE `aluno`
 ADD PRIMARY KEY (`codigo_aluno`), ADD KEY `cpf` (`cpf`);

--
-- Indexes for table `aluno_por_disciplina`
--
ALTER TABLE `aluno_por_disciplina`
 ADD KEY `codigo_disciplina` (`codigo_disciplina`), ADD KEY `codigo_aluno` (`codigo_aluno`);

--
-- Indexes for table `disciplina`
--
ALTER TABLE `disciplina`
 ADD PRIMARY KEY (`codigo_disciplina`);

--
-- Indexes for table `disciplina_por_professor`
--
ALTER TABLE `disciplina_por_professor`
 ADD KEY `codigo_disciplina` (`codigo_disciplina`), ADD KEY `codigo_professor` (`codigo_professor`);

--
-- Indexes for table `professor`
--
ALTER TABLE `professor`
 ADD PRIMARY KEY (`codigo_professor`), ADD KEY `cpf` (`cpf`);

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
MODIFY `codigo_aluno` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
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
ADD CONSTRAINT `aluno_por_disciplina_ibfk_1` FOREIGN KEY (`codigo_disciplina`) REFERENCES `disciplina` (`codigo_disciplina`) ON DELETE CASCADE,
ADD CONSTRAINT `aluno_por_disciplina_ibfk_2` FOREIGN KEY (`codigo_aluno`) REFERENCES `aluno` (`codigo_aluno`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `disciplina_por_professor`
--
ALTER TABLE `disciplina_por_professor`
ADD CONSTRAINT `disciplina_por_professor_ibfk_1` FOREIGN KEY (`codigo_disciplina`) REFERENCES `disciplina` (`codigo_disciplina`) ON DELETE CASCADE,
ADD CONSTRAINT `disciplina_por_professor_ibfk_2` FOREIGN KEY (`codigo_professor`) REFERENCES `professor` (`codigo_professor`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `professor`
--
ALTER TABLE `professor`
ADD CONSTRAINT `professor_ibfk_1` FOREIGN KEY (`cpf`) REFERENCES `usuario` (`cpf`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
