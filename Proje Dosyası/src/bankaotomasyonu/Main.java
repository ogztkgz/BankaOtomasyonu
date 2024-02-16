package bankaotomasyonu;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;



public class Main 
{	
	static Scanner scanner;
	
	public static void main(String[] args) throws IOException 
	{
		
		 scanner = new Scanner(System.in);
		 int input;
		 
		 Bank bank = new Bank();
		 
		while(true) 
		{
			System.out.println("\n-----------------OZİ BANK-----------------\n");
                        System.out.println("\nOZİ BANK'A HOŞ GELDİNİZ\n");
			System.out.println("1-Create_Short_ID_balance(Hesap no, başlangıç parası)");
			System.out.println("2-Create_Long_ID_balance(Hesap no, başlangıç parası)");
                        System.out.println("3-Create_Special_ID_balance(Hesap no, başlangıç parası)");
			System.out.println("4-Create_Current_ID_balance(Hesap no, başlangıç parası)");
			System.out.println("5-Increase_ID_cash(Id)");
			System.out.println("6-Decrease_ID_cash(Id)");
			System.out.println("7-Change System Date");
                        System.out.println("8-Show Accounts Id And Last 5 Transactions ");
			System.out.println("9-Show accounts Id");
                        System.out.println("10-Sortition\n");
                        System.out.println("----------------------------------------------\n");

			System.out.print("Lütfen gerçekleştirmek istediğiniz işlemi seçiniz...:");
			input = scanner.nextInt();
			Main.bankForm(input,bank);
		
		}
	}
	
	static void bankForm(int input, Bank bank) 
	{
		
		switch(input) 
		{
		
			case 1:
			{
				bank.createAccounts(1);
				break;
			}
                        
                        case 2:
			{
				bank.createAccounts(2);
				break;
			}
			case 3:
			{
				bank.createAccounts(3);
				break;
			}
		
			case 4:
			{
				bank.createAccounts(4);
				break;
			}
		
		
			case 5:
			{
					System.out.print("Para yatırmak istediğiniz hesabın idsini giriniz...:");
					int id=scanner.nextInt();
					
					if(bank.controlAccountId(id)==true) 
					{
						System.out.print("Yatırmak istediğiniz para miktarını giriniz...:");
						int cash=scanner.nextInt();
						bank.deposit(id, cash);	
					}
					else 
					{
						System.out.println("Yanlış İd numarası lütfen kontrol ediniz...");
					}
								
					break;
			}
		
			case 6:
			{
					System.out.print("Para çekmek istediğiniz hesabın idsini giriniz...:");
					int id=scanner.nextInt();
					
					if(bank.controlAccountId(id)==true) 
					{
						System.out.print("Çekmek istediğiniz para miktarı...:");
						int cash=scanner.nextInt();
						bank.Withdraw(id, cash);	
					}
					else 
					{
						System.out.println("Yanlış İd numarası lütfen kontrol ediniz...");
					}
					break;
			}
		
			
			case 7:
			{
				bank.changeSystemDate();
                                break;
			}
			
			case 8:
			{
				bank.showAccounts();
                                break;
			}
			
			case 9:
			{
				bank.getAccounts();
				break; 
			}
                        case 10:
                        {
                                bank.sortition();
                                break;
                        }
                        
			default : 
			{
				System.out.println("Geçersiz istekte bulundunuz. Lütfen geçerli bir istek giriniz....:");
			}
		}

	}
	

}
