/**
 * 
 */
package com.deepsm007.bdd.Bdd_Skeleton_Generator.methods;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

/**
 * This class contains generic methods to replace string content and execute
 * terminal commands.
 * 
 * @author Deep Mistry
 *
 */
public class FileHandler {
	static Logger log = Logger.getLogger(FileHandler.class);
	static Process pro = null;

	/**
	 * This method is use to replace placeholder with provided value.
	 * 
	 * @param placeHolder
	 * @param content
	 * @param value
	 * @return
	 */
	public static String replacePlaceholder(String placeHolder, String content, String value) {
		content = content.replace(placeHolder, value);
		return content;
	}

	/**
	 * This method is use to execute windows terminal command.
	 * 
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public static String runProcess(String command) throws Exception {
		pro = Runtime.getRuntime().exec(command);
		String output = "";
//		String error = IOUtils.toString(pro.getErrorStream());
//		if (error.length() > 0) {
//			log.error("Error --> " + error.substring(error.lastIndexOf("Caused")).trim());
//		} else {
			output = IOUtils.toString(pro.getInputStream());
//		}
		pro.destroy();
		return output;
	}
}
