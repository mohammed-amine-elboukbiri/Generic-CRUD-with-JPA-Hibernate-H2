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

## 🎬 Démonstration



https://github.com/user-attachments/assets/58d71537-8322-4182-bbb5-a02f95946d16


