convert input.jpg -virtual-pixel transparent -matte \\n-gravity center -draw "circle 256,256 256,0" -compose DstIn -composite output.png