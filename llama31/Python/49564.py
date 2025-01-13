import requests\nfrom bs4 import BeautifulSoup\n\nstop_number = "9510"\nurl = f"https://www.calgarytransit.com/schedules/next-bus?stop={stop_number}"\n\nresponse = requests.get(url)\nsoup = BeautifulSoup(response.content, "html.parser")\n\n# Find the HTML elements containing the bus stop times and routes\ntimes = soup.find_all("span", class_="time")\nroutes = soup.find_all("span", class_="route")\n\n# Extract the text from the HTML elements\ntimes_text = [time.text.strip() for time in times]\nroutes_text = [route.text.strip() for route in routes]\n\n# Print the extracted data\nfor time, route in zip(times_text, routes_text):\n    print(f"{time} - {route}")