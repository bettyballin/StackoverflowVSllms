#include <linux/init.h>
#include <linux/module.h> /*Needed by all modules*/
#include <linux/kernel.h> /*needed for pr_info(),... */
#include <linux/fs.h>      //for file operations etc
#include <linux/cdev.h>    //for char device stuffs
#include <linux/device.h>  //for class & devices creation, etc..
#include <linux/uaccess.h> // for copy_from_user

#define SIZE_OF_BUFFER 256 //buffer size

/*Declare the cdev variable*/
static struct cdev my_cdev; /*cdef global variable which will hold cdev */
struct kobject *devicekobj;
uint8_t kernelBuffer[SIZE_OF_BUFFER];

/*File operations structure*/
static struct file_operations fops = {
    .write = my_write,
};

/*Write method that will be called when we write to /dev/my_device from userspace*/
ssize_t my_write(struct file *filp, const char __user *buff, size_t len, loff_t *off)
{
    /*This 'len' is the number of characters actually written*/

    if ((*kernelBuffer + 10) >= SIZE_OF_BUFFER) { //check buffer overflow
        pr_info("ERROR:kernelspace Buffer Overflow! data not read\n");
        return -ENOMEM; /*-ENOMEM means error while allocating memory*/
    } else {
        if (copy_from_user(kernelBuffer, buff, len)) {
            pr_info("Error in copying from user buffer to kernel space\n"); //error while copying data form userspace to kernelspace.
            return -EFAULT; /*-EFAULT means error due to invalid access to storage*/
        }
    }
    //(*(buff + *off) = kernelBuffer); /*copying the content read to user's buffer which will be saved in a file  */
    pr_info("My device Write method called\n");
    return len; //successfull operation
}

int mychardev_init(void)
{
    dev_t mydevno = MKDEV(140, 0); /*Create the dev no. /dev/my_device*/

    if (register_chrdev_region(&mydevno, 1, "mycdev")) {
        pr_info("Cannot register the region, error\n"); //printing message to check error code returned.
        return -EBUSY;  /* EBUSY means resource is busy */
    }

    cdev_init(&my_cdev, &fops);   /*Initializing and adding a char driver*/
    if (cdev_add(&my_cdev, mydevno, 1) < 0) {
        pr_info("cdev is not added\n");
        return -1;
    }

    // creating device class for /dev/mycdev
    struct class *class_devcls = class_create(THIS_MODULE, "myClass");
    if (IS_ERR(class_devcls)) {
        pr_info("Failed to create the class.\n"); //printing message to check error code returned.
        return PTR_ERR(class_devcls);
    }

    /*creating /dev/my_device */
    device_create(class_devcls, NULL, mydevno, NULL, "mycdev");
    pr_info("/dev/myCde registered and created successfully\n"); /*return success*/
    return 0;
}

/*Module Exit function to destroy char dev*/
void mychar_exit(void)
{
    cdev_del(&my_cdev);
    unregister_chrdev_region(my_cdev.dev, 1);   /*Unregister the registered device number region */
    struct class *class_devcls = class_find("myClass");
    class_destroy(class_devcls);    /*Deletes and destroys a class (with all its devices).  */
}

module_init(mychardev_init);
module_exit(mychar_exit);

MODULE_LICENSE("GPL");
MODULE_AUTHOR("Your Name");
MODULE_DESCRIPTION("A character device driver");
MODULE_VERSION("1.0");