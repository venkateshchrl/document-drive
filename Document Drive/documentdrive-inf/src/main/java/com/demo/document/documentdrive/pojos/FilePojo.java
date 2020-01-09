package com.demo.document.documentdrive.pojos;

import java.util.List;

import lombok.Data;

@Data
public class FilePojo {
	public String name;
	public int type;
	public String fileSize;
	public List<String> permissions;
	public byte[] fileContent;
	public String mediaType;
}