# SQLAuthChatApp

A Java Swing desktop application that combines SQL-based user authentication with a chat-style messaging interface. Built to demonstrate advanced GUI layout techniques, the Strategy design pattern, and JDBC database connectivity.

## Features

- **Login system** with two interchangeable auth backends: in-memory (for testing) and SQL Server via JDBC
- - **Custom FormLayout** — a hand-written layout manager implementing the Strategy pattern
  - - **Chat interface** with message bubbles, user avatars, and scroll support
    - - **Image utilities** for loading, resizing, and rendering avatars
      - - **Modular architecture** — swap auth providers without changing UI code
       
        - ## Tech Stack
       
        - - Java 17+
          - - Java Swing (BorderLayout, BoxLayout, custom layouts)
            - - JDBC / SQL Server
              - - IntelliJ IDEA
               
                - ## Project Structure
               
                - ```
                  SQLAuthChatApp/
                  ├── AuthService.java          # Auth interface (Strategy pattern)
                  ├── InMemoryAuthService.java  # Hardcoded credentials for local testing
                  ├── JdbcAuthService.java      # SQL Server login verification via JDBC
                  ├── LoginFrame.java           # Login form UI using FormLayout
                  ├── MChatFrame.java           # Main chat window
                  ├── MessageBubble.java        # Custom chat bubble component
                  ├── FormLayout.java           # Custom Swing layout manager
                  ├── ImageUtil.java            # Avatar loading and resizing utilities
                  └── main.java                 # Entry point
                  ```

                  ## Running the App

                  1. Clone the repo
                  2. 2. Open in IntelliJ IDEA
                     3. 3. To use SQL auth: configure your SQL Server connection string in `JdbcAuthService.java`
                        4. 4. To use in-memory auth: set `InMemoryAuthService` in `main.java`
                           5. 5. Run `main.java`
                             
                              6. ## Concepts Demonstrated
                             
                              7. - Strategy design pattern for swappable auth providers
                                 - - Custom Swing layout manager from scratch
                                   - - JDBC connection pooling and prepared statements
                                     - - Event-driven GUI with action listeners
                                       - - Separation of concerns between UI and business logic
