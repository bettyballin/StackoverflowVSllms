import mechanize\n\n# assume browser is your mechanize.Browser object\nbrowser = mechanize.Browser()\nbrowser.open("http://example.com/your_form")\n\n# get the form\nbrowser.select_form(name="your_form_name")\n\n# create a new control\nbrowser.form.new_control('select', 'field1', {'value': ['E']})\n\n# submit the form\nbrowser.submit()