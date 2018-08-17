DROP TABLE empl_proj
IF EXISTS;
DROP TABLE employee
IF EXISTS;
DROP TABLE address
IF EXISTS;
DROP TABLE project
IF EXISTS;


CREATE TABLE address
(
  id        INTEGER IDENTITY PRIMARY KEY,
  country   VARCHAR(255) NOT NULL,
  street    VARCHAR(255) NOT NULL,
  post_code VARCHAR(255) NOT NULL
);

CREATE TABLE employee
(
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  last_name  VARCHAR(255) NOT NULL,
  birthday   TIMESTAMP    NOT NULL,
  address_id INTEGER      NOT NULL,
  FOREIGN KEY (address_id) REFERENCES address (id)
    ON DELETE CASCADE
);



CREATE TABLE project
(
  id    INTEGER IDENTITY PRIMARY KEY,
  title VARCHAR(255) NOT NULL
);


CREATE TABLE empl_proj
(
  employee_id INTEGER NOT NULL,
  project_id  INTEGER NOT NULL,
  CONSTRAINT empl_proj_emplid_projid_idx UNIQUE (employee_id, project_id),
  FOREIGN KEY (employee_id) REFERENCES employee (id)
    ON DELETE CASCADE,
  FOREIGN KEY (project_id) REFERENCES project (id)
    ON DELETE CASCADE
);


