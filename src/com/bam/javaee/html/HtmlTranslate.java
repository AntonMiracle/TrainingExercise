package com.bam.javaee.html;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HtmlTranslate {

	public static void main(String[] args) {
		System.out.println(traslate("D:\\Games\\ProgrammingJava\\WorkSpace\\TrainingExercise\\bin\\com\\bam\\javaee\\html\\HomePage.html"));
	}

	public static String traslate(String fileFullName) {
		FileReader file = null;
		String text = "";
		try {
			file = new FileReader(fileFullName);
			int c;
			while ((c = file.read()) != -1)
				text += (char) c;
			if (file != null) file.close();
		} catch (IOException ex) {
			System.out.println(ex);
		}
		return text;
	}
}
