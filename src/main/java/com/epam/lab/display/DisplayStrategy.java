package com.epam.lab.display;

import com.epam.lab.parser.entity.Text;

import java.util.List;

public interface DisplayStrategy {
    void show(String data);

    void show(Text text);

    void show(List<String> list);
}
