# Service REST CV24

## **Auteur** : Elias LARBI

## Introduction

Ce projet implémente un service REST permettant de gérer des CV en utilisant Spring Boot et MariaDB, et est testé via Postman.

## Lien vers projet déployé

https://cv24-larbieli.cleverapps.io/

## Prérequis

- Maven
- Java 17 ou plus
- MariaDB

## Installation

### Cloner le dépôt

```bash
git clone https://github.com/elias755/cv24v1.git
```

### Installer les dépendances maven

```bash
mvn clean install
```

## Configuration de la base de données (pour utilisation locale)

### Créer une base de données MariaDB

### Modifier le lien de connexion dans le fichier src/main/java/fr/univrouen/cv24/service/CVService.java pour qu'il corresponde au lien vers la BDD créée

### Importer dans la base de données le contenu de script_bdd.sql

## Exécution de l'Application

```bash
mvn spring-boot:run
```

## Api Endpoints

### Page d'Accueil

- **URL** : /
- **Méthode** : GET
- **Retour** : HTML

### Page d’Aide

- **URL** : /help
- **Méthode** : GET
- **Retour** : HTML

### Liste des CV

#### Format XML

- **URL** : /cv24/resume/xml
- **Méthode** : GET
- **Retour** : XML

#### Format HTML

- **URL** : /cv24/resume
- **Méthode** : GET
- **Retour** : HTML

### Détail d’un CV

#### Format XML

- **URL** : /cv24/xml?id=<id>
- **Méthode** : GET
- **Retour** : XML

#### Format HTML

- **URL** : /cv24/html?id=<id>
- **Méthode** : GET
- **Retour** : HTML

### Ajout d’un CV

- **URL** : /cv24/insert
- **Méthode** : POST
- **Retour** : XML (avec id et status)

### Suppression d’un CV

- **URL** : /cv24/delete
- **Méthode** : DELETE
- **Retour** : XML (avec id et status)

## Fichiers complémentaires

### Dossier resources

- **cv_maxi.xml** : Document XML ayant utilisé tous les éléments facultatifs du schéma XSD
- **cv_mini.xml** : Document XML ayant utilisé le minimum d'éléments du schéma XSD
- **cv24_larbi.json** : Collection de tests Postman

### Dossier src/main/resources

- **Dossier static** : Contient les fichiers statiques servis pour les routes statiques (/, /help), l'image ainsi que les css
- **Dossier xsd** : Contient le schéma XSD utilisé pour la validation des XML insérés
- **Dossier xslt** : Contient les XSLT utilisés pour transformer les fichiers XML stockés selon la route voulue
