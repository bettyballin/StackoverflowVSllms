Imports System.ComponentModel\n\nPublic Class ImageProcessor\n\n    Private Function createBW() As BackgroundWorker\n        Dim cbs As New BackgroundWorker()\n        AddHandler cbs.DoWork, AddressOf ConvertImage\n        Return cbs\n    End Function\n\n    Public Sub invertImageBK(ByVal image As Bitmap)\n        Dim snxl As BackgroundWorker = createBW()\n        snxl.RunWorkerAsync(New ImageProperties(image.Clone(), "invertImage", Nothing))\n    End Sub\n\n    Public Sub grayscaleImageBK(ByVal image As Bitmap)\n        Dim snxl As BackgroundWorker = createBW()\n        snxl.RunWorkerAsync(New ImageProperties(image.Clone(), "grayscaleImage", Nothing))\n    End Sub\n\n    Public Sub colorizeImageBK(ByVal image As Bitmap, ByVal colorize As Color)\n        Dim snxl As BackgroundWorker = createBW()\n        snxl.RunWorkerAsync(New ImageProperties(image.Clone(), "colorizeImage", colorize))\n    End Sub\n\n    Private Sub ConvertImage(ByVal sender As Object, ByVal e As DoWorkEventArgs)\n        Dim imgProps As ImageProperties = DirectCast(e.Argument, ImageProperties)\n\n        Select Case imgProps.filt\n            Case "invertImage"\n                If imgProps.extra IsNot Nothing Then\n                    Throw New ArgumentException("invertImage does not accept extra parameters.")\n                End If\n                e.Result = invertImage(imgProps.img)\n                Exit Select\n\n            Case "grayscaleImage"\n                If imgProps.extra IsNot Nothing Then\n                    Throw New ArgumentException("grayscaleImage does not accept extra parameters.")\n                End If\n                e.Result = grayscaleImage(imgProps.img)\n                Exit Select\n\n            Case "colorizeImage"\n                If imgProps.extra Is Nothing Then\n                    Throw New ArgumentException("colorizeImage requires a color parameter.")\n                End If\n                Dim color As Color = DirectCast(imgProps.extra, Color)\n                e.Result = colorizeImage(imgProps.img, color)\n                Exit Select\n\n            Case Else\n                Throw New ArgumentOutOfRangeException($"Method {imgProps.filt} not found.")\n        End Select\n    End Sub\n\n    Private Function invertImage(ByVal image As Bitmap) As Bitmap\n        ' Implementation of invertImage goes here.\n        Return Nothing ' Placeholder return value.\n    End Function\n\n    Private Function grayscaleImage(ByVal image As Bitmap) As Bitmap\n        ' Implementation of grayscaleImage goes here.\n        Return Nothing ' Placeholder return value.\n    End Function\n\n    Private Function colorizeImage(ByVal image As Bitmap, ByVal colorize As Color) As Bitmap\n        ' Implementation of colorizeImage goes here.\n        Return Nothing ' Placeholder return value.\n    End Function\n\n    Private Structure ImageProperties\n        Dim img As Bitmap\n        Dim filt As String\n        Public extra As Object\n\n        Public Sub New(ByVal image As Bitmap, ByVal filter As String, ByVal extraParam As Object)\n            img = image.Clone()\n            filt = filter\n            extra = extraParam\n        End Sub\n    End Structure\n\nEnd Class