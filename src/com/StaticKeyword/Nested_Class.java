package com.StaticKeyword;

 

public class Nested_Class {

	
	static class Fun {
		 static String name;

		public Fun(String name) {
			this.name = name;
		}

	}
	public static void main(String[] args) {
		/// Fun obj = new Fun(); error beacsue this clss depent on Nexted_class;

		Fun obj = new Fun("naveen");
		Fun obj1 = new Fun("kumar");
		
		System.out.println(obj.name);
		System.out.println(obj1.name);

	}
}
