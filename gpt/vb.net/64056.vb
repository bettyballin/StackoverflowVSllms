Imports System.Drawing.Printing\n\nPublic Class Form1\n    Private WithEvents printDoc As New PrintDocument()\n\n    Private Sub ButtonPrint_Click(sender As Object, e As EventArgs) Handles ButtonPrint.Click\n        printDoc.Print()\n    End Sub\n\n    Private Sub printDoc_PrintPage(sender As Object, e As PrintPageEventArgs) Handles printDoc.PrintPage\n        Dim font As New Font("Arial", 12)\n        Dim brush As New SolidBrush(Color.Black)\n        e.Graphics.DrawString("Hello, World!", font, brush, 10, 10)\n    End Sub\nEnd Class