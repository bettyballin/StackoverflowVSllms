/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

class SortOrder {
    private String field;
    private Direction direction;

    public SortOrder(String string, Direction direction) {
        this.field = string;
        this.direction = direction;
    }

    public List<Record> apply(List<Record> list) {
        list.sort((record, record2) -> {
            if (this.direction == Direction.ASC) {
                return record.getName().compareTo(record2.getName());
            }
            return record2.getName().compareTo(record.getName());
        });
        return list;
    }

    public static enum Direction {
        ASC,
        DESC;

    }
}
