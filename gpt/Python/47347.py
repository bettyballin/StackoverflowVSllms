from faker import Faker\nimport csv\n\nfake = Faker()\n\nwith open('sample_data.csv', mode='w', newline='') as file:\n    writer = csv.writer(file)\n    writer.writerow(['Name', 'Address', 'Email']) # Write headers\n    \n    for _ in range(150000):\n        writer.writerow([fake.name(), fake.address(), fake.email()])