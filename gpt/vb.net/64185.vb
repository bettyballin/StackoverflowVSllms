Private badcolor As Color = Color.FromArgb(0, 0, 0, 0)\n\nPublic Function grayscalePixel(ByVal basecolor As Color) As Color\n    Return grayscalePixel(basecolor, 0.3, 0.59, 0.11)\nEnd Function\n\nPublic Function grayscalePixel(ByVal basecolor As Color, ByVal RedMix As Double, ByVal GreenMix As Double, ByVal BlueMix As Double) As Color\n    If basecolor.A = 0 Then\n        Return badcolor\n    End If\n    If (RedMix + GreenMix + BlueMix > 1) Or (RedMix + GreenMix + BlueMix <= 0) Then\n        Return grayscalePixel(basecolor)\n    End If\n\n    Dim grayval As Integer = basecolor.R * RedMix + basecolor.G * GreenMix + basecolor.B * BlueMix\n    Return Color.FromArgb(basecolor.A, grayval, grayval, grayval)\nEnd Function\n\nPublic Function colorizePixel(ByVal basecolor As Color, ByVal colorize As Color) As Color\n    If basecolor.A = 0 Then\n        Return badcolor\n    End If\n    \n    Dim grayval As Color = grayscalePixel(basecolor)\n    \n    Dim r As Integer = (grayval.R * (255 - colorize.A) + colorize.R * colorize.A) \ 255\n    Dim g As Integer = (grayval.G * (255 - colorize.A) + colorize.G * colorize.A) \ 255\n    Dim b As Integer = (grayval.B * (255 - colorize.A) + colorize.B * colorize.A) \ 255\n    \n    Return Color.FromArgb(basecolor.A, r, g, b)\nEnd Functio