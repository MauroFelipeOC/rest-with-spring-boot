package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "file") //para pegar a propriedade do applicatioin.yml
public class FileStorageConfig {
	
	private String uploadDir; //precisa seguir o application.yml (uploadDir ou upload_dir )

	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}
	
}
