package com.demo.document.documentdrive;

import org.springframework.stereotype.Service;

@Service
public interface DocumentReadInterface {
	public byte[] fetchDocument(String folderId, String fileId);
}
