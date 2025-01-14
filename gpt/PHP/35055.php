// Define the RGB components\n$red = 255;   // Red component\n$green = 0;   // Green component\n$blue = 0;    // Blue component\n\n// Combine the components into an OLE_COLOR value\n$oleColor = ($red) | ($green << 8) | ($blue << 16);\n\n// Assuming $this->oBuilder is your COM object\n$this->oBuilder->Font->Color = $oleColor;