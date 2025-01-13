import pyodbc\n    from faker import Faker\n\n    # Establish a connection to SQL Server\n    conn = pyodbc.connect('DRIVER={SQL Server};SERVER=your_server;DATABASE=your_db;UID=your_user;PWD=your_password')\n    cursor = conn.cursor()\n\n    fake = Faker()\n    for _ in range(1000000):\n        name = fake.name()\n        age = fake.random_int(min=0, max=99)\n        created_date = fake.date_between(start_date='-10y', end_date='today')\n        cursor.execute("INSERT INTO TestData (Name, Age, CreatedDate) VALUES (?, ?, ?)", name, age, created_date)\n\n    conn.commit()\n    cursor.close()\n    conn.close()