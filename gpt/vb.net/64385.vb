Dim rtfInput As String = "{\rtf1\ansi\deff0{\fonttbl{\f0\fnil\fcharset0 Courier New;}}{\colortbl ;\red255\green255\blue140;}\viewkind4\uc1\pard\highlight1\lang3084\f0\fs18 The company is a global leader in responsible tourism and was \ul the first major hotel chain in North America\ulnone  to embrace environmental stewardship within its daily operations\highlight0\par}"\nDim cleaner As New RtfCleaner()\nDim cleanedRtf As String = cleaner.CleanRtf(rtfInput)\n\nConsole.WriteLine(cleanedRtf)