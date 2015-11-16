package gmit;

import java.util.HashMap;
import java.util.Map;

public class Encoding
{
	
	Map<Character, String> polybius = new HashMap<Character, String>();
	
	//Put method in HashMap runs in O(1) time, it only has to run once and insertion for HashMaps run in O(1) time
	//Method to encode letters
	public void init()
	{	
		
		//Encoding
		polybius.put('A', "DG");
		polybius.put('B', "VX");
		polybius.put('C', "GV");
		polybius.put('D', "FX");
		polybius.put('E', "DF");
		polybius.put('F', "FV");
		polybius.put('G', "AV");
		polybius.put('H', "AD");
		polybius.put('I', "XV");
		polybius.put('J', "XA");
		polybius.put('K', "GD");
		polybius.put('L', "FA");
		polybius.put('M', "DD");
		polybius.put('N', "FF");
		polybius.put('O', "FG");
		polybius.put('P', "AA");
		polybius.put('Q', "AG");
		polybius.put('R', "GF");
		polybius.put('S', "VA");
		polybius.put('T', "XG");
		polybius.put('U', "XF");
		polybius.put('V', "GX");
		polybius.put('W', "VG");
		polybius.put('X', "GA");
		polybius.put('Y', "DX");
		polybius.put('Z', "VF");
		polybius.put('0', "AF");
		polybius.put('1', "DV");
		polybius.put('2', "FD");
		polybius.put('3', "GG");
		polybius.put('4', "DA");
		polybius.put('5', "VD");
		polybius.put('6', "AX");
		polybius.put('7', "VV");
		polybius.put('8', "XX");
		polybius.put('9', "XD");
		polybius.put('\"', "ZA");
		polybius.put(',', "ZD");
		polybius.put('.', "ZF");
		polybius.put('-', "ZG");
		polybius.put('\'', "ZV");
		polybius.put('?', "ZX");
		polybius.put(';', "ZZ");
		polybius.put('(', "AZ");
		polybius.put(')', "DZ");
		polybius.put('!', "FZ");
		polybius.put(':', "GZ");
		polybius.put('*', "VZ");
		polybius.put('/', "XZ");
		polybius.put('=', "JA");
		
		/*
		//Decoding
		polybius.put("DG", 'A');
		polybius.put("VX", 'B');
		polybius.put("GV", 'C');
		polybius.put("FX", 'D');
		polybius.put("DF", 'E');
		polybius.put("FV", 'F');
		polybius.put("AV", 'G');
		polybius.put("AD", 'H');
		polybius.put("XV", 'I');
		polybius.put("XA", 'J');
		polybius.put("GD", 'K');
		polybius.put("FA", 'L');
		polybius.put("DD", 'M');
		polybius.put("FF", 'N');
		polybius.put("FG", 'O');
		polybius.put("AA", 'P');
		polybius.put("AG", 'Q');
		polybius.put("GF", 'R');
		polybius.put("VA", 'S');
		polybius.put("XG", 'T');
		polybius.put("XF", 'U');
		polybius.put("GX", 'V');
		polybius.put("VG", 'W');
		polybius.put("GA", 'X');
		polybius.put("DX", 'Y');
		polybius.put("VF", 'Z');
		polybius.put("AF", '0');
		polybius.put("DV", '1');
		polybius.put("FD", '2');
		polybius.put("GG", '3');
		polybius.put("DA", '4');
		polybius.put("VD", '5');
		polybius.put("AX", '6');
		polybius.put("VV", '7');
		polybius.put("XX", '8');
		polybius.put("XD", '9');
		polybius.put("ZA", '\"');
		polybius.put("ZD", ',');
		polybius.put("ZF", '.');
		polybius.put("ZG", '-');
		polybius.put("ZV", '\'');
		polybius.put("ZX", '?');
		polybius.put("ZZ", ';');
		polybius.put("AZ", '(');
		polybius.put("DZ", ')');
		polybius.put("FZ", '!');
		polybius.put("GZ", ':');
		polybius.put("VZ", '*');
		polybius.put("XZ", '/');
		polybius.put("JA", '=');
		*/
	}//End init
	
	//Get method in HashMap runs in O(1) time, retrieval in HashMaps run at O(1) time
	//letter is passed in and encoded
	public String encode(char key)
	{
		
		String val;
		
		//Returns encoded string value
		val = polybius.get(key);
		
		return val;
		
	}//End method encode
	
}//End class Encoding











