package com.bharath.skills.main;

public class GoatLatin {

	private static final String A = "a";

	private static final String MA = "ma";

	private static final String SPACE = " ";

	public String toGoatLatin(String s) {

		StringBuilder sb = new StringBuilder();

		StringBuilder asb = new StringBuilder(A);

		for (String st : s.split(" ")) {

			Character c = Character.toLowerCase(st.charAt(0));

			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
				sb.append(st).append(MA).append(asb).append(SPACE);
			else
				sb.append(st.substring(1)).append(st.charAt(0)).append(MA).append(asb).append(SPACE);

			asb.append(A);

		}

		return sb.toString().trim();

	}

	public static void main(String[] args) {

		System.out.println(new GoatLatin().toGoatLatin("I speak Goat Latin"));
	}
}
