CREATE TABLE task (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      description TEXT,
                      creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      completion_date TIMESTAMP,
                      status VARCHAR(50)
);
