# PlacementPilot

PlacementPilot is a full-stack placement application and job tracker for students. It will centralize job applications, companies, interview schedules, statuses, and placement progress in one dashboard.

## Tech stack

- **Frontend:** React + JavaScript
- **Backend:** Java 17 + Spring Boot
- **Database:** MySQL in production; H2 for zero-setup local development
- **Persistence:** Spring Data JPA / Hibernate
- **Build tool:** Maven

## Current structure

```text
PlacementPilot/
├── backend/          # Spring Boot REST API
└── frontend/         # React application (coming next)
```

## Run the backend locally

Prerequisite: Java 17+ and Maven.

```powershell
cd backend
mvn spring-boot:run
```

The API starts at `http://localhost:8080`. Confirm it is running at:

```text
http://localhost:8080/api/v1/status
```

The default development profile uses H2, so MySQL is not required yet. When MySQL is ready, start with the `mysql` profile and provide `DB_USERNAME` and `DB_PASSWORD` environment variables.
