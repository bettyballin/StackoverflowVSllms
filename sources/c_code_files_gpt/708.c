#include <linux/kernel.h>
#include <linux/module.h>
#include <linux/mm.h>
#include <linux/sched.h>
#include <linux/pid.h>
#include <linux/highmem.h>

// Function to translate physical address to virtual address
unsigned long phys_to_virt(unsigned long phys_addr) {
    return (unsigned long)phys_to_virt((phys_addr_t)phys_addr);
}

// Function to find the owner process of a given physical address
void find_owner_process(unsigned long phys_addr) {
    struct task_struct *task;
    struct mm_struct *mm;
    unsigned long virt_addr = phys_to_virt(phys_addr);
    struct vm_area_struct *vma;

    for_each_process(task) {
        mm = task->mm;
        if (!mm) continue;

        down_read(&mm->mmap_sem);
        for (vma = mm->mmap; vma; vma = vma->vm_next) {
            if (virt_addr >= vma->vm_start && virt_addr < vma->vm_end) {
                printk(KERN_INFO "Process %s (pid: %d) owns the physical address 0x%lx\n", task->comm, task->pid, phys_addr);
                up_read(&mm->mmap_sem);
                return;
            }
        }
        up_read(&mm->mmap_sem);
    }
    printk(KERN_INFO "No process owns the physical address 0x%lx\n", phys_addr);
}

static int __init my_module_init(void) {
    unsigned long phys_addr = 0x12345678; // Replace with the physical address you want to check
    find_owner_process(phys_addr);
    return 0;
}

static void __exit my_module_exit(void) {
    printk(KERN_INFO "Module unloaded.\n");
}

module_init(my_module_init);
module_exit(my_module_exit);

MODULE_LICENSE("GPL");
MODULE_AUTHOR("Your Name");
MODULE_DESCRIPTION("A module to find the process owning a physical address");