Imports System.Drawing.Imaging\n\nPublic Sub InvertImage(ByVal bmp As Bitmap)\n    ' Get a bmp graphics object from our bitmap and lock it using lockbits.\n    Dim rect As Rectangle = New Rectangle(0, 0, bmp.Width, bmp.Height)\n\n    ' Lock the pixels in it into memory.\n    Dim bmpData As System.Drawing.Imaging.BitmapData = _\n        bmp.LockBits(rect, Imaging.ImageLockMode.ReadWrite, bmp.PixelFormat)\n\n    ' Get the address of the first line.\n    Dim ptr As IntPtr = bmpData.Scan0\n\n    ' Declare an array to hold the bytes of the bitmap. \n    Dim values(bmp.Height * Math.Abs(bmpData.Stride) - 1) As Byte\n    ' Copy the RGB values into the array.\n    System.Runtime.InteropServices.Marshal.Copy(ptr, values, 0, _\n        values.Length)\n\n    ' Invert each pixel\n    For i As Integer = 0 To values.Length - 1\n        values(i) = CByte(255 - values(i))\n    Next\n\n    ' Copy the RGB values back to the bitmap.\n    System.Runtime.InteropServices.Marshal.Copy(values, 0, ptr, _\n        values.Length)\n\n    ' Unlock the bits.\n    bmp.UnlockBits(bmpData)\nEnd Sub