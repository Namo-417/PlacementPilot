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

## Application API

| Method | Endpoint | Purpose |
| --- | --- | --- |
| `GET` | `/api/v1/applications` | List applications; optional `query` and `status` filters |
| `GET` | `/api/v1/applications/{id}` | Get one application |
| `POST` | `/api/v1/applications` | Create an application |
| `PUT` | `/api/v1/applications/{id}` | Update an application |
| `PATCH` | `/api/v1/applications/{id}/status` | Update only its status |
| `DELETE` | `/api/v1/applications/{id}` | Delete an application |

Example create request:

```json
{
  "companyName": "OpenAI",
  "position": "Software Engineer Intern",
  "location": "Bengaluru",
  "jobType": "INTERNSHIP",
  "status": "APPLIED",
  "applicationDate": "2026-08-21",
  "deadline": "2026-09-05",
  "jobLink": "https://example.com/jobs/software-engineer-intern",
  "notes": "Referral requested."
}
```
