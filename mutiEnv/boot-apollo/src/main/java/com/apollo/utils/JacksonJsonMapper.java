package com.apollo.utils;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.JSONPObject;

public class JacksonJsonMapper {
	private static final Logger log = LoggerFactory.getLogger(JacksonJsonMapper.class);
	public static final JacksonJsonMapper INSTANCE = new JacksonJsonMapper();
	private ObjectMapper mapper;

	public JacksonJsonMapper() {
		this(null);
	}

	public JacksonJsonMapper(JsonInclude.Include include) {
		this.mapper = new ObjectMapper();
		if (include != null) {
			this.mapper.setSerializationInclusion(include);
		}
		this.mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		this.mapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
	}

	public static JacksonJsonMapper nonNullMapper() {
		return new JacksonJsonMapper(JsonInclude.Include.NON_NULL);
	}

	public static JacksonJsonMapper nonEmptyMapper() {
		return new JacksonJsonMapper(JsonInclude.Include.NON_EMPTY);
	}

	public static JacksonJsonMapper defaultMapper() {
		return new JacksonJsonMapper();
	}

	public String toJson(Object object) {
		try {
			return this.mapper.writeValueAsString(object);
		} catch (Exception e) {
			log.warn("write to json string error:" + object, e);
			throw new RuntimeException(e);
		}
	}

	public JsonNode toJsonNode(String jsonString) {
		if (StringUtils.isEmpty(jsonString)) {
			return null;
		}
		try {
			return this.mapper.readTree(jsonString);
		} catch (Exception e) {
			log.error("parse json string error:" + jsonString, e);
			throw new RuntimeException(e);
		}
	}

	public <T> T fromJson(String jsonString, Class<T> clazz) {
		if (StringUtils.isEmpty(jsonString)) {
			return null;
		}
		try {
			return (T) this.mapper.readValue(jsonString, clazz);
		} catch (Exception e) {
			log.error("parse json string error:" + jsonString, e);
			throw new RuntimeException(e);
		}
	}

	public <T> T fromJson(String jsonString, TypeReference typeReference) {
		if (StringUtils.isEmpty(jsonString)) {
			return null;
		}
		try {
			return (T) this.mapper.readValue(jsonString, typeReference);
		} catch (Exception e) {
			log.error("parse json string error:" + jsonString, e);
			throw new RuntimeException(e);
		}
	}

	public <T> T fromJson(String jsonString, JavaType javaType) {
		if (StringUtils.isEmpty(jsonString)) {
			return null;
		}
		try {
			return (T) this.mapper.readValue(jsonString, javaType);
		} catch (Exception e) {
			log.error("parse json string error:" + jsonString, e);
			throw new RuntimeException(e);
		}
	}

	public JavaType buildCollectionType(Class<? extends Collection> collectionClass, Class<?> elementClass) {
		return this.mapper.getTypeFactory().constructCollectionType(collectionClass, elementClass);
	}

	public JavaType buildMapType(Class<? extends Map> mapClass, Class<?> keyClass, Class<?> valueClass) {
		return this.mapper.getTypeFactory().constructMapType(mapClass, keyClass, valueClass);
	}

	public void update(String jsonString, Object object) {
		try {
			this.mapper.readerForUpdating(object).readValue(jsonString);
		} catch (JsonProcessingException e) {
			log.error("update json string:" + jsonString + " to object:" + object + " error.", e);
		} catch (IOException e) {
			log.error("update json string:" + jsonString + " to object:" + object + " error.", e);
		}
	}

	public String toJsonP(String functionName, Object object) {
		return toJson(new JSONPObject(functionName, object));
	}

	public void enableEnumUseToString() {
		this.mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
		this.mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
	}

	public ObjectMapper getMapper() {
		return this.mapper;
	}
}
