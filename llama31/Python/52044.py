from bs4 import BeautifulSoup\nimport sqlite3\n\nurl = 'http://www.eia.doe.gov/emeu/aer/txt/ptb0808.html'\nsoup = BeautifulSoup(url, 'html.parser')\ntable = soup.find('table')\n\n# create an in-memory database\nconn = sqlite3.connect(':memory:')\ncursor = conn.cursor()\n\n# create a table from the parsed HTML table\ncursor.execute('CREATE TABLE data (' + ','.join([f'{th.text} TEXT' for th in table.find('tr').find_all('th')]) + ')')\nfor row in table.find_all('tr')[1:]:\n    cursor.execute('INSERT INTO data VALUES (' + ','.join([f'"{td.text}"' for td in row.find_all('td')]) + ')')\n\n# now you can perform SQL queries on the table\ncursor.execute('SELECT * FROM data WHERE `Column Name` > 10')\nresult = cursor.fetchall()\nprint(result)