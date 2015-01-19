package dataHomework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WordCounter {
	public static void main(String args[]) {
		new WordCounter().grep();
}
	public void grep(){
		Map<String, Integer> tokenSayici = new HashMap<String, Integer>();
		Map<String, ArrayList<Integer>> tokenlar = new HashMap<>();
		BufferedReader reader = null;
		File file = new File("Dosya Yolu");
		try {reader = new BufferedReader(new FileReader(file));}
		catch (Exception e) {
			System.out.println("Hatalý iþlem, dosya yok veya bozuk "
					+ e.getMessage());
		}
	
		String satir = null;
		try {satir = reader.readLine();} catch (IOException e1) {}
		Integer satirNumarasi = 1;
		while (satir != null) {
			StringTokenizer tk = new StringTokenizer(satir,
					"?:;'!>.)<,/}-0123456789”“’… ");
			while (tk.hasMoreTokens()) {
				String s = tk.nextToken().toLowerCase();
				if (s.length() == 0)  continue;
				Integer currentCount = tokenSayici.get(s);
				if (currentCount == null) currentCount = 0;
				tokenSayici.put(s, ++currentCount);
				if (tokenlar.containsKey(s)){
					if(!tokenlar.get(s).contains(satirNumarasi))
					tokenlar.get(s).add(satirNumarasi);
			}
				else {
					ArrayList<Integer> arrList = new ArrayList<Integer>();
					arrList.add(satirNumarasi);
					tokenlar.put(s, arrList);
				}
			}
			try {satir = reader.readLine();}
			catch (IOException e) {System.out.println("Hata!");}
			satirNumarasi++;
		}
		try {reader.close();} catch (IOException e) {}
		Scanner scan = new Scanner(System.in);
		System.out.print("Aranacak kelimeyi girin: ");
		String kelime = scan.nextLine();
		scan.close();
		ArrayList<Integer> lines = tokenlar.get(kelime.toLowerCase());
		if (lines != null) {
			System.out.println("Kelime var. Ayrýca þu satýrlarda geçiyor: ");
			for (Integer i : lines)
				System.out.print(i + "   ");
			System.out.println("\n Ayrýca dosyada " + tokenSayici.get(kelime)
					+ " kere geçiyor");
		} else
			System.out.println("Kelime yok");
	  }
  }
