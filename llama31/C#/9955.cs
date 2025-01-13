using Twilio;\nusing Twilio.Rest.Fax.V1;\n\n// Initialize the Twilio client\nvar accountSid = "your_account_sid";\nvar authToken = "your_auth_token";\nvar client = new TwilioRestClient(accountSid, authToken);\n\n// Create a new fax instance\nvar fax = new FaxResource(\n    from: new Twilio.Types.PhoneNumber("your_twilio_phone_number"),\n    to: new Twilio.Types.PhoneNumber("remote_fax_number"),\n    mediaUrl: new Uri("https://example.com/fax.pdf")\n);\n\n// Send the fax\nvar faxSid = FaxResource.Create(fax).Sid;