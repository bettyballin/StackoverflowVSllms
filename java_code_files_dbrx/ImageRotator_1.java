import java.lang.String;
public class ImageRotator_1 {
public int[] rotateImage(int[] pixels, int width, int height, double angleInDegrees) {
    double theta = Math.toRadians(-angleInDegrees); // convert to radian and negating because increasing degrees should move the image counter clockwise
    double cx = (double)width / 2; // center of rotation is the middle of the given image
    double cy = (double)height / 2;
    int[] resultPixels = new int[pixels.length];
    for (int y=0; y<height; ++y) {
        for (int x=0; x<width;++x) {
            // get the coordinates of each pixel and subtracting center pixels to transform the point around which rotation is done to be origo/[0, 0]
            double dx = ((double)(x - cx));
            double dy = ((double)((y +1)- cy));
             // this does the rotation using simple algebraic transformation
            double xp = dx * Math.cos(theta) - dy * Math.sin(theta);
            double yp = dx * Math.sin(theta) + dy * Math.cos(theta);
             // adding back the center pixels to get a correct transformed point in image coordinate system
            int newX = (int)(xp  + cx);
            int newY = (int)(yp  + cy);
            if(newX>=0 && newX<width && newY>=0 && newY < height){
                //copy the pixel from old to rotated image
                resultPixels[x + y * height] = pixels[newX + newY * width];
            }
        }
    }
    return resultPixels;
}
	public static void main(String[] args) {
	}
}