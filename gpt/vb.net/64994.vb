Imports System.Web\n\n' Your XML string\nDim xmlString As String = "<systemCode>APP</systemCode>"\n\n' Manually HTML encode the XML string\nDim encodedXmlString As String = HttpUtility.HtmlEncode(xmlString)\n\n' Decode the string before assigning to the hidden field to prevent double-encoding\nDim decodedXmlString As String = HttpUtility.HtmlDecode(encodedXmlString)\n\n' Set the value to the hidden field\nhiddenField.Value = decodedXmlString