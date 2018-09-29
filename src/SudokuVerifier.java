
public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		/* I MIGHT HAVE DONE THIS A LITTLE HARDER THAN IT NEEDED TO BE DONE.. BUT IT WORKS. SORT OF */
		// returns 0 if the candidate solution is correct
		
		//Check length
		int len = candidateSolution.length();
		if(len != 81) {
			return -1;
		}
		
		//Check R1
		for(int i = 0; i < len; i++) {
			if(candidateSolution.charAt(i) != '1') {
				if(candidateSolution.charAt(i) != '2') {
					if(candidateSolution.charAt(i) != '3') {
						if(candidateSolution.charAt(i) != '4') {
							if(candidateSolution.charAt(i) != '5') {
								if(candidateSolution.charAt(i) != '6') {
									if(candidateSolution.charAt(i) != '7') {
										if(candidateSolution.charAt(i) != '8') {
											if(candidateSolution.charAt(i) != '9') {
												return -1;
		}}}}}}}}}}
		
		//R2 Check sub-grids
		//Check first sub-grid
		String s1 = candidateSolution.substring(0, 3);
		String s2 = candidateSolution.substring(9, 12);
		String s3 = candidateSolution.substring(18, 21);
		int sLen = s1.length();
		for(int i = 0; i < sLen; i++) {
			if(s1.charAt(i) == s2.charAt(0) || s1.charAt(i) == s2.charAt(1) || s1.charAt(i) == s2.charAt(2) ||
				s1.charAt(i) == s3.charAt(0) || s1.charAt(i) == s3.charAt(1) || s1.charAt(i) == s3.charAt(2) ||
				s2.charAt(i) == s1.charAt(0) || s2.charAt(i) == s1.charAt(1) || s2.charAt(i) == s1.charAt(2) ||
				s2.charAt(i) == s3.charAt(0) || s2.charAt(i) == s3.charAt(1) || s2.charAt(i) == s3.charAt(2) ||
				s3.charAt(i) == s1.charAt(0) || s3.charAt(i) == s1.charAt(1) || s3.charAt(i) == s1.charAt(2) ||
				s3.charAt(i) == s2.charAt(0) || s3.charAt(i) == s2.charAt(1) || s3.charAt(i) == s2.charAt(2)){
				return -2;
			}
		}
		
		//Check second sub-grid
		s1 = candidateSolution.substring(3, 6);
		s2 = candidateSolution.substring(12, 15);
		s3 = candidateSolution.substring(21, 24);
		for(int i = 0; i < sLen; i++) {
			if(s1.charAt(i) == s2.charAt(0) || s1.charAt(i) == s2.charAt(1) || s1.charAt(i) == s2.charAt(2) ||
				s1.charAt(i) == s3.charAt(0) || s1.charAt(i) == s3.charAt(1) || s1.charAt(i) == s3.charAt(2) ||
				s2.charAt(i) == s1.charAt(0) || s2.charAt(i) == s1.charAt(1) || s2.charAt(i) == s1.charAt(2) ||
				s2.charAt(i) == s3.charAt(0) || s2.charAt(i) == s3.charAt(1) || s2.charAt(i) == s3.charAt(2) ||
				s3.charAt(i) == s1.charAt(0) || s3.charAt(i) == s1.charAt(1) || s3.charAt(i) == s1.charAt(2) ||
				s3.charAt(i) == s2.charAt(0) || s3.charAt(i) == s2.charAt(1) || s3.charAt(i) == s2.charAt(2)){
				return -2;
			}
		}
		
		//Check third sub-grid
		s1 = candidateSolution.substring(6, 9);
		s2 = candidateSolution.substring(15, 18);
		s3 = candidateSolution.substring(24, 27);
		for(int i = 0; i < sLen; i++) {
			if(s1.charAt(i) == s2.charAt(0) || s1.charAt(i) == s2.charAt(1) || s1.charAt(i) == s2.charAt(2) ||
				s1.charAt(i) == s3.charAt(0) || s1.charAt(i) == s3.charAt(1) || s1.charAt(i) == s3.charAt(2) ||
				s2.charAt(i) == s1.charAt(0) || s2.charAt(i) == s1.charAt(1) || s2.charAt(i) == s1.charAt(2) ||
				s2.charAt(i) == s3.charAt(0) || s2.charAt(i) == s3.charAt(1) || s2.charAt(i) == s3.charAt(2) ||
				s3.charAt(i) == s1.charAt(0) || s3.charAt(i) == s1.charAt(1) || s3.charAt(i) == s1.charAt(2) ||
				s3.charAt(i) == s2.charAt(0) || s3.charAt(i) == s2.charAt(1) || s3.charAt(i) == s2.charAt(2)){
				return -2;
			}
		}
		
		//Check fourth sub-grid
		s1 = candidateSolution.substring(27, 30);
		s2 = candidateSolution.substring(36, 39);
		s3 = candidateSolution.substring(45, 48);
		for(int i = 0; i < sLen; i++) {
			if(s1.charAt(i) == s2.charAt(0) || s1.charAt(i) == s2.charAt(1) || s1.charAt(i) == s2.charAt(2) ||
				s1.charAt(i) == s3.charAt(0) || s1.charAt(i) == s3.charAt(1) || s1.charAt(i) == s3.charAt(2) ||
				s2.charAt(i) == s1.charAt(0) || s2.charAt(i) == s1.charAt(1) || s2.charAt(i) == s1.charAt(2) ||
				s2.charAt(i) == s3.charAt(0) || s2.charAt(i) == s3.charAt(1) || s2.charAt(i) == s3.charAt(2) ||
				s3.charAt(i) == s1.charAt(0) || s3.charAt(i) == s1.charAt(1) || s3.charAt(i) == s1.charAt(2) ||
				s3.charAt(i) == s2.charAt(0) || s3.charAt(i) == s2.charAt(1) || s3.charAt(i) == s2.charAt(2)){
				return -2;
			}
		}
		
		//Check the fifth sub-grid
		s1 = candidateSolution.substring(30, 33);
		s2 = candidateSolution.substring(39, 42);
		s3 = candidateSolution.substring(48, 51);
		for(int i = 0; i < sLen; i++) {
			if(s1.charAt(i) == s2.charAt(0) || s1.charAt(i) == s2.charAt(1) || s1.charAt(i) == s2.charAt(2) ||
				s1.charAt(i) == s3.charAt(0) || s1.charAt(i) == s3.charAt(1) || s1.charAt(i) == s3.charAt(2) ||
				s2.charAt(i) == s1.charAt(0) || s2.charAt(i) == s1.charAt(1) || s2.charAt(i) == s1.charAt(2) ||
				s2.charAt(i) == s3.charAt(0) || s2.charAt(i) == s3.charAt(1) || s2.charAt(i) == s3.charAt(2) ||
				s3.charAt(i) == s1.charAt(0) || s3.charAt(i) == s1.charAt(1) || s3.charAt(i) == s1.charAt(2) ||
				s3.charAt(i) == s2.charAt(0) || s3.charAt(i) == s2.charAt(1) || s3.charAt(i) == s2.charAt(2)){
				return -2;
			}
		}
		
		//Check the sixth sub-grid
		s1 = candidateSolution.substring(33, 36);
		s2 = candidateSolution.substring(42, 45);
		s3 = candidateSolution.substring(51, 54);
		for(int i = 0; i < sLen; i++) {
			if(s1.charAt(i) == s2.charAt(0) || s1.charAt(i) == s2.charAt(1) || s1.charAt(i) == s2.charAt(2) ||
				s1.charAt(i) == s3.charAt(0) || s1.charAt(i) == s3.charAt(1) || s1.charAt(i) == s3.charAt(2) ||
				s2.charAt(i) == s1.charAt(0) || s2.charAt(i) == s1.charAt(1) || s2.charAt(i) == s1.charAt(2) ||
				s2.charAt(i) == s3.charAt(0) || s2.charAt(i) == s3.charAt(1) || s2.charAt(i) == s3.charAt(2) ||
				s3.charAt(i) == s1.charAt(0) || s3.charAt(i) == s1.charAt(1) || s3.charAt(i) == s1.charAt(2) ||
				s3.charAt(i) == s2.charAt(0) || s3.charAt(i) == s2.charAt(1) || s3.charAt(i) == s2.charAt(2)){
				return -2;
			}
		}
		
		//Check the seventh sub-grid
		s1 = candidateSolution.substring(54, 57);
		s2 = candidateSolution.substring(63, 66);
		s3 = candidateSolution.substring(72, 75);
		for(int i = 0; i < sLen; i++) {
			if(s1.charAt(i) == s2.charAt(0) || s1.charAt(i) == s2.charAt(1) || s1.charAt(i) == s2.charAt(2) ||
				s1.charAt(i) == s3.charAt(0) || s1.charAt(i) == s3.charAt(1) || s1.charAt(i) == s3.charAt(2) ||
				s2.charAt(i) == s1.charAt(0) || s2.charAt(i) == s1.charAt(1) || s2.charAt(i) == s1.charAt(2) ||
				s2.charAt(i) == s3.charAt(0) || s2.charAt(i) == s3.charAt(1) || s2.charAt(i) == s3.charAt(2) ||
				s3.charAt(i) == s1.charAt(0) || s3.charAt(i) == s1.charAt(1) || s3.charAt(i) == s1.charAt(2) ||
				s3.charAt(i) == s2.charAt(0) || s3.charAt(i) == s2.charAt(1) || s3.charAt(i) == s2.charAt(2)){
				return -2;
			}
		}
		
		//Check the eighth sub-grid
		s1 = candidateSolution.substring(57, 60);
		s2 = candidateSolution.substring(66, 69);
		s3 = candidateSolution.substring(75, 78);
		for(int i = 0; i < sLen; i++) {
			if(s1.charAt(i) == s2.charAt(0) || s1.charAt(i) == s2.charAt(1) || s1.charAt(i) == s2.charAt(2) ||
				s1.charAt(i) == s3.charAt(0) || s1.charAt(i) == s3.charAt(1) || s1.charAt(i) == s3.charAt(2) ||
				s2.charAt(i) == s1.charAt(0) || s2.charAt(i) == s1.charAt(1) || s2.charAt(i) == s1.charAt(2) ||
				s2.charAt(i) == s3.charAt(0) || s2.charAt(i) == s3.charAt(1) || s2.charAt(i) == s3.charAt(2) ||
				s3.charAt(i) == s1.charAt(0) || s3.charAt(i) == s1.charAt(1) || s3.charAt(i) == s1.charAt(2) ||
				s3.charAt(i) == s2.charAt(0) || s3.charAt(i) == s2.charAt(1) || s3.charAt(i) == s2.charAt(2)){
				return -2;
			}
		}
		
		//Check the final sub-grid
		s1 = candidateSolution.substring(60, 63);
		s2 = candidateSolution.substring(69, 72);
		s3 = candidateSolution.substring(78, 81);
		for(int i = 0; i < sLen; i++) {
			if(s1.charAt(i) == s2.charAt(0) || s1.charAt(i) == s2.charAt(1) || s1.charAt(i) == s2.charAt(2) ||
				s1.charAt(i) == s3.charAt(0) || s1.charAt(i) == s3.charAt(1) || s1.charAt(i) == s3.charAt(2) ||
				s2.charAt(i) == s1.charAt(0) || s2.charAt(i) == s1.charAt(1) || s2.charAt(i) == s1.charAt(2) ||
				s2.charAt(i) == s3.charAt(0) || s2.charAt(i) == s3.charAt(1) || s2.charAt(i) == s3.charAt(2) ||
				s3.charAt(i) == s1.charAt(0) || s3.charAt(i) == s1.charAt(1) || s3.charAt(i) == s1.charAt(2) ||
				s3.charAt(i) == s2.charAt(0) || s3.charAt(i) == s2.charAt(1) || s3.charAt(i) == s2.charAt(2)){
				return -2;
			}
		}
		
		//R3 check rows by substring
		//First row
		String sub = candidateSolution.substring(0, 8);
		int subLen = sub.length();
		int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0, count7 = 0, count8 = 0,
				count9 = 0;
		for(int i = 0; i < subLen; i++) {
			if(sub.charAt(i) == '1') {
				count1++;
				if(count1 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '2') {
				count2++;
				if(count2 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '3') {
				count3++;
				if(count3 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '4') {
				count4++;
				if(count4 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '5') {
				count5++;
				if(count5 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '6') {
				count6++;
				if(count6 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '7') {
				count7++;
				if(count7 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '8') {
				count8++;
				if(count8 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '9') {
				count9++;
				if(count9 > 1) {
					return -3;
				}
			}
		}

		count1 = 0;
		count2 = 0;
		count3 = 0;
		count4 = 0;
		count5 = 0;
		count6 = 0;
		count7 = 0;
		count8 = 0;
		count9 = 0;
		
		//Second row
		sub = candidateSolution.substring(9, 17);
		subLen = sub.length();
		for(int i = 0; i < subLen; i++) {
			if(sub.charAt(i) == '1') {
				count1++;
				if(count1 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '2') {
				count2++;
				if(count2 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '3') {
				count3++;
				if(count3 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '4') {
				count4++;
				if(count4 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '5') {
				count5++;
				if(count5 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '6') {
				count6++;
				if(count6 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '7') {
				count7++;
				if(count7 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '8') {
				count8++;
				if(count8 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '9') {
				count9++;
				if(count9 > 1) {
					return -3;
				}
			}
		}

		count1 = 0;
		count2 = 0;
		count3 = 0;
		count4 = 0;
		count5 = 0;
		count6 = 0;
		count7 = 0;
		count8 = 0;
		count9 = 0;
		
		//Third row
		sub = candidateSolution.substring(18, 26);
		subLen = sub.length();
		for(int i = 0; i < subLen; i++) {
			if(sub.charAt(i) == '1') {
				count1++;
				if(count1 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '2') {
				count2++;
				if(count2 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '3') {
				count3++;
				if(count3 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '4') {
				count4++;
				if(count4 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '5') {
				count5++;
				if(count5 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '6') {
				count6++;
				if(count6 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '7') {
				count7++;
				if(count7 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '8') {
				count8++;
				if(count8 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '9') {
				count9++;
				if(count9 > 1) {
					return -3;
				}
			}
		}
		
		count1 = 0;
		count2 = 0;
		count3 = 0;
		count4 = 0;
		count5 = 0;
		count6 = 0;
		count7 = 0;
		count8 = 0;
		count9 = 0;
		
		//Fourth row
		sub = candidateSolution.substring(27, 35);
		subLen = sub.length();
		for(int i = 0; i < subLen; i++) {
			if(sub.charAt(i) == '1') {
				count1++;
				if(count1 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '2') {
				count2++;
				if(count2 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '3') {
				count3++;
				if(count3 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '4') {
				count4++;
				if(count4 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '5') {
				count5++;
				if(count5 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '6') {
				count6++;
				if(count6 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '7') {
				count7++;
				if(count7 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '8') {
				count8++;
				if(count8 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '9') {
				count9++;
				if(count9 > 1) {
					return -3;
				}
			}
		}
		
		count1 = 0;
		count2 = 0;
		count3 = 0;
		count4 = 0;
		count5 = 0;
		count6 = 0;
		count7 = 0;
		count8 = 0;
		count9 = 0;
		
		//Fifth row
		sub = candidateSolution.substring(36, 44);
		subLen = sub.length();
		for(int i = 0; i < subLen; i++) {
			if(sub.charAt(i) == '1') {
				count1++;
				if(count1 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '2') {
				count2++;
				if(count2 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '3') {
				count3++;
				if(count3 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '4') {
				count4++;
				if(count4 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '5') {
				count5++;
				if(count5 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '6') {
				count6++;
				if(count6 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '7') {
				count7++;
				if(count7 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '8') {
				count8++;
				if(count8 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '9') {
				count9++;
				if(count9 > 1) {
					return -3;
				}
			}
		}
		
		count1 = 0;
		count2 = 0;
		count3 = 0;
		count4 = 0;
		count5 = 0;
		count6 = 0;
		count7 = 0;
		count8 = 0;
		count9 = 0;
		
		//Sixth row
		sub = candidateSolution.substring(45, 53);
		subLen = sub.length();
		for(int i = 0; i < subLen; i++) {
			if(sub.charAt(i) == '1') {
				count1++;
				if(count1 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '2') {
				count2++;
				if(count2 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '3') {
				count3++;
				if(count3 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '4') {
				count4++;
				if(count4 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '5') {
				count5++;
				if(count5 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '6') {
				count6++;
				if(count6 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '7') {
				count7++;
				if(count7 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '8') {
				count8++;
				if(count8 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '9') {
				count9++;
				if(count9 > 1) {
					return -3;
				}
			}
		}
		
		count1 = 0;
		count2 = 0;
		count3 = 0;
		count4 = 0;
		count5 = 0;
		count6 = 0;
		count7 = 0;
		count8 = 0;
		count9 = 0;
		
		//Seventh row
		sub = candidateSolution.substring(54, 62);
		subLen = sub.length();
		for(int i = 0; i < subLen; i++) {
			if(sub.charAt(i) == '1') {
				count1++;
				if(count1 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '2') {
				count2++;
				if(count2 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '3') {
				count3++;
				if(count3 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '4') {
				count4++;
				if(count4 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '5') {
				count5++;
				if(count5 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '6') {
				count6++;
				if(count6 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '7') {
				count7++;
				if(count7 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '8') {
				count8++;
				if(count8 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '9') {
				count9++;
				if(count9 > 1) {
					return -3;
				}
			}
		}

		count1 = 0;
		count2 = 0;
		count3 = 0;
		count4 = 0;
		count5 = 0;
		count6 = 0;
		count7 = 0;
		count8 = 0;
		count9 = 0;
		
		//Eighth row
		sub = candidateSolution.substring(63, 71);
		subLen = sub.length();
		for(int i = 0; i < subLen; i++) {
			if(sub.charAt(i) == '1') {
				count1++;
				if(count1 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '2') {
				count2++;
				if(count2 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '3') {
				count3++;
				if(count3 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '4') {
				count4++;
				if(count4 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '5') {
				count5++;
				if(count5 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '6') {
				count6++;
				if(count6 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '7') {
				count7++;
				if(count7 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '8') {
				count8++;
				if(count8 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '9') {
				count9++;
				if(count9 > 1) {
					return -3;
				}
			}
		}

		count1 = 0;
		count2 = 0;
		count3 = 0;
		count4 = 0;
		count5 = 0;
		count6 = 0;
		count7 = 0;
		count8 = 0;
		count9 = 0;
		
		//Ninth row
		sub = candidateSolution.substring(72, 81);
		subLen = sub.length();
		for(int i = 0; i < subLen; i++) {
			if(sub.charAt(i) == '1') {
				count1++;
				if(count1 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '2') {
				count2++;
				if(count2 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '3') {
				count3++;
				if(count3 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '4') {
				count4++;
				if(count4 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '5') {
				count5++;
				if(count5 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '6') {
				count6++;
				if(count6 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '7') {
				count7++;
				if(count7 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '8') {
				count8++;
				if(count8 > 1) {
					return -3;
				}
			}else if(sub.charAt(i) == '9') {
				count9++;
				if(count9 > 1) {
					return -3;
				}
			}
		}
		
		//Check R4
		String s = candidateSolution;
		for(int i = 0; i < 72; i++) {
			if(i <= 8) {
				if(s.charAt(i) == s.charAt(i+9) || s.charAt(i) == s.charAt(i+18) ||
						s.charAt(i) == s.charAt(i+27) || s.charAt(i) == s.charAt(i+36) ||
						s.charAt(i) == s.charAt(i+45) || s.charAt(i) == s.charAt(i+54) ||
						s.charAt(i) == s.charAt(i+63) || s.charAt(i) == s.charAt(i+72)) {
					return -4;
				}else if(i > 8 && i <= 17){
					if(s.charAt(i) == s.charAt(i+9) || s.charAt(i) == s.charAt(i+18) ||
						s.charAt(i) == s.charAt(i+27) || s.charAt(i) == s.charAt(i+36) ||
						s.charAt(i) == s.charAt(i+45) || s.charAt(i) == s.charAt(i+54) ||
						s.charAt(i) == s.charAt(i+63)) {
						return -4;
					}
				}else if(i > 17 && i <= 26) {
					if(s.charAt(i) == s.charAt(i+9) || s.charAt(i) == s.charAt(i+18) ||
						s.charAt(i) == s.charAt(i+27) || s.charAt(i) == s.charAt(i+36) ||
						s.charAt(i) == s.charAt(i+45) || s.charAt(i) == s.charAt(i+54)) {
						return -4;
					}
				}else if(i > 26 && i <= 35) {
					if(s.charAt(i) == s.charAt(i+9) || s.charAt(i) == s.charAt(i+18) ||
						s.charAt(i) == s.charAt(i+27) || s.charAt(i) == s.charAt(i+36) ||
						s.charAt(i) == s.charAt(i+45)) {
						return -4;
					}
				}else if(i > 35 && i <= 44) {
					if(s.charAt(i) == s.charAt(i+9) || s.charAt(i) == s.charAt(i+18) ||
						s.charAt(i) == s.charAt(i+27) || s.charAt(i) == s.charAt(i+36)) {
						return -4;
					}
				}else if(i > 44 && i <= 53) {
					if(s.charAt(i) == s.charAt(i+9) || s.charAt(i) == s.charAt(i+18) ||
						s.charAt(i) == s.charAt(i+27)) {
						return -4;
					}
				}else if(i > 53 && i <= 62) {
					if(s.charAt(i) == s.charAt(i+9) || s.charAt(i) == s.charAt(i+18)){
						return -4;
					}
				}else if(i > 62 && i <=71) {
					if(s.charAt(i) == s.charAt(i+9)) {
						return -4;
					}
				}	
			}	
		}
		
		
		return 0;
	}
	
	public String test(String s) {
		String ss = s.substring(9, 11);
		return ss;
	}
}
