# 🏡 J'irai dormir chez vous (JDCV)

![CI/CD](https://github.com/chellabisonia/JdcvApp/actions/workflows/workflow.yml/badge.svg)  
*Une application de réservation moderne construite avec Spring Boot et React.*

---

## 🚀 Introduction

Ce projet est une plateforme de réservation permettant aux utilisateurs de consulter et réserver des séjours chez des habitants locaux dans différentes villes, en offrant une expérience immersive et authentique..  
L'application repose sur **Spring Boot** pour le backend et **React** pour le frontend, avec une interface élégante stylisée via **Styled-components**.

---

## 🛠️ Technologies utilisées

### 🔹 Backend
- **Java 17+** – Langage utilisé pour le développement backend.
- **Spring Boot** – Framework Java pour l'API REST.
- **JUnit 5** – Outil de test unitaire.
- **Mockito** – Framework pour les tests avec mocks.
- **JaCoCo** – Génération de rapports de couverture de code.
- **Checkstyle** – Analyse statique du code.
- **Logback** – Gestion des logs.

### 🔹 Frontend
- **React** – Bibliothèque JavaScript pour le frontend.
- **Styled-components** – Gestion des styles CSS dans les composants.
- **Jest** – Tests unitaires pour React.

---

## 📌 Prérequis

Avant de commencer, assurez-vous d'avoir installé :

- **[Java JDK 17+](https://adoptopenjdk.net/)**
- **[Maven 3+](https://maven.apache.org/)**
- **[Node.js 14+](https://nodejs.org/)**

---

## 📥 Installation & Exécution
### 🔧 Backend (Spring Boot)

1. Cloner le projet
```bash
git clone git@github.com:chellabisonia/JdcvApp.git
cd /backend
```
2. Compiler et exécuter les tests
```bash
mvn clean install
```
3. Démarrer le backend
```bash
mvn spring-boot:run
```
📍 L'API est accessible à http://localhost:8080

---

### 💻 Frontend (React) 

1. Aller dans le répertoire frontend
```bash
  cd ../frontend
```
3. Installer les dépendances
```bash
npm install
```
5. Démarrer l'application
```bash
  npm start
```
 📍 L'application est accessible à http://localhost:3000

---

### ✅ Tests & Qualité du Code
🔍 Tests Backend
```bash
mvn test
```
📊 Couverture de Code (JaCoCo)
```bash
mvn jacoco:report
```
Ouvrir le fichier target/site/jacoco/index.html

 # 🔍 Linter Backend (Checkstyle)
```bash
mvn checkstyle:check
```
# 🛠️ Tests Frontend
```bash
npm test
```
### 📜 Logging (Logback)
L'application utilise Logback pour la gestion des logs, les enregistre et sauvegarde pendant 30 jours

### 🔗 API Documentation



### 📜 Licence
📝 Ce projet est sous licence MIT.

