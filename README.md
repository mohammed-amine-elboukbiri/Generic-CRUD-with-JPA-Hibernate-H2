# Gestion Salles 🏫

Application Java qui illustre la mise en place d'un **service CRUD générique** avec **JPA**, **Hibernate** et une base de données **H2 embarquée**.

---

## Présentation du projet

Ce projet a pour objectif de démontrer comment structurer une couche d'accès aux données en Java en utilisant JPA et Hibernate comme implémentation. Toutes les opérations de base (création, lecture, mise à jour, suppression) sont centralisées dans une interface générique réutilisable, ce qui évite la duplication de code entre les différentes entités métier.

La base de données H2 fonctionne entièrement en mémoire : aucune configuration externe n'est nécessaire pour faire tourner le projet.

---

## Fonctionnement

Le projet repose sur trois niveaux :

**1. L'interface générique**
`CrudService<T, ID>` définit les opérations CRUD applicables à n'importe quelle entité JPA.

**2. L'implémentation abstraite**
`AbstractCrudService<T, ID>` prend en charge la gestion de l'`EntityManager` et des transactions de façon transparente.

**3. Les services concrets**
`UtilisateurService` et `SalleService` héritent de l'implémentation abstraite et peuvent être étendus selon les besoins métier.

---

## Stack technique

| Brique | Version |
|---|---|
| Java | JDK 8+ |
| Maven | 3.x |
| JPA API | 2.2 |
| Hibernate Core | 5.6.5.Final |
| Hibernate Validator | 6.2.0.Final |
| Base H2 | 2.1.214 |
| SLF4J | 1.7.36 |
| JUnit | 4.13.2 |

---

## Organisation des fichiers

```
gestion-salles/
├── src/
│   ├── main/
│   │   ├── java/com/example/
│   │   │   ├── App.java
│   │   │   ├── model/
│   │   │   │   ├── Utilisateur.java
│   │   │   │   └── Salle.java
│   │   │   └── service/
│   │   │       ├── CrudService.java
│   │   │       ├── AbstractCrudService.java
│   │   │       ├── UtilisateurService.java
│   │   │       └── SalleService.java
│   │   └── resources/META-INF/
│   │       └── persistence.xml
│   └── test/
│       └── java/com/example/service/
├── pom.xml
└── README.md
```

---

## Paramètres JPA

La configuration se trouve dans `src/main/resources/META-INF/persistence.xml`.

```xml
<property name="javax.persistence.jdbc.url"
          value="jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1"/>
<property name="hibernate.hbm2ddl.auto" value="create-drop"/>
<property name="hibernate.show_sql"     value="true"/>
<property name="hibernate.format_sql"   value="true"/>
```

Le schéma est recréé à chaque démarrage (`create-drop`), ce qui garantit un environnement propre pour chaque exécution.

---

## 🎬 Démonstration

[![Watch the video](https://img.youtube.com/vi/SWVAMm52ngo/0.jpg)](https://youtu.be/SWVAMm52ngo)

