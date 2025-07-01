# GreenDrop - Plateforme de Gestion de l'Irrigation

## Project Structure

```
greendrop/
├── backend/                           # Spring Boot Backend
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/greendrop/
│   │   │   │   ├── config/           # Configuration classes
│   │   │   │   ├── controller/       # REST controllers
│   │   │   │   ├── model/           # Entity classes
│   │   │   │   ├── repository/       # JPA repositories
│   │   │   │   ├── service/         # Business logic
│   │   │   │   ├── dto/             # Data Transfer Objects
│   │   │   │        
│   │   │   │   └── security/        # Security related classes
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/                     # Test classes
│   └── pom.xml
│
└── frontend/                          # Angular Frontend
    ├── src/
    │   ├── app/
    │   │   ├── components/          # Angular components
    │   │   │   ├── auth/           # Authentication components
    │   │   │   ├── crops/          # Crop management components
    │   │   │   ├── fields/         # Field management components
    │   │   │   └── irrigation/     # Irrigation management components
    │   │   ├── services/           # Angular services
    │   │   ├── models/             # TypeScript interfaces
    │   │   ├── guards/             # Route guards
    │   │   └── shared/             # Shared components/modules
    │   ├── assets/
    │   └── environments/
    ├── package.json
    └── angular.json
```

## Setup Instructions

### Backend Setup
1. Navigate to the backend directory
2. Run `mvn clean install`
3. Run `mvn spring-boot:run`
4. The backend will be available at `http://localhost:8080`

### Frontend Setup
1. Navigate to the frontend directory
2. Run `npm install`
3. Run `ng serve`
4. The frontend will be available at `http://localhost:4200`

## Features
- Bilingual interface (French/Arabic)
- Mobile-friendly design
- Secure authentication
- Crop management
- Field management
- Irrigation scheduling
- Weather-based recommendations
- Color-coded status indicators

## Technologies Used
- Backend: Spring Boot 3.2.3
- Frontend: Angular 17
- Database: H2 (Development)
- Security: Spring Security + JWT
- UI Framework: Angular Material + Bootstrap 