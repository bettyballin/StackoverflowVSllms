from requests_html import HTMLSession\n\nsession = HTMLSession()\nresponse = session.get("https://example.com")\nhtml = response.html.render()