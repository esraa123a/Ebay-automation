package utils;

import java.io.InputStream;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestDataLoader {
	public static JsonNode loadJson(String path) throws Exception {
		try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(path)) {
			if (in == null)
				throw new RuntimeException("Missing resource: " + path);
			return new ObjectMapper().readTree(in);
		}
	}
}
