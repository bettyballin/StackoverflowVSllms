# Example of letting users choose a verification method\ndef send_verification(user):\n    if user.preferred_method == 'SMS':\n        send_sms(user.phone_number)\n    elif user.preferred_method == 'Email':\n        send_email(user.email)\n\ndef send_sms(phone_number):\n    # SMS sending logic here\n\ndef send_email(email_address):\n    # Email sending logic here