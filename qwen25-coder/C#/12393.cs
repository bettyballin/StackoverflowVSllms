[DataContract]\npublic class ImageClass\n{\n    [DataMember]\n    public byte[] ImageData { get; set; }\n\n    // Method to convert Bitmap to byte array\n    public static byte[] ConvertBitmapToByteArray(Bitmap bmp)\n    {\n        using (var ms = new MemoryStream())\n        {\n            bmp.Save(ms, System.Drawing.Imaging.ImageFormat.Png);\n            return ms.ToArray();\n        }\n    }\n\n    // Method to convert byte array back to Bitmap\n    public static Bitmap ConvertByteArrayToBitmap(byte[] byteArray)\n    {\n        using (var ms = new MemoryStream(byteArray))\n        {\n            return new Bitmap(ms);\n        }\n    }\n}