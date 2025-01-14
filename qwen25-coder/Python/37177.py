import requests\n\ndef get_book_info(upc):\n    # Replace YOUR_API_KEY with your actual Google Books API key\n    api_key = 'YOUR_API_KEY'\n    url = f'https://www.googleapis.com/books/v1/volumes?q=isbn:{upc}&key={api_key}'\n    \n    response = requests.get(url)\n    data = response.json()\n    \n    if 'items' in data:\n        book_info = data['items'][0]['volumeInfo']\n        title = book_info.get('title', 'N/A')\n        authors = ', '.join(book_info.get('authors', ['N/A']))\n        published_year = book_info.get('publishedDate', 'N/A').split('-')[0]  # Get only the year\n        industry_identifiers = book_info.get('industryIdentifiers', [])\n        \n        lo_c_catalog_number = 'N/A'\n        dewey_decimal = 'N/A'\n        for identifier in industry_identifiers:\n            if identifier['type'] == 'LIBRARY_OF_CONGRESS':\n                lo_c_catalog_number = identifier['identifier']\n            elif identifier['type'] == 'OTHER' and 'DDC' in identifier['identifier']:\n                dewey_decimal = identifier['identifier'].split(' ')[0]\n        \n        return {\n            'title': title,\n            'authors': authors,\n            'published_year': published_year,\n            'lo_c_catalog_number': lo_c_catalog_number,\n            'dewey_decimal': dewey_decimal\n        }\n    else:\n        return None\n\n# Example usage\nbarcode = "9780545010221"  # Replace this with an actual barcode/ISBN number\nbook_data = get_book_info(barcode)\n\nif book_data:\n    print(f"Title: {book_data['title']}")\n    print(f"Authors: {book_data['authors']}")\n    print(f"Published Year: {book_data['published_year']}")\n    print(f"Library of Congress Catalog Number: {book_data['lo_c_catalog_number']}")\n    print(f"Dewey Decimal: {book_data['dewey_decimal']}")\nelse:\n    print("No book found with that barcode.")