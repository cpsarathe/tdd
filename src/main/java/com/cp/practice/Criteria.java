package com.cp.practice;

import java.util.List;

public interface Criteria<E> {
    List<E> arrange(List<E> list);
}
