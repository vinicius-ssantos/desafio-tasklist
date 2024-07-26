-- Schema
CREATE TABLE task (
                      id SERIAL PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      description TEXT,
                      creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      completion_date TIMESTAMP,
                      status VARCHAR(50)
);
SELECT * FROM information_schema.tables WHERE table_name = 'task';