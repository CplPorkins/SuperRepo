/*
Shantanu Jha, Advay Sriram
APCS1 pd5
HW44--This or That Fourteen Other Things
2015-12-08
*/

public class Hexadecimal {
	private int _decNum;
	private String _hexNum;
	private final static String HEXDIGITS = "0123456789ABCDEF";
	private final static String [] HexDigits = {"0", "1", "2", "3","4","5","6","7","8","9","A","B","C","D","E","F"};
 
	public Hexadecimal(){
		_decNum = 0;
		_hexNum = "0";
	}

	public Hexadecimal(int n){
		_decNum = n;
		_hexNum = decToHex(n);
	}
	
	public Hexadecimal(String s){
		_decNum = hexToDec(s);
		_hexNum = s;
	}	
	
	
	public static int hexToDec(String str){
		int ans = 0;
		int len = str.length();
		while (len > 0){
			ans = 16*ans + HEXDIGITS.indexOf(str.substring(0,1));
			str = str.substring(1);
			len--;
		}
		return ans;
	}
	
	public static int hexToDecR(String str){
		if(str.length() == 0) return 0;
		return 16*hexToDecR(str.substring(0,str.length()-1)) + (HEXDIGITS.indexOf(str.substring(str.length()-1)));
	}
	
	
	public static String decToHex(int n){
		String ans = "";
		int temp = 0;
		while(n>0){
			temp = n%16;
			n = n/16;
			ans = HexDigits[temp] + ans; 
		}
		return ans;
	}

	public static String decToHexR(int n){
		if(n==0) return "";
		return decToHexR(n/16) + HexDigits[n%16];
	}	
	
	public static void main(String [] args){
		System.out.println(Hexadecimal.hexToDec("2E6"));
		System.out.println(Hexadecimal.hexToDecR("2E6"));
		System.out.println(Hexadecimal.decToHex(742));
		System.out.println(Hexadecimal.decToHexR(742));
		
	}
}
