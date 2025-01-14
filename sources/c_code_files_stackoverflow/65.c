#include <linux/rtc.h>
#include <sys/ioctl.h>
#include <fcntl.h>  // for open() and O_RDONLY

struct rtc_time {
    int tm_sec;      /* seconds */
    int tm_min;      /* minutes */
    int tm_hour;     /* hours */
    int tm_mday;     /* day of the month */
    int tm_mon;      /* month */
    int tm_year;     /* year */
    int tm_wday; /* unused */
    int tm_yday; /* unused */
    int tm_isdst;/* unused */
};

int main() {
    int fd;
    struct rtc_time rt;
    /* set your values here */
    rt.tm_sec = 0;   /* seconds */
    rt.tm_min = 0;   /* minutes */
    rt.tm_hour = 0;  /* hours */
    rt.tm_mday = 1;  /* day of the month */
    rt.tm_mon = 0;   /* month */
    rt.tm_year = 0;  /* year */

    fd = open("/dev/rtc", O_WRONLY);  // Changed to O_WRONLY
    if (fd == -1) {
        perror("open");
        return 1;
    }

    if (ioctl(fd, RTC_SET_TIME, &rt) == -1) {
        perror("ioctl");
        return 1;
    }

    close(fd);
    return 0;
}