import java.util.*;

public class Main {
	
	Random rand =new Random();
	Scanner scan = new Scanner(System.in);
	ArrayList<String> listID = new ArrayList<>();
	ArrayList<String> listNama = new ArrayList<>();
	ArrayList<String> listJenis = new ArrayList<>();
	ArrayList<String> listJabatan = new ArrayList<>();
	ArrayList<String> listtempID = new ArrayList<>();
	ArrayList<String> listJabatanA = new ArrayList<>();
	ArrayList<String> listJabatanB = new ArrayList<>();
	ArrayList<String> listJabatanC = new ArrayList<>();

	ArrayList<Integer> listGaji = new ArrayList<>();

	ArrayList<Integer> listtemp = new ArrayList<>();
	ArrayList<Integer> listtempA = new ArrayList<>();
	ArrayList<Integer> listtempB = new ArrayList<>();
	ArrayList<Integer> listtempC = new ArrayList<>();
	
	
	int select = 0, gaji, counter=0, indexke, indexkedel;
	String nama, jeniskelamin, jabatan, id, bonus;
	
	final String intErrorMsg = "Input can be only Integer!";
	
	public Main() {
			
			do {
				menu();
			} while (select != 5);
		}
	
	
	
	public void menu() {
		System.out.println("PT. Mentol HR APP");
		System.out.println("=================");
		System.out.println("1. Insert Data");
		System.out.println("2. View Data");
		System.out.println("3. Update Data");
		System.out.println("4. Delete Data");
		do {
			try {
				System.out.print("Choose >> ");
				select = scan.nextInt(); scan.nextLine();
			}catch(Exception e) {
				select = -1;
				System.out.println(intErrorMsg);
						
			}finally {
				if (select == -1) {
					scan.nextLine();
				}
				
			}
		
		}while (select < 1 || select >4);
	
		//INPUT HERE
		switch (select) {
			case 1:
				menuInput();
				break;
			
			case 2:
				sortArray();
				viewArray();
				break;
				
			case 3:
				updateArray();
				break;
			
			case 4:
				deleteArray();
				break;
				}
				
				
		}
		
	



	public void deleteArray() {
		sortArray();
		viewArray();
		if (listID.size() == 0) {
			System.out.println();
		}
		else {
			do {
				System.out.println();
				System.out.print("Masukkan No Yang Ingin di Delete : ");
				indexkedel = scan.nextInt();
				scan.nextLine();
			} while (indexkedel < 1 || indexkedel > (listID.size()));
			
			indexkedel = indexkedel - 1;
			
			System.out.println();
			System.out.println("Berhasil Delete Karyawan dengan ID " + listID.get(indexkedel) + " Atas Nama " + listNama.get(indexkedel));
			System.out.println();
			
			listID.remove(indexkedel);
			listNama.remove(indexkedel);
			listJenis.remove(indexkedel);
			listGaji.remove(indexkedel);
			listJabatan.remove(indexkedel);
		}
	}



	public void updateArray() {
		sortArray();
		viewArray();
		
		if (listID.size() == 0) {
			System.out.println();
		}
		else {
			do {
				System.out.println();
				System.out.print("Masukkan No Yang Ingin di Update : ");
				indexke = scan.nextInt();
				scan.nextLine();
			} while (indexke < 1 || indexke > (listID.size()));
			
			do {
				System.out.print("Input nama karyawan [Must be 3 Characters or More] : ");
				nama = scan.nextLine();
			} while (nama.length()<3);
			
			do {
				System.out.print("Input Jenis Kelamin Anda [Laki-Laki / Perempuan] Case Sensitive! : ");
				jeniskelamin = scan.nextLine();
			} while (!jeniskelamin.equals("Laki-Laki") && !jeniskelamin.equals("Perempuan")); 
	
			do {
				System.out.print("Input Jabatan Anda [Manager / Supervisor / Admin] Case Sensitive! : ");
				jabatan = scan.nextLine();
			} while (!jabatan.equals("Manager") && !jabatan.equals("Supervisor") && !jabatan.equals("Admin")); 
	
			if (jabatan.equals("Manager")) {
				gaji = 8000000;
			}
			else if (jabatan.equals("Supervisor")) {
				gaji = 6000000;
			}
			else {
				gaji = 4000000;
			}
		
			char id1 = (char)(rand.nextInt(26) + 'A');
			char id2 = (char)(rand.nextInt(26) + 'A');
			int idAngka1 = rand.nextInt(10-1+1);
			int idAngka2 = rand.nextInt(10-1+1);
			int idAngka3 = rand.nextInt(10-1+1);
			int idAngka4 = rand.nextInt(10-1+1);
	
			String id = "" + id1 + id2 + "-"+idAngka1+idAngka2+idAngka3+idAngka4+"";
			
			indexke = indexke - 1;
			
			System.out.println();
			System.out.println("Berhasil Update karyawan dengan ID " + listID.get(indexke) + " Atas Nama " + listNama.get(indexke) + " Menjadi " + id + " Atas Nama " + nama);
			System.out.println();
			
			listID.set(indexke, id);
			listNama.set(indexke, nama);
			listJenis.set(indexke, jeniskelamin);
			listGaji.set(indexke, gaji);
			listJabatan.set(indexke, jabatan);
			
			
		}
	}


//////////////////////////////////////
	public void menuInput() {
		do {
			System.out.print("Input nama karyawan [Must be 3 Characters or More] : ");
			nama = scan.nextLine();
		} while (nama.length()<3);
		
		do {
			System.out.print("Input Jenis Kelamin Anda [Laki-Laki / Perempuan] Case Sensitive! : ");
			jeniskelamin = scan.nextLine();
		} while (!jeniskelamin.equals("Laki-Laki") && !jeniskelamin.equals("Perempuan")); 

		do {
			System.out.print("Input Jabatan Anda [Manager / Supervisor / Admin] Case Sensitive! : ");
			jabatan = scan.nextLine();
		} while (!jabatan.equals("Manager") && !jabatan.equals("Supervisor") && !jabatan.equals("Admin")); 

		if (jabatan.equals("Manager")) {
			gaji = 8000000;
		}
		else if (jabatan.equals("Supervisor")) {
			gaji = 6000000;
		}
		else {
			gaji = 4000000;
		}
	
		char id1 = (char)(rand.nextInt(26) + 'A');
		char id2 = (char)(rand.nextInt(26) + 'A');
		int idAngka1 = rand.nextInt(10-1+1);
		int idAngka2 = rand.nextInt(10-1+1);
		int idAngka3 = rand.nextInt(10-1+1);
		int idAngka4 = rand.nextInt(10-1+1);

		String id = "" + id1 + id2 + "-"+idAngka1+idAngka2+idAngka3+idAngka4+"";
		
		listID.add(id);
		listNama.add(nama);
		listJenis.add(jeniskelamin);
		listGaji.add(gaji);
		listJabatan.add(jabatan);

		
		System.out.println();
		System.out.println("Berhasil input karyawan dengan ID " + id);
		System.out.println();
		
	
		
		
		
		//Bikin arraylist 4 perkerjaan. If equals ini maka check di array perkerjaan itu. if modulus 3 masuk rumus bawah. LISRTTEMPID DELETE
	
		if (jabatan.equals("Manager")) {
			listJabatanA.add(id);
			listtempA.add(counter);
			bonus = "10%";
			if (listJabatanA.size()%3 == 1 && listJabatanA.size() != 1) {
				System.out.println("Bonus sebesar "+bonus+" telah diberikan kepada karyawan dengan id");
				for (int i = 0; i < listJabatanA.size() -1 ; i++) {
					gaji = listGaji.get(listtempA.get(i));
					gaji = gaji * 110 / 100;
					listGaji.set(listtempA.get(i), gaji);
					System.out.print(listJabatanA.get(i)+ ", ");
				}
			}
			
		}
		else if (jabatan.equals("Supervisor")) {
			listJabatanB.add(id);
			listtempB.add(counter);
			bonus = "7.5%";
			if (listJabatanB.size()%3 == 1 && listJabatanB.size() != 1) {
				System.out.println("Bonus sebesar "+bonus+" telah diberikan kepada karyawan dengan id");
				for (int i = 0; i < listJabatanB.size() -1 ; i++) {
					gaji = listGaji.get(listtempB.get(i));
					gaji = gaji * 1075 / 1000;
					listGaji.set(listtempB.get(i), gaji);
					System.out.print(listJabatanB.get(i)+ ", ");
				}
			}
			
		}
		else {
			listJabatanC.add(id);
			listtempC.add(counter);
			bonus = "5%";
			if (listJabatanC.size()%3 == 1 && listJabatanC.size() != 1) {
				System.out.println("Bonus sebesar "+bonus+" telah diberikan kepada karyawan dengan id");
				for (int i = 0; i < listJabatanC.size() -1 ; i++) {
					gaji = listGaji.get(listtempC.get(i));
					gaji = gaji * 105 / 100;
					listGaji.set(listtempC.get(i), gaji);
					System.out.print(listJabatanC.get(i)+ ", ");
				}
			}
		}
		
		counter += 1;
		
		
		
		
		
		System.out.println();
			
		System.out.println("PRESS ENTER");
		scan.nextLine();
		
		
	}



	public void viewArray() {
		if (listID.size() == 0) {
			System.out.println("No Data Avaiable");
		}
		else {
			System.out.println("| NO | Kode Karyawan    | Nama Karyawan     | Jenis Kelamin | Jabatan   | Gaji Karyawan |");
			System.out.println("|----|------------------|-------------------|---------------|-----------|---------------|");
			for (int i = 0 ; i < listID.size() ; i++) {
				System.out.printf("|%4d|%18s|%19s|%15s|%11s|%15s|\n", (i+1), listID.get(i), listNama.get(i), listJenis.get(i), listJabatan.get(i), listGaji.get(i) );
			}
			System.out.println();
			System.out.println();
		}
		
		
	}



	public void sortArray() {
		for (int j = 0; j < listID.size() - 1 ; j++) {
			for (int i = listID.size() - 1; i > j; i--) {
				if (listNama.get(i).compareTo(listNama.get(i-1)) < 0){ // > for DESCENDING
					String temp = listID.get(i);
					listID.set(i, listID.get(i-1));
					listID.set(i-1, temp);
					
					String temp2 = listNama.get(i);
					listNama.set(i, listNama.get(i-1));
					listNama.set(i-1, temp2);
					
					String temp3 = listJenis.get(i);
					listJenis.set(i, listJenis.get(i-1));
					listJenis.set(i-1, temp3);
					
					Integer temp4 = listGaji.get(i);
					listGaji.set(i, listGaji.get(i-1));
					listGaji.set(i-1, temp4);
					
					String temp5 = listJabatan.get(i);
					listJabatan.set(i, listJabatan.get(i-1));
					listJabatan.set(i-1, temp5);
				}
			}
		}
		
	}



	public static void main(String[] args) {
		new Main();

	}

}
