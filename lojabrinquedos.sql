-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 24-Out-2022 às 23:04
-- Versão do servidor: 10.4.22-MariaDB
-- versão do PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `lojabrinquedos`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tblbrinquedos`
--

CREATE TABLE `tblbrinquedos` (
  `id` int(10) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `cat` varchar(50) NOT NULL,
  `preco` varchar(10) NOT NULL,
  `datadd` varchar(14) NOT NULL,
  `descr` varchar(255) NOT NULL,
  `quant` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tblbrinquedos`
--

INSERT INTO `tblbrinquedos` (`id`, `nome`, `cat`, `preco`, `datadd`, `descr`, `quant`) VALUES
(2, 'Barbie', 'Boneco', 'R$20,00', '', 'Boneca Infantil', 100),
(3, 'Nerf Rapidstriker', 'Arma de Brinquedo', 'R$250,00', '', 'Arma de Brinquedo', 247),
(5, 'sadasd', 'dsadsad', 'dsadsad', '26/02/22d', 'sdaqssad', 3224);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tblcliente`
--

CREATE TABLE `tblcliente` (
  `id` int(10) NOT NULL,
  `nome` text NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `datanasc` varchar(10) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `telefone` varchar(10) NOT NULL,
  `usuario` varchar(30) NOT NULL,
  `senha` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tblusuario`
--

CREATE TABLE `tblusuario` (
  `usuario` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tblusuario`
--

INSERT INTO `tblusuario` (`usuario`, `senha`) VALUES
('ABC', '123'),
('DEF', '456');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tblbrinquedos`
--
ALTER TABLE `tblbrinquedos`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tblcliente`
--
ALTER TABLE `tblcliente`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tblusuario`
--
ALTER TABLE `tblusuario`
  ADD PRIMARY KEY (`usuario`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tblbrinquedos`
--
ALTER TABLE `tblbrinquedos`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `tblcliente`
--
ALTER TABLE `tblcliente`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
