function SendMail(mailFrom, mailTo, mailSubject, mailBody, bHtml)\n    Const cdoSendUsingMethod        = "http://schemas.microsoft.com/cdo/configuration/sendusing"\n    Const cdoSendUsingPort          = 2\n    Const cdoSMTPServer             = "http://schemas.microsoft.com/cdo/configuration/smtpserver"\n    Const cdoSMTPServerPort         = "http://schemas.microsoft.com/cdo/configuration/smtpserverport"\n    Const cdoSMTPConnectionTimeout  = "http://schemas.microsoft.com/cdo/configuration/smtpconnectiontimeout"\n    Const cdoSMTPAuthenticate       = "http://schemas.microsoft.com/cdo/configuration/smtpauthenticate"\n    Const cdoBasic                  = 1\n    Const cdoSendUserName           = "http://schemas.microsoft.com/cdo/configuration/sendusername"\n    Const cdoSendPassword           = "http://schemas.microsoft.com/cdo/configuration/sendpassword"\n    Const cdoSMTPUseSSL            = "http://schemas.microsoft.com/cdo/configuration/smtpusessl"\n    Const smtpServer = "localhost"\n\n    Dim objConfig  ' As CDO.Configuration\n    Dim objMessage ' As CDO.Message\n    Dim Fields     ' As ADODB.Fields\n\n    ' Get a handle on the config object and it's fields\n    Set objConfig = Server.CreateObject("CDO.Configuration")\n    Set Fields = objConfig.Fields\n\n    ' Set config fields we care about\n    With Fields\n        .Item(cdoSendUsingMethod)       = cdoSendUsingPort\n        .Item(cdoSMTPServer)            = smtpServer\n        .Item(cdoSMTPServerPort)        = 465 ' Use port 465 for secure connections\n        .Item(cdoSMTPConnectionTimeout) = 10\n        .Item(cdoSMTPAuthenticate)      = cdoBasic\n        .Item(cdoSendUserName)          = "username"\n        .Item(cdoSendPassword)          = "password"\n        .Item(cdoSMTPUseSSL)            = True ' Enable SSL\n        .Update\n    End With\n\n    Set objMessage = Server.CreateObject("CDO.Message")\n\n    Set objMessage.Configuration = objConfig\n\n    With objMessage\n        .To       = mailTo\n        .From     = mailFrom\n        .Subject  = mailSubject\n        If bHtml Then\n            .HtmlBody = mailBody\n        Else\n            .TextBody = mailBody\n        End If\n        .Send\n    End With\n\n    Set Fields = Nothing\n    Set objMessage = Nothing\n    Set objConfig = Nothing\nend functio