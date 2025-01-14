from selenium import webdriver\n   from selenium.webdriver.common.by import By\n\n   driver = webdriver.Chrome()\n   driver.get('https://example.com/search?q=book')\n\n   books = []\n   book_elements = driver.find_elements(By.CLASS_NAME, 'book-item')\n   for book in book_elements:\n       title = book.find_element(By.CLASS_NAME, 'title').text\n       author = book.find_element(By.CLASS_NAME, 'author').text\n       books.append({'title': title, 'author': author})\n\n   driver.quit()\n   print(books)