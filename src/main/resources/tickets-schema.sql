drop table if exists tickets CASCADE;
CREATE TABLE tickets (
    id BIGINT AUTO_INCREMENT,
    screen BIGINT,
    seat_num BIGINT,
    seat_row CHAR(255) NOT NULL,
    title VARCHAR(255),
    PRIMARY KEY (id)
);