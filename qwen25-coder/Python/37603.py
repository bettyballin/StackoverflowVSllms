import requests\nfrom bs4 import BeautifulSoup\n\n# Step 1: Fetch the dynamic PHP page\nresponse = requests.get("http://www.biglickmedia.com/art/random/index.php")\nresponse.raise_for_status()\n\n# Step 2: Parse the HTML content and find the image source URL\nsoup = BeautifulSoup(response.content, 'html.parser')\nimg_tag = soup.find('img')\n\nif img_tag and 'src' in img_tag.attrs:\n    img_url = img_tag['src']\n    \n    # If the URL is relative, convert it to an absolute URL\n    if not img_url.startswith(('http:', 'https:')):\n        img_url = requests.compat.urljoin(response.url, img_url)\n    \n    # Step 3: Download the image\n    img_response = requests.get(img_url)\n    img_response.raise_for_status()\n    \n    # Save the image to a file\n    with open('downloaded_image.jpg', 'wb') as f:\n        f.write(img_response.content)\n    \n    print("Image downloaded successfully.")\nelse:\n    print("No image found on the page or could not obtain the image source URL.")