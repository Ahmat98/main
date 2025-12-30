# Hospital Management System

A comprehensive hospital management system built with ASP.NET Core, designed to streamline hospital operations, patient management, and healthcare services.

## Project Overview

The Hospital Management System is a modern, scalable web application that provides:
- Patient management and record keeping
- Appointment scheduling
- Doctor and staff management
- Medical records and history tracking
- Billing and insurance management
- Real-time notifications

## Technology Stack

- **Framework**: ASP.NET Core 8.0
- **Language**: C#
- **Database**: SQL Server
- **API Documentation**: Swagger/OpenAPI
- **Authentication**: JWT (JSON Web Tokens)
- **Architecture**: RESTful API with Clean Architecture principles

## Project Structure

```
Hospital/
├── Hospital.API/           # Main API project
│   ├── appsettings.json
│   ├── appsettings.Development.json
│   ├── Program.cs
│   └── Hospital.API.csproj
├── Hospital.sln            # Solution file
└── .gitignore             # Git ignore rules
```

## Getting Started

### Prerequisites
- .NET 8.0 SDK or later
- SQL Server (Local or Remote)
- Visual Studio 2022 or VS Code

### Installation

1. Clone the repository:
```bash
git clone https://github.com/Ahmat98/main.git
cd Asp.net/Hospital
```

2. Restore NuGet packages:
```bash
dotnet restore
```

3. Update the connection string in `appsettings.Development.json` with your SQL Server details.

4. Run the application:
```bash
cd Hospital.API
dotnet run
```

5. Access the API documentation at: `https://localhost:7000/swagger`

## Configuration

### appsettings.json
Contains production configuration settings including:
- Database connection strings
- JWT authentication settings
- Logging configuration

### appsettings.Development.json
Development-specific settings for local development.

## Features (In Development)

- [ ] User Authentication & Authorization
- [ ] Patient Management
- [ ] Doctor Management
- [ ] Appointment Scheduling
- [ ] Medical Records
- [ ] Billing System
- [ ] Reporting & Analytics
- [ ] Email Notifications

## API Endpoints

Endpoints will be documented in Swagger UI once development begins.

## Contributing

Contributions are welcome! Please follow the coding standards and submit pull requests for review.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Support

For issues and support, please contact the development team.
