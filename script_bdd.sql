-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : by3e2k93tqzmrmwemybh-mysql.services.clever-cloud.com:3306
-- Généré le : lun. 20 mai 2024 à 23:55
-- Version du serveur : 8.0.22-13
-- Version de PHP : 8.2.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `by3e2k93tqzmrmwemybh`
--

-- --------------------------------------------------------

--
-- Structure de la table `cv`
--

CREATE TABLE `cv` (
  `id` int NOT NULL,
  `genre` varchar(5) NOT NULL,
  `prenom` varchar(32) NOT NULL,
  `nom` varchar(32) NOT NULL,
  `tel` varchar(32) NOT NULL,
  `xml` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `cv`
--

INSERT INTO `cv` (`id`, `genre`, `prenom`, `nom`, `tel`, `xml`) VALUES
(1, 'M.', 'Elias', 'LARBI', '+33 7 48 85 57 75', '<cv24:cv24 xmlns:cv24=\"http://univ.fr/cv24\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://univ.fr/cv24 cv24.xsd \">\n    <cv24:identite>\n        <cv24:genre>M.</cv24:genre>\n        <cv24:nom>LARBI</cv24:nom>\n        <cv24:prenom>Elias</cv24:prenom>\n        <cv24:tel>+33 7 48 85 57 75</cv24:tel>\n        <cv24:mail>mailtest@tp.xml</cv24:mail>\n    </cv24:identite>\n    <cv24:objectif statut=\"stage\">Développeur Logiciel</cv24:objectif>\n    <cv24:prof>\n        <cv24:detail>\n            <cv24:datedeb>2002-12-03</cv24:datedeb>\n            <cv24:titre>Chomeur</cv24:titre>\n        </cv24:detail>\n        <cv24:detail>\n            <cv24:datedeb>2023-04-17</cv24:datedeb>\n            <cv24:datefin>2023-06-16</cv24:datefin>\n            <cv24:titre>Stagiaire</cv24:titre>\n        </cv24:detail>\n        <cv24:detail>\n            <cv24:datedeb>2020-10-19</cv24:datedeb>\n            <cv24:datefin>2023-06-30</cv24:datefin>\n            <cv24:titre>Etudiant</cv24:titre>\n        </cv24:detail>\n    </cv24:prof>\n    <cv24:competences>\n        <cv24:diplome niveau=\"4\">\n            <cv24:intitule>BAC</cv24:intitule>\n            <cv24:date>2020-09-03</cv24:date>\n            <cv24:institut>Lycée INT Tizi Ouzou</cv24:institut>\n        </cv24:diplome>\n        <cv24:diplome niveau=\"6\">\n            <cv24:intitule>Licence informatique</cv24:intitule>\n            <cv24:date>2023-06-30</cv24:date>\n            <cv24:institut>Université de Rouen</cv24:institut>\n        </cv24:diplome>\n        <cv24:diplome niveau=\"7\">\n            <cv24:intitule>Master GIL</cv24:intitule>\n            <cv24:date>2025-09-03</cv24:date>\n            <cv24:institut>Université de Rouen</cv24:institut>\n        </cv24:diplome>\n        <cv24:certif>\n            <cv24:datedeb>2024-02-14</cv24:datedeb>\n            <cv24:datefin>2024-02-14</cv24:datefin>\n            <cv24:titre>Certification XML</cv24:titre>\n        </cv24:certif>\n    </cv24:competences>\n    <cv24:divers>\n        <cv24:lv cert=\"MAT\" lang=\"fr\"/>\n        <cv24:lv cert=\"MAT\" lang=\"ar\"/>\n        <cv24:lv cert=\"CLES\" lang=\"en\" nivs=\"C1\"/>\n        <cv24:autre titre=\"Permis de Conduire\" comment=\"Pas de permis\"/>\n    </cv24:divers>\n</cv24:cv24>\n'),
(2, 'M.', 'Lionel', 'MESSI', '+33 7 48 85 57 73', '<cv24:cv24 xmlns:cv24=\"http://univ.fr/cv24\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://univ.fr/cv24 cv24.xsd \">\n    <cv24:identite>\n        <cv24:genre>M.</cv24:genre>\n        <cv24:nom>MESSI</cv24:nom>\n        <cv24:prenom>Lionel</cv24:prenom>\n        <cv24:tel>+33 7 48 85 57 73</cv24:tel>\n        <cv24:mail>mailtest@tp.xml</cv24:mail>\n    </cv24:identite>\n    <cv24:objectif statut=\"stage\">Développeur Logiciel</cv24:objectif>\n    <cv24:prof>\n        <cv24:detail>\n            <cv24:datedeb>2002-12-03</cv24:datedeb>\n            <cv24:titre>Chomeur</cv24:titre>\n        </cv24:detail>\n        <cv24:detail>\n            <cv24:datedeb>2023-04-17</cv24:datedeb>\n            <cv24:datefin>2023-06-16</cv24:datefin>\n            <cv24:titre>Stagiaire</cv24:titre>\n        </cv24:detail>\n        <cv24:detail>\n            <cv24:datedeb>2020-10-19</cv24:datedeb>\n            <cv24:datefin>2023-06-30</cv24:datefin>\n            <cv24:titre>Etudiant</cv24:titre>\n        </cv24:detail>\n    </cv24:prof>\n    <cv24:competences>\n        <cv24:diplome niveau=\"4\">\n            <cv24:intitule>BAC</cv24:intitule>\n            <cv24:date>2020-09-03</cv24:date>\n            <cv24:institut>Lycée INT Tizi Ouzou</cv24:institut>\n        </cv24:diplome>\n        <cv24:diplome niveau=\"6\">\n            <cv24:intitule>Licence informatique</cv24:intitule>\n            <cv24:date>2023-06-30</cv24:date>\n            <cv24:institut>Université de Rouen</cv24:institut>\n        </cv24:diplome>\n        <cv24:diplome niveau=\"7\">\n            <cv24:intitule>Master GIL</cv24:intitule>\n            <cv24:date>2025-09-03</cv24:date>\n            <cv24:institut>Université de Rouen</cv24:institut>\n        </cv24:diplome>\n        <cv24:certif>\n            <cv24:datedeb>2024-02-14</cv24:datedeb>\n            <cv24:datefin>2024-02-14</cv24:datefin>\n            <cv24:titre>Certification XML</cv24:titre>\n        </cv24:certif>\n    </cv24:competences>\n    <cv24:divers>\n        <cv24:lv cert=\"MAT\" lang=\"fr\"/>\n        <cv24:lv cert=\"MAT\" lang=\"ar\"/>\n        <cv24:lv cert=\"CLES\" lang=\"en\" nivs=\"C1\"/>\n        <cv24:autre titre=\"Permis de Conduire\" comment=\"Pas de permis\"/>\n    </cv24:divers>\n</cv24:cv24>\n');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `cv`
--
ALTER TABLE `cv`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
