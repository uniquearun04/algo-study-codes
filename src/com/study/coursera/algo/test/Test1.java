package com.study.coursera.algo.test;

import java.io.File;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		String inFilePath = "D:/Arun/Study/EclipseWSStudy/Algorithms/src/com/study/coursera/algo";
		String OutFilePath = "D:/Arun/Study/EclipseWSStudy/Algorithms/src/com/study/coursera/algo";
		
		File[] listFiles = null;
		
		File inDir = new File(inFilePath);
		if(inDir.isDirectory()){
			listFiles = inDir.listFiles();
		}
		
		if(listFiles != null){
			
		}

	}

}
