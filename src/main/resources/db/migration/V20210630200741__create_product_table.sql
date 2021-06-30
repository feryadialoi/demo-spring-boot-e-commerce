CREATE TABLE products
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    name               VARCHAR(255)          NOT NULL,
    price              DECIMAL(19, 2)        NOT NULL,
    quantity           INT,
    created_date       TIMESTAMP,
    last_modified_date TIMESTAMP,
    PRIMARY KEY (id)
)