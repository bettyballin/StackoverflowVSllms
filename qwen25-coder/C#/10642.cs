using System;\nusing Twilio;\nusing Twilio.Rest.Api.V2010.Account;\nusing Twilio.Types;\n\npublic class SmsSender\n{\n    // Find your Account SID and Auth Token at twilio.com/console\n    private const string accountSid = "your_account_sid";\n    private const string authToken = "your_auth_token";\n\n    public void SendScheduledSms(string toNumber, string messageBody)\n    {\n        TwilioClient.Init(accountSid, authToken);\n\n        var message = MessageResource.Create(\n            body: messageBody,\n            from: new PhoneNumber("your_twilio_phone_number"),\n            to: new PhoneNumber(toNumber)\n        );\n\n        Console.WriteLine(message.Sid);\n    }\n}