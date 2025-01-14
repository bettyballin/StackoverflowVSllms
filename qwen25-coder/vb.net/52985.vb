Imports System.Net\nImports System.Text\nImports System.IO\nImports System.Security.Cryptography\n\nPartial Class PostToTwitter\n    Inherits System.Web.UI.Page\n\n    Protected Sub btnPostTweet_Click(sender As Object, e As EventArgs) Handles btnPostTweet.Click\n        Dim consumerKey As String = "YOUR_CONSUMER_KEY"\n        Dim consumerSecret As String = "YOUR_CONSUMER_SECRET"\n        Dim accessToken As String = "YOUR_ACCESS_TOKEN"\n        Dim accessTokenSecret As String = "YOUR_ACCESS_TOKEN_SECRET"\n\n        Dim tweetText As String = txtTweet.Text\n\n        ' Create the signature\n        Dim timestamp As String = GetTimestamp()\n        Dim nonce As String = GenerateNonce()\n        Dim signature As String = CreateSignature("POST", "https://api.twitter.com/1.1/statuses/update.json",\n                                                  consumerKey, consumerSecret, accessToken, accessTokenSecret, tweetText,\n                                                  nonce, timestamp)\n\n        ' HTTP POST request\n        Dim requestUri As String = "https://api.twitter.com/1.1/statuses/update.json?status=" & Uri.EscapeDataString(tweetText)\n        Using webRequest As HttpWebRequest = DirectCast(WebRequest.Create(requestUri), HttpWebRequest)\n            webRequest.Method = "POST"\n            webRequest.ServicePoint.Expect100Continue = False\n            webRequest.Headers.Add("Authorization", GetHeader(consumerKey, accessToken, nonce, timestamp, signature))\n\n            Try\n                Using response As WebResponse = webRequest.GetResponse()\n                    Dim dataStream = response.GetResponseStream()\n                    Dim reader As New StreamReader(dataStream)\n                    Dim responseFromServer As String = reader.ReadToEnd()\n\n                    ' Process the response\n                    lblResult.Text = "Tweet posted successfully!"\n                End Using\n            Catch ex As WebException\n                lblResult.Text = "Error: " & ex.Message\n            End Try\n        End Using\n    End Sub\n\n    Private Function GetTimestamp() As String\n        Return (Date.UtcNow.Subtract(New DateTime(1970, 1, 1))).TotalSeconds.ToString\n    End Function\n\n    Private Function GenerateNonce() As String\n        Dim rand As New Random()\n        Dim nonce As Integer = rand.Next(123400, Int32.MaxValue)\n        Return nonce.ToString\n    End Function\n\n    Private Function CreateSignature(httpMethod As String, requestUriString As String,\n                                    consumerKey As String, consumerSecret As String,\n                                    accessToken As String, accessTokenSecret As String,\n                                    tweetText As String,\n                                    nonce As String, timestamp As String) As String\n        Dim baseFormat As String = "oauth_consumer_key={0}&oauth_nonce={1}" &\n                                             "&oauth_signature_method=HMAC-SHA1&oauth_timestamp={2}" &\n                                             "&oauth_token={3}&oauth_version=1.0"\n        Dim baseString As String = String.Format(baseFormat,\n                                                 Uri.EscapeDataString(consumerKey),\n                                                 Uri.EscapeDataString(nonce),\n                                                 timestamp,\n                                                 Uri.EscapeDataString(accessToken)\n                                               )\n\n        ' Add tweet text to the signature\n        baseString += "&status=" & Uri.EscapeDataString(tweetText)\n\n        ' Convert our URL to Base64 for inclusion in the signature calculation\n        Dim url = Uri.EscapeDataString(requestUriString)\n\n        ' Combine our two sets of strings into one string\n        Dim combinedBaseString As String = $"{httpMethod}&{url}&{Uri.EscapeDataString(baseString)}"\n\n        ' Create a hash from the base string using your consumer secret and access token secret as the key\n        Dim encoding As New System.Text.ASCIIEncoding()\n        Dim signingKeyString As String = $"{Uri.EscapeDataString(consumerSecret)}&{Uri.EscapeDataString(accessTokenSecret)}"\n        Dim messageBytes As Byte() = encoding.GetBytes(combinedBaseString)\n        Dim signingKeyBytes As Byte() = encoding.GetBytes(signingKeyString)\n\n        Dim crypto As New HMACSHA1()\n        crypto.Key = signingKeyBytes\n\n        Dim hashBytes As Byte() = crypto.ComputeHash(messageBytes)\n\n        ' Convert the hash bytes to a Base64 string\n        Return Convert.ToBase64String(hashBytes)\n    End Function\n\n    Private Function GetHeader(consumerKey As String, accessToken As String,\n                               nonce As String, timestamp As String, signature As String) As String\n        Dim headerFormat As String = "OAuth oauth_consumer_key=\"{0}\", oauth_token=\"{1}\", " &\n                                               "oauth_signature_method=\"HMAC-SHA1\", oauth_timestamp=\"{2}\", " &\n                                               "oauth_nonce=\"{3}\", oauth_version=\"1.0\", oauth_signature=\"{4}\""\n        Dim authHeader As String = String.Format(headerFormat,\n                                                 Uri.EscapeDataString(consumerKey),\n                                                 Uri.EscapeDataString(accessToken),\n                                                 timestamp,\n                                                 nonce,\n                                                 Uri.EscapeDataString(signature)\n                                               )\n\n        Return authHeader\n    End Function\nEnd Class