package bankaotomasyonu;

import java.time.LocalDate;
import java.time.Period;

public class LongTermAccount extends Account
{
	
	public  LongTermAccount(int id, int balance) 
	{
		
		super.setAccountId(id);
		super.setBakiye(balance);
		super.type = AccountType.LONGTERM;
	}

	@Override
	public void accountRules() 
	{
		
		System.out.println("Yıllık %24 faiz verir ve en az 1500 tl bakiye olmak zorundadır.");
	}

	@Override
	public float benefit() 
	{
		
		  int year =Period.between(super.opening_account_date, LocalDate.now()).getYears();
		  int month =Period.between(super.opening_account_date, LocalDate.now()).getMonths();
		  int day =Period.between(super.opening_account_date, LocalDate.now()).getDays();
		  
		  int total_days = year*365 + 30*month + day;
		  
		  float faiz_miktari =  ( (getBakiye() *((float)24/365) / 100 ) * total_days);
		  
		  return faiz_miktari;
	} 
}
