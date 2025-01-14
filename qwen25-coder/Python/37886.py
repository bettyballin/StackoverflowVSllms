from bs4 import BeautifulSoup\nfrom django import forms\n\ndef create_form_instance_from_html(html, form_class, form_name=None):\n    soup = BeautifulSoup(html, 'html.parser')\n    \n    # Find all forms in the HTML or select by name\n    if form_name:\n        form_tag = soup.find('form', {'name': form_name})\n    else:\n        form_tag = soup.find('form')\n    \n    if not form_tag:\n        raise ValueError("Form not found in HTML.")\n    \n    # Extract input fields\n    inputs = form_tag.find_all(['input', 'textarea', 'select'])\n    data = {}\n    \n    for input_tag in inputs:\n        name = input_tag.get('name')\n        tag_type = input_tag.name\n        \n        if not name:\n            continue  # Skip this input as it doesn't have a name attribute\n        \n        # Handle different types of inputs\n        if tag_type == 'input':\n            type_ = input_tag.get('type', '').lower()\n            value = input_tag.get('value')\n            \n            if type_ in ['checkbox', 'radio']:\n                checked = input_tag.has_attr('checked')\n                value = checked  # For checkboxes and radios, use boolean to represent check state\n            else:\n                value = input_tag['value'] if value is not None else ''\n        elif tag_type == 'textarea':\n            value = input_tag.string or ''\n        elif tag_type == 'select':\n            options = input_tag.find_all('option')\n            selected_option = next((opt for opt in options if opt.has_attr('selected')), None)\n            value = selected_option['value'] if selected_option else ''\n        \n        data[name] = value\n    \n    # Create a form instance with the extracted data\n    form_instance = form_class(data=data)\n    \n    return form_instance\n\n# Example usage\n# Assuming you have a Django form class `TestForm` and HTML string `html_string`\n# form_instance = create_form_instance_from_html(html_string, TestForm, form_name='test_form')