package com.bharath.skills.main;

import java.util.StringTokenizer;

class VersionsSolution {

	public static final String DEFAULT_VERSION = "0";

	public int compareVersion(String version1, String version2) {

		StringTokenizer st1 = new StringTokenizer(version1, ".");
		StringTokenizer st2 = new StringTokenizer(version2, ".");

		while (st1.hasMoreTokens() || st2.hasMoreTokens()) {
			
			

			String t1 = st1.hasMoreTokens() ? st1.nextToken() : DEFAULT_VERSION;
			String t2 = st2.hasMoreTokens() ? st2.nextToken() : DEFAULT_VERSION;

			System.out.println(t1+"-"+t2);
			if (t1.equals(t2))
				continue;

			int nt1 = Integer.parseInt(t1);
			int nt2 = Integer.parseInt(t2);

			if (nt1 == nt2)
				continue;
			return nt1 < nt2 ? -1 : 1;

		}
		return 0;

	}
}

public class Versions {

	public static void main(String[] args) {

		String version1 = "1.0";
		String version2 = "1.0.0";

		VersionsSolution sol = new VersionsSolution();

		System.out.println(sol.compareVersion(version1, version2));

	}

}
