package com.cg.vim.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
/**
 * Used to serialize Java.util.Date, which is not a common JSON
 * type, so we have to create a custom serialize method;.
 */
@Component
public class JsonDateSerializer extends JsonSerializer<Date>{

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	public SimpleDateFormat getDateFormat() {
		return dateFormat;
	}
	public void setDateFormat(SimpleDateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}
	@Override
	public void serialize(Date date, JsonGenerator gen, SerializerProvider provider)
			throws IOException {
		String formattedDate = this.getDateFormat().format(date);
		gen.writeString(formattedDate);
	}
}
