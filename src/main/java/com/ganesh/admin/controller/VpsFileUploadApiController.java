package com.ganesh.admin.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class VpsFileUploadApiController {

	
	public static final String ANNOUNCE_IMAGES_PATH="/usr/local/tomcat/apache-tomcat-8.5.35/webapps/kvnimages/";
	
	public static final String EVENT_IMAGES_PATH="/usr/local/tomcat/apache-tomcat-8.5.35/webapps/kvnimages/";
	
	public static final String NOTICE_IMAGES_PATH="/usr/local/tomcat/apache-tomcat-8.5.35/webapps/kvnimages/";
	//public static final String NOTICE_IMAGES_PATH="E:\\";

	
	
	/*
	 * String UPLOAD_DIR = "C://uploads//";
	 * 
	 * @RequestMapping(value = "/upload", method = RequestMethod.POST)
	 * public @ResponseBody String handleFileUpload(@RequestParam(value = "files")
	 * MultipartFile file, @RequestParam("imageName") String
	 * imageName,@RequestParam("imageType") int imageType, @RequestParam("userId")
	 * int userId) throws IOException {
	 * 
	 * String fileExtension = getFileExtension(file); String filename =
	 * getRandomString();
	 * 
	 * File targetFile = getTargetFile(fileExtension, filename);
	 * 
	 * byte[] bytes = file.getBytes(); file.transferTo(targetFile); String
	 * UploadedDirectory = targetFile.getAbsolutePath();
	 * 
	 * return filename; }
	 * 
	 * private String getRandomString() { return new Random().nextInt(999999) + "_"
	 * + System.currentTimeMillis(); }
	 * 
	 * private File getTargetFile(String fileExtn, String fileName) { File
	 * targetFile = new File(UPLOAD_DIR + fileName + fileExtn); return targetFile; }
	 * 
	 * private String getFileExtension(MultipartFile inFile) { String fileExtention
	 * = inFile.getOriginalFilename().substring(inFile.getOriginalFilename().
	 * lastIndexOf('.')); return fileExtention; }
	 */
	
	public   static void uploadFile( MultipartFile file,
			 String imageName,  int imageType) throws IOException {

		 
	 
		System.out.println("File Name: " + file.getOriginalFilename());
		Path path = null;
		byte[] bytes = file.getBytes();
		 

		if (imageType == 1) {

			path = Paths.get(ANNOUNCE_IMAGES_PATH+ imageName);
			
		} else if(imageType == 2) {
			
			path = Paths.get(EVENT_IMAGES_PATH+ imageName);
		}else if(imageType==3) {
			
			path = Paths.get(NOTICE_IMAGES_PATH+ imageName);
		}
		
		try {
			 
			Files.write(path, bytes);
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
			 
		}

		 

	}

	private String getFileExtension(MultipartFile inFile) {
		String fileExtention = inFile.getOriginalFilename().substring(inFile.getOriginalFilename().lastIndexOf('.'));
		return fileExtention;
	}
}
