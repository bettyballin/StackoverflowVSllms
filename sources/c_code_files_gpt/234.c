#include <linux/module.h>
#include <linux/kernel.h>
#include <linux/sched.h>
#include <linux/fs.h>
#include <linux/path.h>
#include <linux/dcache.h>
#include <linux/fdtable.h>

MODULE_LICENSE("GPL");
MODULE_AUTHOR("Security Expert");
MODULE_DESCRIPTION("Kernel module to list files and offsets of a process");

static int __init get_process_files_init(void)
{
    struct task_struct *task;
    struct files_struct *files;
    struct fdtable *fdt;
    struct file *file;
    struct path *path;
    int i;

    // Replace with the PID of the target process
    pid_t target_pid = 1234;

    rcu_read_lock();
    task = pid_task(find_vpid(target_pid), PIDTYPE_PID);
    if (!task) {
        pr_err("Cannot find task with pid %d\n", target_pid);
        rcu_read_unlock();
        return -ESRCH;
    }

    files = task->files;
    if (!files) {
        pr_err("Task has no files_struct\n");
        rcu_read_unlock();
        return -ENOENT;
    }

    spin_lock(&files->file_lock);
    fdt = files_fdtable(files);
    for (i = 0; i < fdt->max_fds; i++) {
        file = fdt->fd[i];
        if (file) {
            path = &file->f_path;
            path_get(path);
            pr_info("File: %s, Offset: %lld\n", d_path(path, (char *)__get_free_page(GFP_KERNEL), PAGE_SIZE), file->f_pos);
            path_put(path);
        }
    }
    spin_unlock(&files->file_lock);
    rcu_read_unlock();

    return 0;
}

static void __exit get_process_files_exit(void)
{
    pr_info("Module exited\n");
}

module_init(get_process_files_init);
module_exit(get_process_files_exit);