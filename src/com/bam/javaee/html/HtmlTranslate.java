package com.bam.javaee.html;

import java.io.FileReader;
import java.io.IOException;

public class HtmlTranslate {

	public static void main(String[] args) {
		String htmlText = translate(
				"D:\\Games\\ProgrammingJava\\WorkSpace\\TrainingExercise\\src\\com\\bam\\javaee\\html\\HomePage.html");
//		String cssText = translate("D:\\Games\\ProgrammingJava\\WorkSpace\\TrainingExercise\\bin\\com\\bam\\javaee\\html\\source\\style.css");
		String newText = "<p>Hello</p>";
		System.out.println(addintoBody(htmlText, newText));
	}

	public static String translate(String fileFullName) {
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

	public static String addStyleToHtml(String htmlText, String cssText) {
		String firstPart = "";
		String secondPart = "";
		boolean isFirstPart = true;
		String newCssText = "<style>\n" + cssText + "\n</style>";
		for (int i = 0; i < htmlText.length() - 7; i++) {
			if (isFirstPart) {
				firstPart += htmlText.charAt(i);
			} else {
				secondPart += htmlText.charAt(i);
			}
			String check = "";
			if (isFirstPart && (htmlText.charAt(i) == ' ' || htmlText.charAt(i) == '\n')) {
				for (int j = 1; j <= 7; j++) {
					check += htmlText.charAt(i + j);
				}
				if (check.equals("</head>")) {
					isFirstPart = false;
				}
			}
		}
		return firstPart + "\n" + newCssText + "\n" + secondPart;
	}
	
	public static String addintoBody(String htmlText, String additionalHtmlCode){
		String newHtmlText = "\n";
		boolean isCodeAdded = false;
		
		for(int i = 0; i < htmlText.length(); i++)
		{
			newHtmlText += htmlText.charAt(i);
			if(!isCodeAdded && (htmlText.charAt(i) == ' ' || htmlText.charAt(i) == '\n'))
			{
				String check = "";
				for(int j = 1; j <= 6; j++)
				{
					check += htmlText.charAt(i + j);
				}
				if(check.equals("<body>"))
				{
					newHtmlText += "\n<body>\n" + additionalHtmlCode + "\n";
					i += 6;
					isCodeAdded = true;
				}
			}
		}
		return newHtmlText;
	}
}
