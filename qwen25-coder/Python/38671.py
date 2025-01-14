from bs4 import BeautifulSoup\n\ndef clean_html(input_html):\n    soup = BeautifulSoup(input_html, 'html.parser')\n    \n    # Remove unwanted styles and classes\n    for tag in soup.find_all(True):  # True matches all tags\n        if 'style' in tag.attrs:\n            del tag['style']\n        if 'class' in tag.attrs:\n            del tag['class']\n\n    return str(soup)\n\n# Example usage\ndirty_html = '''<tr style="mso-yfti-irow:0;mso-yfti-firstrow:yes">\n                <td style="border:solid windowtext 1.0pt;mso-border-alt:solid windowtext .5pt;\n   padding:0cm 5.4pt 0cm 5.4pt" valign="top">\n                    <p align="left" class="MsoNormal" \n                        style="text-align:left;tab-stops:center 216.0pt right 432.0pt">\n                        <b style="mso-bidi-font-weight:normal"><span lang="EN-US">ID<o:p></o:p></span></b></p>\n                </td>\n                <td style="border:solid windowtext 1.0pt;border-left:none;\n   mso-border-left-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;\n   padding:0cm 5.4pt 0cm 5.4pt" valign="top">\n                </td>\n             </tr>'''\n\ncleaned_html = clean_html(dirty_html)\nprint(cleaned_html)