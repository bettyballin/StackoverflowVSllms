from psycopg2.extensions import adapt\n\nprint adapt("Hello World'; DROP DATABASE World;")