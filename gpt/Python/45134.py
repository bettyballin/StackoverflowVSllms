from telesign.messaging import MessagingClient\n\n     customer_id = "your_customer_id"\n     api_key = "your_api_key"\n     phone_number = "destination_phone_number"\n     message = "Your code is 123456"\n     message_type = "ARN"\n\n     messaging = MessagingClient(customer_id, api_key)\n     response = messaging.message(phone_number, message, message_type)\n\n     print(response.json)