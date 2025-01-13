// CUDA example (nvidia-tesla)\n#include <cuda_runtime.h>\n\nint main() {\n    // Initialize CUDA device\n    cudaDeviceProp deviceProp;\n    cudaGetDeviceProperties(&deviceProp, 0);\n\n    // Allocate memory on device\n    float* d_data;\n    cudaMalloc((void**)&d_data, size * sizeof(float));\n\n    // Launch kernel\n    my_kernel<<<numBlocks, numThreads>>>(d_data);\n\n    // Copy data back to host\n    cudaMemcpy(h_data, d_data, size * sizeof(float), cudaMemcpyDeviceToHost);\n\n    // Clean up\n    cudaFree(d_data);\n    return 0;\n}