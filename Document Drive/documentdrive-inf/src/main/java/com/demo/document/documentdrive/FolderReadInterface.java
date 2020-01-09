package com.demo.document.documentdrive;

import org.springframework.stereotype.Service;

@Service
public interface FolderReadInterface {
	public byte[] downloadFolder(String folderId);
}
