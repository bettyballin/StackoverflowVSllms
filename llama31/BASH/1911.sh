$(TARGET).elf: $(OBJS) $(INCLUDE)/*.h\n    $(LD) -T link.ld -o $@ $^