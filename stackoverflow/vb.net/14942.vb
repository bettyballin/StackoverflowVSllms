' get the response stream so we can read it\nDim responseStream = response.GetResponseStream()\n' create a stream reader to read the response\nDim responseReader = New IO.StreamReader(responseStream)\n' read the response text (this should be javascript)\nDim responseText = responseReader.ReadToEnd()\n\n' load the response into an XDocument\nDim xmlDocument = XDocument.Parse(responseText)\n\n' find all the player objects from the document\nFor Each playerObject In xmlDocument...<object>\n\n    ' display the player's name (this is how you access an attribute)\n    Console.WriteLine("Player name: {0}", playerObject.@name)\n    ' display the player's status (this is how you access an element)\n    Console.WriteLine("Player status: {0}", playerObject.<status>.Value)\n\nNext