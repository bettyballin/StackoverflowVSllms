#include <opencv2/opencv.hpp>

int cvSaveImage(const char* filename, const CvArr* image) {
    // Note: CvArr is a deprecated type in OpenCV 3.x and later.
    // You should use cv::Mat instead.
    cv::Mat mat = cv::cvarrToMat(image);
    return cv::imwrite(filename, mat) ? 0 : -1;
}

int main() {
    // Example usage:
    cv::Mat image = cv::Mat::zeros(100, 100, CV_8UC3);
    cvSaveImage("example.png", &image);
    return 0;
}