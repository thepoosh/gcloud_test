package com.thepoosh.main;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		try {
			Process proc = Runtime.getRuntime().exec("/bin/bash -c gcloud");
			proc.waitFor();
			int result = proc.exitValue();
			if (result != 0) {
				printStream(proc.getErrorStream());
			} else {
				printStream(proc.getInputStream());
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("hello world");
	}

	private static void printStream(InputStream stream) {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
		String line;
		try {
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
