package bankaotomasyonu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collection;
import java.util.Collections;


import bankaotomasyonu.Account;
import bankaotomasyonu.CurrentAccount;
import bankaotomasyonu.LongTermAccount;
import bankaotomasyonu.ShortTermAccount;

import java.time.*;
import java.time.format.DateTimeFormatter;

import bankaotomasyonu.Account;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Random;

public class Bank {
    
    
        private ArrayList<Account> accounts;
	private Scanner scanner;
	private Account account;
	private LocalDate date;
	private DateTimeFormatter dateTimeFormat;
	private LocalDate systemStartDate;
	
        public Bank() 
	{
		accounts = new ArrayList<Account>();
                systemStartDate = LocalDate.of(2023, 5, 5);
	}
	
		
	public void getAccounts() 
	{
		for (Account account : accounts) 
		{
			System.out.println(account.getAccountId());
		}
	}
	
	public LocalDate getDate() 
        {
                if (date != null) {
                    return date;
            } else {
                    return systemStartDate;
            }
		
	}
	
	public void deposit(int Id, int cash) 
	{
		boolean foundId=false;
		if(!accounts.isEmpty())
		{
			for (Account account : accounts) 
			{
				if(Id == account.getAccountId()) 
				{
					account.deposit(Id, cash);
					account.transactions.add("Hesaba "+cash+" TL para yatırıldı. ("+getDate() +")");
					System.out.println(account.getId() + " nolu hesabınıza "+cash+" tl yatırıldı.Toplam bakiye: "+account.getBakiye());
					foundId=true;
				}
				
			}		
		}
		else
		{
			System.out.println("Oluşturulmuş hesap yok..");
		}
		
		if(foundId==false) {System.out.println("Yanlış Hesap id..");}
	}

	
	public void Withdraw(int Id, int cash) 
	{
		boolean foundId=false;
		if(!accounts.isEmpty())
		{
			for (Account account : accounts) 
			{
				if(Id == account.getAccountId()) 
				{
					foundId=true;
					if(cash <= account.getBakiye()) 
					{
						account.withdraw(Id, cash);
						account.transactions.add("Hesaptan "+cash+" TL para çekildi.  ("+getDate() +")");
						System.out.println(account.getId() + " nolu hesaptan "+cash + " tl çekildi.Toplam bakiye : "+account.getBakiye());
						
					}
					else
					{
						System.out.println("Yetersiz Bakiye !");
					}
					
				}
			
			}
		}
		else 
		{
			System.out.println("Oluşturulmuş hesap yok..");
		}
		
		if(foundId==false) {System.out.println("Yanlış Hesap id..");}
	}
	
	public void showAccounts() 
	{
		if(!accounts.isEmpty())
		{
			for (Account account : accounts) 
			{	
				System.out.println("Hesap İd: " + account.getId());
				int count=1;
				for (int i=account.transactions.size()-1; i>=0; i--) 
				{
					if(count<=5) 
					{
						System.out.println((i+1) + ".işlem : "+account.transactions.get(i));
					}
					count++;
				}
				System.out.println("--------------------------------------------------------------");
			}			
		}
		else 
		{	
			System.out.println("Görüntülenecek hesap Yok..");
		}
		
	}
	
	public void createAccounts(int input) 
	{
		 scanner = new Scanner(System.in);
		 int id;
		 int balance;
		 
		if(input==1) 
		{	
			System.out.println("SHORT TERM ACCOUNT");
			System.out.println("İd numarası giriniz ?");
			id=scanner.nextInt();
			System.out.println("Başlangıç para miktarı giriniz.(min 1000TL).");
			balance=scanner.nextInt();
			
			if(balance >= 1000) 
			{
				account = new ShortTermAccount(id, balance);
				accounts.add(account);
				account.transactions.add("Hesap oluşturuldu.. ("+getDate() +")");
				System.out.print("Hesap oluşturuldu");
			}
			else 
			{
				System.out.println("Kısa vadeli hesap oluşturmak için minimum 1000 TL bakiye olmalıdır.");
			}
			
		}
		else if(input==2) 
		{
			System.out.println("LONG TERM ACCOUNT");
			System.out.println("İd numarası giriniz ?");
			id=scanner.nextInt();
			System.out.println("Başlangıç para miktarı giriniz.(min 1500TL).");
			balance=scanner.nextInt();
			
			if(balance >= 1500)
			{
				account = new LongTermAccount(id, balance);
				accounts.add(account);
				account.transactions.add("Hesap oluşturuldu..("+getDate() +")");
				System.out.print("Hesap oluşturuldu");

			}
			else 
			{
				System.out.println("Uzun vadeli hesap oluşturmak için minimum 1500 TL bakiye olmalıdır.");
			}

		}
                else if(input==3) 
		{
			System.out.println("SPECIAL ACCOUNT");
			System.out.println("İd numarası giriniz ?");
			id=scanner.nextInt();
			System.out.println("Başlangıç para miktarı giriniz.(en az hesap açtığındakı kadar para hesapta bakiye olması gerekiyor).");
			balance=scanner.nextInt();
			
			if(balance >= 1500)
			{
				account = new LongTermAccount(id, balance);
				accounts.add(account);
				account.transactions.add("Hesap oluşturuldu..("+getDate() +")");
				System.out.print("Hesap oluşturuldu");

			}
			else 
			{
				System.out.println("Special hesap oluşturmak için en az hesap açtığındakı kadar para hesapta bakiye olması gerekiyor.");
			}

		}
	
		else if(input==4) 
		{
			System.out.println("CURRENT ACCOUNT");
			System.out.println("İd numarası giriniz ?");
			id=scanner.nextInt();
			account = new CurrentAccount(id);
			accounts.add(account);
			account.transactions.add("Hesap oluşturuldu..("+getDate() +")");
			System.out.print("Hesap oluşturuldu");


		}
	}
	
	public Boolean controlAccountId(int accountId)
	{		
		Boolean bool=false;
		for (Account account : accounts) 
		{
			if(account.getAccountId() == accountId) 
			{
				bool = true; 
			}
			
		}
		
		return bool;
	}
        
        public void sortition(){
        
              if (accounts.isEmpty()) {
                System.out.println("Çekiliş yapılacak hesap bulunamadı.");
                return;
                }

                    Random random = new Random();
                    int randomIndex = random.nextInt(accounts.size());
  
                    Account winningAccount = accounts.get(randomIndex);
                    System.out.println("Kazanan hesap: " + winningAccount.getAccountId());
                    
                    winningAccount.deposit(10000);
                    System.out.println("Kazanan hesaba 10.000 TL eklendi. Yeni bakiye: " + winningAccount.getBakiye());
        
        }
        

        public void changeSystemDate() 
        {
                scanner = new Scanner(System.in);
                System.out.print("Yeni sistem tarihini girin (gg.aa.yyyy): ");
                String newDate = scanner.nextLine();
                dateTimeFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            try {
                    date = LocalDate.parse(newDate, dateTimeFormat);
                    System.out.println("Sistem tarihi güncellendi: " + date.format(dateTimeFormat));
                } catch (DateTimeParseException e) { 
                    System.out.println("Geçersiz tarih formatı! Lütfen gg.aa.yyyy formatında girin.");
                }
        
        }
}
        
    

