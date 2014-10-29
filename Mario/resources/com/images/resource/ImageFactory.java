package com.images.resource;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.core.EFields;

public class ImageFactory {

	private static Map<EFields,BufferedImage> imagesMap = new HashMap<EFields,BufferedImage>();
	
	static {
		String fieldName;
		BufferedImage image;
		for(EFields field : EFields.values()){
			fieldName = field.getName();
			image = getBufferedImage(ImageFactory.class.getResource(fieldName).getPath());
			imagesMap.put(field, image);
		}
	}
	
	public static BufferedImage getImage(EFields field) {
		return imagesMap.get(field);
	}

	private static BufferedImage getBufferedImage(String path) {
		File imageFile = new File(path);
		BufferedImage imageTemp = null;
		try {
			imageTemp = ImageIO.read(imageFile);
		} catch (IOException e) {
			System.err.println("Error while reading picture...");
			e.printStackTrace();
		}
		return imageTemp;
	}
}
