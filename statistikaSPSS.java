import java.util.*;
import java.math.*;
class statistikaSPSS
{
	public static void main(String [] kelompokIstimewa)
	{
		Scanner input = new Scanner(System.in);
		Scanner masuk = new Scanner(System.in);
		Scanner repeat 	= new Scanner(System.in);
		int pil,tunggal,kelompok,i,j,v;

		System.out.println("\n====================UNIVERSITAS PGRI YOGYAKARTA====================");
		System.out.println("		FAKULTAS TEKNIK - TEKNIK INFORMATIKA");
		System.out.println("		Kelas	: TI - 16 A2");
		System.out.println("");
		System.out.println("		PROGRAM SPSS STATISTIKA");
		System.out.println("");

		System.out.print("Masukan banyak data : ");
		int nBil=input.nextInt();

		int isiData[] = new int[nBil];

		for(i=0;i<nBil;i++)
		{
			System.out.print("Data ke "+(i+1)+": ");
			isiData[i]=input.nextInt();
		}

		System.out.println("\n");
		System.out.print("\nData yang dimasukan	: ");
		for (i=0; i<nBil; i++)
		{
			System.out.print(isiData[i]+ " ");
		}
		System.out.println();

		//proses sorting metode bubblesort
		for(i=0;i<nBil;i++)
		{
			for(j=i+1;j<nBil;j++)
			{
				if(isiData[j]<isiData[i])
				{
					int tmp=isiData[i];
					isiData[i]=isiData[j];
					isiData[j]=tmp;
				}
			}
		}

		System.out.print("Data Sorting		: ");
		for(i=0;i<isiData.length;i++)
		{
			System.out.print(isiData[i]+" "); //menampilkan data di yg telah sorting
		}

		//rumus total data
		int jml;
		int total=0;
		for(i=0;i<isiData.length;i++)
		{
			total=total+isiData[i];
		}
		jml=total;

		System.out.println("\nTotal Data		: "+jml);


		//proses mencari nilai maksimum
		int Max=isiData[0];
		for(i=1;i<isiData.length;i++)
		{
			if(Max < isiData[i])
			{
			Max=isiData[i];
			}
		}

		//proses mencari nilai minimum
		int Min=isiData[0];
		for(i=1;i<isiData.length;i++)
		{
			if(Min>isiData[i])
			{
			Min=isiData[i];
			}
		}

		System.out.println();
		System.out.println("\nBil. Terkecil		: "+Min);
		System.out.println("Bil. Terbesar		: "+Max);

		int Range = Max-Min; //menghitung Range

		double K = 1 + 3.3*+Math.log(nBil)/Math.log(10); //jumlah kelas masih bentuk desimal
		double k = 1 + 3.3*+Math.log(nBil)/Math.log(10); //menghitung jumlah kelas

		int desimalturun = 0;
		BigDecimal bd = new BigDecimal(k);
		bd = bd.setScale(desimalturun,BigDecimal.ROUND_UP); //pembulatan dinaikan
		k = bd.doubleValue();

		double C = Range/k; //lebar kelas masih berupa desimal
		double c = Range/k; //menghitung lebar tiap kelas

		int desimalnaik = 0;
		BigDecimal bc = new BigDecimal(c);
		bc = bc.setScale(desimalnaik,BigDecimal.ROUND_UP); //pembulatan dinaikan
		c = bc.doubleValue();

		//---rumus bagian DESIL 1---
		double desil1 = (1*0.1*(nBil+1));
		int bulatD1 = (int) desil1;
		double tunggalD1 = isiData[bulatD1-1]+(desil1-bulatD1)*((isiData[bulatD1]-isiData[bulatD1-1]));

		//---rumus bagian DESIL 3---
		double desil3 = (1*0.3*(nBil+1));
		int bulatD3 = (int) desil3;
		double tunggalD3 = isiData[bulatD3-1]+(desil3-bulatD3)*((isiData[bulatD3]-isiData[bulatD3-1]));

		//---rumus bagian DESIL 7---
		double desil7 = (1*0.7*(nBil+1));
		int bulatD7 = (int) desil7;
		double tunggalD7 = isiData[bulatD7-1]+(desil7-bulatD7)*((isiData[bulatD7]-isiData[bulatD7-1]));

		System.out.println("\n");
		System.out.println("+----|--------------------------|");
		System.out.println("| No |	   Daftar Pilihan	+");
		System.out.println("+----|--------------------------|");
		System.out.println("| 1. |  Hitung Data Tunggal	|");
		System.out.println("| 2. |  Hitung Data Kelompok	|");
		System.out.println("+-------------------------------+");
		System.out.print("\nMasukkan pilihan : ");
		pil = input.nextInt();

		//---switch Case (Big)---
		switch (pil) {
		//---------------------------------------Pilihan 1-----------------------------------------
		case 1:

			String resend="y";
			while (resend.equalsIgnoreCase ("y"))
			{
				System.out.println("\n   +-----+----------------------+");
				System.out.println("   | No  |  Daftar Program      |");
				System.out.println("   +-----+----------------------+");
				System.out.println("   | 1.  |    Mean		|");
				System.out.println("   | 2.  |    Modus		|");
				System.out.println("   | 3.  |    Median		|");
				System.out.println("   | 4.  |    Quartil 1		|");
				System.out.println("   | 5.  |    Quartil 3		|");
				System.out.println("   | 6.  |    Desil 1		|");
				System.out.println("   | 7.  |    Desil 3		|");
				System.out.println("   | 8.  |    Desil 7		|");
				System.out.println("   | 9.  |    Hitung Semua	|");
				System.out.println("   +-----+----------------------+");
				System.out.print("\nMasukkan pilihan: ");
				tunggal = input.nextInt();
				System.out.println();
				switch (tunggal)
				{
				case 1:

					//mencari Mean
					System.out.println();
					System.out.println("<!------------- MEAN ------------->");
					System.out.println(" Mean(rata-rata) 	: jumlah seluruh data/banyak data");
					System.out.println(" 			: "+jml+"/"+nBil);
					System.out.println(" 			: "+(double)jml/nBil);

					System.out.println("\n==============TERIMA KASIH TELAH MENGGUNAKAN PROGRAM INI===========");
					System.out.print("\nApakah anda ingin mengulang program SPSS ? [Y/T]: ");
					resend = masuk.nextLine();

					break;

				case 2:

					//mencari Modus
					System.out.println();
					System.out.println("<!------------- MODUS ------------->");
					int banyak[]=new int[999];
					int mds[]=new int[999];
					int x=0;
					int g=1;
					float jumlah=0;
					for(i=0;i<nBil;i++)
				   	{
						banyak[i]=0;
							for(j=0;j<nBil;j++)
						 	{
						   		if(isiData[i]==isiData[j])
								{
								 banyak[i]++;
								}
						 	}
					}
					//menentukan nilai yang paling sering muncul
					for(i=0;i<nBil;i++)
					{
						if(banyak[i]>g)
						{
					 		g=banyak[i];
						}
					}

					//jika modus lebih dari satu
					for(i=0;i<nBil;i++)
					{
					  	if(x==0)
						{
							mds[x]=0;
						}
						else
						{
							mds[x]=mds[x-1];
						}
						if(banyak[i]==g)
						{
							if(isiData[i]!=mds[x])
							{
								mds[x]=isiData[i];
								x++;
							}
						}
					}
					//Jika Semua angka muncul sama banyak
					int z=0;
					for(i=0;i<nBil;i++)
					{
						if(banyak[i]==g)
						{
							z++;
						}
					}
					if(z==nBil)
					{
						x=0;
					}
					if (x==0)
					{
						System.out.print("\nTidak Ada Modus!");
					}
					else{
					System.out.println("\nModusnya ada "+x);
					for(i=0;i<x;i++)
					{
					   System.out.println(" Modus ke "+(i+1)+" : "+mds[i]);
					}
					}

					System.out.println("\n==============TERIMA KASIH TELAH MENGGUNAKAN PROGRAM INI===========");
					System.out.print("\nApakah anda ingin mengulang program SPSS ? [Y/T]: ");
					resend = masuk.nextLine();

					break;

				case 3:

					//mencari Median
					System.out.println();
					System.out.println("<!------------- MEDIAN ------------->");

					int bil = nBil % 2;
					if (bil==0)
					{
						int posisi = nBil /2;
						System.out.println(" Datanya Genap");
						double tunggalMedian = (isiData[posisi-1]+isiData[posisi])*0.5;
						System.out.printf("\n Median = %.1f", tunggalMedian);
						System.out.println();
					}
					else
					{
						int posisi = (nBil +1)/2;
						System.out.println(" Datanya Ganjil");
						double tunggalMedian = isiData[posisi-1];
						System.out.println(" Median = "+ tunggalMedian);
						System.out.println();
					}

					System.out.println("\n==============TERIMA KASIH TELAH MENGGUNAKAN PROGRAM INI===========");
					System.out.print("\nApakah anda ingin mengulang program SPSS ? [Y/T]: ");
					resend = masuk.nextLine();

					break;

				case 4:

					//mencari Quartil 1
					System.out.println();
					System.out.println("<!------------- Quartil 1 ------------->");

				   if (nBil%2==0)
				   {
					   System.out.println(" Jumlah Data genap ");
					   if (nBil%4==0)
					   {

						   double tunggalq1 = (isiData[(nBil-1)/4]+isiData[(nBil+3)/4])*0.5;
						   System.out.println("Quartil 1		: "+tunggalq1);

						}
						else
						{

							double tunggalq1 = isiData[(nBil+1)/4];
							System.out.println("Quartil 1		: "+tunggalq1);

						}
				   }
				   else
				   {
					   System.out.println(" Jumlah Data ganjil ");
					   if ((nBil+1)%4==0)
					   {

							double tunggalq1 = isiData[((nBil+1)/4)-1];
							System.out.println("Quartil 1		: "+tunggalq1);

						}
						else
						{
							double tunggalq1 = (isiData[((nBil-1)/4)-1]+isiData[((nBil+3)/4)-1])*0.5;
							System.out.println("Quartil 1		: "+tunggalq1);
						}
					}


					System.out.println("\n==============TERIMA KASIH TELAH MENGGUNAKAN PROGRAM INI===========");
					System.out.print("\nApakah anda ingin mengulang program SPSS ? [Y/T]: ");
					resend = masuk.nextLine();

					break;

				case 5:

					//mencari Quartil 3
					System.out.println();
					System.out.println("<!------------- Quartil 3 ------------->");

					if (nBil%2==0)
					{
						System.out.println(" Jumlah Data genap ");
						if (nBil%4==0)
						{
							double tunggalq3 = (isiData[(3*nBil+1)/4]+isiData[(3*nBil+5)/4])*0.5;
							System.out.println("Quartil 3		: "+tunggalq3);
						}
						else
						{
							double tunggalq3 = isiData[((3*nBil+2)/4)-1];
							System.out.println("Quartil 3		: "+tunggalq3);
						}
					}
					else
					{
						System.out.println(" Jumlah Data ganjil ");
						if ((nBil+1)%4==0)
						{
							double tunggalq3 = isiData[(3*nBil+1)/4-1];
							System.out.println("Quartil 3		: "+tunggalq3);
						}
						else
						{
							double tunggalq3 = (isiData[((3*nBil+1)/4)-1]+isiData[((3*nBil+5)/4)-1])*0.5;
							System.out.println("Quartil 3		: "+tunggalq3);
						}
					}



					System.out.println("\n==============TERIMA KASIH TELAH MENGGUNAKAN PROGRAM INI===========");
					System.out.print("\nApakah anda ingin mengulang program SPSS ? [Y/T]: ");
					resend = masuk.nextLine();

					break;

				case 6:

					//mencari Desil 1
					System.out.println();
					System.out.println("<!------------- Desil 1 ------------->");

					System.out.println(" Desil 1: "+tunggalD1);


					System.out.println("\n==============TERIMA KASIH TELAH MENGGUNAKAN PROGRAM INI===========");
					System.out.print("\nApakah anda ingin mengulang program SPSS ? [Y/T]: ");
					resend = masuk.nextLine();

					break;

				case 7:

					//mencari Desil 3
					System.out.println();
					System.out.println("<!------------- Desil 3 ------------->");

					System.out.println(" Desil 3: "+tunggalD3);


					System.out.println("\n==============TERIMA KASIH TELAH MENGGUNAKAN PROGRAM INI===========");
					System.out.print("\nApakah anda ingin mengulang program SPSS ? [Y/T]: ");
					resend = masuk.nextLine();

					break;

				case 8:

					//mencari Desil 7
					System.out.println();
					System.out.println("<!------------- Desil 7 ------------->");

					System.out.println(" Desil 7: "+tunggalD7);


					System.out.println("\n==============TERIMA KASIH TELAH MENGGUNAKAN PROGRAM INI===========");
					System.out.print("\nApakah anda ingin mengulang program SPSS ? [Y/T]: ");
					resend = masuk.nextLine();

					break;

				case 9:

					System.out.println();
					System.out.println("<!------------- All In One ------------->");
					System.out.println("Mean			: "+(double)jml/nBil);

					//---------------bagian Modus----------------------
					int banyak9[]=new int[999];
					int mds9[]=new int[999];
					int x9=0;
					int g9=1;
					float jumlah9=0;
					for(i=0;i<nBil;i++)
					{
						banyak9[i]=0;
							for(j=0;j<nBil;j++)
							{
								if(isiData[i]==isiData[j])
								{
								 banyak9[i]++;
								}
							}
					}
					//menentukan nilai yang paling sering muncul
					for(i=0;i<nBil;i++)
					{
						if(banyak9[i]>g9)
						{
							g9=banyak9[i];
						}
					}

					//jika modus lebih dari satu
					for(i=0;i<nBil;i++)
					{
						if(x9==0)
						{
							mds9[x9]=0;
						}
						else
						{
							mds9[x9]=mds9[x9-1];
						}
						if(banyak9[i]==g9)
						{
							if(isiData[i]!=mds9[x9])
							{
								mds9[x9]=isiData[i];
								x9++;
							}
						}
					}
					//Jika Semua angka muncul sama banyak
					int z9=0;
					for(i=0;i<nBil;i++)
					{
						if(banyak9[i]==g9)
						{
							z9++;
						}
					}
					if(z9==nBil)
					{
						x9=0;
					}
					if (x9==0)
					{
						System.out.print("\nTidak Ada Modus!");
					}
					else{
					System.out.println("Modusnya ada "+x9);
					for(i=0;i<x9;i++)
					{
					   System.out.println("  Modus ke"+(i+1)+"		: "+mds9[i]);
					}
					}

					//---------------bagian Median----------------------
					if (nBil%2==0)
					{
						int letak = nBil /2;
						double medianTunggal = (isiData[letak-1]+isiData[letak])*0.5;
						System.out.printf("Median			: %.1f", medianTunggal);
						System.out.println();
					}
					else
					{
						int letak = (nBil +1)/2;
						System.out.println(" Datanya Ganjil");
						double medianTunggal = isiData[letak-1];
						System.out.println("Median			: "+ medianTunggal);
						System.out.println();
					}

					//---------------bagian Quartil 1----------------------
					if (nBil%2==0)
				   	{
					   if (nBil%4==0)
					   {

						   double tunggalq1 = (isiData[(nBil-1)/4]+isiData[(nBil+3)/4])*0.5;
						   System.out.println("Quartil 1		: "+tunggalq1);

						}
						else
						{

							double tunggalq1 = isiData[(nBil+1)/4];
							System.out.println("Quartil 1		: "+tunggalq1);

						}
				   	}
				   	else
				   	{
					   if ((nBil+1)%4==0)
					   {

							double tunggalq1 = isiData[((nBil+1)/4)-1];
							System.out.println("Quartil 1		: "+tunggalq1);

						}
						else
						{
							double tunggalq1 = (isiData[((nBil-1)/4)-1]+isiData[((nBil+3)/4)-1])*0.5;
							System.out.println("Quartil 1		: "+tunggalq1);
						}
					}

					//---------------bagian Quartil 3----------------------
					if (nBil%2==0)
					{
						if (nBil%4==0)
						{
							double tunggalq3 = (isiData[(3*nBil+1)/4]+isiData[(3*nBil+5)/4])*0.5;
							System.out.println("Quartil 3		: "+tunggalq3);
						}
						else
						{
							double tunggalq3 = isiData[((3*nBil+2)/4)-1];
							System.out.println("Quartil 3		: "+tunggalq3);
						}
					}
					else
					{
						if ((nBil+1)%4==0)
						{
							double tunggalq3 = isiData[(3*nBil+1)/4-1];
							System.out.println("Quartil 3		: "+tunggalq3);
						}
						else
						{
							double tunggalq3 = (isiData[((3*nBil+1)/4)-1]+isiData[((3*nBil+5)/4)-1])*0.5;
							System.out.println("Quartil 3		: "+tunggalq3);
						}
					}
					System.out.println("Desil 1			: "+tunggalD1);
					System.out.println("Desil 3			: "+tunggalD3);
					System.out.println("Desil 7			: "+tunggalD7);

					System.out.println("\n==============TERIMA KASIH TELAH MENGGUNAKAN PROGRAM INI===========");
					System.out.print("\nApakah anda ingin mengulang program SPSS ? [Y/T]: ");
					resend = masuk.nextLine();

					break;

				default:
					System.out.println("Pilihan yang Anda masukkan tidak tersedia !");
					break;
				}
			}
		//---------------------------------------Pilihan 2-----------------------------------------
		case 2:
				System.out.println("Range			: Bil. Terbesar - Bil. Terkecil ");
				System.out.println("			: "+Max+" - "+Min);
				System.out.println("			: "+Range);
				System.out.println("\nJumlah Kelas		: 1 + ( 3.3 * log(nData) )");
				System.out.println("			: 1 + ( 3.3 * log("+nBil+") )");
				System.out.println("			: "+K+" dibulatkan naik menjadi : "+k);
				System.out.println("\nLebar Interval		: Range / Jumlah Kelas");
				System.out.println("			: "+Range+" / "+k);
				System.out.println("			: "+C+" dibulatkan naik menjadi : "+c);

				System.out.println("\n=========================================================================================================================");
				System.out.println("\n			  			Tabel Distribusi Frekuensi");
				System.out.println("   +--------------------------------------------------------------------------------------------------------------------+");
				System.out.println("   | Interval  Kelas | Frekuensi | Frek Relatif | FrekKumulatif   | N.Tengah   | N.Tengah x Frek	| (N.Tengah x Frek)²|");
				System.out.println("   +--------------------------------------------------------------------------------------------------------------------+");

				//pendeklarasian tiap kelas menjadi array
				double kelasBawah[]=new double [isiData.length];
				double kelasAtas[] = new double [isiData.length];

				//Rumus mencetak tiap kelas pada array ke 0
				kelasBawah[0]=Min;
				kelasAtas[0]=Min+(c-1);

				//deklarasi untuk mempermudah mencari nilai tengah
				double batasBawah = Min;
				double batasAtas = batasBawah + c - 1;

				//rumus nilaiTengah
				double nilaiTengah=((batasBawah+batasAtas)/2);

				int kumulatif[]= new int [999];//999 tersebut mewakili jumlah K, dengan ketentuan jangan berisi dibawah dari jumlah k

				int frek[]= new int [999]; //999 tersebut mewakili jumlah K, dengan ketentuan jangan berisi dibawah dari jumlah k

				double relatif=0; //unarylooping pada total relatif
				double sumXiFi=0; //unarylooping pada total nilaiTengah x Frekuensi
				double sumXiFikdrt=0; //unarylooping pada total kuadrat dari nilaiTengah x Frekuensi

				for(i=0; i<k; i++)
					{
						//Rumus mencetak tiap kelas pada array ke 1
						kelasBawah[i+1]=kelasBawah[i];
						kelasAtas[i+1]=kelasBawah[i+1]+(c-1);

							for (j=0;j<nBil;j++) //menghitung frekuensi pada array ke 0
							{
								if(isiData[j]>=kelasBawah[i] && isiData[j]<=kelasAtas[i])//menentukan frekuensi pada setiap interval
								{
									frek[i]=frek[i]+1;//mencetak frekuensi array ke 0
								}
							}

							for (j=0;j<k;j++)
							{
								kumulatif[j]=kumulatif[j]+frek[i];
							}

						//rumus frekuensi Relatif
						float fRelatif=frek[i]/(float)nBil*100; //rumus frekuensi Relatif
						if(fRelatif < 10.0)
						{
							System.out.println();
						}else if (fRelatif < 100.0)
						{
							System.out.println();
						}
						relatif=relatif+fRelatif;//mencetak total frekuensi relatif

						double XiFi = nilaiTengah*frek[i]; //mengisi tabel N.Tengah * Frek

						sumXiFi=sumXiFi+XiFi; //rumus total dari nilai tengah x frekuensi

						double XiFikdrt = Math.pow(XiFi,2); //rumus kuadrat dari nilai tengah x frekuensi

						sumXiFikdrt=sumXiFikdrt+XiFikdrt; //rumus total kuadrat dari nilai tengah x frekuensi


						//--------bagian pemanggilan tiap variable--------------

						System.out.println("   |  "+kelasBawah[i]+" - "+kelasAtas[i]+"	  " +frek[i]+"		"+(String.format("%.2f",fRelatif))+"%"+"		"+kumulatif[i]+"		"+nilaiTengah+"		"+XiFi+"			   "+XiFikdrt+"	|");

						//mencetak ulang tiap kelas kembali pada interval selanjutnya (Unary looping)
						kelasBawah[i+1]=kelasBawah[i+1]+c;
						kelasAtas[i+1]=kelasAtas[i+1]+c;

						//mencetak ulang frekuensi kembali pada interval selanjutnya (Unary looping) sebagai syarat dimulai dari array ke 0
						batasBawah=batasBawah+c;
						batasAtas=batasAtas+c;

						nilaiTengah=nilaiTengah+c; //mencetak ulang nilaiTengah lagi pada interval selanjutnya (Unary looping)
						XiFi=XiFi+c;//mencetak ulang N.Tengah*Frek lagi pada interval selanjutnya (Unary looping)

					}

				System.out.println("   +--------------------------------------------------------------------------------------------------------------------+");
				System.out.println("   +	Total		  "+nBil+"		"+(String.format("%.2f",relatif))+"						"+sumXiFi+"			   "+sumXiFikdrt+"	+");
				System.out.println("   +--------------------------------------------------------------------------------------------------------------------+");



				//menghitung frekuensi kumulatif pada array ke 1
				int kum[]= new int [999];

				kum[0]= frek[0]; //menjadikan pemanggilan kumulatif array ke 1 dan frekuensi array ke 1 sejajar

				for(v=1; v<k; v++)
				{
					kum[v]=kum[v-1]+frek[v]; //mencetak frekuensi kumulatif pada array ke 1
				}

				//----rumus bagian modus-----
				int kelasModus=0;
				int maxFrek=0;
				for(i=0;i<k;i++)
				{

					if(maxFrek < frek[i])
					{
					maxFrek=frek[i];
					kelasModus=i;
					}

				}

				double d1=frek[kelasModus]-frek[kelasModus-1];
				double d2=frek[kelasModus]-frek[kelasModus+1];
				double Lmodus = kelasBawah[kelasModus]-0.5;
				double modus = Lmodus + ((d1/(d1+d2))*c);

				//---rumus bagian median---
				double posmed=nBil/2;
				int kumed=0;
				int kumed1=0;
				for(i=0;i<k;i++)
				{
					if(posmed < kum[i])
					{
						kumed=i;
					}else
					{
						kumed1=kumed+2;
					}
				}

				double fkum=kum[kumed1];
				double fmed=frek[kumed1+1];
				double L=kelasBawah[kumed1+1]-0.5;
				double median = L + (((posmed - fkum)/fmed)*c);

				//---rumus bagian quartil 1----
				double posq1=(double)nBil/4;
				int kumq1=0;
				int kumq2=0;
				for(i=0;i<k;i++)
				{
					if(posq1 < kum[i])
					{
						kumq1=i;
					}else
					{
						kumq2=kumq1+1;
					}
				}
				double fkumq1=kum[kumq2];
				double fq1=frek[kumq2+1];
				double Lq1=kelasBawah[kumq2+1]-0.5;
				double q1= Lq1 + (((posq1 - fkumq1)/fq1)*c);

				//----rumus bagian quartil 3---
				double posq3=(double)(nBil*3)/4;
				int kumq3=0;
				int kumq4=0;
				for(i=0;i<k;i++)
				{
					if(posq3 < kum[i])
					{
						kumq3=i;
					}else
					{
						kumq4=kumq3+2;
					}
				}
				double fkumq3=kum[kumq4];
				double fq3=frek[kumq4+1];
				double Lq3=kelasBawah[kumq4+1]-0.5;
				double q3= Lq3 + (((posq3 - fkumq3)/fq3)*c);

				//---rumus bagian desil 1----
				double posD1=nBil/10;
				int kumD1=0;
				int kumD2=0;
				for(i=0;i<k;i++)
				{
					if(posD1 < kum[i])
					{
						kumD1=i;
					}else
					{
						kumD2=kumD1+1;
					}
				}
				double fkumD1=kum[kumD2-1];
				double fD1=frek[kumD2];
				double LD1=kelasBawah[kumD2]-0.5;
				double D1= LD1 + (((posD1 - fkumD1)/fD1)*c);

				//---rumus bagian desil 3----
				double posD3=(3*nBil)/10;
				int kumD3=0;
				int kumD4=0;
				for(i=0;i<k;i++)
				{
					if(posD3 < kum[i])
					{
						kumD3=i;
					}else
					{
						kumD4=kumD3+1;
					}
				}
				double fkumD3=kum[kumD4-1];
				double fD3=frek[kumD4];
				double LD3=kelasBawah[kumD4]-0.5;
				double D3= LD3 + (((posD3 - fkumD3)/fD3)*c);

				//---rumus bagian desil 7---
				double posD7=(7*nBil)/10;
				int kumD7=0;
				int kumD8=0;
				for(i=0;i<k;i++)
				{
					if(posD7 < kum[i])
					{
						kumD7=i;
					}else
					{
						kumD8=kumD7+1;
					}
				}
				double fkumD7=kum[kumD8-1];
				double fD7=frek[kumD8];
				double LD7=kelasBawah[kumD8]-0.5;
				double D7= LD7 + (((posD7 - fkumD7)/fD7)*c);

				//---rumus bagian standar deviasi---
				double kdrtsumXiFi = Math.pow(sumXiFi,2);
				double varian = ((sumXiFikdrt -(kdrtsumXiFi/(nBil-1))) /(nBil-1)); //akar dari varian

				String reload="y";
				while (reload.equalsIgnoreCase ("y"))
				{
					System.out.println("\n   +-----+----------------------+");
					System.out.println("   | No  |  Daftar Program      |");
					System.out.println("   +-----+----------------------+");
					System.out.println("   | 1.  |    Mean		|");
					System.out.println("   | 2.  |    Modus		|");
					System.out.println("   | 3.  |    Median		|");
					System.out.println("   | 4.  |    Quartil 1		|");
					System.out.println("   | 5.  |    Quartil 3		|");
					System.out.println("   | 6.  |    Desil 1		|");
					System.out.println("   | 7.  |    Desil 3		|");
					System.out.println("   | 8.  |    Desil 7		|");
					System.out.println("   | 9.  |    Standar Deviasi	|");
					System.out.println("   | 10. |    Hitung Semua	|");
					System.out.println("   +-----+----------------------+");
					System.out.print("\n    Masukkan pilihan : ");
					kelompok = input.nextInt();
				//---switch Case---
				switch (kelompok) {
					case 1:

						//mencari Mean
						System.out.println();
						System.out.println("<!------------- MEAN ------------->");
						System.out.println("\n   Mean(rata-rata) 	:(Total Frek * Nilai Tengah) / Total Frek");
						System.out.println("			  "+sumXiFi+ " / " +nBil);
						System.out.println("			  "+sumXiFi/nBil);
						System.out.println();

						System.out.println("\n==============TERIMA KASIH TELAH MENGGUNAKAN PROGRAM INI===========");
						System.out.print("\nApakah anda ingin mengulang program SPSS ? [Y/T]: ");
						reload=repeat.nextLine();

						break;

					case 2:

						//Mencari Modus
						System.out.println();
						System.out.println("<!------------- Modus ------------->");
						System.out.println();
						System.out.println("   frekTerbesar 	: "+maxFrek);
						System.out.println("   batasBawah	 	: "+Lmodus);
						System.out.println("   d1 			: frekTerbesar - frek(sebelum)");
						System.out.println(" 			  "+d1);
						System.out.println("   d2 			: frekTerbesar - frek(sesudah)");
						System.out.println(" 			  "+d2);
						System.out.println("   P 			: "+c);
						System.out.println("   Modus		: batasBawah + (d1/d1+d2) * P");
						System.out.println("			  "+Lmodus+" + ("+d1+"/"+d1+"+"+d2+") * "+c);
						System.out.println("			  "+Lmodus+" + ("+(d1/(d1+d2))+" * "+c+" )");
						System.out.println("			  "+Lmodus+" + "+((d1/(d1+d2))*c));
						System.out.println("		 	  "+modus);
						System.out.println();

						System.out.println("\n==============TERIMA KASIH TELAH MENGGUNAKAN PROGRAM INI===========");
						System.out.print("\nApakah anda ingin mengulang program SPSS ? [Y/T]: ");
						reload=repeat.nextLine();

						break;

					case 3:

						//mencari Median
						System.out.println();
						System.out.println("<!------------- Median ------------->");
						System.out.println();
						System.out.println("   posisiMedian 	: n / 2");
						System.out.println("   			  "+nBil+" / 2");
						System.out.println("   			  "+posmed);
						System.out.println("   batasBawah 		: "+L);
						System.out.println("   fKum(sebelum) 	: "+fkum);
						System.out.println("   fMedian		: "+fmed);
						System.out.println("   P 			: "+c);
						System.out.println("   Median		: batasBawah + ((n/2 - fKum(sebelum))/fMedian) * P");
						System.out.println("   			  "+L+" + ("+posmed+" - "+fkum+") / "+fmed+") * "+c);
						System.out.println("   			  "+L+" + ("+(posmed-fkum)+" / "+fmed+") * "+c);
						System.out.println("   			  "+L+" + ("+((posmed-fkum)/fmed)+" * "+c+")");
						System.out.println("   			  "+L+" + "+(((posmed-fkum)/fmed)*c));
						System.out.println("    			  "+median);

						System.out.println("\n==============TERIMA KASIH TELAH MENGGUNAKAN PROGRAM INI===========");
						System.out.print("\nApakah anda ingin mengulang program SPSS ? [Y/T]: ");
						reload=repeat.nextLine();

						break;

					case 4:

						//mencari Q1
						System.out.println();
						System.out.println("<!------------- Quartil 1 ------------->");
						System.out.println();
						System.out.println("   posisi Q1	 	: n / 4");
						System.out.println("   			  "+nBil+" / 4");
						System.out.println("   			  "+posq1);
						System.out.println("   batasBawah 		: "+Lq1);
						System.out.println("   fKum(sebelum) 	: "+fkumq1);
						System.out.println("   f Q1			: "+fq1);
						System.out.println("   P 			: "+c);
						System.out.println("   Quartil 1		: batasBawah + ((n/4 - fKum(sebelum))/fQ1) * P");
						System.out.println("   			  "+Lq1+" + ("+posq1+" - "+fkumq1+") / "+fq1+") * "+c);
						System.out.println("   			  "+Lq1+" + ("+(posq1-fkumq1)+" / "+fq1+") * "+c);
						System.out.println("   			  "+Lq1+" + ("+((posq1-fkumq1)/fq1)+" * "+c+")");
						System.out.println("   			  "+Lq1+" + "+(((posq1-fkumq1)/fq1)*c));
						System.out.println("    			  "+q1);

						System.out.println("\n==============TERIMA KASIH TELAH MENGGUNAKAN PROGRAM INI===========");
						System.out.print("\nApakah anda ingin mengulang program SPSS ? [Y/T]: ");
						reload=repeat.nextLine();


						break;

					case 5:

						//mencari Q3
						System.out.println();
						System.out.println("<!------------- Quartil 3 ------------->");
						System.out.println();
						System.out.println("   posisi Q3	 	: 3n / 4");
						System.out.println("   			  3 * "+nBil+" / 4");
						System.out.println("   			  "+posq3);
						System.out.println("   batasBawah 		: "+Lq3);
						System.out.println("   fKum(sebelum) 	: "+fkumq3);
						System.out.println("   f Q3			: "+fq3);
						System.out.println("   P 			: "+c);
						System.out.println("   Quartil 3		: batasBawah + ((3n/4 - fKum(sebelum))/fQ3) * P");
						System.out.println("   			  "+Lq3+" + ("+posq3+" - "+fkumq3+") / "+fq3+") * "+c);
						System.out.println("   			  "+Lq3+" + ("+(posq3-fkumq3)+"/ "+fq3+") * "+c);
						System.out.println("   			  "+Lq3+" + ("+((posq3-fkumq3)/fq3)+" * "+c+")");
						System.out.println("   			  "+Lq3+" + "+(((posq3-fkumq3)/fq3)*c));
						System.out.println("    			  "+q3);

						System.out.println("\n==============TERIMA KASIH TELAH MENGGUNAKAN PROGRAM INI===========");
						System.out.print("\nApakah anda ingin mengulang program SPSS ? [Y/T]: ");
						reload=repeat.nextLine();

						break;

					case 6:

						//mencari DESIL 1
						System.out.println();
						System.out.println("<!------------- Desil 1 ------------->");
						System.out.println();
						System.out.println("   posisi D1	 	: 1 * n / 10");
						System.out.println("   			  1 * "+nBil+" / 10");
						System.out.println("   			  "+posD1);
						System.out.println("   batasBawah 		: "+LD1);
						System.out.println("   fKum(sebelum) 	: "+fkumD1);
						System.out.println("   f D1			: "+fD1);
						System.out.println("   P 			: "+c);
						System.out.println("   DESIL 1		: batasBawah + ((1*n/10 - fKum(sebelum))/fD3) * P");
						System.out.println("   			  "+LD1+" + ("+posD1+" - "+fkumD1+") / "+fD1+") * "+c);
						System.out.println("   			  "+LD1+" + ("+(posD1-fkumD1)+") / "+fD1+") * "+c);
						System.out.println("   			  "+LD1+" + ("+((posD1-fkumD1)/fD1)+" * "+c+")");
						System.out.println("   			  "+LD1+" + "+(((posD1-fkumD1)/fD1)*c));
						System.out.println("    			  "+D1);
						System.out.println();

						System.out.println("\n==============TERIMA KASIH TELAH MENGGUNAKAN PROGRAM INI===========");
						System.out.print("\nApakah anda ingin mengulang program SPSS ? [Y/T]: ");
						reload=repeat.nextLine();

						break;

					case 7:

						//mencari DESIL 3
						System.out.println("<!------------- Desil 3 ------------->");
						System.out.println();
						System.out.println("   posisi D3	 	: 3 * n / 10");
						System.out.println("   			  3 * "+nBil+" / 10");
						System.out.println("   			  "+posD3);
						System.out.println("   batasBawah 		: "+LD3);
						System.out.println("   fKum(sebelum) 	: "+fkumD3);
						System.out.println("   f D3			: "+fD3);
						System.out.println("   P 			: "+c);
						System.out.println("   DESIL 3		: batasBawah + ((3*n/10 - fKum(sebelum))/fD3) * P");
						System.out.println("   			  "+LD3+" + ("+posD3+" - "+fkumD3+") / "+fD3+") * "+c);
						System.out.println("   			  "+LD3+" + ("+(posD3-fkumD3)+") / "+fD3+") * "+c);
						System.out.println("   			  "+LD3+" + ("+((posD3-fkumD3)/fD3)+" * "+c+")");
						System.out.println("   			  "+LD3+" + "+(((posD3-fkumD3)/fD3)*c));
						System.out.println("    			  "+D3);
						System.out.println();

						System.out.println("\n==============TERIMA KASIH TELAH MENGGUNAKAN PROGRAM INI===========");
						System.out.print("\nApakah anda ingin mengulang program SPSS ? [Y/T]: ");
						reload=repeat.nextLine();

						break;

					case 8:

						System.out.println("<!------------- Desil 7 ------------->");
						System.out.println();
						System.out.println("   posisi D7	 	: 7 * n / 10");
						System.out.println("   			  7 * "+nBil+" / 10");
						System.out.println("   			  "+posD7);
						System.out.println("   batasBawah 		: "+LD7);
						System.out.println("   fKum(sebelum) 	: "+fkumD7);
						System.out.println("   f D7			: "+fD7);
						System.out.println("   P 			: "+c);
						System.out.println("   DESIL 7		: batasBawah + ((7*n/10 - fKum(sebelum))/fD7) * P");
						System.out.println("   			  "+LD7+" + ("+posD7+" - "+fkumD7+") / "+fD7+") * "+c);
						System.out.println("   			  "+LD7+" + ("+(posD7-fkumD7)+") / "+fD7+") * "+c);
						System.out.println("   			  "+LD7+" + ("+((posD7-fkumD7)/fD7)+" * "+c+")");
						System.out.println("   			  "+LD7+" + "+(((posD7-fkumD7)/fD7)*c));
						System.out.println("    			  "+D7);

						System.out.println("\n==============TERIMA KASIH TELAH MENGGUNAKAN PROGRAM INI===========");
						System.out.print("\nApakah anda ingin mengulang program SPSS ? [Y/T]: ");
						reload=repeat.nextLine();

						break;

					case 9:
						//mencari StandarDeviasi
						System.out.println();
						System.out.println("<!------------- Standar Deviasi ------------->");
						System.out.println("\nStandar Deviasi		: Akar dari Varian");
						System.out.println("			: Varian = (total (N.Tengah x Frek)² - ((kuadrat dari total N.Tengah x Frek)/total Frekuensi - 1)) / total Frekuensi - 1 ");
						System.out.println("			    	 = "+sumXiFikdrt+" - ("+sumXiFi+"² "+" / "+nBil+" - 1) / "+nBil+" - 1");
						System.out.println("			    	 = "+sumXiFikdrt+" - ("+kdrtsumXiFi+" / "+(nBil-1)+") / "+(nBil-1));
						System.out.println("			    	 = ("+sumXiFikdrt+" - "+kdrtsumXiFi/(nBil-1)+") / "+(nBil-1));
						System.out.println("			    	 = "+((sumXiFikdrt -(kdrtsumXiFi/(nBil-1))) /(nBil-1))+"^1/2");
						System.out.println("			: "+Math.sqrt(varian));

						System.out.println("\n==============TERIMA KASIH TELAH MENGGUNAKAN PROGRAM INI===========");
						System.out.print("\nApakah anda ingin mengulang program SPSS ? [Y/T]: ");
						reload=repeat.nextLine();

						break;

					case 10:

						System.out.println();
						System.out.println("<!------------- All In One ------------->");
						System.out.println("Mean			: "+sumXiFi/nBil);
						System.out.println("Modus			: "+modus);
						System.out.println("Median			: "+median);
						System.out.println("Quartil 1		: "+q1);
						System.out.println("Quartil 3		: "+q3);
						System.out.println("Desil 1			: "+D1);
						System.out.println("Desil 3			: "+D3);
						System.out.println("Desil 7			: "+D7);
						System.out.println("Standar Deviasi		: "+Math.sqrt(varian));

						System.out.println("\n==============TERIMA KASIH TELAH MENGGUNAKAN PROGRAM INI===========");
						System.out.print("\nApakah anda ingin mengulang program SPSS ? [Y/T]: ");
						reload=repeat.nextLine();

						break;

					default:
						System.out.println("Pilihan yang Anda masukkan tidak tersedia !");
						break;
					} //--- end Switch ---
				} //--- end while ---
			break;
		} //--- end switch Case (Big)---
	}
}