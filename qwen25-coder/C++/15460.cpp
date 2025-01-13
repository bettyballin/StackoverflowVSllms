#include <opencv2/opencv.hpp>\n\nint main() {\n    cv::Mat image = cv::imread("input.jpg");\n    if (image.empty()) {\n        std::cout << "Could not open or find the image!" << std::endl;\n        return -1;\n    }\n\n    // Set the compression factor, range 0-100\n    int quality = 50; // Example quality setting\n    std::vector<int> compression_params;\n    compression_params.push_back(cv::IMWRITE_JPEG_QUALITY);\n    compression_params.push_back(quality);\n\n    bool result = cv::imwrite("output.jpg", image, compression_params);\n    if (!result) {\n        std::cout << "Could not save the image!" << std::endl;\n        return -1;\n    }\n\n    return 0;\n}