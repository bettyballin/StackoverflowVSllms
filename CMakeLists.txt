cmake_minimum_required(VERSION 3.10)

# Set the project name
project(StackoverflowProject)

# Set the C++ standard
set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED True)
set(CMAKE_EXPORT_COMPILE_COMMANDS ON)

# Specify the source files directory
set(SOURCE_DIR cpp_code_files_stackoverflow)

# Find all .cpp files in the source directory
file(GLOB SOURCES "${SOURCE_DIR}/*.cpp")

# Create the executable
add_executable(StackoverflowExecutable ${SOURCES})