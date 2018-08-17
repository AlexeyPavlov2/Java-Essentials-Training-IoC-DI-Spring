DELETE FROM address;
DELETE FROM project;
DELETE FROM empl_proj;
DELETE FROM employee;

INSERT INTO address (country, street, post_code) VALUES
  ('USA', 'St. Avenue 21, NY', '15623'),
  ('Russia', 'Red Square, 1, Moscow', '1000000');


INSERT INTO employee (first_name, last_name, birthday, address_id) VALUES
  ('Adam', 'Smith', '2003-05-27 13:00:00', 1),
  ('Eva', 'Brown', '2010-06-30 13:00:00', 0);


INSERT INTO project (title) VALUES
  ('Project # 1'),
  ('Project # 2'),
  ('Project # 3'),
  ('Project # 4');

INSERT INTO empl_proj (employee_id, project_id) VALUES
  (0, 0),
  (0,1),
  (1, 2),
  (0, 2),
  (0, 3),
  (1, 3)
;


