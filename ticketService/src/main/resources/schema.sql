CREATE TABLE Tickets (
    ticketId NUMBER PRIMARY KEY,
    eventId NUMBER,
    userName VARCHAR2(255),
    seatNumber NUMBER,
    userId NUMBER,
    CONSTRAINT fk_event FOREIGN KEY (eventId) REFERENCES Events(eventId),
    CONSTRAINT fk_user FOREIGN KEY (userId) REFERENCES Users(userId)
);