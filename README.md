# Gestionnaire de Tâches — Spring Boot REST API

Une API REST construite avec Spring Boot permettant de gérer des utilisateurs et leurs tâches associées.

---

## Technologies utilisées

- **Java 17+**
- **Spring Boot 3**
- **Spring Data JPA / Hibernate**
- **Spring Validation**
- **PostgreSQL** (ou MySQL)
- **Maven**

---

## Fonctionnalités

- Créer, lire, modifier et supprimer des utilisateurs
- Créer, lire, modifier et supprimer des tâches
- Associer des tâches à un utilisateur
- Récupérer toutes les tâches d'un utilisateur
- Suppression automatique des tâches lors de la suppression d'un utilisateur (cascade)
- Validation des données (nom obligatoire, âge entre 18 et 140, etc.)

---

## Endpoints

### Utilisateurs — `/users`

| Méthode | URL | Description |
|--------|-----|-------------|
| `GET` | `/users` | Récupérer tous les utilisateurs |
| `GET` | `/users/{id}` | Récupérer un utilisateur par ID |
| `POST` | `/users` | Créer un utilisateur |
| `PUT` | `/users/{id}` | Modifier un utilisateur |
| `DELETE` | `/users/{id}` | Supprimer un utilisateur et ses tâches |
| `GET` | `/users/{userId}/tasks` | Récupérer toutes les tâches d'un utilisateur |
| `POST` | `/users/{userId}/tasks` | Créer une tâche pour un utilisateur |

### Tâches — `/tasks`

| Méthode | URL | Description |
|--------|-----|-------------|
| `GET` | `/tasks` | Récupérer toutes les tâches |
| `GET` | `/tasks/{id}` | Récupérer une tâche par ID |
| `PUT` | `/tasks/{id}` | Modifier une tâche |
| `DELETE` | `/tasks/{id}` | Supprimer une tâche |

---

## Lancer le projet

### Prérequis

- Java 17 ou supérieur installé
- Maven installé
- PostgreSQL (ou MySQL) installé et en cours d'exécution

### 1. Cloner le projet

```bash
git clone https://github.com/yawsf1/taskManagerWithSpringBoot.git
cd taskManagerWithSpringBoot
```

### 2. Configurer la base de données

Dans `src/main/resources/application.properties` :

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nom_de_ta_base
spring.datasource.username=ton_utilisateur
spring.datasource.password=ton_mot_de_passe
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8081
```

### 3. Lancer l'application

```bash
mvn spring-boot:run
```

L'API sera disponible sur : `http://localhost:8081`

---

## Exemple de requêtes

### Créer un utilisateur
```http
POST /users
Content-Type: application/json

{
    "nom": "Youssef Alami",
    "age": 25
}
```

### Créer une tâche pour l'utilisateur 1
```http
POST /users/1/tasks
Content-Type: application/json

{
    "task": "Finir le projet Spring Boot"
}
```

---

## Auteur

**yawsf1** — [github.com/yawsf1](https://github.com/yawsf1)
