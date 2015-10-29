package com.epam.lab.display;

import java.util.List;
/**
 * @deprecated
 */
public interface DisplayStrategy {
	void show(String data);
	void show(List<String> data);
}
