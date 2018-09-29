
public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		
		//Check length
		int len = candidateSolution.length();
		if(len != 81) {
			return -1;
		}
		
		//R1
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
											}
										}
									}
								}
							}
						}
					}
				}
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
		
		
		
		return 0;
	}
}
