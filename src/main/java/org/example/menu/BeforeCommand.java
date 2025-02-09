package org.example.menu;

import java.util.List;

public interface BeforeCommand<T> {
    void beforeExecute(List<T> list);
}
