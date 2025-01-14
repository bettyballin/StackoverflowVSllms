#include <CL/cl.h>

int main() {
    // Assume these variables are already defined
    cl_context context;
    cl_device_id device;
    cl_program program;
    cl_mem buffer1, buffer2;
    cl_int err;

    // Create multiple command queues
    cl_command_queue queue1 = clCreateCommandQueue(context, device, 0, &err);
    cl_command_queue queue2 = clCreateCommandQueue(context, device, 0, &err);

    // Create and build kernels
    cl_kernel kernel1 = clCreateKernel(program, "kernel_function1", &err);
    cl_kernel kernel2 = clCreateKernel(program, "kernel_function2", &err);

    // Set kernel arguments
    clSetKernelArg(kernel1, 0, sizeof(cl_mem), &buffer1);
    clSetKernelArg(kernel2, 0, sizeof(cl_mem), &buffer2);

    // Enqueue the kernels in their respective command queues
    size_t global_work_size = 1024;
    clEnqueueNDRangeKernel(queue1, kernel1, 1, NULL, &global_work_size, NULL, 0, NULL, NULL);
    clEnqueueNDRangeKernel(queue2, kernel2, 1, NULL, &global_work_size, NULL, 0, NULL, NULL);

    // Wait for the commands to complete
    clFinish(queue1);
    clFinish(queue2);

    // Clean up
    clReleaseKernel(kernel1);
    clReleaseKernel(kernel2);
    clReleaseCommandQueue(queue1);
    clReleaseCommandQueue(queue2);

    return 0;
}