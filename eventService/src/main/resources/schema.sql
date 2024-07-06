CREATE TABLE Event (
    eventId NUMBER PRIMARY KEY,
    name VARCHAR2(255),
    location VARCHAR2(255),
    dateTime VARCHAR2(50),
    ticketId NUMBER,
    CONSTRAINT fk_ticket FOREIGN KEY (ticketId) REFERENCES Ticket(ticketId)
);  