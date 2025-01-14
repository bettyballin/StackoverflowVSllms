Public Class Form1\n\n    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load\n        ' Create WebBrowser instance at runtime\n        Dim dynamicWebBrowser As New WebBrowser()\n\n        ' Set properties for the WebBrowser control if necessary\n        dynamicWebBrowser.Dock = DockStyle.Fill\n\n        ' Add the WebBrowser to your form's controls\n        Me.Controls.Add(dynamicWebBrowser)\n\n        ' Subscribe to the Navigated event\n        AddHandler dynamicWebBrowser.Navigated, AddressOf DynamicWebBrowser_Navigated\n\n        ' Optionally navigate to a URL or perform other actions\n        dynamicWebBrowser.Navigate("http://www.example.com")\n    End Sub\n\n    ' Event handler for the WebBrowser's Navigated event\n    Private Sub DynamicWebBrowser_Navigated(sender As Object, e As WebBrowserNavigatedEventArgs)\n        MessageBox.Show($"Navigated to: {e.Url}")\n    End Sub\n\nEnd Class