from faker import Faker\n\nfake = Faker()\ncompanies = []\n\nfor _ in range(1000):\n    company_info = {\n        'name': fake.company(),\n        'address': fake.address().replace('\n', ', '),\n        'phone_number': fake.phone_number()\n    }\n    companies.append(company_info)\n\n# Print the first 10 to verify\nfor cmpny in companies[:10]:\n    print(cmpny)