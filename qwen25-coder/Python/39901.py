from bs4 import BeautifulSoup\n\nhtml_content = '''\n<table>\n   <tr>\n     <td class="blabla"> <table><tr><td><table><tr><td></td></tr></table></td></tr></table>\n     </td>\n   </tr>\n  <tr>\n     <td class="blabla"> <table><tr><td></td></tr></table>\n     </td>\n   </tr>\n</table>\n'''\n\nsoup = BeautifulSoup(html_content, 'html.parser')\ntds = soup.find_all('td', class_='blabla')\n\nfor td in tds:\n    print(td)