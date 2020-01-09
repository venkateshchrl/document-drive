package com.demo.document.documentdrive;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.document.documentdrive.pojos.FilePojo;

@Service
public interface DocumentCreateInterface {

	public FilePojo createDocument(String folderId, List<FilePojo> filePojo);
}
