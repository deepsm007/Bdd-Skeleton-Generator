/**
 * 
 */
package com.deepsm007.bdd.Bdd_Skeleton_Generator.methods;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * This class contains method to generate java class.
 * 
 * @author Deep Mistry
 *
 */
public class GenerateJavaClass {
	static Logger log = Logger.getLogger(GenerateJavaClass.class);

	/**
	 * This method is use to generate java class with the provided content.
	 * 
	 * @param fileName
	 * @param fileType
	 * @param content
	 */
	public static void generateFile(String fileName, String fileType, String content) {
		FileWriter fr = null;
		BufferedWriter br = null;
		File file = null;
		try {
			file = new File(RunnerConstants.OUTPUT + "//" + fileName + "//" + fileName + fileType + ".java");
			file.getParentFile().mkdirs();
			fr = new FileWriter(file);
			br = new BufferedWriter(fr);
			br.write(content);
			br.close();
			fr.close();
		} catch (IOException e) {
			log.error("Error writing file --> " + fileName + ".java");
		}
	}
}
