#include <linux/fs.h>

long unlocked_device_ioctl(struct file *file, unsigned int cmd, unsigned long arg) {
    // implementation of unlocked_device_ioctl function
}

struct file_operations fops = {
    .unlocked_ioctl = unlocked_device_ioctl;
};