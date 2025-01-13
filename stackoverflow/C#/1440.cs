using System.Web.Mail;\nusing System;\npublic class MailSender\n{\n    public static bool SendEmail(\n        string pGmailEmail, \n        string pGmailPassword, \n        string pTo, \n        string pSubject,\n        string pBody, \n        System.Web.Mail.MailFormat pFormat,\n        string pAttachmentPath)\n    {\n    try\n    {\n        System.Web.Mail.MailMessage myMail = new System.Web.Mail.MailMessage();\n        myMail.Fields.Add\n            ("http://schemas.microsoft.com/cdo/configuration/smtpserver",\n                          "smtp.gmail.com");\n        myMail.Fields.Add\n            ("http://schemas.microsoft.com/cdo/configuration/smtpserverport",\n                          "465");\n        myMail.Fields.Add\n            ("http://schemas.microsoft.com/cdo/configuration/sendusing",\n                          "2");\n        //sendusing: cdoSendUsingPort, value 2, for sending the message using \n        //the network.\n\n        //smtpauthenticate: Specifies the mechanism used when authenticating \n        //to an SMTP \n        //service over the network. Possible values are:\n        //- cdoAnonymous, value 0. Do not authenticate.\n        //- cdoBasic, value 1. Use basic clear-text authentication. \n        //When using this option you have to provide the user name and password \n        //through the sendusername and sendpassword fields.\n        //- cdoNTLM, value 2. The current process security context is used to \n        // authenticate with the service.\n        myMail.Fields.Add\n        ("http://schemas.microsoft.com/cdo/configuration/smtpauthenticate","1");\n        //Use 0 for anonymous\n        myMail.Fields.Add\n        ("http://schemas.microsoft.com/cdo/configuration/sendusername",\n            pGmailEmail);\n        myMail.Fields.Add\n        ("http://schemas.microsoft.com/cdo/configuration/sendpassword",\n             pGmailPassword);\n        myMail.Fields.Add\n        ("http://schemas.microsoft.com/cdo/configuration/smtpusessl",\n             "true");\n        myMail.From = pGmailEmail;\n        myMail.To = pTo;\n        myMail.Subject = pSubject;\n        myMail.BodyFormat = pFormat;\n        myMail.Body = pBody;\n        if (pAttachmentPath.Trim() != "")\n        {\n            MailAttachment MyAttachment = \n                    new MailAttachment(pAttachmentPath);\n            myMail.Attachments.Add(MyAttachment);\n            myMail.Priority = System.Web.Mail.MailPriority.High;\n        }\n\n        System.Web.Mail.SmtpMail.SmtpServer = "smtp.gmail.com:465";\n        System.Web.Mail.SmtpMail.Send(myMail);\n        return true;\n    }\n    catch (Exception ex)\n    {\n        throw;\n    }\n}\n}