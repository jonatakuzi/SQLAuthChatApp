MChat GUI

A Java Swing application that demonstrates advanced GUI layout techniques, custom layout managers, and user authentication. The project includes a login form, a chat-style interface, image handling utilities, and optional JDBC-based login verification.

 Project Structure
src/
 └── main/
      ├── java/
      │    └── mchat/
      │         ├── AuthService.java
      │         ├── InMemoryAuthService.java
      │         ├── JdbcAuthService.java
      │         ├── LoginFrame.java
      │         ├── MChatFrame.java
      │         ├── MessageBubble.java
      │         ├── FormLayout.java
      │         └── ImageUtil.java
      └── resources/
           └── images/
                ├── bowser.png
                └── luigi.png etc

 Features
 Login System

Uses a custom FormLayout (Strategy pattern) for the login form.

Supports:

InMemoryAuthService → simple local testing

JdbcAuthService → SQL Server login authentication

💬 Chat Interface (MChatFrame)

BorderLayout for overall window structure

BoxLayout for stacking messages in the chat panel

MessageBubble uses absolute positioning for icon + text

Auto-resizes message height based on content

 Image Utilities

ImageUtil loads and resizes icons

Can load profile images from resources or database

Provides helper functions for converting and manipulating images

 Running the App

Run:

Main.java


Choose your desired authentication service by switching between:

new InMemoryAuthService()


or

new JdbcAuthService()


in Main.

 Requirements

Java 8+

(Optional) SQL Server + JDBC driver if using JdbcAuthService
