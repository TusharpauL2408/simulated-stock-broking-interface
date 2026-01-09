Project Overview

This project is a simplified trading backend system built to simulate core functionalities of an online stock broking platform.
It exposes REST APIs to view instruments, place buy/sell orders, track order status, view executed trades, and fetch portfolio holdings.

The system uses in-memory storage and does not connect to real financial markets.

Technology Stack

Language: Java 17

Framework: Spring Boot

Build Tool: Maven

API Format: REST (JSON)

Documentation: Swagger (OpenAPI)

Storage: In-memory (Java Collections)

 Setup and Run Instructions
Prerequisites

Java 17 installed

IntelliJ IDEA or any Java IDE

Steps to Run the Application

Open the project in IntelliJ

Reload Maven dependencies

Run the main class:

TradingApplication.java


Application starts on:

http://localhost:8080

API Documentation (Swagger)

Once the application is running, open Swagger UI in the browser:

http://localhost:8080/swagger-ui/index.html


Swagger provides a complete list of APIs along with request/response details.

API Details
 Instruments API

Fetch all tradable instruments.

GET /api/v1/instruments


Response includes:

symbol

exchange

instrumentType

lastTradedPrice

Order Management APIs
Place a New Order
POST /api/v1/orders


Request Fields:

symbol

orderType (BUY / SELL)

orderStyle (MARKET / LIMIT)

quantity (must be > 0)

price (mandatory for LIMIT orders)

Order Status Values:

NEW

PLACED

EXECUTED

Fetch Order Status
GET /api/v1/orders/{orderId}


Returns complete order details for the given order ID.

 Trades API

Fetch all executed trades.

GET /api/v1/trades


A trade is created only when an order is executed.

 Portfolio API

Fetch current portfolio holdings.

GET /api/v1/portfolio


Portfolio Fields:

symbol

quantity

averagePrice

currentValue

Portfolio is calculated dynamically from executed trades.

Assumptions Made During Implementation

Single hardcoded user (no authentication)

MARKET orders are executed immediately

LIMIT orders remain in PLACED state

No real market price feed or exchange connectivity

All data is stored in memory and resets on application restart

Conclusion

This project demonstrates a clean and modular backend design for a trading system using REST APIs.
It focuses on core trading concepts, proper layering, and clear API documentation, aligning with real-world broking platforms at a simplified level