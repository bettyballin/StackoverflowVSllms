CREATE TABLE states (\n    id SERIAL PRIMARY KEY,\n    name VARCHAR(50) NOT NULL,\n    abbrev CHAR(2) NOT NULL\n);\n\nINSERT INTO states (name, abbrev)\nVALUES\n    ('Alabama', 'AL'),\n    ('Alaska', 'AK'),\n    ('Arizona', 'AZ'),\n    ('Arkansas', 'AR'),\n    ('California', 'CA'),\n    ('Colorado', 'CO'),\n    ('Connecticut', 'CT'),\n    ('Delaware', 'DE'),\n    ('Florida', 'FL'),\n    ('Georgia', 'GA'),\n    ('Hawaii', 'HI'),\n    ('Idaho', 'ID'),\n    ('Illinois', 'IL'),\n    ('Indiana', 'IN'),\n    ('Iowa', 'IA'),\n    ('Kansas', 'KS'),\n    ('Kentucky', 'KY'),\n    ('Louisiana', 'LA'),\n    ('Maine', 'ME'),\n    ('Maryland', 'MD'),\n    ('Massachusetts', 'MA'),\n    ('Michigan', 'MI'),\n    ('Minnesota', 'MN'),\n    ('Mississippi', 'MS'),\n    ('Missouri', 'MO'),\n    ('Montana', 'MT'),\n    ('Nebraska', 'NE'),\n    ('Nevada', 'NV'),\n    ('New Hampshire', 'NH'),\n    ('New Jersey', 'NJ'),\n    ('New Mexico', 'NM'),\n    ('New York', 'NY'),\n    ('North Carolina', 'NC'),\n    ('North Dakota', 'ND'),\n    ('Ohio', 'OH'),\n    ('Oklahoma', 'OK'),\n    ('Oregon', 'OR'),\n    ('Pennsylvania', 'PA'),\n    ('Rhode Island', 'RI'),\n    ('South Carolina', 'SC'),\n    ('South Dakota', 'SD'),\n    ('Tennessee', 'TN'),\n    ('Texas', 'TX'),\n    ('Utah', 'UT'),\n    ('Vermont', 'VT'),\n    ('Virginia', 'VA'),\n    ('Washington', 'WA'),\n    ('West Virginia', 'WV'),\n    ('Wisconsin', 'WI'),\n    ('Wyoming', 'WY');