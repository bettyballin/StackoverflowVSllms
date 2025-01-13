using System;\nusing AForge.Video;\nusing AForge.Video.DirectShow;\nusing System.Drawing;\nusing System.Windows.Forms;\n\npublic class WebcamCapture\n{\n    private FilterInfoCollection videoDevices;\n    private VideoCaptureDevice videoSource;\n\n    public void StartCapturing()\n    {\n        videoDevices = new FilterInfoCollection(FilterCategory.VideoInputDevice);\n        if (videoDevices.Count == 0)\n        {\n            throw new ApplicationException("No video devices found");\n        }\n\n        videoSource = new VideoCaptureDevice(videoDevices[0].MonikerString);\n        videoSource.NewFrame += new NewFrameEventHandler(video_NewFrame);\n        videoSource.Start();\n    }\n\n    private void video_NewFrame(object sender, NewFrameEventArgs eventArgs)\n    {\n        Bitmap image = (Bitmap)eventArgs.Frame.Clone();\n        // Process captured frame (e.g., display in PictureBox, save to file, etc.)\n        image.Save("captured_image.jpg", System.Drawing.Imaging.ImageFormat.Jpeg);\n        videoSource.SignalToStop();\n    }\n\n    public void StopCapturing()\n    {\n        if (videoSource != null && videoSource.IsRunning)\n        {\n            videoSource.SignalToStop();\n            videoSource.WaitForStop();\n        }\n    }\n\n    [STAThread]\n    static void Main()\n    {\n        WebcamCapture webcamCapture = new WebcamCapture();\n        webcamCapture.StartCapturing();\n        Application.Run();\n    }\n}