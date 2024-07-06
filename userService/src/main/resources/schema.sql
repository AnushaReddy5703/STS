 CREATE TABLE Users (
    userId NUMBER PRIMARY KEY NOT NULL,
    fullName VARCHAR2(255),
    email VARCHAR2(255),
    ticketId NUMBER,
    eventId NUMBER,
    CONSTRAINT fk_ticket FOREIGN KEY (ticketId) REFERENCES Tickets(ticketId),
    CONSTRAINT fk_event FOREIGN KEY (eventId) REFERENCES Events(eventId)
);