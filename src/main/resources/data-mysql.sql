-- Table: link
INSERT INTO link (id, created_date, last_modified_date, title, url) 
VALUES (1, '2019-05-23 16:37:10', '2019-05-23 16:37:12', 'Getting starting with Spring Boot 2', 'https://docs.spring.io/spring-boot/docs/current/reference/html/');

-- Table: comment
INSERT INTO comment (id, created_date, last_modified_date, body, link_id) 
VALUES ('1', '2019-05-23 16:52:43', '2019-05-23 16:52:46', 'What an awesome course', '1');