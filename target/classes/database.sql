CREATE database gymcomdb;
CREATE USER 'gymcomdb'@'localhost' IDENTIFIED  BY 'gymcomdb!';

GRANT ALL PRIVILEGES ON gymcomdb.* TO 'gymcomdb'@'localhost';

FLUSH PRIVILEGES;

