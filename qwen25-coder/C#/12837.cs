byte[] header = new byte[]{255, 216};\nstring hexString = BitConverter.ToString(header).Replace("-", "");\nConsole.WriteLine(hexString); // Outputs FFD8