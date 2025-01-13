CREATE TABLE UserFacilityRoles (\n       user_id INT,\n       facility_id INT,\n       role_id INT,\n       PRIMARY KEY (user_id, facility_id, role_id),\n       FOREIGN KEY (user_id) REFERENCES Users(user_id),\n       FOREIGN KEY (facility_id) REFERENCES Facilities(facility_id),\n       FOREIGN KEY (role_id) REFERENCES Roles(role_id)\n   );