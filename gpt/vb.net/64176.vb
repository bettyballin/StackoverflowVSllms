Imports TweetSharp\n\nPublic Class TwitterHelper\n    Private Const ConsumerKey As String = "YOUR_CONSUMER_KEY"\n    Private Const ConsumerSecret As String = "YOUR_CONSUMER_SECRET"\n    Private Const AccessToken As String = "YOUR_ACCESS_TOKEN"\n    Private Const AccessTokenSecret As String = "YOUR_ACCESS_TOKEN_SECRET"\n\n    Public Sub PostTweet(ByVal message As String)\n        Dim service As New TwitterService(ConsumerKey, ConsumerSecret)\n        service.AuthenticateWith(AccessToken, AccessTokenSecret)\n\n        Dim tweet = service.SendTweet(New SendTweetOptions With {\n            .Status = message\n        })\n\n        If tweet IsNot Nothing Then\n            Console.WriteLine("Tweet posted successfully: " & tweet.Text)\n        Else\n            Console.WriteLine("Failed to post tweet.")\n        End If\n    End Sub\nEnd Class