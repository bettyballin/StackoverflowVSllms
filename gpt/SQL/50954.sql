ALTER TABLE schedules ADD CONSTRAINT fk_assignment FOREIGN KEY (assignment_id) REFERENCES assignments(id) ON DELETE RESTRICT;\nALTER TABLE schedules ADD CONSTRAINT fk_employee FOREIGN KEY (employee_id) REFERENCES employees(id) ON DELETE RESTRICT;\nALTER TABLE blocks ADD CONSTRAINT fk_assignment FOREIGN KEY (assignment_id) REFERENCES assignments(id) ON DELETE RESTRICT;