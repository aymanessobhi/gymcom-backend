create database fmsardb;
CREATE USER 'fmsardb'@'localhost' IDENTIFIED  BY 'fmsardb!';
GRANT ALL PRIVILEGES ON fmsardb.* TO 'fmsardb'@'localhost';
FLUSH PRIVILEGES;

INSERT INTO fmsardb.fmsar_roles
(id, description, name)
VALUES(1, 'ROLE_AGENT', 'ROLE_AGENT');
INSERT INTO fmsardb.fmsar_roles
(id, description, name)
VALUES(2, 'ROLE_ADMIN', 'ROLE_ADMIN');use fmsardb;
