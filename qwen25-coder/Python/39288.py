import bleach\n\ndef clean_html(input_string, allowed_tags):\n    # Clean the input string by allowing only specified tags\n    return bleach.clean(input_string, tags=allowed_tags)\n\n# Example usage\ninput_string = "<p>I have a <script>alert('XSS')</script>string with <b>safe</b> and <u>unsafe</u> tags.</p>"\nallowed_tags = ['b', 'p', 'u']\ncleaned_string = clean_html(input_string, allowed_tags)\nprint(cleaned_string)  # Output: "<p>I have a string with <b>safe</b> and <u>unsafe</u> tags.</p>"