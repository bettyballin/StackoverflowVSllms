// Example of ClickOnce deployment\n// Create a ClickOnce deployment manifest\nvar deployment = new Deployment("MyApp");\ndeployment.AddAssembly("MyApp.exe");\ndeployment.Publish("https://mydeploymentlocation.com");