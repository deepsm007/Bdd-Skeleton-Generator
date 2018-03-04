package com.deepsm007.bdd.Bdd_Skeleton_Generator.methods;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains method to search directory for specific file extension.
 * 
 * @author Deep Mistry
 *
 */
public class ScanDirectory {
	public static List<File> listOfFiles = new ArrayList<File>();

	/**
	 * This method searches for the files in the directory with the provided
	 * file extension.
	 * 
	 * @param file
	 * @param extension
	 */
	public static void search(File file, String extension) {
		if (file.isDirectory()) {
			if (file.canRead()) {
				for (File temp : file.listFiles()) {
					if (temp.isDirectory()) {
						search(temp, extension);
					} else {
						if (temp.getName().endsWith(extension)) {
							listOfFiles.add(temp);
						}
					}
				}
			}
		}
	}
}
