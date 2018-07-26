package com.citi.test.csi.connection;

import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.annotation.Region;


@Region(value = "customer")
public class Csi implements PdxSerializable {

	@Id
    private String key;
	
    private String value;

    @PersistenceConstructor
    public Csi(String key, String value) {
        this.key = key;
        this.value = value;
    }
  
    @PersistenceConstructor
    public Csi() {
    	
    }

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public void toData(PdxWriter writer) {		
	}

	@Override
	public void fromData(PdxReader reader) {
	}
	
}
