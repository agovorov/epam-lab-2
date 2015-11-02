package com.epam.lab.display;

import java.util.List;

import com.epam.lab.parser.entity.Text;

public interface DisplayStrategy {
    void show(String data);

    void show(Text text);

    void show(List<String> list);
}
