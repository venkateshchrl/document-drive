package com.demo.document.documentdrive;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.document.documentdrive.pojos.FilePojo;

@Service
public interface DocumentListInterface {
	public List<FilePojo> listDocuments(String folderId);
}
